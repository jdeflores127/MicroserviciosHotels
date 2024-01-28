package com.aleal.hotels.services;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aleal.hotels.dao.IHotelDao;
import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.model.HotelRooms;
import com.aleal.hotels.model.Room;
import com.aleal.hotels.services.feignClients.RoomsFeignClients;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelDao hotelDao;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RoomsFeignClients roomsFeignClients;
	
	@Override
	public List<Hotel> search() {
		return (List<Hotel>) hotelDao.findAll();
	}

	@Override
	public HotelRooms getRoomsByHotel(long idHotel) {
		//Obtener informacion del hotel con base al IdHotel de base de datos
		Hotel hotelInfo = this.getRoomById(idHotel);
		
		List<Room> habitacionesXhotel = getRooms("feign", idHotel);
		
		
		
		return HotelRooms.builder()
				.hotel( hotelInfo )
				.listaHabitaciones( habitacionesXhotel )
				.build();
	}

	public Hotel getRoomById(long idHotel) {
		return hotelDao.findById(idHotel)
				.orElseThrow(() -> new NoSuchElementException("no existe el hotel con ID "+idHotel));
	}
	
	private List<Room> getRooms(String impl, long idHotel) {
		if(impl.equals("feign")) {
			//Consumir servicio rest mediante Feign
			return roomsFeignClients.getRoomByIdHotel(idHotel); 
		}
		if(impl.equals("restTemplate")) {
			//Obtener mediante una peticion Get las habitaciones del hotel
			return Arrays.asList(restTemplate.getForObject("http://localhost:8081/rooms/getRoom/{id}", Room[].class, Map.of("id", idHotel)));		
		} 
		
		throw new RuntimeException("implementacion no existe"); 
	}

	
}
