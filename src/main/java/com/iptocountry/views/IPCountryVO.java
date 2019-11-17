package com.iptocountry.views;

import java.util.Objects;

public class IPCountryVO {


    private Long endIp;

    private String countryCode;

    public IPCountryVO(Long endIp, String countryCode) {
        this.endIp = endIp;
        this.countryCode = countryCode;
    }

    public Long getEndIp() {
        return endIp;
    }

    public void setEndIp(Long endIp) {
        this.endIp = endIp;
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
        IPCountryVO that = (IPCountryVO) o;
        return endIp.equals(that.endIp) &&
                countryCode.equals(that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endIp, countryCode);
    }
}
