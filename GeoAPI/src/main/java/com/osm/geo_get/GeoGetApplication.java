package com.osm.geo_get;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GeoGetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoGetApplication.class, args);
	}

}
