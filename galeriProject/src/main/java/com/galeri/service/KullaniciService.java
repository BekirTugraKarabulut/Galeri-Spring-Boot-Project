package com.galeri.service;

import com.galeri.dto.DtoKullanici;

public interface KullaniciService {

    public DtoKullanici getKullaniciByUsername(String username);

}
