package com.marcus.rest.converter;

import com.marcus.entity.ReservationEntity;
import com.marcus.model.response.ReservationResponse;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by yongliu on 20/5/17.
 */
public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse> {
    @Override
    public ReservationResponse convert(ReservationEntity source) {

        ReservationResponse response = new ReservationResponse();
        response.setCheckin(source.getCheckin());
        response.setCheckout(source.getCheckout());

        if (source.getRoom() != null) {
            response.setId(source.getRoom().getId());
        }
        return response;
    }
}
