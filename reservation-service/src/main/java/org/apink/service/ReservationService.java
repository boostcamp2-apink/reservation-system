package org.apink.service;

import org.apink.domain.Reservation;
import org.apink.util.PagingHandler;

import java.util.List;
import java.util.Map;

public interface ReservationService {

    Map<Integer,List<Reservation>> getByUserId(int userId, PagingHandler pagingHandler);

    Reservation addReservation(Reservation reservation);

    int cancelReservation(int reservationId);

    void deleteReservation(int reservationId);
}
