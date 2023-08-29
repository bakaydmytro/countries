package com.api.countries.service;

import com.api.countries.dto.CountryDTO;

import java.util.List;

public interface CountriesService {

    List<CountryDTO> filterCountriesByName(List<CountryDTO> countries, String filter);
}