package com.example.fullstejk;

import com.example.fullstejk.service.GeoLocationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AppController {

    private final GeoLocationService geoLocationService;

    @GetMapping("/")
    public ResponseEntity<Object> respond(HttpServletRequest httpServletRequest) {
        String userIp = httpServletRequest.getRemoteAddr();
        return ResponseEntity.ok(geoLocationService.handleResponse(geoLocationService.APIInfo(userIp), userIp));
    }

}
