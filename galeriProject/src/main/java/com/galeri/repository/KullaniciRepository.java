package com.galeri.repository;

import com.galeri.model.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, String> {

    Optional<Kullanici> findByUsername(String username);

}
