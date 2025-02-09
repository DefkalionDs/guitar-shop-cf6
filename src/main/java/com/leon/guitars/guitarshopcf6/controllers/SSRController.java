package com.leon.guitars.guitarshopcf6.controllers;

import com.leon.guitars.guitarshopcf6.dtos.GuitarDTO;
import com.leon.guitars.guitarshopcf6.services.GuitarService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Controller
public class SSRController {

    final GuitarService guitarService;

    public SSRController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    public List<GuitarDTO> cart = new ArrayList<>();

    @ModelAttribute("allGuitars")
    public List<GuitarDTO> populateGuitars() {
        return this.guitarService.findAll();
    }

    @ModelAttribute("cartQnt")
    public Map<Long, Long> populateCart() {
        Map<Long, Long> cartQnts = new HashMap<>(populateGuitars().stream().collect(toMap(GuitarDTO::getId, k -> 0L)));
        cartQnts.putAll(cart.stream().collect(Collectors.groupingBy(GuitarDTO::getId, Collectors.counting())));
        return cartQnts;
    }

    @RequestMapping({"/", "/guitars"})
    public String listGuitars(final GuitarDTO guitarDTO, final ModelMap model) {
        SecurityContextHolder.
                getContext().
                getAuthentication().
                getAuthorities().
                forEach(role -> {
                    String authority = role.getAuthority();
                    switch (authority) {
                        case "ROLE_ADMIN":
                            model.addAttribute("isAdmin", true);
                            break;
                        case "ROLE_USER":
                            model.addAttribute("isUser", true);
                            break;
                    }
                });
        return "main";
    }

    @RequestMapping(value = "/guitar", params = {"save"})
    public String saveGuitar(
            final GuitarDTO guitarDTO, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "main";
        }
        this.guitarService.add(guitarDTO);
        model.clear();
        return "redirect:/guitars";
    }

    @RequestMapping(value = "/guitar/{id}", params = {"addToCart"})
    public String addGuitarToCart(@PathVariable Long id,
                                  final BindingResult bindingResult,
                                  final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "main";
        }
        GuitarDTO guitarDTO = this.populateGuitars().get(id.intValue());
        cart.add(guitarDTO);
        model.clear();
        return "redirect:/guitars";
    }

    @RequestMapping(value = "/guitar/{id}", params = {"removeFromCart"})
    public String removeGuitarFromCart(@PathVariable Long id,
                                       final BindingResult bindingResult,
                                       final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "main";
        }
        GuitarDTO guitarDTO = this.populateGuitars().get(id.intValue());
        cart.remove(guitarDTO);
        model.clear();
        return "redirect:/guitars";
    }

}
