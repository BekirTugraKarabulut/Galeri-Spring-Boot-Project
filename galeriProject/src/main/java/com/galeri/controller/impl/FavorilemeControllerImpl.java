package com.galeri.controller.impl;

import com.galeri.controller.FavorilemeController;
import com.galeri.dto.DtoFavorileme;
import com.galeri.dto.DtoFavorilemeUI;
import com.galeri.service.FavorilemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavorilemeControllerImpl implements FavorilemeController {

    @Autowired
    private FavorilemeService favorilemeService;


    @Override
    @PostMapping(path = "/favorilemeEkle")
    public DtoFavorileme favorilemeEkle(@RequestBody DtoFavorilemeUI dtoFavorilemeUI) {
        return favorilemeService.favorilemeEkle(dtoFavorilemeUI);
    }

}
