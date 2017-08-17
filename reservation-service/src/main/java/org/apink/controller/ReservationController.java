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
        model.addAttribute("reservations",reservationService.getByUserId(userId,new PagingHandler(1)));
        return "myreservation";
    }

    @GetMapping("/test")
    @ResponseBody
    public List<Reservation> test() {
        System.out.println(reservationService.getByUserId(1,new PagingHandler(1)).toString());
        return reservationService.getByUserId(1,new PagingHandler(1));
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
}
