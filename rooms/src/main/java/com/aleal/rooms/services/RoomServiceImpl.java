package com.aleal.rooms.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aleal.rooms.dao.IRoomDao;
import com.aleal.rooms.model.Room;

@Service
public class RoomServiceImpl implements IRoomService {
	
	@Autowired
	private IRoomDao roomDao;
	
	@Value("${server.port}")
	private String puerto;

	@Override
	public List<Room> search() {
		return (List<Room>) roomDao.findAll();
	}

	@Override
	public List<Room> searchRoomByIdHotel(long idHotel) {
		List<Room> listaHabitaciones = roomDao.findByHotelId(idHotel);
		return listaHabitaciones
				.stream()
				.map(habitacion -> {
					habitacion.setPort(puerto);
					return habitacion;
				}).collect(Collectors.toList());
	}

}
