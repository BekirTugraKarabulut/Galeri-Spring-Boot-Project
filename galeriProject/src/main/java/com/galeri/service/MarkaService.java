package com.galeri.service;

import com.galeri.dto.DtoMarkaAraba;


import java.util.List;

public interface MarkaService {

    public List<DtoMarkaAraba> getAracByMarka(String marka);

}
