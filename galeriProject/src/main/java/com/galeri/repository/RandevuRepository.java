package com.galeri.repository;

import com.galeri.model.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RandevuRepository extends JpaRepository<Randevu, Long> {

    List<Randevu> findByKullanici_Username(String username);

    Optional<Randevu> findByRandevuId(Long randevuId);

}
