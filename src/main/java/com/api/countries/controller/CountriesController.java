package com.api.countries.controller;

import com.api.countries.dto.CountryDTO;
import com.api.countries.mapper.CountryMapper;
import com.api.countries.service.APIClient;
import com.api.countries.service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CountriesController {

    private final static String REST_COUNTRIES_URL = "https://restcountries.com/v3.1/all";
    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private CountriesService countriesService;


    @GetMapping("/countries")
    public List<CountryDTO> myEndpoint(
            @RequestParam(required = false) String countryName,
            @RequestParam(required = false) String param2,
            @RequestParam(required = false) String param3,
            @RequestParam(required = false) String param4
    ) throws IOException {
        String response = APIClient.makeGetRequest(REST_COUNTRIES_URL);
        List<CountryDTO> countryInfoDTO = countryMapper.mapJsonToCountryList(response);

        if (countryName != null && !countryName.isEmpty()) {
            countryInfoDTO = countriesService.filterCountriesByName(countryInfoDTO, countryName);
        }

        return countryInfoDTO;
    }
}
