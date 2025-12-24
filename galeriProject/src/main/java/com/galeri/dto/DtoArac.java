package com.galeri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoArac {

    private Long aracId;

    private String marka;

    private String model;

    private Long yil;

    private String fiyat;

    private List<DtoAracResmi> aracResmi;

}
