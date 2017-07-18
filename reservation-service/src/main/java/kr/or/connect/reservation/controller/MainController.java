package kr.or.connect.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping
	public String main() {
		return "mainpage";
	}
	
	@GetMapping("/myreservation")
	public String myReservation() {
		return "myreservation";
	}
}
