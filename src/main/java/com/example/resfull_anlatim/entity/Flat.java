package com.example.resfull_anlatim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FLAT")
@Getter
@Setter
@RequiredArgsConstructor
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APARTMENT_ID")
    private Apartment apartment;

    @Column(name = "FLAT_NUMBER")
    private Integer flatNumber;

    @OneToOne
    @JoinColumn(name = "RENTER_ID")
    private Renter renter;


}
