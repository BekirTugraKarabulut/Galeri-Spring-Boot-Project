package com.galeri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoFavorileme {

    private Long favorilemeId;

    private DtoKullanici kullanici;

    private DtoArac arac;

}
