package com.marcus.rest.converter;

import com.marcus.entity.ReservationEntity;
import com.marcus.model.request.ReservationRequest;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by yongliu on 20/5/17.
 */
public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest, ReservationEntity> {
    @Override
    public ReservationEntity convert(ReservationRequest request) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setCheckin(request.getCheckin());
        reservationEntity.setCheckout(request.getCheckout());

        if (request.getId() != null) {
            reservationEntity.setId(request.getId());
        }

        return reservationEntity;
    }
}
