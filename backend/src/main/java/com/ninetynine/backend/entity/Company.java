package com.ninetynine.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String sharePrice;

    Company(String name, String sharePrice) {
        this.name = name;
        this.sharePrice = sharePrice;
    }
}
