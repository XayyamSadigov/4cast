package com.forecast.main;

import com.forecast.main.entity.LocationEntity;
import com.forecast.main.model.LocationDto;
import com.forecast.main.model.WeatherDto;
import com.forecast.main.repository.LocationRepository;
import com.forecast.main.service.LocationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class LocationServiceTest {
    @Autowired
    private LocationService locationService;

    @MockBean
    private LocationRepository locationRepository;

    @Test
    public void testAddWeatherToExistingLocation() {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setName("test");
        locationEntity.setLat(1);
        locationEntity.setLng(1);
        locationEntity.setWeathers(new ArrayList<>());


        Mockito.when(locationRepository.findByLatAndLng(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyDouble())).thenReturn(Optional.of(locationEntity));
        Mockito.when(locationRepository.save(ArgumentMatchers.any())).thenReturn(locationEntity);


        LocationDto dto = new LocationDto();
        dto.setName("test");
        dto.setLat(1);
        dto.setLng(1);
        dto.setWeathers(new ArrayList<>() {{
            add(new WeatherDto());
        }});

        Optional<LocationEntity> added = locationService.add(dto);

        Assertions.assertThat(added).isPresent();
        Mockito.verify(locationRepository, Mockito.atLeastOnce()).findByLatAndLng(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyDouble());
        Mockito.verify(locationRepository, Mockito.atLeastOnce()).save(ArgumentMatchers.any());

    }


    @Test
    public void testAddWeatherToNotExistingLocation() {

        Mockito.when(locationRepository.findByLatAndLng(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyDouble())).thenReturn(Optional.empty());
        Mockito.when(locationRepository.save(ArgumentMatchers.any())).thenReturn(new LocationEntity());

        LocationDto dto = new LocationDto();
        dto.setName("test");
        dto.setLat(1);
        dto.setLng(1);
        dto.setWeathers(new ArrayList<>() {{
            add(new WeatherDto());
        }});

        Optional<LocationEntity> added = locationService.add(dto);

        Assertions.assertThat(added).isPresent();
        Mockito.verify(locationRepository, Mockito.atLeastOnce()).findByLatAndLng(ArgumentMatchers.anyDouble(), ArgumentMatchers.anyDouble());
        Mockito.verify(locationRepository, Mockito.atLeastOnce()).save(ArgumentMatchers.any());

    }
}
