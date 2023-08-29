package com.api.countries.service.impl;

import com.api.countries.dto.CountryDTO;
import com.api.countries.service.CountriesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CountriesServiceImpl implements CountriesService {


    @Override
    public List<CountryDTO> filterCountriesByName(List<CountryDTO> countries, String filter) {
        return countries.stream()
                .filter(country -> country.getName() != null && country.getName().getCommon() != null &&
                        country.getName().getCommon().toLowerCase().contains(filter.toLowerCase()))
                .toList();

    }


    public List<CountryDTO> filterCountriesByPopulation(List<CountryDTO> countries, Integer populationThreshold) {
        List<CountryDTO> filteredCountries = new ArrayList<>();

        for (CountryDTO country : countries) {
            if (country.getPopulation() < populationThreshold * 1000000) {
                filteredCountries.add(country);
            }
        }

        return filteredCountries;
    }

    @Override
    public List<CountryDTO> sortCountriesByName(List<CountryDTO> countryList, String sortOrder) {
        Comparator<CountryDTO> comparator = (country1, country2) -> {
            String name1 = country1.getName().getCommon();
            String name2 = country2.getName().getCommon();

            if ("ascend".equalsIgnoreCase(sortOrder)) {
                return name1.compareTo(name2);
            } else if ("descend".equalsIgnoreCase(sortOrder)) {
                return name2.compareTo(name1);
            } else {
                throw new IllegalArgumentException("Invalid sort order. Use 'ascend' or 'descend'.");
            }
        };

        List<CountryDTO> sortedList = new ArrayList<>(countryList);
        sortedList.sort(comparator);

        return sortedList;
    }
}
