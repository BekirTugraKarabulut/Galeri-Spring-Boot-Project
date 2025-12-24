package com.galeri.controller;

import com.galeri.dto.DtoGalerici;
import com.galeri.dto.DtoGalericiUI;
import com.galeri.dto.DtoRefreshToken;
import com.galeri.jwt.AuthResponse;
import com.galeri.jwt.GalericiAuthRequest;

public interface GalericiAuthController {

    public DtoGalerici kayitGalerici(DtoGalericiUI dtoGalericiUI);

    public AuthResponse girisGalerici(GalericiAuthRequest galericiAuthRequest);

    public AuthResponse refreshTokenGalerici(DtoRefreshToken dtoRefreshToken);

}
