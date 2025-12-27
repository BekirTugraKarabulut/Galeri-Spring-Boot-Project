package com.galeri.repository;

import com.galeri.model.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RandevuRepository extends JpaRepository<Randevu, Long> {

    List<Randevu> findByKullanici_Username(String username);

}
