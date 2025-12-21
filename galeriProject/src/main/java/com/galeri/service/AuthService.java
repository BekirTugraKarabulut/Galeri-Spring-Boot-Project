package com.galeri.service;

import com.galeri.dto.DtoKullanici;
import com.galeri.dto.DtoKullaniciUI;
import com.galeri.dto.DtoRefreshToken;
import com.galeri.jwt.AuthRequest;
import com.galeri.jwt.AuthResponse;

public interface AuthService {

    public DtoKullanici register(DtoKullaniciUI dtoKullaniciUI);

    public AuthResponse login(AuthRequest authRequest);

    public AuthResponse refreshToken(DtoRefreshToken dtoRefreshToken);

}
