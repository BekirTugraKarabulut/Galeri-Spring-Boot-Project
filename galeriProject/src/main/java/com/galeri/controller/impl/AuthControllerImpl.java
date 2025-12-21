package com.galeri.controller.impl;

import com.galeri.controller.AuthController;
import com.galeri.dto.DtoKullanici;
import com.galeri.dto.DtoKullaniciUI;
import com.galeri.dto.DtoRefreshToken;
import com.galeri.jwt.AuthRequest;
import com.galeri.jwt.AuthResponse;
import com.galeri.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements AuthController {

    @Autowired
    private AuthService authService;


    @Override
    @PostMapping(path = "/register")
    public DtoKullanici register(@Valid @RequestBody DtoKullaniciUI dtoKullaniciUI) {
        return authService.register(dtoKullaniciUI);
    }

    @Override
    @PostMapping(path = "/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }

    @Override
    @PostMapping(path = "/refresh-token")
    public AuthResponse refreshToken(@RequestBody DtoRefreshToken dtoRefreshToken) {
        return authService.refreshToken(dtoRefreshToken);
    }

}
