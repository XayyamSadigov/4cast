package com.forecast.main.service;

import com.forecast.main.entity.LocationEntity;
import com.forecast.main.model.LocationDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface LocationService {
    Optional<LocationEntity> add(LocationDto dto);
}
