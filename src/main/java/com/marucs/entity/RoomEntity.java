package com.marucs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by yongliu on 19/05/2017.
 */

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Integer roomNumber;

    @NotNull
    private String price;

    public RoomEntity() {
    }

    public RoomEntity(Integer roomNumber, String price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
