package com.aleal.hotels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.hotels.config.external.HotelExternalPropertiesConfig;
import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.services.IHotelService;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
public class HotelController {
	
	@Autowired
	private IHotelService service;
	
	@Autowired
	private HotelExternalPropertiesConfig hotelExternalPropertiesConfig;
	
	@GetMapping("hotels")
	public ResponseEntity<List<Hotel>> search(){
		List<Hotel> hoteles = this.service.search(); 
		return new ResponseEntity<List<Hotel>>(hoteles, HttpStatus.OK);
	}
	
	@GetMapping("/hotels/properties")
	public String leerPropiedades() throws JsonProcessingException{
		/*ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(hotelExternalPropertiesConfig);*/
		return new StringBuilder().append(hotelExternalPropertiesConfig.toString()).toString();
		//return "hola";
	}

}
