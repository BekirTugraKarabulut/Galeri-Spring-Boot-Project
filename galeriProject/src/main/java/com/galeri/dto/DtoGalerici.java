package com.galeri.dto;

import com.galeri.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoGalerici {

    private String galericiId;

    private String name;

    private String password;

}
