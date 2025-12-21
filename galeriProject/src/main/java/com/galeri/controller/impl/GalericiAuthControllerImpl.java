package com.galeri.controller.impl;

import com.galeri.controller.GalericiAuthController;
import com.galeri.dto.DtoGalericiUI;
import com.galeri.service.GalericiAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GalericiAuthControllerImpl implements GalericiAuthController {

    @Autowired
    private GalericiAuthService galericiAuthService;


    @Override
    @PostMapping(path = "/galerici/giris")
    public boolean girisGalerici(@RequestBody DtoGalericiUI dtoGalericiUI) {
        return galericiAuthService.girisGalerici(dtoGalericiUI);
    }

}
