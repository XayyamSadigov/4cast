package com.forecast.main.entity;

import com.forecast.main.model.enums.Direction;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "weather")
public class WeatherEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "wind_speed")
    private double windSpeed;

    @Column(name = "wind_direction")
    @Enumerated(EnumType.STRING)
    private Direction windDirection;

    @Column(name = "weather")
    private String weather;

    @Column(name = "event_date")
    private LocalDateTime time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Direction getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Direction windDirection) {
        this.windDirection = windDirection;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
