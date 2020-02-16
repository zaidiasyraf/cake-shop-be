package com.cakefaiqah.cakefaiqah.controller;

import com.cakefaiqah.cakefaiqah.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private CakeService cakeService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cakes", cakeService.getAllCake());
        return "index";
    }
}
