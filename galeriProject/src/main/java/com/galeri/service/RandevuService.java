package com.galeri.service;

import com.galeri.dto.DtoRandevu;
import com.galeri.dto.DtoRandevuUI;

import java.util.List;

public interface RandevuService {

    public DtoRandevu randevuAl(DtoRandevuUI dtoRandevuUI);

    public List<DtoRandevu> getAllRandevular();

    public List<DtoRandevu> getRandevularByUsername(String username);

}
