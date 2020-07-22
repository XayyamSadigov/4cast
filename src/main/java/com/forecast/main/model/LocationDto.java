package com.forecast.main.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Validated
public class LocationDto {

    @NotNull(message = "Please provide a name")
    @Size(min=2, message="Name should have at least 2 characters")
    private String name;

    @NotNull(message = "Please provide the latitude")
    @Min(value=-90, message="The latitude must be equal or greater than -90")
    @Max(value=90, message="The latitude must be equal or less than 90")
    private double lat;

    @NotNull(message = "Please provide the longitude")
    @Min(value=-180, message="The latitude must be equal or greater than -180")
    @Max(value=180, message="The latitude must be equal or less than 180")
    private double lng;

    private List<WeatherDto> weathers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public List<WeatherDto> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<WeatherDto> weathers) {
        this.weathers = weathers;
    }

    @Override
    public String toString() {
        return "LocationDto{" +
                "name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", weathers=" + weathers +
                '}';
    }
}
