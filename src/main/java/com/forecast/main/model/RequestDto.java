package com.forecast.main.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Validated
public class RequestDto {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time;

    @NotNull(message = "Please provide the latitude")
    @Min(value=-90, message="The latitude must be equal or greater than -90")
    @Max(value=90, message="The latitude must be equal or less than 90")
    private double lat;

    @NotNull(message = "Please provide the longitude")
    @Min(value=-180, message="The latitude must be equal or greater than -180")
    @Max(value=180, message="The latitude must be equal or less than 180")
    private double lng;

    public RequestDto(LocalDateTime time, double lat, double lng) {
        this.time = time;
        this.lat = lat;
        this.lng = lng;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "RequestDto{" +
                "time=" + time +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
