package org.apink.controller;

import org.apink.domain.Reservation;
import org.apink.service.ProductService;
import org.apink.service.ReservationService;
import org.apink.service.UserService;
import org.apink.util.PagingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private ProductService productService;
    private UserService userService;
    private ReservationService reservationService;

    @Autowired
    public ReservationController(ProductService productService, UserService userService, ReservationService reservationService) {
        this.productService = productService;
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @GetMapping
    public String reservation(Model model) {
        //TODO Get userId from a session || argumentResolver
        int userId = 1;
        Map<Integer,List<Reservation>> filteredMap= reservationService.getByUserId(userId,new PagingHandler(1));
        model.addAttribute("clock",filteredMap.get(0));
        model.addAttribute("check",filteredMap.get(1));
        model.addAttribute("used",filteredMap.get(2));
        model.addAttribute("cancel",filteredMap.get(3));
        return "myreservation";
    }



    @GetMapping("/products/{productId}")
    public String reserveView(@PathVariable int productId, Model model) {
        model.addAttribute("id", productId);
        model.addAttribute("product", productService.getSummaryByProductId(productId));
        model.addAttribute("prices", productService.getPriceByProductId(productId));

        //TODO Get userId from a session || argumentResolver
        int userId = 1;
        model.addAttribute("user", userService.getByUserId(userId));
        return "reserve";
    }

    @PostMapping
    @ResponseBody
    public Reservation addReservation(@RequestBody Reservation reservation){
        //TODO Get userId from a session || argumentResolver
        int userId = 1;
        reservation.setUserId(userId);
        reservation.setReservationDate(new Date(System.currentTimeMillis()));
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/cancel/{reservationId}")
    public String cancelReservation(@PathVariable Integer reservationId) {
        if(reservationService.cancelReservation(reservationId) != 0) {
            return "redirect:/reservations";
        } else {
            return "redirect:/error";
        }
    }
}
