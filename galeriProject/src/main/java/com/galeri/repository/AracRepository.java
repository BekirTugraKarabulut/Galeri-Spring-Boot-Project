package com.galeri.repository;

import com.galeri.model.Arac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AracRepository extends JpaRepository<Arac, Long> {

    Optional<Arac> findByAracId(Long aracId);

    List<Arac> findByMarka(String marka);

}
