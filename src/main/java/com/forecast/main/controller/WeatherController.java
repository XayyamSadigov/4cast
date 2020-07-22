package com.forecast.main.controller;

import com.forecast.main.logger.SafeLogger;
import com.forecast.main.model.RequestDto;
import com.forecast.main.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Weather API")
public class WeatherController {
    private static final SafeLogger log = SafeLogger.getLogger(WeatherController.class);
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(path = "/weather/get")
    @ApiOperation(value = "Get Weather information")
    public ResponseEntity<?> request(@Valid @RequestParam String time, @RequestParam double lat, @RequestParam double lng) {
        log.debug("WeatherController:request method invoked for {} with {}", time + " " + lat + "," + lng);
        return weatherService.
                get(new RequestDto(LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), lat, lng)).
                map(w -> ResponseEntity.ok().body(w)).
                orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
