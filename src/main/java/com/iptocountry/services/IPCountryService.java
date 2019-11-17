package com.iptocountry.services;


import com.iptocountry.entities.IPCountryDo;

import java.util.List;

public interface IPCountryService {
    List<IPCountryDo> getIpCountries();
}