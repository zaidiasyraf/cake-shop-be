package com.cakefaiqah.cakefaiqah.repository;

import com.cakefaiqah.cakefaiqah.entity.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {

    Cake findByName(String name);
}
