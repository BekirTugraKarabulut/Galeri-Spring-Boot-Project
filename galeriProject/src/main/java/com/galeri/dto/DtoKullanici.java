package com.galeri.dto;

import com.galeri.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoKullanici {

    private String username;

    private String isim;

    private String soyisim;

    private String password;

    private String telefonNo;

    private Role role;

    private Integer roleId;

}
