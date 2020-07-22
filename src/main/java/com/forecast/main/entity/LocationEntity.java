package com.forecast.main.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "location")
public class LocationEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private List<WeatherEntity> weathers;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<WeatherEntity> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<WeatherEntity> weathers) {
        this.weathers = weathers;
    }
}
