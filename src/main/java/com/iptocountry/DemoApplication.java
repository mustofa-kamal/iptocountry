package com.iptocountry;


import com.iptocountry.entities.IPCountryDo;
import com.iptocountry.repositories.IPCountryRepository;
import com.iptocountry.utils.IP2CountyCodeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(
            IPCountryRepository iPCountryRepository) {

        return (args) -> {


            List<IPCountryDo> iPCountryDoes = new ArrayList<>();

            IP2CountyCodeMap iP2CountyCodeMap = new IP2CountyCodeMap();


            iPCountryDoes.add(iP2CountyCodeMap.getIPCountryDo("192.168.0.0", "192.168.100.0", "USA"));

            iPCountryDoes.add(iP2CountyCodeMap.getIPCountryDo("192.168.100.1", "192.168.200.0", "Mexico"));

            iPCountryDoes.add(iP2CountyCodeMap.getIPCountryDo("192.168.200.1", "192.168.240.0", "Brazil"));


            iPCountryRepository.save(iPCountryDoes);


            log.info("Show all ip, with country name: ");
            log.info("-------------------");
            for (IPCountryDo iPCountryDo : iPCountryRepository.findAll()) {
                log.info(iPCountryDo.toString());


            }


        };


    }


}
