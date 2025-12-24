package com.galeri.service.impl;

import com.galeri.dto.DtoKullanici;
import com.galeri.model.Kullanici;
import com.galeri.repository.KullaniciRepository;
import com.galeri.service.KullaniciService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KullaniciServiceImpl implements KullaniciService {

    @Autowired
    private KullaniciRepository kullaniciRepository;


    @Override
    public DtoKullanici getKullaniciByUsername(String username) {

        Optional<Kullanici> kullaniciOptional = kullaniciRepository.findByUsername(username);

        if(kullaniciOptional.isEmpty()){
            return null;
        }

        DtoKullanici dtoKullanici = new DtoKullanici();
        BeanUtils.copyProperties(kullaniciOptional.get(), dtoKullanici);

        return dtoKullanici;
    }
}
