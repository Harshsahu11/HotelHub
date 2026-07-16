package com.detrox.HotelHub.serviceImpl;

import com.detrox.HotelHub.dto.RoomDto;
import com.detrox.HotelHub.entity.Hotel;
import com.detrox.HotelHub.entity.Room;
import com.detrox.HotelHub.exception.ResourceNotFoundException;
import com.detrox.HotelHub.repository.HotelRepository;
import com.detrox.HotelHub.repository.RoomRepository;
import com.detrox.HotelHub.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final HotelRepository hotelRepository;

    private final ModelMapper modelMapper;

    @Override
    public RoomDto createNewRoom(Long hotelId, RoomDto roomDto) {
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Hotel not found with id: "+hotelId)
                );
        Room room = modelMapper.map(roomDto, Room.class);
        room.setHotel(hotel);
        room = roomRepository.save(room);

        return modelMapper.map(room,RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Hotel not found with id: "+hotelId)
                );

        return hotel
                .getRoom()
                .stream()
                .map((element)->modelMapper.map(element,RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Hotel not found with id: "+roomId));
        return modelMapper.map(room,RoomDto.class);
    }

    @Override
    public void deleteRoomById( Long roomId) {
        boolean exists = roomRepository.existsById(roomId);
        if(!exists)
            throw new ResourceNotFoundException("Hotel not found with id: "+roomId);
        roomRepository.deleteById(roomId);
    }

}
