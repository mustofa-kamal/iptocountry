package com.iptocountry.controller;


import com.iptocountry.entities.IPCountryDo;
import com.iptocountry.services.IPCountryService;
import com.iptocountry.utils.IP2CountyCodeMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ip")
public class IPCountryController {

    private final IPCountryService ipCountryService;

    public IPCountryController(IPCountryService ipCountryService) {
        this.ipCountryService = ipCountryService;
    }


    @RequestMapping(path = "/{address:.+}", method = RequestMethod.GET)
    public String getCountryCode(@PathVariable final String address) {

        List<IPCountryDo> ipCountries = ipCountryService.getIpCountries();

        IP2CountyCodeMap iP2CountyCodeMap = new IP2CountyCodeMap();

        return iP2CountyCodeMap.getCountryName(ipCountries, address);
    }
}




