package com.galeri.controller;

import com.galeri.dto.DtoMarkaAraba;
import com.galeri.model.Arac;

import java.util.List;

public interface MarkaController {

    public List<DtoMarkaAraba> getAracByMarka(String marka);


}
