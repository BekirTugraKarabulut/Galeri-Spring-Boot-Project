package com.galeri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "arac_resmi")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AracResmi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resim_id")
    private Long resimId;

    @Column(name = "resim_url")
    private String resimUrl;

    @ManyToOne
    @JoinColumn(name = "arac_id", referencedColumnName = "arac_id")
    private Arac arac;

}
