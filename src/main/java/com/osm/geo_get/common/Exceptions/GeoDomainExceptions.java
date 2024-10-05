package com.osm.geo_get.common.Exceptions;


import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class GeoDomainExceptions extends Exception {
    HttpStatus httpStatus;
    String message;

    public GeoDomainExceptions(String message) {
        super(message);
    }
    public GeoDomainExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
