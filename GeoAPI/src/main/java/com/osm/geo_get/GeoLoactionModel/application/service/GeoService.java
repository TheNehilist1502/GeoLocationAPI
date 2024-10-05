package com.osm.geo_get.GeoLoactionModel.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osm.geo_get.GeoLoactionModel.domain.GeoCoordinates;
import com.osm.geo_get.GeoLoactionModel.domain.GeoLocation;
import com.osm.geo_get.GeoLoactionModel.infrastructure.ws.GeoFeignResource;
import com.osm.geo_get.GeoLoactionModel.infrastructure.ws.mapper.GeoMapper;
import com.osm.geo_get.common.Exceptions.GeoDomainExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GeoService {

    private final GeoMapper geoMapper;


    public String getGeoLocation(GeoCoordinates geoCoordinates) throws GeoDomainExceptions, JsonProcessingException {
        GeoLocation geoLocation = geoMapper.toGeoLocation(geoCoordinates);
        return geoLocation.toString();

    }

    public String getGeoCoordinates(String geoLocation) throws GeoDomainExceptions, JsonProcessingException {
        GeoCoordinates geoCoordinates = geoMapper.toGeoCoordinates(geoLocation);
        return "Geo coordinates: " +
                "lat: " + geoCoordinates.getLatitude() +
                " lon: " + geoCoordinates.getLongitude();
    }
}
