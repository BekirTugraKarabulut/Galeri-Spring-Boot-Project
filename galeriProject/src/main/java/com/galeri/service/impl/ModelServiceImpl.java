package com.galeri.service.impl;

import com.galeri.dto.DtoArac;
import com.galeri.model.Arac;
import com.galeri.model.Model;
import com.galeri.repository.AracRepository;
import com.galeri.repository.ModelRepository;
import com.galeri.service.ModelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private AracRepository aracRepository;


    @Override
    public List<DtoArac> getModelByModelAdi(String modelAdi) {

        Optional<Model> model = modelRepository.findByModelAdi(modelAdi);

        if(model.isPresent()) {

            List<Arac> aracList = aracRepository.findByModel(model.get().getModelAdi());
            List<DtoArac> dtoAracList = new ArrayList<>();

            for (Arac arac : aracList){
                DtoArac dtoArac = new DtoArac();
                BeanUtils.copyProperties(arac,dtoArac);
                dtoAracList.add(dtoArac);
            }

            return dtoAracList;
        }

        return null;
    }
}
