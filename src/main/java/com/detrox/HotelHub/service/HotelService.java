package com.detrox.HotelHub.service;

import com.detrox.HotelHub.dto.HotelDto;
import com.detrox.HotelHub.entity.Hotel;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);
}
