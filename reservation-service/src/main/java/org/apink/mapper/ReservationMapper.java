package org.apink.mapper;

import org.apink.domain.Reservation;
import org.apink.domain.ReservationTicket;
import org.apink.domain.vo.ReservationTicketVo;
import org.apink.util.PagingHandler;

import java.util.List;

public interface ReservationMapper {

    List<Reservation> selectByUserId(int userId, PagingHandler pagingHandler );

    List<ReservationTicket> selectTicketsByReservationIds(List<Integer> reservationIds);

    int insertReservation(Reservation reservation);

    void insertReservationTicket(ReservationTicket reservationTicket);

    Reservation selectByReservationId(int reservationId);

    int updateReservationType(int reservationId, int reservationType);

    int deleteReservation(int reservationId);

    int deleteReservationTicketsByReservationId(int reservationId);
}
