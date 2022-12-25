package com.example.resfull_anlatim.controller;

import com.example.resfull_anlatim.entity.Apartment;
import com.example.resfull_anlatim.entity.Renter;
import com.example.resfull_anlatim.request.AssignRenterRequest;
import com.example.resfull_anlatim.request.CreateApartmentRequest;
import com.example.resfull_anlatim.request.UpdateApartmentRequest;
import com.example.resfull_anlatim.service.ApartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartment")
public class ApartmentController {

    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Apartment> create(@RequestBody CreateApartmentRequest createApartmentRequest){
        Apartment apartment = apartmentService.save(createApartmentRequest);
        return new ResponseEntity(apartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartment> findById(@PathVariable Long id){
        Apartment apartment = apartmentService.findById(id);
        return new ResponseEntity(apartment, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Apartment> findAll(){
        List<Apartment> apartment = apartmentService.findAll();
        return new ResponseEntity(apartment, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Apartment> update(@RequestBody UpdateApartmentRequest updateApartmentRequest){
        Apartment apartment = apartmentService.update(updateApartmentRequest);
        return new ResponseEntity(apartment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        apartmentService.delete(id);
        return new ResponseEntity(id, HttpStatus.NO_CONTENT);
    }
}
