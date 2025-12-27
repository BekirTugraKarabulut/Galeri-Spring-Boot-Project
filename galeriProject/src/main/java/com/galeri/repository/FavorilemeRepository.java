package com.galeri.repository;

import com.galeri.model.Favorileme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorilemeRepository extends JpaRepository<Favorileme, Long> {

}
