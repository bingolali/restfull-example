package com.example.resfull_anlatim.service;

import com.example.resfull_anlatim.entity.Apartment;
import com.example.resfull_anlatim.request.CreateApartmentRequest;
import com.example.resfull_anlatim.request.UpdateApartmentRequest;

public interface ApartmentService extends BaseInterface<Apartment, Apartment> {

    Apartment save(CreateApartmentRequest createApartmentRequest);

    Apartment update(UpdateApartmentRequest updateApartmentRequest);

}
