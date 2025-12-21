package com.galeri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    @Column(name = "rol_id")
    private Long rolId;

    @Column(name = "rol")
    private String rol;

    @OneToOne(mappedBy = "rol" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Kullanici kullanici;


}
