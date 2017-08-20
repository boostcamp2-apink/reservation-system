package org.apink.service.implement;

import org.apink.domain.Reservation;
import org.apink.domain.ReservationTicket;
import org.apink.domain.vo.CommentImageVo;
import org.apink.mapper.ReservationMapper;
import org.apink.service.ReservationService;
import org.apink.util.PagingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationMapper reservationMapper;

    @Autowired
    public ReservationServiceImpl(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @Override
    public Map<Integer,List<Reservation>> getByUserId(int userId, PagingHandler pagingHandler) {
        List<Reservation> reservations;
        reservations = oneToMany(reservationMapper.selectByUserId(userId, pagingHandler));
       return filtering(reservations);
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

    @Override
    public int cancelReservation(int reservationId) {
       return reservationMapper.updateReservationType(reservationId,3);
    }

    @Override
    @Transactional
    public void deleteReservation(int reservationId) {
        reservationMapper.deleteReservation(reservationId);
        reservationMapper.deleteReservationTicketsByReservationId(reservationId);
    }

    private Map<Integer,List<Reservation>> filtering(List<Reservation> reservations) {
        Map<Integer, List<Reservation>> filteredMap = reservations.stream()
                .collect(Collectors.groupingBy(Reservation::getReservationType));
        System.out.println("@@" + filteredMap.toString());

        return filteredMap;
    }
    private List<Reservation> oneToMany(List<Reservation> reservations) {
        List<Integer> reservationIds;
        List<ReservationTicket> reservationTickets;
        Map<Integer,Reservation> reservationMap;

        reservationIds = getReservationIdsToReservations(reservations);
        reservationTickets = reservationMapper.selectTicketsByReservationIds(reservationIds);
        reservationMap = listToMap(reservations);
        System.out.println(reservations.toString());

        for(ReservationTicket reservationTicket : reservationTickets) {
            reservationMap.get(reservationTicket.getReservationId()).addReservationTicket(reservationTicket);
        }
        return reservations;
    }
    private List<Integer> getReservationIdsToReservations(List<Reservation> reservations) {
        List<Integer> reservationsIds = new ArrayList<>();
        for (Reservation reservation : reservations) {
            reservationsIds.add(reservation.getId());
        }
        return reservationsIds;
    }

    private Map<Integer,Reservation> listToMap(List<Reservation> reservations) {
        return reservations.stream().collect(Collectors.toMap(Reservation::getId, Function.identity()));
    }
}
