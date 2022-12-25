package com.example.resfull_anlatim.service;

import java.util.List;

public interface BaseInterface <I,O>{

    O findById(Long id);

    List<O> findAll();

    void delete(Long id);

}
