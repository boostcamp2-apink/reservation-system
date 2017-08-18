package org.apink.service.implement;

import org.apink.domain.Reservation;
import org.apink.domain.ReservationTicket;
import org.apink.mapper.ReservationMapper;
import org.apink.service.ReservationService;
import org.apink.util.PagingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationMapper reservationMapper;

    @Autowired
    public ReservationServiceImpl(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @Override
    public List<Reservation> getByUserId(int userId, PagingHandler pagingHandler) {
        return reservationMapper.selectByUserId(userId, pagingHandler);
    }

    @Override
    @Transactional
    public Reservation addReservation(Reservation reservation) {
        List<ReservationTicket> reservationTickets = reservation.getReservationTickets();
        int reservationId = reservationMapper.insertReservation(reservation);
        for(ReservationTicket ticket : reservationTickets){
            ticket.setReservationId(reservationId);
            System.out.println(ticket.toString());
            reservationMapper.insertReservationTicket(ticket);
        }
        return reservationMapper.selectByReservationId(reservationId);
    }
}
