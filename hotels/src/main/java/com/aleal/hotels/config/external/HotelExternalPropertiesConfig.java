package com.aleal.hotels.config.external;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "hotels")
@Data
public class HotelExternalPropertiesConfig {
	private String msg;
	private String buildVersion;
	
	private Map<String,String> mailDetails;

}
