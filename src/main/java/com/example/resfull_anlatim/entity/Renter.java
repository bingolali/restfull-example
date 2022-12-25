package com.example.resfull_anlatim.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RENTER")
@Getter
@Setter
@RequiredArgsConstructor
public class Renter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "renter")
    private Flat flat;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surName;

    @Column(name = "PHONE_NUMBER")
    private Integer phoneNumber;

    @Column(name = "TCKN")
    private Long tckn;

}
