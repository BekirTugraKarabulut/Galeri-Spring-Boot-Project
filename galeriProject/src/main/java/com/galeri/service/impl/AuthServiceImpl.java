package com.galeri.service.impl;

import com.galeri.dto.DtoKullanici;
import com.galeri.dto.DtoKullaniciUI;
import com.galeri.dto.DtoRefreshToken;
import com.galeri.jwt.AuthRequest;
import com.galeri.jwt.AuthResponse;
import com.galeri.jwt.JwtService;
import com.galeri.model.Kullanici;
import com.galeri.model.RefreshToken;
import com.galeri.model.Rol;
import com.galeri.model.Role;
import com.galeri.repository.AuthRepository;
import com.galeri.repository.RefreshTokenRepository;
import com.galeri.repository.RolRepository;
import com.galeri.service.AuthService;
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
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Override
    public DtoKullanici register(DtoKullaniciUI dtoKullaniciUI) {

        Kullanici kullanici = new Kullanici();
        kullanici.setUsername(dtoKullaniciUI.getUsername());
        kullanici.setIsim(dtoKullaniciUI.getIsim());
        kullanici.setSoyisim(dtoKullaniciUI.getSoyisim());
        kullanici.setTelefonNo(dtoKullaniciUI.getTelefonNo());

        Optional<Rol> rol = rolRepository.findByRolId(1);

        if(rol.isPresent()) {
            kullanici.setRol(rol.get());
        }else{
            return null;
        }

        kullanici.setRole(Role.KULLANICI);
        kullanici.setPassword(bCryptPasswordEncoder.encode(dtoKullaniciUI.getPassword()));

        if(authRepository.findByUsername(kullanici.getUsername()).isPresent()) {
            return null;
        }

        if(authRepository.findByTelefonNo(kullanici.getTelefonNo()).isPresent()) {
            return null;
        }

        Kullanici dbKullanici = authRepository.save(kullanici);
        DtoKullanici dtoKullanici = new DtoKullanici();
        BeanUtils.copyProperties(dbKullanici, dtoKullanici);

        return dtoKullanici;
    }

    public RefreshToken createRefreshToken(Kullanici kullanici){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setKullanici(kullanici);
        refreshToken.setIssueDate(new Date());
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24));
        refreshToken.setToken(UUID.randomUUID().toString());
        return refreshToken;
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        authenticationProvider.authenticate(authenticationToken);

        Optional<Kullanici> kullaniciOptional = authRepository.findByUsername(authRequest.getUsername());

        if(kullaniciOptional.isEmpty()){
            return null;
        }

        String accessToken = jwtService.generateToken(kullaniciOptional.get());
        RefreshToken refreshToken = createRefreshToken(kullaniciOptional.get());
        RefreshToken dbRefreshToken = refreshTokenRepository.save(refreshToken);

        return new AuthResponse(accessToken , dbRefreshToken.getToken());
    }

    public boolean isValidToken(Date expiredDate){
        return new Date().before(expiredDate);
    }

    @Override
    public AuthResponse refreshToken(DtoRefreshToken dtoRefreshToken) {

        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByToken(dtoRefreshToken.getRefreshToken());

        if(refreshToken.isEmpty()){
            return null;
        }

        if(!isValidToken(refreshToken.get().getExpireDate())){
            return null;
        }

        String accessToken = jwtService.generateToken(refreshToken.get().getKullanici());
        RefreshToken newRefreshToken = createRefreshToken(refreshToken.get().getKullanici());
        RefreshToken dbRefreshToken = refreshTokenRepository.save(newRefreshToken);

        return new AuthResponse(accessToken, dbRefreshToken.getToken());
    }
}
