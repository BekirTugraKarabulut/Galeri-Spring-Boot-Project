package com.galeri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "arac")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arac_id")
    private Long aracId;

    @Column(name = "marka")
    private String marka;

    @Column(name = "model")
    private String model;

    @Column(name = "yil")
    private Long yil;

    @Column(name = "fiyat")
    private String fiyat;

    @Column(name = "arac_resmi")
    private String aracResmi;

    @ManyToOne
    @JoinColumn(name = "galerici_id" , referencedColumnName = "galerici_id")
    private Galerici galerici;

    @OneToMany(mappedBy = "arac", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Favorileme> favorilemes;

    @ManyToOne
    private Marka markas;

}
