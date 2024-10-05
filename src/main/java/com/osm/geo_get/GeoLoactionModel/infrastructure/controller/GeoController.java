package com.osm.geo_get.GeoLoactionModel.infrastructure.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.osm.geo_get.GeoLoactionModel.application.service.GeoService;
import com.osm.geo_get.GeoLoactionModel.domain.GeoCoordinates;
import com.osm.geo_get.GeoLoactionModel.domain.GeoLocation;
import com.osm.geo_get.common.Exceptions.GeoDomainExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class GeoController {

    private final GeoService geoService;


    @GetMapping("/location")
    public String getGeoLocation(@RequestParam(name = "lat") String lat, @RequestParam(name = "lon") String lon) throws GeoDomainExceptions, JsonProcessingException {
        GeoCoordinates geoCoordinates = new GeoCoordinates();
        geoCoordinates.setLatitude(lat);
        geoCoordinates.setLongitude(lon);
        return geoService.getGeoLocation(geoCoordinates);
    }

    @GetMapping("/coordinates")
    public String getGeoCoordinates(@RequestParam(name = "q") String geoLocation) throws GeoDomainExceptions, JsonProcessingException {
        return geoService.getGeoCoordinates(geoLocation);
    }
}
