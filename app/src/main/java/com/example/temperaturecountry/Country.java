package com.example.temperaturecountry;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Country {
    @GET("samayo/country-json/master/src/country-by-yearly-average-temperature.json")
    Observable<List<CountryTemp>>getData();
}
