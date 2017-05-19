package com.marucs.rest.converter;

import com.marucs.entity.RoomEntity;
import com.marucs.model.Links;
import com.marucs.model.Self;
import com.marucs.model.response.ReservationResponse;
import com.marucs.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by yongliu on 19/5/17.
 */
public class RoomEntityToReservationResponseConverter implements Converter<RoomEntity, ReservationResponse> {

    @Override
    public ReservationResponse convert(RoomEntity roomEntity) {

        ReservationResponse response = new ReservationResponse();
        response.setRoomNumber(roomEntity.getRoomNumber());
        response.setPrice(Integer.valueOf(roomEntity.getPrice()));

        Self self = new Self();
        self.setRef(ResourceConstants.ROOM_RESERVATION_V1+ "/" + roomEntity.getId());
        Links links = new Links();
        links.setSelf(self);
        response.setLinks(links);

        return response;
    }
}
