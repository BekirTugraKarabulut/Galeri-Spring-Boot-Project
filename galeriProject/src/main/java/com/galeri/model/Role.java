package com.galeri.model;

import lombok.Getter;

@Getter
public enum Role {

    KULLANICI("KULLANICI"),
    GALERICI("GALERICI"),;

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

}
