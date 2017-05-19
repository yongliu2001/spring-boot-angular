package com.marcus.rest;

import com.marcus.entity.ReservationEntity;
import com.marcus.entity.RoomEntity;
import com.marcus.model.request.ReservationRequest;
import com.marcus.model.response.ReservableRoomResponse;
import com.marcus.model.response.ReservationResponse;
import com.marcus.repository.PageableRoomRepository;
import com.marcus.repository.ReservationRepository;
import com.marcus.repository.RoomRepository;
import com.marcus.rest.converter.RoomEntityToReservableRoomResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * Created by yongliu on 18/5/17.
 */

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {

    @Autowired
    PageableRoomRepository pageableRoomRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ConversionService conversionService;

    @RequestMapping(path = "", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<ReservableRoomResponse> getAvailableRooms(
            @RequestParam(value = "checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkin,
            @RequestParam(value = "checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkout,
            Pageable pageable) {

        Page<RoomEntity> roomEntities = pageableRoomRepository.findAll(pageable);
        return roomEntities.map(new RoomEntityToReservableRoomResponseConverter());
    }


    @RequestMapping(path = "/{roomId}", method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RoomEntity> getRoomId(
            @PathVariable Long roomId) {

        return new ResponseEntity<>(roomRepository.findById(roomId), HttpStatus.OK);
    }


    @RequestMapping(path = "", method = RequestMethod.POST
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> createReservation(
            @RequestBody ReservationRequest reservationRequest) {

        ReservationEntity reservationEntity = conversionService.convert(reservationRequest, ReservationEntity.class);
        reservationRepository.save(reservationEntity);

        RoomEntity roomEntity = roomRepository.findById(reservationRequest.getRoomId());
        roomEntity.addReservation(reservationEntity);
        roomRepository.save(roomEntity);
        reservationEntity.setRoom(roomEntity);

        ReservationResponse response = conversionService.convert(reservationEntity, ReservationResponse.class);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @RequestMapping(path = "", method = RequestMethod.PUT
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservableRoomResponse> updateReservation(
            @RequestBody ReservationRequest reservationRequest) {
        return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);
    }


    @RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(
            @PathVariable long reservationId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
