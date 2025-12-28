package com.galeri.controller;

import com.galeri.dto.DtoFavorileme;
import com.galeri.dto.DtoFavorilemeUI;

import java.util.List;

public interface FavorilemeController {

    public DtoFavorileme favorilemeEkle(DtoFavorilemeUI dtoFavorilemeUI);

    List<DtoFavorileme> kullaniciFavoriListByUsername(String username);

}
