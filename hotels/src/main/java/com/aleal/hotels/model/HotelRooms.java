package com.aleal.hotels.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelRooms {
	private Hotel hotel;
	private List<Room> listaHabitaciones;
}
