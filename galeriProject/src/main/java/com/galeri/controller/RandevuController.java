package com.galeri.controller;

import com.galeri.dto.DtoRandevu;
import com.galeri.dto.DtoRandevuUI;

import java.util.List;

public interface RandevuController {

    public DtoRandevu randevuAl(DtoRandevuUI dtoRandevuUI);

    public List<DtoRandevu> getAllRandevular();

    public List<DtoRandevu> getRandevularByUsername(String username);

    public boolean randevuSil(Long randevuId);

}
