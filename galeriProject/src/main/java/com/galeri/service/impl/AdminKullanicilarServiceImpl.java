package com.galeri.service.impl;

import com.galeri.dto.DtoKullanici;
import com.galeri.model.Kullanici;
import com.galeri.repository.AdminKullanicilarRepository;
import com.galeri.service.AdminKullanicilarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminKullanicilarServiceImpl implements AdminKullanicilarService {

    @Autowired
    private AdminKullanicilarRepository adminKullanicilarRepository;

    @Override
    public List<DtoKullanici> getAllKullanicilar() {

        List<Kullanici> kullaniciList = adminKullanicilarRepository.findAll();
        List<DtoKullanici> dtoKullanicis = new ArrayList<>();

        for(Kullanici kullanici : kullaniciList){
            DtoKullanici dtoKullanici = new DtoKullanici();
            BeanUtils.copyProperties(kullanici,dtoKullanici);
            dtoKullanicis.add(dtoKullanici);
        }
        return dtoKullanicis;
    }

}
