package com.example.resfull_anlatim.service.impl;

import com.example.resfull_anlatim.entity.Renter;
import com.example.resfull_anlatim.repository.RenterRepository;
import com.example.resfull_anlatim.service.RenterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RenterServiceImpl implements RenterService {

   private final RenterRepository renterRepository;

    public RenterServiceImpl(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    @Override
    public Renter findById(Long id) {
        return renterRepository.findById(id).orElseThrow(()->new NoSuchElementException("Renter not found"));
    }

    @Override
    public List<Renter> findAll() {
        return renterRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        renterRepository.deleteById(id);
    }
}
