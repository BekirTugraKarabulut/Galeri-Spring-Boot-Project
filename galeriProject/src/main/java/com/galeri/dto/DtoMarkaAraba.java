package com.galeri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoMarkaAraba {

    private Long aracId;

    private String marka;

    private String model;

    private Long yil;

    private String fiyat;

    private String aracResmi;

}
