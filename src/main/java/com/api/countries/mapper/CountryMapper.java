package com.api.countries.mapper;

import com.api.countries.dto.CountryDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class CountryMapper {

    private final Gson gson = new Gson();

    public List<CountryDTO> mapJsonToCountryList(String json) {
        Type listType = new TypeToken<List<CountryDTO>>() {
        }.getType();
        return gson.fromJson(json, listType);
    }
}