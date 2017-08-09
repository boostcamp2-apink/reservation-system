package org.apink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainViewController {

    @GetMapping
    public String mainView(Model model) {
       model.addAttribute("id","2");
        return "mainpage";
    }


}
