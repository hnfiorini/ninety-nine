package com.ninetynine.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FilterDTO {

    private String idCompany;
    private String searchType;
    private int fromHour;
    private int toHour;
    private int day;
    private int month;
    private int year;
    private int fromDay;
    private int toDay;
}
