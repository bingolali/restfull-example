package com.example.resfull_anlatim.service.impl;

import com.example.resfull_anlatim.entity.Apartment;
import com.example.resfull_anlatim.entity.Flat;
import com.example.resfull_anlatim.entity.Renter;
import com.example.resfull_anlatim.repository.FlatRepository;
import com.example.resfull_anlatim.request.AssignRenterRequest;
import com.example.resfull_anlatim.request.CreateFlatRequest;
import com.example.resfull_anlatim.request.UpdateFlatRequest;
import com.example.resfull_anlatim.service.ApartmentService;
import com.example.resfull_anlatim.service.FlatService;
import com.example.resfull_anlatim.service.RenterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FlatServiceImpl implements FlatService {

    private final FlatRepository flatRepository;
    private final RenterService renterService;
    private final ApartmentService apartmentService;

    public FlatServiceImpl(FlatRepository flatRepository, RenterService renterService, ApartmentService apartmentService) {
        this.flatRepository = flatRepository;
        this.renterService = renterService;
        this.apartmentService = apartmentService;
    }


    @Override
    public Flat findById(Long id) {
        return flatRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Flat not found"));
    }

    @Override
    public List<Flat> findAll() {
        return flatRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        flatRepository.deleteById(id);
    }

    @Override
    public Flat save(CreateFlatRequest createFlatRequest) {
        Flat flat = new Flat();
        Apartment apartment = getApartment(createFlatRequest.getApartmentId());
        flat.setApartment(apartment);
        flat.setFlatNumber(createFlatRequest.getFlatNumber());
        return flatRepository.save(flat);
    }

    @Override
    public Flat update(UpdateFlatRequest updateFlatRequest) {

        Flat flat = findById(updateFlatRequest.getFlatId());
        Apartment apartment = getApartment(updateFlatRequest.getApartmentId());
        flat.setApartment(apartment);
        flat.setFlatNumber(updateFlatRequest.getFlatNumber());
        return flatRepository.save(flat);
    }

    @Override
    public Flat assignRenter(AssignRenterRequest assignRenterRequest) {
        Renter renter = renterService.findById(assignRenterRequest.getFlatId());
        Flat flat = findById(assignRenterRequest.getFlatId());
        flat.setRenter(renter);
        return flatRepository.save(flat);
    }

    private Apartment getApartment(Long apartmentId) {
        return apartmentService.findById(apartmentId);
    }
}
