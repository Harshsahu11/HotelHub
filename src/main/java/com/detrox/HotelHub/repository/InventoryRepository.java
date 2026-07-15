package com.detrox.HotelHub.repository;

import com.detrox.HotelHub.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

}
