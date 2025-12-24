package com.galeri.service.impl;

import com.galeri.dto.DtoGalerici;
import com.galeri.dto.DtoGalericiUI;
import com.galeri.dto.DtoRefreshToken;
import com.galeri.jwt.AuthResponse;
import com.galeri.jwt.GalericiAuthRequest;
import com.galeri.jwt.JwtService;
import com.galeri.model.Galerici;
import com.galeri.model.RefreshTokenGalerici;
import com.galeri.model.Role;
import com.galeri.repository.GalericiRepository;
import com.galeri.repository.RefreshTokenGalericiRepository;
import com.galeri.service.GalericiAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class GalericiAuthServiceImpl implements GalericiAuthService {

    @Autowired
    private GalericiRepository galericiRepository;

    @Autowired
    private RefreshTokenGalericiRepository refreshTokenGalericiRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtService jwtService;

    @Override
    public DtoGalerici kayitGalerici(DtoGalericiUI dtoGalericiUI) {

        Galerici galerici = new Galerici();
        galerici.setGalericiId(dtoGalericiUI.getGalericiId());
        galerici.setName(dtoGalericiUI.getName());
        galerici.setPassword(bCryptPasswordEncoder.encode(dtoGalericiUI.getPassword()));
        galerici.setRole(Role.GALERICI);

        Galerici dbGalerici = galericiRepository.save(galerici);
        DtoGalerici dtoGalerici = new DtoGalerici();
        BeanUtils.copyProperties(dbGalerici, dtoGalerici);

        return dtoGalerici;
    }

    public RefreshTokenGalerici createRefrehToken(Galerici galerici){
        RefreshTokenGalerici refreshTokenGalerici = new RefreshTokenGalerici();
        refreshTokenGalerici.setGalerici(galerici);
        refreshTokenGalerici.setIssueDate(new Date());
        refreshTokenGalerici.setExpireDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24));
        refreshTokenGalerici.setToken(UUID.randomUUID().toString());
        return refreshTokenGalerici;
    }

    @Override
    public AuthResponse girisGalerici(GalericiAuthRequest galericiAuthRequest) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(galericiAuthRequest.getGalericiId(), galericiAuthRequest.getPassword());
        authenticationProvider.authenticate(authenticationToken);

        Optional<Galerici> galerici = galericiRepository.findByGalericiId(galericiAuthRequest.getGalericiId());

        if(galerici.isEmpty()){
            return null;
        }

        String accessToken = jwtService.generateToken(galerici.get());
        RefreshTokenGalerici refreshTokenGalerici = createRefrehToken(galerici.get());
        RefreshTokenGalerici dbRefreshTokenGalerici = refreshTokenGalericiRepository.save(refreshTokenGalerici);

        return new AuthResponse(accessToken , dbRefreshTokenGalerici.getToken());
    }

    public boolean isValidRefreshToken(Date expireDate){
        return new Date().before(expireDate);
    }

    @Override
    public AuthResponse refreshTokenGalerici(DtoRefreshToken dtoRefreshToken) {

        Optional<RefreshTokenGalerici> refreshTokenGalerici =
                refreshTokenGalericiRepository.findByToken(dtoRefreshToken.getRefreshToken());

        if(refreshTokenGalerici.isEmpty()){
            return null;
        }

        if(!isValidRefreshToken(refreshTokenGalerici.get().getExpireDate())){
            return null;
        }

        Optional<Galerici> galerici =
                galericiRepository.findByGalericiId(refreshTokenGalerici.get().getGalerici().getGalericiId());

        if(galerici.isEmpty()){
            return null;
        }

        String accessToken = jwtService.generateToken(galerici.get());
        RefreshTokenGalerici newRefreshTokenGalerici = createRefrehToken(galerici.get());
        RefreshTokenGalerici dbRefreshTokenGalerici = refreshTokenGalericiRepository.save(newRefreshTokenGalerici);

        return new AuthResponse(accessToken , dbRefreshTokenGalerici.getToken());
    }

}
