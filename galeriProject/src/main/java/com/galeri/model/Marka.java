package com.galeri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "marka")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marka {

    @Id
    @Column(name = "marka_id")
    private Long markaId;

    @Column(name = "marka_adi")
    private String markaAdi;

    @OneToMany(mappedBy = "marka" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Model> modelList;

    @OneToMany(mappedBy = "markas" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Arac> aracList;

}
