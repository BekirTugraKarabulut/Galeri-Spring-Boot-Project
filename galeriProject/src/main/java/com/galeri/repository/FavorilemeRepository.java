package com.galeri.repository;

import com.galeri.model.Favorileme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavorilemeRepository extends JpaRepository<Favorileme, Long> {

    List<Favorileme> findByKullanici_Username(String username);

}
