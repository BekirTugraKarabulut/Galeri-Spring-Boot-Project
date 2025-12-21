package com.galeri.repository;

import com.galeri.model.Galerici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GalericiRepository extends JpaRepository<Galerici,String> {

    Optional<Galerici> findByGalericiId(String galericiId);

}
