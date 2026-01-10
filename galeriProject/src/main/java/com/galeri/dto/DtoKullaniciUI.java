package com.galeri.dto;

import com.galeri.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoKullaniciUI {

    @Email(message = "Geçerli bir email adresi giriniz.")
    private String username;

    private String isim;

    private String soyisim;

    private String password;

    @Size(min = 11, max = 11, message = "Telefon numarası 11 haneli olmalıdır.")
    private String telefonNo;

    private Role role;

}
