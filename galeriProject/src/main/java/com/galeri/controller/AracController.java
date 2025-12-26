package com.galeri.controller;

import com.galeri.dto.DtoArac;
import com.galeri.dto.DtoAracUI;

import java.util.List;

public interface AracController {

    public List<DtoArac> getAllArac();

    public DtoArac aracEkle(DtoAracUI dtoAracUI);

}
