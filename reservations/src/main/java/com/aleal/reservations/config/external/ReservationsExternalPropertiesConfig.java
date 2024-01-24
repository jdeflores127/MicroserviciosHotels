package com.aleal.reservations.config.external;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "reservations")
@Data
public class ReservationsExternalPropertiesConfig {
	private String msg;
	private String buildVersion;
	
	private Map<String,String> mailDetails;
}
