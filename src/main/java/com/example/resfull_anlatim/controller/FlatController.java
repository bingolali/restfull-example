package com.example.resfull_anlatim.controller;

import com.example.resfull_anlatim.entity.Apartment;
import com.example.resfull_anlatim.entity.Flat;
import com.example.resfull_anlatim.entity.Renter;
import com.example.resfull_anlatim.request.*;
import com.example.resfull_anlatim.service.FlatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flat")
public class FlatController {

    private final FlatService flatService;

    public FlatController(FlatService flatService) {
        this.flatService = flatService;
    }

    @PostMapping("/create")
    public ResponseEntity<Flat> create(@RequestBody CreateFlatRequest createFlatRequest){
        Flat flat = flatService.save(createFlatRequest);
        return new ResponseEntity(flat, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flat> findById(@PathVariable Long id){
        Flat flat = flatService.findById(id);
        return new ResponseEntity(flat, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Flat> findAll(){
        List<Flat> flats = flatService.findAll();
        return new ResponseEntity(flats, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Flat> update(@RequestBody UpdateFlatRequest updateFlatRequest){
        Flat flat = flatService.update(updateFlatRequest);
        return new ResponseEntity(flat, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        flatService.delete(id);
        return new ResponseEntity(id, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/assign")
    public ResponseEntity<Flat> assignRenter(@RequestBody AssignRenterRequest assignRenterRequest){
        Flat flat = flatService.assignRenter(assignRenterRequest);
        return new ResponseEntity(flat, HttpStatus.NO_CONTENT);
    }
}
