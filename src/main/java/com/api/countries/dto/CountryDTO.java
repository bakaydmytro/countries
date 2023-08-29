package com.api.countries.dto;

import lombok.Data;

import java.util.List;

@Data
public class CountryDTO {

    private List<String> capital;
    private String region;
    private String subregion;
    private int population;
    private String flag;
}
