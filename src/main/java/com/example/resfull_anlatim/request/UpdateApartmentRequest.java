package com.example.resfull_anlatim.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateApartmentRequest {

    private Long apartmentId;

    private String streetName;

    private String apartmentName;

    private Integer apartmentNumber;

    private String province;

    private String district;
}
