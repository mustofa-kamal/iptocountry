package com.iptocountry.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class CountryCodeEntryDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected CountryCodeEntryDo() {
    }


    public Long endIpAddress;
    public String countryCode;

    public CountryCodeEntryDo(Long endIpAddress, String countryCode) {
        this.endIpAddress = endIpAddress;
        this.countryCode = countryCode;
    }

    public Long getEndIpAddress() {
        return endIpAddress;
    }

    public void setEndIpAddress(Long endIpAddress) {
        this.endIpAddress = endIpAddress;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryCodeEntryDo that = (CountryCodeEntryDo) o;
        return Objects.equals(endIpAddress, that.endIpAddress) &&
                Objects.equals(countryCode, that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endIpAddress, countryCode);
    }
}
