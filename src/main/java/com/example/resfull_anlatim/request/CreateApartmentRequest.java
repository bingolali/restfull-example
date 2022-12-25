package com.example.resfull_anlatim.request;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateApartmentRequest {

    private String streetName;

    private String apartmentName;

    private Integer apartmentNumber;

    private String province;

    private String district;

}
