package com.galeri.controller.impl;

import com.galeri.controller.AracController;
import com.galeri.dto.DtoArac;
import com.galeri.dto.DtoAracUI;
import com.galeri.service.AracService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AracControllerImpl implements AracController {

    @Autowired
    private AracService aracService;

    @Override
    @GetMapping(path = "/araclar")
    public List<DtoArac> getAllArac() {
        return aracService.getAllArac();
    }

    @Override
    @PostMapping(path = "/arac-ekle")
    public DtoArac aracEkle(@RequestBody DtoAracUI dtoAracUI) {
        return aracService.aracEkle(dtoAracUI);
    }

    @Override
    @DeleteMapping(path = "/arac-sil/{aracId}")
    public boolean aracSil(@PathVariable(name = "aracId" , required = true) Long aracId) {
        return aracService.aracSil(aracId);
    }

}
