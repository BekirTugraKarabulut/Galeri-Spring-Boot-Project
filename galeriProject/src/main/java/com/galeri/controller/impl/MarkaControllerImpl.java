package com.galeri.controller.impl;

import com.galeri.controller.MarkaController;
import com.galeri.dto.DtoMarkaAraba;
import com.galeri.service.MarkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/marka")
public class MarkaControllerImpl implements MarkaController {

    @Autowired
    private MarkaService markaService;


    @Override
    @GetMapping(path = "/araclar/{marka}")
    public List<DtoMarkaAraba> getAracByMarka(@PathVariable(name = "marka" , required = true) String marka) {
        return markaService.getAracByMarka(marka);
    }

}
