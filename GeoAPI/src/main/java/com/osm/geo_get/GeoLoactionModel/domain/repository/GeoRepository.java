package com.osm.geo_get.GeoLoactionModel.domain.repository;

import com.osm.geo_get.GeoLoactionModel.domain.GeoCoordinates;
import com.osm.geo_get.GeoLoactionModel.domain.GeoLocation;

public interface GeoRepository {

    public GeoLocation getGeoLocation(GeoCoordinates geoCoordinates);
    public GeoCoordinates getGeoCoordinates(GeoLocation geoLocation);

    public String getCity(GeoCoordinates geoCoordinates);
    public String getCountry(GeoCoordinates geoCoordinates);
}
