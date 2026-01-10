package com.galeri.repository;

import com.galeri.model.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminKullanicilarRepository extends JpaRepository<Kullanici , String> {


}
