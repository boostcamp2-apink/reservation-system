package org.apink.mapper;

import org.apink.domain.Reservation;
import org.apink.domain.ReservationTicket;
import org.apink.domain.vo.ReservationTicketVo;
import org.apink.util.PagingHandler;

import java.util.List;

public interface ReservationMapper {

    List<Reservation> selectByUserId(int userId, PagingHandler pagingHandler );

    List<ReservationTicketVo> selectTicketsByReservationId(int reservationId);

    int insertReservation(Reservation reservation);

    void insertReservationTicket(ReservationTicket reservationTicket);

    Reservation selectByReservationId(int reservationId);
}
