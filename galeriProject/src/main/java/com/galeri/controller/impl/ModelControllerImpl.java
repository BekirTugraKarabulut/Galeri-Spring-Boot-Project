package com.galeri.controller.impl;

import com.galeri.controller.ModelController;
import com.galeri.dto.DtoArac;
import com.galeri.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelControllerImpl implements ModelController {

    @Autowired
    private ModelService modelService;

    @Override
    @GetMapping(path = "/getModel/{modelAdi}")
    public List<DtoArac> getModelByModelAdi(@PathVariable(name = "modelAdi" , required = true) String modelAdi) {
        return modelService.getModelByModelAdi(modelAdi);
    }

}
