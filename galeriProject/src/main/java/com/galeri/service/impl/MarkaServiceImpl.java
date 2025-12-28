package com.galeri.service.impl;

import com.galeri.dto.DtoMarkaAraba;
import com.galeri.model.Arac;
import com.galeri.model.Marka;
import com.galeri.repository.AracRepository;
import com.galeri.repository.MarkaRepository;
import com.galeri.service.MarkaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MarkaServiceImpl implements MarkaService {

    @Autowired
    private MarkaRepository markaRepository;

    @Autowired
    private AracRepository aracRepository;


    @Override
    public List<DtoMarkaAraba> getAracByMarka(String marka) {

        Optional<Marka> markaOptional = markaRepository.findByMarkaAdi(marka);

        if(markaOptional.isPresent()) {

            List<Arac> aracList = aracRepository.findByMarka(markaOptional.get().getMarkaAdi());
            List<DtoMarkaAraba> dtoArabaList = new ArrayList<>();

            for(Arac arac : aracList) {
                DtoMarkaAraba dtoMarkaAraba = new DtoMarkaAraba();
                BeanUtils.copyProperties(arac, dtoMarkaAraba);
                dtoArabaList.add(dtoMarkaAraba);
            }

            return dtoArabaList;
        }else{
            return null;
        }

    }
}
