package com.galeri.service.impl;

import com.galeri.dto.DtoArac;
import com.galeri.dto.DtoAracUI;
import com.galeri.dto.DtoAracUpdate;
import com.galeri.dto.DtoGalerici;
import com.galeri.model.Arac;
import com.galeri.model.Galerici;
import com.galeri.repository.AracRepository;
import com.galeri.repository.GalericiRepository;
import com.galeri.service.AracService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AracServiceImpl implements AracService {

    @Autowired
    private AracRepository aracRepository;

    @Autowired
    private GalericiRepository galericiRepository;

    @Override
    public List<DtoArac> getAllArac() {

        List<Arac> aracList = aracRepository.findAll();
        List<DtoArac> dtoAracList = new ArrayList<>();

        for(Arac arac : aracList){
            DtoArac dtoArac = new DtoArac();
            BeanUtils.copyProperties(arac,dtoArac);

            dtoAracList.add(dtoArac);
        }

        return dtoAracList;
    }

    @Override
    public DtoArac aracEkle(DtoAracUI dtoAracUI) {

        Arac arac = new Arac();
        arac.setMarka(dtoAracUI.getMarka());
        arac.setModel(dtoAracUI.getModel());
        arac.setFiyat(dtoAracUI.getFiyat());
        arac.setYil(dtoAracUI.getYil());
        arac.setAracResmi(dtoAracUI.getAracResmi());

        Galerici galerici = new Galerici();
        galerici.setGalericiId(dtoAracUI.getGalerici().getGalericiId());
        Optional<Galerici> galericiOptional = galericiRepository.findByGalericiId(dtoAracUI.getGalerici().getGalericiId());
        arac.setGalerici(galericiOptional.get());

        Arac dbArac = aracRepository.save(arac);
        DtoArac dtoArac = new DtoArac();
        BeanUtils.copyProperties(dbArac,dtoArac);

        DtoGalerici dtoGalerici = new DtoGalerici();
        BeanUtils.copyProperties(dbArac.getGalerici(),dtoGalerici);
        dtoArac.setGalerici(dtoGalerici);

        return dtoArac;

    }

    @Override
    public boolean aracSil(Long aracId) {

        Optional<Arac> arac = aracRepository.findByAracId(aracId);

        if(arac.isPresent()){
            aracRepository.delete(arac.get());
            return true;
        }else{
            return false;
        }

    }

    @Override
    public DtoArac aracbyAracId(Long aracId) {

        Optional<Arac> arac = aracRepository.findByAracId(aracId);

        if(arac.isPresent()){
            DtoArac dtoArac = new DtoArac();
            BeanUtils.copyProperties(arac.get(),dtoArac);

            DtoGalerici dtoGalerici = new DtoGalerici();
            BeanUtils.copyProperties(arac.get().getGalerici(),dtoGalerici);
            dtoArac.setGalerici(dtoGalerici);

            return dtoArac;
        }else{
            return null;
        }

    }

    @Override
    public DtoArac updateAracByAracId(Long aracId, DtoAracUpdate dtoAracUpdate) {

        Optional<Arac> arac = aracRepository.findByAracId(aracId);

        if(arac.isPresent()){
            arac.get().setMarka(dtoAracUpdate.getMarka());
            arac.get().setModel(dtoAracUpdate.getModel());
            arac.get().setFiyat(dtoAracUpdate.getFiyat());
            arac.get().setYil(dtoAracUpdate.getYil());
            Arac dbArac = aracRepository.save(arac.get());
            DtoArac dtoArac = new DtoArac();
            BeanUtils.copyProperties(dbArac,dtoArac);

            DtoGalerici dtoGalerici = new DtoGalerici();
            BeanUtils.copyProperties(dbArac.getGalerici(),dtoGalerici);
            dtoArac.setGalerici(dtoGalerici);

            return dtoArac;
        }else{
            return null;
        }

    }


}
