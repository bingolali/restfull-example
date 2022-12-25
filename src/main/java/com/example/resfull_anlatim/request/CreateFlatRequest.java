package com.example.resfull_anlatim.request;

import com.example.resfull_anlatim.entity.Apartment;
import com.example.resfull_anlatim.entity.Renter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFlatRequest {

    private Long apartmentId;

    private Integer flatNumber;

}
