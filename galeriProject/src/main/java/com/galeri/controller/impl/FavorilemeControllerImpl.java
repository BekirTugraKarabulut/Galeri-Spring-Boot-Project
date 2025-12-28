package com.galeri.controller.impl;

import com.galeri.controller.FavorilemeController;
import com.galeri.dto.DtoFavorileme;
import com.galeri.dto.DtoFavorilemeUI;
import com.galeri.service.FavorilemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorileme")
public class FavorilemeControllerImpl implements FavorilemeController {

    @Autowired
    private FavorilemeService favorilemeService;


    @Override
    @PostMapping(path = "/favorilemeEkle")
    public DtoFavorileme favorilemeEkle(@RequestBody DtoFavorilemeUI dtoFavorilemeUI) {
        return favorilemeService.favorilemeEkle(dtoFavorilemeUI);
    }

    @Override
    @GetMapping(path = "/kullaniciFavoriListByUsername/{username}")
    public List<DtoFavorileme> kullaniciFavoriListByUsername(@PathVariable(name = "username" , required = true) String username) {
        return favorilemeService.kullaniciFavoriListByUsername(username);
    }

    @Override
    @DeleteMapping(path = "/favorilemeSil/{favorilemeId}")
    public boolean favorilemeSil(@PathVariable(name = "favorilemeId" , required = true) Long favorilemeId) {
        return favorilemeService.favorilemeSil(favorilemeId);
    }

}
