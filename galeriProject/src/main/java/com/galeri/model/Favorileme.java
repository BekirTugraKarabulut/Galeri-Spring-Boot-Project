package com.galeri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "favorileme")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorileme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorileme_id")
    private Long favorilemeId;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Kullanici kullanici;

    @ManyToOne
    @JoinColumn(name = "arac_id", referencedColumnName = "arac_id")
    private Arac arac;

}
