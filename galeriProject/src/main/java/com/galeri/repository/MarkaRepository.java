package com.galeri.repository;

import com.galeri.model.Marka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarkaRepository extends JpaRepository<Marka , Long> {

    Optional<Marka> findByMarkaAdi(String marka);

}
