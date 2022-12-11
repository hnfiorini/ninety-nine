package com.ninetynine.dataprovidermock.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
public class Company {

    private String id;
    private String name;
    private String sharePrice;
    private LocalDateTime dateTime;

    public Company(String id, String name, String sharePrice, LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.sharePrice = sharePrice;
        this.dateTime = dateTime;
    }

}
