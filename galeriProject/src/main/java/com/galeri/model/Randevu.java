package com.galeri.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "randevu",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"randevu_tarihi", "randevu_saati", "galerici_id"})
        }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Randevu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "randevu_id")
    private Long randevuId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "randevu_tarihi")
    private Date randevuTarihi;

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "HH:mm")
    @Column(name = "randevu_saati")
    private String randevuSaati;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Kullanici kullanici;

    @ManyToOne
    @JoinColumn(name = "galerici_id", referencedColumnName = "galerici_id")
    private Galerici galerici;

}
