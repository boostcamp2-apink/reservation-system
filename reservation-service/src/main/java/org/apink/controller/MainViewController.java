package org.apink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainViewController {

    @GetMapping
    public String mainView(){
        return "forward:/resources/html/mainpage.html";
    }

}
