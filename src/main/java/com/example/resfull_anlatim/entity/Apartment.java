package com.example.resfull_anlatim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "APARTMENT")
@Getter
@Setter
@RequiredArgsConstructor
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "APARTMENT_NAME")
    private String apartmentName;

    @Column(name = "APARTMENT_NUMBER")
    private Integer apartmentNumber;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "DISTRICT")
    private String district;

    @OneToMany(mappedBy = "apartment", orphanRemoval = true)
    private List<Flat> flat;

}
