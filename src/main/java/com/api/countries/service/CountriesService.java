package com.api.countries.service;

import com.api.countries.dto.CountryDTO;

import java.util.List;

public interface CountriesService {

    List<CountryDTO> filterCountriesByName(List<CountryDTO> countries, String filter);

    List<CountryDTO> filterCountriesByPopulation(List<CountryDTO> countryInfoDTO, Integer populationThreshold);

    List<CountryDTO> sortCountriesByName(List<CountryDTO> countryList, String sortOrder);
}