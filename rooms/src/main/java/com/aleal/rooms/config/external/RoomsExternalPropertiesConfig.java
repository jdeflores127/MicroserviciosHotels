package com.aleal.rooms.config.external;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "rooms")
@Data
public class RoomsExternalPropertiesConfig {
	private String msg;
	private String buildVersion;
	
	private Map<String,String> mailDetails;
}
