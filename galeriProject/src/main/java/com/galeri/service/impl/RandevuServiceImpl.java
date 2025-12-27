package com.galeri.service.impl;

import com.galeri.dto.DtoGalerici;
import com.galeri.dto.DtoKullanici;
import com.galeri.dto.DtoRandevu;
import com.galeri.dto.DtoRandevuUI;
import com.galeri.model.Arac;
import com.galeri.model.Galerici;
import com.galeri.model.Kullanici;
import com.galeri.model.Randevu;
import com.galeri.repository.GalericiRepository;
import com.galeri.repository.KullaniciRepository;
import com.galeri.repository.RandevuRepository;
import com.galeri.service.RandevuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RandevuServiceImpl implements RandevuService {

    @Autowired
    private RandevuRepository randevuRepository;

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @Autowired
    private GalericiRepository galericiRepository;

    @Override
    public DtoRandevu randevuAl(DtoRandevuUI dtoRandevuUI) {

        Randevu randevu = new Randevu();
        randevu.setRandevuSaati(dtoRandevuUI.getRandevuSaati());
        randevu.setRandevuTarihi(dtoRandevuUI.getRandevuTarihi());

        Kullanici kullanici = new Kullanici();
        kullanici.setUsername(dtoRandevuUI.getKullanici().getUsername());
        Optional<Kullanici> kullaniciOptional = kullaniciRepository.findByUsername(kullanici.getUsername());

        if(kullaniciOptional.isEmpty()){
            return null;
        }
        randevu.setKullanici(kullaniciOptional.get());

        Galerici galerici = new Galerici();
        galerici.setGalericiId(dtoRandevuUI.getGalerici().getGalericiId());
        Optional<Galerici> galericiOptional = galericiRepository.findByGalericiId(galerici.getGalericiId());

        if(galericiOptional.isEmpty()){
            return null;
        }
        randevu.setGalerici(galericiOptional.get());

        Randevu dbRandevu = randevuRepository.save(randevu);

        DtoRandevu dtoRandevu = new DtoRandevu();
        BeanUtils.copyProperties(dbRandevu, dtoRandevu);

        DtoKullanici dtoKullanici = new DtoKullanici();
        BeanUtils.copyProperties(dbRandevu.getKullanici(), dtoKullanici);
        dtoRandevu.setKullanici(dtoKullanici);

        DtoGalerici dtoGalerici = new DtoGalerici();
        BeanUtils.copyProperties(dbRandevu.getGalerici(), dtoGalerici);
        dtoRandevu.setGalerici(dtoGalerici);

        return dtoRandevu;
    }

    @Override
    public List<DtoRandevu> getAllRandevular() {

        List<Randevu> randevuList = randevuRepository.findAll();
        List<DtoRandevu> dtoRandevuList = new ArrayList<>();

        for(Randevu randevu : randevuList){
            DtoRandevu dtoRandevu = new DtoRandevu();
            BeanUtils.copyProperties(randevu, dtoRandevu);

            DtoKullanici dtoKullanici = new DtoKullanici();
            BeanUtils.copyProperties(randevu.getKullanici(), dtoKullanici);
            dtoRandevu.setKullanici(dtoKullanici);

            DtoGalerici dtoGalerici = new DtoGalerici();
            BeanUtils.copyProperties(randevu.getGalerici(), dtoGalerici);
            dtoRandevu.setGalerici(dtoGalerici);

            dtoRandevuList.add(dtoRandevu);
        }

        return dtoRandevuList;
    }

    @Override
    public List<DtoRandevu> getRandevularByUsername(String username) {

        List<Randevu> randevuList = randevuRepository.findByKullanici_Username(username);
        List<DtoRandevu> dtoRandevuList = new ArrayList<>();

        for (Randevu randevu : randevuList) {
            DtoRandevu dtoRandevu = new DtoRandevu();
            BeanUtils.copyProperties(randevu, dtoRandevu);

            DtoKullanici dtoKullanici = new DtoKullanici();
            BeanUtils.copyProperties(randevu.getKullanici(), dtoKullanici);
            dtoRandevu.setKullanici(dtoKullanici);

            DtoGalerici dtoGalerici = new DtoGalerici();
            BeanUtils.copyProperties(randevu.getGalerici(), dtoGalerici);
            dtoRandevu.setGalerici(dtoGalerici);

            dtoRandevuList.add(dtoRandevu);
        }
        return dtoRandevuList;
    }
}
