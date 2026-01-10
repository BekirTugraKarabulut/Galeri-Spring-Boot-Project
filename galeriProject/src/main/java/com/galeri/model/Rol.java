package com.galeri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rol_id")
    private Integer rolId;

    @Column(name = "rol")
    private String rol;

    @OneToMany(mappedBy = "rol" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Kullanici> kullanici;

    @OneToOne(mappedBy = "rol" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Galerici galerici;

}
