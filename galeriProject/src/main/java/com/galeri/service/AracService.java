package com.galeri.service;

import com.galeri.dto.DtoArac;
import com.galeri.dto.DtoAracUI;

import java.util.List;

public interface AracService {

    public List<DtoArac> getAllArac();

    public DtoArac aracEkle(DtoAracUI dtoAracUI);

    public boolean aracSil(Long aracId);

}
