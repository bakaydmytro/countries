package com.api.countries.service;

import com.api.countries.dto.CountryDTO;
import com.api.countries.dto.CountryName;
import com.api.countries.service.impl.CountriesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountriesServiceImplTest {


    private CountriesServiceImpl countriesService;
    private List<CountryDTO> countryList;

    @BeforeEach
    void setUp() {
        countriesService = new CountriesServiceImpl();

        countryList = Arrays.asList(
                CountryDTO.builder().name(CountryName.builder().common("Country A").build()).population(1000000)
                        .build(),
                CountryDTO.builder().name(CountryName.builder().common("Country B").build()).population(2000000)
                        .build(),
                CountryDTO.builder().name(CountryName.builder().common("Country C").build()).population(3000000).build()
        );
    }

    @Test
    void testFilterCountriesByName() {
        List<CountryDTO> filteredCountries = countriesService.filterCountriesByName(countryList, "country B");

        assertEquals(1, filteredCountries.size());
        assertEquals("Country B", filteredCountries.get(0).getName().getCommon());
    }

    @Test
    void testFilterCountriesByPopulation() {
        List<CountryDTO> filteredCountries = countriesService.filterCountriesByPopulation(countryList, 2);

        assertEquals(1, filteredCountries.size());
        assertEquals("Country A", filteredCountries.get(0).getName().getCommon());
    }

    @Test
    void testSortCountriesByNameAscending() {
        List<CountryDTO> sortedCountries = countriesService.sortCountriesByName(countryList, "ascend");

        List<String> expectedOrder = Arrays.asList("Country A", "Country B", "Country C");
        for (int i = 0; i < sortedCountries.size(); i++) {
            assertEquals(expectedOrder.get(i), sortedCountries.get(i).getName().getCommon());
        }
    }

    @Test
    void testSortCountriesByNameDescending() {
        List<CountryDTO> sortedCountries = countriesService.sortCountriesByName(countryList, "descend");

        List<String> expectedOrder = Arrays.asList("Country C", "Country B", "Country A");
        for (int i = 0; i < sortedCountries.size(); i++) {
            assertEquals(expectedOrder.get(i), sortedCountries.get(i).getName().getCommon());
        }
    }

    @Test
    void testApplyCountryLimit() {
        List<CountryDTO> limitedCountries = countriesService.applyCountryLimit(countryList, 2);

        assertEquals(2, limitedCountries.size());
    }

}
