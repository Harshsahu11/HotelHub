package com.detrox.HotelHub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "unique_hotel_room_date",
                columnNames = {"hotel_id","room_id","date"}
        )
)
public class Inventory  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
