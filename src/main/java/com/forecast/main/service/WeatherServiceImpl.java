package com.forecast.main.service;

import com.forecast.main.entity.LocationEntity;
import com.forecast.main.entity.WeatherEntity;
import com.forecast.main.logger.SafeLogger;
import com.forecast.main.model.RequestDto;
import com.forecast.main.model.mappers.LocationMapper;
import com.forecast.main.model.mappers.WeatherMapper;
import com.forecast.main.repository.LocationRepository;
import com.forecast.main.repository.WeatherRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final SafeLogger logger = SafeLogger.getLogger(LocationServiceImpl.class);
    private LocationMapper locationMapper = Mappers.getMapper(LocationMapper.class);
    private WeatherMapper weatherMapper = Mappers.getMapper(WeatherMapper.class);

    private final LocationRepository locationRepository;
    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(LocationRepository locationRepository, WeatherRepository weatherRepository) {
        this.locationRepository = locationRepository;
        this.weatherRepository = weatherRepository;
    }

    @Override
    public Optional<WeatherEntity> get(RequestDto dto) {
        LocationEntity nearest = null;
        double minDistance = Double.MAX_VALUE;
        double distance;

        // Find closest point.
        // O(n)
        for (LocationEntity location : locationRepository.findAll()) {
            distance = Math.sqrt(Math.pow(dto.getLat() - location.getLat(), 2) + Math.pow(dto.getLng() - location.getLng(), 2));
            if (distance < minDistance) {
                minDistance = distance;
                nearest = location;
            }
        }

        return nearest.getWeathers().stream().filter(weatherEntity -> weatherEntity.getTime().equals(dto.getTime())).findFirst();

    }
}
