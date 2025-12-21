package com.galeri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {

    @Id
    @Column(name = "model_id")
    private Long modelId;

    @Column(name = "model_adi")
    private String modelAdi;

    @ManyToOne
    @JoinColumn(name = "marka_id" , referencedColumnName = "marka_id")
    private Marka marka;

}
