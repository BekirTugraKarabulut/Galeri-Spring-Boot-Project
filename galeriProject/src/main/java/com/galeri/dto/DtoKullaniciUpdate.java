package com.galeri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoKullaniciUpdate {

    private String username;

    private String isim;

    private String soyisim;

    private String telefonNo;

}
