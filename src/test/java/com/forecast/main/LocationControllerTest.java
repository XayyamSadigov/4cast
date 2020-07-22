package com.forecast.main;

import com.forecast.main.entity.LocationEntity;
import com.forecast.main.service.LocationService;
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

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class LocationControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    @Test
    public void testAddLocation() throws Exception {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setName("test");
        locationEntity.setLat(1);
        locationEntity.setLng(1);
        locationEntity.setWeathers(new ArrayList<>());
        String json = "{\n" +
                "    \"name\" : \"test\",\n" +
                "    \"lat\" : 1,\n" +
                "    \"lng\" : 6,\n" +
                "    \"weathers\" :\n" +
                "    [\n" +
                "        {\n" +
                "            \"weather\" : \"Snow\",\n" +
                "            \"temperature\" : 1,\n" +
                "            \"windSpeed\" : 1,\n" +
                "            \"windDirection\" : \"EAST\",\n" +
                "            \"time\" : \"2020-07-18 00:00\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        Mockito.when(locationService.add(ArgumentMatchers.any())).thenReturn(Optional.of(locationEntity));
        mockMvc.perform(MockMvcRequestBuilders.post("/location/input").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void testAddLocationNameValidationError() throws Exception {
        String json = "{\n" +
                "    \"lat\" : 1,\n" +
                "    \"lng\" : 6,\n" +
                "    \"weathers\" :\n" +
                "    [\n" +
                "        {\n" +
                "            \"weather\" : \"Snow\",\n" +
                "            \"temperature\" : 1,\n" +
                "            \"windSpeed\" : 1,\n" +
                "            \"windDirection\" : \"EAST\",\n" +
                "            \"time\" : \"2020-07-18 00:00\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/location/input").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
