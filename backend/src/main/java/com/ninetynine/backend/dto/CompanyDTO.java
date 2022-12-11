package com.ninetynine.backend.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CompanyDTO {

    private String id;
    private String name;
    private String sharePrice;
    private LocalDateTime dateTime;

    public CompanyDTO(String id, String name, String sharePrice, LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.sharePrice = sharePrice;
        this.dateTime = dateTime;
    }

}
