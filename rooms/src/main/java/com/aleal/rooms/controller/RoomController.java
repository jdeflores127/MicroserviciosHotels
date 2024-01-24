package com.aleal.rooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.rooms.config.external.RoomsExternalPropertiesConfig;
import com.aleal.rooms.model.Room;
import com.aleal.rooms.services.IRoomService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class RoomController {

	@Autowired
	private IRoomService service;
	
	@Autowired
	private RoomsExternalPropertiesConfig roomsExternalPropertiesConfig;
	
	@GetMapping("rooms")
	public List<Room> search(){
		return (List<Room>) this.service.search();	
	}
	
	@GetMapping("/rooms/properties")
	public String leerPropiedades() throws JsonProcessingException{
		return new StringBuilder().append(roomsExternalPropertiesConfig.toString()).toString();
	
	}
}
