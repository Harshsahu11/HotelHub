package com.detrox.HotelHub.repository;

import com.detrox.HotelHub.entity.Inventory;
import com.detrox.HotelHub.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    void deleteByDateAfterAndRoom(LocalDate date, Room room);

}
