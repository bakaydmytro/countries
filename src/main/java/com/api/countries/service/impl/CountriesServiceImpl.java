package com.api.countries.service.impl;

import com.api.countries.dto.CountryDTO;
import com.api.countries.service.CountriesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountriesServiceImpl implements CountriesService {


    @Override
    public List<CountryDTO> filterCountriesByName(List<CountryDTO> countries, String filter) {
        return countries.stream()
                .filter(country -> country.getName() != null && country.getName().getCommon() != null &&
                        country.getName().getCommon().toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());

    }
}
