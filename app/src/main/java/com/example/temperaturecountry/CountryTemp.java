package com.example.temperaturecountry;

import com.google.gson.annotations.SerializedName;

public class CountryTemp {
    @SerializedName("country")
    String country;
    @SerializedName("temperature")
    String temperature;
}
