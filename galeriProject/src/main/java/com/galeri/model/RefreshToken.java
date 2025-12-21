package com.galeri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "refresh_token")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refresh_token_id")
    private Long refreshTokenId;

    @Column(name = "token")
    private String token;

    @Column(name = "baslangic_tarihi")
    private Date issueDate;

    @Column(name = "bitis_tarihi")
    private Date expireDate;

    @ManyToOne
    @JoinColumn(name = "email" , referencedColumnName = "email")
    private Kullanici kullanici;

}
