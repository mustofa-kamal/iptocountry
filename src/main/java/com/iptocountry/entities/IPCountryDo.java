package com.iptocountry.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class IPCountryDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Long startIpAddress;

    private Long endIpAddress;

    private String countryCode;


    public IPCountryDo() {

    }

    public IPCountryDo(Long startIpAddress, Long endIpAddress, String countryCode) {
        this.startIpAddress = startIpAddress;
        this.endIpAddress = endIpAddress;
        this.countryCode = countryCode;
    }

    public Long getStartIpAddress() {
        return startIpAddress;
    }

    public void setStartIpAddress(Long startIpAddress) {
        this.startIpAddress = startIpAddress;
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
        IPCountryDo that = (IPCountryDo) o;
        return startIpAddress.equals(that.startIpAddress) &&
                endIpAddress.equals(that.endIpAddress) &&
                countryCode.equals(that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startIpAddress, endIpAddress, countryCode);
    }

    @Override
    public String toString() {
        return "IPCountryDo{" +
                "id=" + id +
                ", startIpAddress=" + startIpAddress +
                ", endIpAddress=" + endIpAddress +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
