package com.iptocountry.services.impl;


import com.google.common.collect.ImmutableList;
import com.iptocountry.entities.IPCountryDo;
import com.iptocountry.repositories.IPCountryRepository;
import com.iptocountry.services.IPCountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class IPCountryServiceImpl implements IPCountryService {

    private static final Logger logger = LoggerFactory.getLogger(IPCountryServiceImpl.class);

    IPCountryRepository ipCountryRepository;

    public IPCountryServiceImpl(IPCountryRepository ipCountryRepository) {
        this.ipCountryRepository = ipCountryRepository;
    }

    @Override
    public List<IPCountryDo> getIpCountries() {
        final List<IPCountryDo> ipCountries = ImmutableList.copyOf(ipCountryRepository.findAll());
        logger.info("List all ipCountryList=[{}]", ipCountries);

        return ipCountries;
    }
}










