package com.aleal.hotels.services.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aleal.hotels.model.Room;


//Nombre del servicio registrado en eureka
@FeignClient("rooms")
public interface RoomsFeignClients {
	
	@GetMapping(value="rooms/getRoom/{idHotel}", consumes = "application/json")
	public List<Room> getRoomByIdHotel( @PathVariable long idHotel );
}
