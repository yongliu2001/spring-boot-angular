package com.marcus.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

/**
 * Created by yongliu on 20/5/17.
 */
public class ReservationResponse {

    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate checkin;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate checkout;

    public ReservationResponse() {
    }

    public ReservationResponse(Long id, LocalDate checkin, LocalDate checkout) {
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }
}
