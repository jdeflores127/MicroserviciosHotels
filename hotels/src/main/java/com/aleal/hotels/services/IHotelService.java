package com.aleal.hotels.services;

import java.util.List;

import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.model.HotelRooms;

public interface IHotelService {
	
	List<Hotel> search();
	Hotel getRoomById(long idHotel);
	HotelRooms getRoomsByHotel(long idHotel);

}
