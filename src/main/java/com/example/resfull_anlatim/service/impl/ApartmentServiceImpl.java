package com.example.resfull_anlatim.service.impl;

import com.example.resfull_anlatim.entity.Apartment;
import com.example.resfull_anlatim.repository.ApartmentRepository;
import com.example.resfull_anlatim.request.CreateApartmentRequest;
import com.example.resfull_anlatim.request.UpdateApartmentRequest;
import com.example.resfull_anlatim.service.ApartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }


    @Override
    public Apartment save(CreateApartmentRequest input) {
        Apartment apartment = new Apartment();
        apartment.setFlat(new ArrayList<>());
        apartment.setApartmentName(input.getApartmentName());
        apartment.setApartmentNumber(input.getApartmentNumber());
        apartment.setProvince(input.getProvince());
        apartment.setDistrict(input.getDistrict());
        apartment.setStreetName(input.getStreetName());
        return apartmentRepository.save(apartment);
    }

    @Override
    public Apartment findById(Long id) {
        return apartmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Apartment not found"));
    }

    @Override
    public List<Apartment> findAll() {
        return apartmentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Apartment apartment = findById(id);
        apartmentRepository.delete(apartment);
    }

    @Override
    public Apartment update(UpdateApartmentRequest input) {

        Apartment oldApartment = findById(input.getApartmentId());

        oldApartment.setApartmentName(input.getApartmentName());
        oldApartment.setApartmentNumber(input.getApartmentNumber());
        oldApartment.setDistrict(input.getDistrict());
        oldApartment.setProvince(input.getProvince());
        oldApartment.setStreetName(input.getStreetName());
        return apartmentRepository.save(oldApartment);

    }
}
