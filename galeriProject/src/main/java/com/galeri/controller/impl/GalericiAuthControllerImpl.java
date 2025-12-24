package com.galeri.controller.impl;

import com.galeri.controller.GalericiAuthController;
import com.galeri.dto.DtoGalerici;
import com.galeri.dto.DtoGalericiUI;
import com.galeri.dto.DtoRefreshToken;
import com.galeri.jwt.AuthResponse;
import com.galeri.jwt.GalericiAuthRequest;
import com.galeri.service.GalericiAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/galerici/auth")
public class GalericiAuthControllerImpl implements GalericiAuthController {

    @Autowired
    private GalericiAuthService galericiAuthService;


    @Override
    @PostMapping(path = "/kayit")
    public DtoGalerici kayitGalerici(@RequestBody DtoGalericiUI dtoGalericiUI) {
        return galericiAuthService.kayitGalerici(dtoGalericiUI);
    }

    @Override
    @PostMapping(path = "/giris")
    public AuthResponse girisGalerici(@RequestBody GalericiAuthRequest galericiAuthRequest) {
        return galericiAuthService.girisGalerici(galericiAuthRequest);
    }

    @Override
    @PostMapping(path = "/refresh-token")
    public AuthResponse refreshTokenGalerici(@RequestBody DtoRefreshToken dtoRefreshToken) {
        return galericiAuthService.refreshTokenGalerici(dtoRefreshToken);
    }

}
