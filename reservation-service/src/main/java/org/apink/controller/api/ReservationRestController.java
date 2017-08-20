package org.apink.controller.api;

import org.apink.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {

    private ReservationService reservationService;

    @Autowired
    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PutMapping("/{reservationId}")
    public int cancelReservation(@PathVariable Integer reservationId) {
        return reservationService.cancelReservation(reservationId);
    }
}
