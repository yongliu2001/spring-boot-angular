package com.marcus.rest.converter;

import com.marcus.entity.RoomEntity;
import com.marcus.model.Links;
import com.marcus.model.Self;
import com.marcus.model.response.ReservableRoomResponse;
import com.marcus.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by yongliu on 19/5/17.
 */
public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse> {

    @Override
    public ReservableRoomResponse convert(RoomEntity roomEntity) {

        ReservableRoomResponse response = new ReservableRoomResponse();
        response.setRoomNumber(roomEntity.getRoomNumber());
        response.setPrice(Integer.valueOf(roomEntity.getPrice()));
        response.setId(roomEntity.getId());

        Self self = new Self();
        self.setRef(ResourceConstants.ROOM_RESERVATION_V1+ "/" + roomEntity.getId());
        Links links = new Links();
        links.setSelf(self);
        response.setLinks(links);

        return response;
    }
}
