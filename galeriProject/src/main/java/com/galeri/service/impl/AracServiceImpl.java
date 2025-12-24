package com.galeri.service.impl;

import com.galeri.dto.DtoArac;
import com.galeri.dto.DtoAracResmi;
import com.galeri.model.Arac;
import com.galeri.repository.AracRepository;
import com.galeri.service.AracService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AracServiceImpl implements AracService {

    @Autowired
    private AracRepository aracRepository;


    @Override
    public List<DtoArac> getAllArac() {

        List<Arac> aracList = aracRepository.findAll();
        List<DtoArac> dtoAracList = new ArrayList<>();

        for(Arac arac : aracList){
            DtoArac dtoArac = new DtoArac();
            BeanUtils.copyProperties(arac,dtoArac);

            DtoAracResmi dtoAracResmi = new DtoAracResmi();
            BeanUtils.copyProperties(arac.getAracResmi(),dtoAracResmi);
            dtoArac.setAracResmi(List.of(dtoAracResmi));

            dtoAracList.add(dtoArac);
        }

        return dtoAracList;
    }
}
