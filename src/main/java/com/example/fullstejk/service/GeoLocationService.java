package com.example.fullstejk.service;

import com.example.fullstejk.model.GeoInfo;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Service
@Slf4j
public class GeoLocationService {

    private final WebClient webClient = WebClient.create();

    @Value("${ipinfo.token}")
    private String token;

    @Value("${server.port}")
    private String port;

    @PostConstruct
    void init() {
        log.warn("Appka Sebastian Dyjach wjezdza na porcie " + port + " o godzinie " + LocalDateTime.now());
    }

    public GeoInfo APIInfo(String ipAddress) {
        return webClient.get()
                .uri(String.format("ipinfo.io/%s?token=%s", ipAddress, token))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GeoInfo.class)
                .block();
    }

    public String handleResponse(GeoInfo geoInfo, String userIp) {
        String LOCAL_IP = "172.18.0.1";
        if(geoInfo.getTimezone() == null && geoInfo.getIp().equals(LOCAL_IP)) {
            return String.format("This is %s and its timezone is Europe/Warsaw", userIp);
        } else if (geoInfo.getTimezone() == null) {
            return String.format("Unknown timezone for %s address", userIp);
        } else {
            return String.format("For %s ip address timezone is %s", geoInfo.getIp(), geoInfo.getTimezone());
        }
    }

}
