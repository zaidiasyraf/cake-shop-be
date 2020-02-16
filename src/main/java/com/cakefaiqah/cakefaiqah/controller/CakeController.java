package com.cakefaiqah.cakefaiqah.controller;

import com.cakefaiqah.cakefaiqah.entity.Cake;
import com.cakefaiqah.cakefaiqah.repository.CakeRepository;
import com.cakefaiqah.cakefaiqah.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cake/")
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @GetMapping("signup")
    public String showAddCakeForm(Cake cake) {
        return "add-cake";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("cakes", cakeService.getAllCake());
        return "index";
    }

    @PostMapping("add")
    public String addCake(@Valid Cake cake, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-cake";
        }

        cakeService.createCake(cake);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Cake cake = cakeService.getCakeById(id);
        model.addAttribute("cake", cake);
        return "update-cake";
    }

    @PostMapping("update/{id}")
    public String updateCake(@PathVariable("id") Long id, @Valid Cake cake, BindingResult result, Model model) {
        if (result.hasErrors()) {
            cake.setId(id);
            return "update-cake";
        }

        cakeService.updateCake(cake);
        model.addAttribute("cakes", cakeService.getAllCake());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteCake(@PathVariable("id") Long id, Model model) {
        cakeService.deleteCake(id);
        model.addAttribute("cakes", cakeService.getAllCake());
        return "index";
    }
}
