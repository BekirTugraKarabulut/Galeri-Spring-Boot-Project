package com.galeri.service;

import com.galeri.dto.DtoFavorileme;
import com.galeri.dto.DtoFavorilemeUI;

import java.util.List;

public interface FavorilemeService {

    public DtoFavorileme favorilemeEkle(DtoFavorilemeUI dtoFavorilemeUI);

    List<DtoFavorileme> kullaniciFavoriListByUsername(String username);

    public boolean favorilemeSil(Long favorilemeId);

}
