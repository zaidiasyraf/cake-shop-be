package com.cakefaiqah.cakefaiqah.service;

import com.cakefaiqah.cakefaiqah.entity.Cake;
import com.cakefaiqah.cakefaiqah.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeService {

    @Autowired
    private CakeRepository cakeRepository;

    public Cake createCake(Cake cake) {
        return cakeRepository.save(cake);
    }

    public Cake updateCake (Cake cake) {
        return cakeRepository.save(cake);
    }

    public Cake getCakeByName (String cakeName) {
        return cakeRepository.findByName(cakeName);
    }

    public void deleteCake (Long id) {
        Cake cake = getCakeById(id);
        cakeRepository.delete(cake);
    }

    public List<Cake> getAllCake () {
        return cakeRepository.findAll();
    }

    public Cake getCakeById (Long id) {
        return cakeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Cake Id : " + id));
    }
}
