package com.galeri.repository;

import com.galeri.model.Arac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AracRepository extends JpaRepository<Arac, Long> {

}
