package com.galeri.controller;

import com.galeri.dto.DtoKullanici;
import com.galeri.dto.DtoKullaniciUI;
import com.galeri.dto.DtoKullaniciUpdate;

public interface KullaniciController {

    public DtoKullanici getKullaniciByUsername(String username);

    public DtoKullanici updateKullanici(String username , DtoKullaniciUpdate dtoKullaniciUpdate);


}
