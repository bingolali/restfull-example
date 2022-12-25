package com.example.resfull_anlatim.service;

import com.example.resfull_anlatim.entity.Apartment;
import com.example.resfull_anlatim.entity.Flat;
import com.example.resfull_anlatim.request.*;

public interface FlatService extends BaseInterface<Flat, Flat>{

    Flat save(CreateFlatRequest createFlatRequest);

    Flat update(UpdateFlatRequest updateFlatRequest);

    Flat assignRenter(AssignRenterRequest assignRenterRequest);
}
