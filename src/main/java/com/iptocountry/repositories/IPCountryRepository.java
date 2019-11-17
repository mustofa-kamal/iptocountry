package com.iptocountry.repositories;


import com.iptocountry.entities.IPCountryDo;
import org.springframework.data.repository.CrudRepository;


public interface IPCountryRepository extends CrudRepository<IPCountryDo, Long> {
}

