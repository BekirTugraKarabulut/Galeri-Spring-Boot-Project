package com.galeri.controller.impl;

import com.galeri.controller.AdminKullanicilarController;
import com.galeri.dto.DtoKullanici;
import com.galeri.service.AdminKullanicilarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminKullanicilarControllerImpl implements AdminKullanicilarController {

    @Autowired
    private AdminKullanicilarService adminKullanicilarService;


    @Override
    @GetMapping(path = "/admin/kullanicilar")
    public List<DtoKullanici> getAllKullanicilar() {
        return adminKullanicilarService.getAllKullanicilar();
    }

}
