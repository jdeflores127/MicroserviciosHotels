package com.aleal.reservations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.reservations.config.external.ReservationsExternalPropertiesConfig;
import com.aleal.reservations.model.Reservation;
import com.aleal.reservations.services.IReservationService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ReservationController {
	
	@Autowired
	private IReservationService service;
	
	@Autowired
	private ReservationsExternalPropertiesConfig reservationsExternalPropertiesConfig;

	@GetMapping("reservations")
	public List<Reservation> search(){
		return (List<Reservation>) this.service.search();	
	}
	
	@GetMapping("/reservations/properties")
	public String leerPropiedades() throws JsonProcessingException{
		return new StringBuilder().append(reservationsExternalPropertiesConfig.toString()).toString();
	}


}
