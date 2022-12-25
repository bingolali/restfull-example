package com.example.resfull_anlatim.controller;

import com.example.resfull_anlatim.entity.Apartment;
import com.example.resfull_anlatim.entity.Flat;
import com.example.resfull_anlatim.entity.Renter;
import com.example.resfull_anlatim.request.AssignRenterRequest;
import com.example.resfull_anlatim.service.RenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/renter")
public class RenterController {

    private final RenterService renterService;

    public RenterController(RenterService renterService) {
        this.renterService = renterService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Renter> findById(@PathVariable Long id){
        Renter renter = renterService.findById(id);
        return new ResponseEntity(renter, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Renter> findAll(){
        List<Renter> renters = renterService.findAll();
        return new ResponseEntity(renters, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        renterService.delete(id);
        return new ResponseEntity(id, HttpStatus.NO_CONTENT);
    }
}
