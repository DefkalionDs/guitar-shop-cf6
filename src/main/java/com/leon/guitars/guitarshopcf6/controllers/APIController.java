package com.leon.guitars.guitarshopcf6.controllers;

import com.leon.guitars.guitarshopcf6.dtos.GuitarDTO;
import com.leon.guitars.guitarshopcf6.services.GuitarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leon-guitars")
public class APIController {

    private final GuitarService guitarService;

    public APIController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @GetMapping()
    public ResponseEntity<List<GuitarDTO>> listGuitars() {
        return ResponseEntity.ok(guitarService.findAll());
    }

}
