package com.forecast.main;

import com.forecast.main.entity.LocationEntity;
import com.forecast.main.entity.WeatherEntity;
import com.forecast.main.model.enums.Direction;
import com.forecast.main.service.LocationService;
import com.forecast.main.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class WeatherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;


    @Test
    public void testRequest() throws Exception {
        WeatherEntity weatherEntity1 = new WeatherEntity();
        weatherEntity1.setTemperature(1);
        weatherEntity1.setTime(LocalDateTime.of(2020, 07, 22, 00, 00, 00));
        weatherEntity1.setWeather("Sunny");
        weatherEntity1.setWindDirection(Direction.EAST);
        weatherEntity1.setWindSpeed(0);

        Mockito.when(weatherService.get(ArgumentMatchers.any())).thenReturn(Optional.of(weatherEntity1));
        mockMvc.perform(MockMvcRequestBuilders.get("/weather/get?time=2020-07-22 00:00&lat=1&lng=1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
