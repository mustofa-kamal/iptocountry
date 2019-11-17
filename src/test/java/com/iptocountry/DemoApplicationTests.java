package com.iptocountry;

import com.iptocountry.entities.IPCountryDo;
import com.iptocountry.repositories.IPCountryRepository;
import com.iptocountry.services.IPCountryService;
import com.iptocountry.utils.IP2CountyCodeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    IPCountryRepository iPCountryRepository;

    @Autowired
    IPCountryService ipCountryService;


    @Before
    public void loadIp() {


        IP2CountyCodeMap iP2CountyCodeMap = new IP2CountyCodeMap();


        List<IPCountryDo> iPCountryDoes = new ArrayList<>();


        iPCountryDoes.add(iP2CountyCodeMap.getIPCountryDo("192.168.0.0", "192.168.100.0", "USA"));

        iPCountryDoes.add(iP2CountyCodeMap.getIPCountryDo("192.168.100.1", "192.168.200.0", "Mexico"));

        iPCountryDoes.add(iP2CountyCodeMap.getIPCountryDo("192.168.200.1", "192.168.240.0", "Brazil"));

        iPCountryRepository.save(iPCountryDoes);
    }

    @Test
    public void countryName() {

        List<IPCountryDo> ipCountries = ipCountryService.getIpCountries();

        IP2CountyCodeMap iP2CountyCodeMap = new IP2CountyCodeMap();

        Assert.assertEquals("USA", iP2CountyCodeMap.getCountryName(ipCountries, "192.168.9.9"));
        Assert.assertEquals("Mexico", iP2CountyCodeMap.getCountryName(ipCountries, "192.168.100.9"));
        Assert.assertEquals("Brazil", iP2CountyCodeMap.getCountryName(ipCountries, "192.168.200.9"));
    }

}
