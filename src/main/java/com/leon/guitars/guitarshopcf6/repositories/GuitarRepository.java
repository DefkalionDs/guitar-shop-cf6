package com.leon.guitars.guitarshopcf6.repositories;

import com.leon.guitars.guitarshopcf6.entities.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GuitarRepository extends JpaRepository<Guitar, Long> {
}
