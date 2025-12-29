package com.galeri.controller;

import com.galeri.dto.DtoArac;

import java.util.List;

public interface ModelController {

    public List<DtoArac> getModelByModelAdi(String modelAdi);

}
