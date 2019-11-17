package com.iptocountry.utils;


import com.iptocountry.entities.CountryCodeEntryDo;
import com.iptocountry.entities.IPCountryDo;
import com.iptocountry.views.IPCountryVO;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IP2CountyCodeMap {


    public static class IPv4 {


        public static Long toLong(String ipAddress) {
            if (ipAddress == null || ipAddress.isEmpty()) {
                throw new IllegalArgumentException("ip address cannot be null or empty");
            }
            String[] octets = ipAddress.split(java.util.regex.Pattern.quote("."));
            if (octets.length != 4) {
                throw new IllegalArgumentException("invalid ip address");
            }
            Long ip = 0l;
            for (int i = 3; i >= 0; i--) {
                long octet = Long.parseLong(octets[3 - i]);
                if (octet > 255 || octet < 0) {
                    throw new IllegalArgumentException("invalid ip address");
                }
                ip |= octet << (i * 8);
            }
            return ip;
        }


        public static String toString(long ip) {
            // if ip is bigger than 255.255.255.255 or smaller than 0.0.0.0
            if (ip > 4294967295l || ip < 0) {
                throw new IllegalArgumentException("invalid ip");
            }
            StringBuilder ipAddress = new StringBuilder();
            for (int i = 3; i >= 0; i--) {
                int shift = i * 8;
                ipAddress.append((ip & (0xff << shift)) >> shift);
                if (i > 0) {
                    ipAddress.append(".");
                }
            }
            return ipAddress.toString();
        }


    }


    private final TreeMap<Long, CountryCodeEntryDo> ipMap = new TreeMap();

    public void addIpRange(String startIp, String endIp, String countryCode) {
        addIpRange(IPv4.toLong(startIp), IPv4.toLong(endIp), countryCode);

    }

    public void addIpRange(long startIp, long endIp, String countryCode) {
        ipMap.put(startIp, new CountryCodeEntryDo(endIp, countryCode));
    }

    public String getCountryCode(String ip) {
        return getCountryCode(IPv4.toLong(ip));
    }


    public IPCountryDo getIPCountryDo(String startIp, String endIp, String countryCode) {


        IPCountryDo iPCountryDo = new IPCountryDo(IPv4.toLong(startIp),
                IPv4.toLong(endIp), countryCode);

        return iPCountryDo;

    }

    public String getCountryCode(long ip) {
        Map.Entry<Long, CountryCodeEntryDo> entry = ipMap.floorEntry(ip);
        if (entry != null && ip <= entry.getValue().endIpAddress) {
            return entry.getValue().countryCode;
        }
        return null;
    }


    public String getCountryName(List<IPCountryDo> ipCountryListDo, String ipAddress) {

        Map<Long, IPCountryVO> ipMap = new TreeMap();
        ipCountryListDo.forEach(e -> ipMap.put(e.getStartIpAddress(),
                new IPCountryVO(e.getEndIpAddress(), e.getCountryCode())));


        Long ip = IPv4.toLong(ipAddress);


        Map.Entry<Long, IPCountryVO> entry = ((TreeMap<Long, IPCountryVO>) ipMap).floorEntry(ip);
        if (entry != null && ip <= entry.getValue().getEndIp()) {
            return entry.getValue().getCountryCode();
        }

        return "No match found";
    }

}
