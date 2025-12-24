package com.galeri.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GalericiAuthRequest {

    private String galericiId;

    private String password;

}
