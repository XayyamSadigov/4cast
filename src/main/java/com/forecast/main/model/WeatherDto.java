package com.forecast.main.model;

import com.forecast.main.model.enums.Direction;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Validated
public class WeatherDto {

    @NotNull(message = "Please provide a name")
    @Size(min=2, message="Name should have at least 2 characters")
    private String weather;

    @NotNull(message = "Please provide the temperature")
    private int temperature;

    @NotNull(message = "Please provide the speed of the wind")
    private int windSpeed;

    @NotNull(message = "Please provide the direction of the wind")
    private Direction windDirection;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time;



    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Direction getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Direction windDirection) {
        this.windDirection = windDirection;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeatherDto{" +
                "weather='" + weather + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", time=" + time +
                '}';
    }
}
