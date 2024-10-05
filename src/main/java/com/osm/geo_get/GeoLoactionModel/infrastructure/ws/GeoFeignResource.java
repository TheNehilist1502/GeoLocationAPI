package com.osm.geo_get.GeoLoactionModel.infrastructure.ws;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "geo-feign", url = "${geocoding.api.resource}")
public interface GeoFeignResource {

    @GetMapping("/reverse")
    String getGeoLocation(@RequestParam(name = "lat") String lat, @RequestParam(name = "lon") String lon, @RequestParam(name = "api_key") String key);

    @GetMapping("/search")
    String getGeoCoordinates(@RequestParam(name = "q") String geoLocation, @RequestParam(name = "api_key") String key);
}
