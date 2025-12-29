package com.galeri.controller.impl;

import com.galeri.controller.RandevuController;
import com.galeri.dto.DtoRandevu;
import com.galeri.dto.DtoRandevuUI;
import com.galeri.service.RandevuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/randevu")
public class RandevuControllerImpl implements RandevuController {

    @Autowired
    private RandevuService randevuService;


    @Override
    @PostMapping(path = "/randevuAl")
    public DtoRandevu randevuAl(@RequestBody DtoRandevuUI dtoRandevuUI) {
        return randevuService.randevuAl(dtoRandevuUI);
    }

    @Override
    @GetMapping(path = "/getAllRandevular")
    public List<DtoRandevu> getAllRandevular() {
        return randevuService.getAllRandevular();
    }

    @Override
    @GetMapping(path = "/getRandevularByUsername/{username}")
    public List<DtoRandevu> getRandevularByUsername(@PathVariable(name = "username" , required = true) String username) {
        return randevuService.getRandevularByUsername(username);
    }

    @Override
    @DeleteMapping(path = "/randevuSil/{randevuId}")
    public boolean randevuSil(@PathVariable(name = "randevuId" , required = true) Long randevuId) {
        return randevuService.randevuSil(randevuId);
    }

}
