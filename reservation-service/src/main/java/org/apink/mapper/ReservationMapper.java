package org.apink.mapper;

import org.apink.domain.Reservation;
import org.apink.domain.vo.ReservationTicketVo;
import org.apink.util.PagingHandler;

import java.util.List;

public interface ReservationMapper {

    List<Reservation> selectByUserId(int userId, PagingHandler pagingHandler );

    List<ReservationTicketVo> selectTicketsByReservationIds(List<Integer> reservationIds);
}
