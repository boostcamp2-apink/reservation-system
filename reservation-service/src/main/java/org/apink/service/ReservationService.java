package org.apink.service;

import org.apink.domain.Reservation;
import org.apink.util.PagingHandler;

import java.util.List;

public interface ReservationService {

    List<Reservation> getByUserId(int userId, PagingHandler pagingHandler);

    Reservation addReservation(Reservation reservation);
}
