package com.osm.geo_get.GeoLoactionModel.infrastructure.ws.mapper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osm.geo_get.GeoLoactionModel.domain.GeoCoordinates;
import com.osm.geo_get.GeoLoactionModel.domain.GeoLocation;
import com.osm.geo_get.GeoLoactionModel.infrastructure.ws.GeoFeignResource;
import com.osm.geo_get.common.Exceptions.GeoDomainExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GeoMapper {

    private final GeoFeignResource geoFeignResource;
    private final ObjectMapper mapper = new ObjectMapper();
    @Value("${geocoding.api.key}")
    private String apiKey;

    public GeoLocation toGeoLocation(GeoCoordinates geoCoordinates) throws JsonProcessingException, GeoDomainExceptions {
        GeoLocation geoLocation = new GeoLocation();
        String response = geoFeignResource.getGeoLocation(geoCoordinates.getLatitude(), geoCoordinates.getLongitude(),apiKey);
        try {
            JsonNode responseNode = mapper.readTree(response).get("address");
            geoLocation.setCity(responseNode.get("city").asText());
            geoLocation.setCountry(responseNode.get("country").asText());
            return geoLocation;
        }
        catch (Exception e) {
            throw new GeoDomainExceptions(e.getMessage());
        }
    }

    public GeoCoordinates toGeoCoordinates(String geoLocation) throws JsonProcessingException, GeoDomainExceptions {
        GeoCoordinates geoCoordinates = new GeoCoordinates();
        String response = geoFeignResource.getGeoCoordinates(geoLocation,apiKey);
        try{
        JsonNode responseNode = mapper.readTree(response).get(0);
        geoCoordinates.setLatitude(responseNode.get("lat").asText());
        geoCoordinates.setLongitude(responseNode.get("lon").asText());
        return geoCoordinates;
    }
        catch (Exception e) {
            throw new GeoDomainExceptions(e.getMessage());}
    }
}
