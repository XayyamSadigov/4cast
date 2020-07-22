package com.forecast.main.service;

import com.forecast.main.entity.WeatherEntity;
import com.forecast.main.model.RequestDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface WeatherService {

    Optional<WeatherEntity> get(RequestDto dto);
}
