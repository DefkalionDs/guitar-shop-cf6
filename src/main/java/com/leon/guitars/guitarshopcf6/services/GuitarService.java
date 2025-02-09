package com.leon.guitars.guitarshopcf6.services;

import com.leon.guitars.guitarshopcf6.dtos.GuitarDTO;
import com.leon.guitars.guitarshopcf6.entities.Guitar;
import com.leon.guitars.guitarshopcf6.repositories.GuitarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarService {

    private final GuitarRepository guitarRepository;

    public GuitarService(GuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    public List<GuitarDTO> findAll() {
        return this.guitarRepository.findAll().stream().map(Guitar::asDTO).toList();
    }

    public void add(final GuitarDTO guitarDTO) {
        this.guitarRepository.save(guitarDTO.asEntity());
    }
}
