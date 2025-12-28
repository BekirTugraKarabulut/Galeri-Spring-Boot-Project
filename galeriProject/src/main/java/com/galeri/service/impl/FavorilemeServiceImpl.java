package com.galeri.service.impl;

import com.galeri.dto.DtoArac;
import com.galeri.dto.DtoFavorileme;
import com.galeri.dto.DtoFavorilemeUI;
import com.galeri.dto.DtoKullanici;
import com.galeri.model.Arac;
import com.galeri.model.Favorileme;
import com.galeri.model.Kullanici;
import com.galeri.repository.AracRepository;
import com.galeri.repository.FavorilemeRepository;
import com.galeri.repository.KullaniciRepository;
import com.galeri.service.FavorilemeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavorilemeServiceImpl implements FavorilemeService {

    @Autowired
    private FavorilemeRepository favorilemeRepository;

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @Autowired
    private AracRepository aracRepository;

    @Override
    public DtoFavorileme favorilemeEkle(DtoFavorilemeUI dtoFavorilemeUI) {

        Favorileme favorileme = new Favorileme();

        Kullanici kullanici = new Kullanici();
        kullanici.setUsername(dtoFavorilemeUI.getKullanici().getUsername());
        Optional<Kullanici> kullaniciOptional = kullaniciRepository.findByUsername(kullanici.getUsername());

        if(kullaniciOptional.isEmpty()){
            return null;
        }
        favorileme.setKullanici(kullaniciOptional.get());

        Arac arac = new Arac();
        arac.setAracId(dtoFavorilemeUI.getArac().getAracId());
        Optional<Arac> aracOptional = aracRepository.findByAracId(arac.getAracId());

        if(aracOptional.isEmpty()){
            return null;
        }
        favorileme.setArac(aracOptional.get());

        Favorileme dbFavorileme = favorilemeRepository.save(favorileme);
        DtoFavorileme dtoFavorileme = new DtoFavorileme();
        BeanUtils.copyProperties(dbFavorileme, dtoFavorileme);

        DtoKullanici dtoKullanici = new DtoKullanici();
        BeanUtils.copyProperties(dbFavorileme.getKullanici(), dtoKullanici);
        dtoFavorileme.setKullanici(dtoKullanici);

        DtoArac dtoArac = new DtoArac();
        BeanUtils.copyProperties(dbFavorileme.getArac(), dtoArac);
        dtoFavorileme.setArac(dtoArac);

        return dtoFavorileme;
    }

    @Override
    public List<DtoFavorileme> kullaniciFavoriListByUsername(String username) {

        List<Favorileme> favorilemeList = favorilemeRepository.findByKullanici_Username(username);
        List<DtoFavorileme> dtoFavorilemes = new ArrayList<>();

        for(Favorileme favorileme : favorilemeList){
            DtoFavorileme dtoFavorileme = new DtoFavorileme();
            BeanUtils.copyProperties(favorileme, dtoFavorileme);

            DtoKullanici dtoKullanici = new DtoKullanici();
            BeanUtils.copyProperties(favorileme.getKullanici(), dtoKullanici);
            dtoFavorileme.setKullanici(dtoKullanici);

            DtoArac dtoArac = new DtoArac();
            BeanUtils.copyProperties(favorileme.getArac(), dtoArac);
            dtoFavorileme.setArac(dtoArac);

            dtoFavorilemes.add(dtoFavorileme);
        }

        return dtoFavorilemes;
    }

    @Override
    public boolean favorilemeSil(Long favorilemeId) {

        Optional<Favorileme> favorileme = favorilemeRepository.findByFavorilemeId(favorilemeId);

        if(favorileme.isPresent()){
            favorilemeRepository.deleteById(favorilemeId);
            return true;
        }else{
            return false;
        }
    }
}
