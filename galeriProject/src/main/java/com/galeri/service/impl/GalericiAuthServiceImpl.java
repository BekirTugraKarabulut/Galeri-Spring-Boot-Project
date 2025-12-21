package com.galeri.service.impl;

import com.galeri.dto.DtoGalericiUI;
import com.galeri.repository.GalericiRepository;
import com.galeri.service.GalericiAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalericiAuthServiceImpl implements GalericiAuthService {

    @Autowired
    private GalericiRepository galericiRepository;

    @Override
    public boolean girisGalerici(DtoGalericiUI dtoGalericiUI) {

        DtoGalericiUI dtoGalerici = new DtoGalericiUI();
        dtoGalerici.setGalericiId(dtoGalericiUI.getGalericiId());
        dtoGalerici.setPassword(dtoGalericiUI.getPassword());

        if(dtoGalerici.getGalericiId().equals("158") && dtoGalerici.getPassword().equals("123")){
            return true;
        } else {
            return false;
        }

    }
}
