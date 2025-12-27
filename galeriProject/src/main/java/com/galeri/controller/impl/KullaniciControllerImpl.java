package com.galeri.controller.impl;

import com.galeri.controller.KullaniciController;
import com.galeri.dto.DtoKullanici;
import com.galeri.dto.DtoKullaniciUI;
import com.galeri.dto.DtoKullaniciUpdate;
import com.galeri.service.KullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kullanici")
public class KullaniciControllerImpl implements KullaniciController {

    @Autowired
    private KullaniciService kullaniciService;


    @Override
    @GetMapping(path = "/get/{username}")
    public DtoKullanici getKullaniciByUsername(@PathVariable(name = "username" , required = true) String username) {
        return kullaniciService.getKullaniciByUsername(username);
    }

    @Override
    @PutMapping(path = "/update/{username}")
    public DtoKullanici updateKullanici(@PathVariable(name = "username" ,required = true) String username,@RequestBody DtoKullaniciUpdate dtoKullaniciUpdate) {
        return kullaniciService.updateKullanici(username, dtoKullaniciUpdate);
    }

}
