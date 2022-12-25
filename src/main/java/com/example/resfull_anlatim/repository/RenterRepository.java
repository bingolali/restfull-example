package com.example.resfull_anlatim.repository;

import com.example.resfull_anlatim.entity.Apartment;
import com.example.resfull_anlatim.entity.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenterRepository extends JpaRepository <Renter,Long>{

}
