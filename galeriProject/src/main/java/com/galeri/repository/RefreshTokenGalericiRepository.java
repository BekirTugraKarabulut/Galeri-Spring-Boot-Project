package com.galeri.repository;

import com.galeri.model.RefreshTokenGalerici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenGalericiRepository extends JpaRepository<RefreshTokenGalerici, Long> {

    Optional<RefreshTokenGalerici> findByToken(String token);

}
