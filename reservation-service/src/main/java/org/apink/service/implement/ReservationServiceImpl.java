package org.apink.service.implement;

import org.apink.domain.Reservation;
import org.apink.domain.vo.ReservationTicketVo;
import org.apink.mapper.ReservationMapper;
import org.apink.service.ReservationService;
import org.apink.util.PagingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    public List<Reservation> getByUserId(int userId, PagingHandler pagingHandler) {
        List<Reservation> reservations;
        List<Integer> reservationIds;
        List<ReservationTicketVo> reservationTicketVos;
        Map<Integer,Reservation> reservationMap;
        reservations = reservationMapper.selectByUserId(userId, pagingHandler);
        reservationIds = getReservationIdsToReservations(reservations);
        reservationTicketVos = reservationMapper.selectTicketsByReservationIds(reservationIds);
        reservationMap = listToMap(reservations);

        return null;
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
