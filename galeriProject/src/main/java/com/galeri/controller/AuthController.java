package com.galeri.controller;

import com.galeri.dto.DtoKullanici;
import com.galeri.dto.DtoKullaniciUI;
import com.galeri.dto.DtoRefreshToken;
import com.galeri.jwt.AuthRequest;
import com.galeri.jwt.AuthResponse;

public interface AuthController {

    public DtoKullanici register(DtoKullaniciUI dtoKullaniciUI);

    public AuthResponse login(AuthRequest authRequest);

    public AuthResponse refreshToken(DtoRefreshToken dtoRefreshToken);

}
