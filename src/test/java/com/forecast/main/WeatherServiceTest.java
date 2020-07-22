package com.forecast.main;


import com.forecast.main.entity.LocationEntity;
import com.forecast.main.entity.WeatherEntity;
import com.forecast.main.model.RequestDto;
import com.forecast.main.model.enums.Direction;
import com.forecast.main.repository.LocationRepository;
import com.forecast.main.service.WeatherService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;

    @MockBean
    private LocationRepository locationRepository;


    @Test
    public void testGetWeather() {
        LocationEntity locationEntity1 = new LocationEntity();
        locationEntity1.setName("test");
        locationEntity1.setLat(1);
        locationEntity1.setLng(1);
        WeatherEntity weatherEntity1 = new WeatherEntity();
        weatherEntity1.setTemperature(1);
        weatherEntity1.setTime(LocalDateTime.of(2020, 07, 22, 00, 00, 00));
        weatherEntity1.setWeather("Sunny");
        weatherEntity1.setWindDirection(Direction.EAST);
        weatherEntity1.setWindSpeed(0);
        locationEntity1.setWeathers(new ArrayList<>() {{
            add(weatherEntity1);
        }});


        LocationEntity locationEntity2 = new LocationEntity();
        locationEntity1.setName("test");
        locationEntity1.setLat(20);
        locationEntity1.setLng(20);
        WeatherEntity weatherEntity2 = new WeatherEntity();
        weatherEntity2.setTemperature(20);
        weatherEntity2.setTime(LocalDateTime.of(2020, 07, 22, 00, 00, 00));
        weatherEntity2.setWeather("Sunny");
        weatherEntity2.setWindDirection(Direction.EAST);
        weatherEntity2.setWindSpeed(0);
        locationEntity1.setWeathers(new ArrayList<>() {{
            add(weatherEntity2);
        }});

        List<LocationEntity> list = new ArrayList<>();
        list.add(locationEntity1);
        list.add(locationEntity2);


        Mockito.when(locationRepository.findAll()).thenReturn(list);

        RequestDto requestDto = new RequestDto(LocalDateTime.of(2020, 07, 22, 00, 00, 00), 15, 15);

        Optional<WeatherEntity> got = weatherService.get(requestDto);
        Assertions.assertThat(got.get()).isEqualTo(weatherEntity2);

        Mockito.verify(locationRepository, Mockito.atLeastOnce()).findAll();

    }


}
