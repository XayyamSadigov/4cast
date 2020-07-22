package com.forecast.main.service;

import com.forecast.main.entity.LocationEntity;
import com.forecast.main.logger.SafeLogger;
import com.forecast.main.model.LocationDto;
import com.forecast.main.model.mappers.LocationMapper;
import com.forecast.main.model.mappers.WeatherMapper;
import com.forecast.main.repository.LocationRepository;
import com.forecast.main.repository.WeatherRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private static final SafeLogger log = SafeLogger.getLogger(LocationServiceImpl.class);
    private LocationMapper locationMapper = Mappers.getMapper(LocationMapper.class);
    private WeatherMapper weatherMapper = Mappers.getMapper(WeatherMapper.class);

    private final LocationRepository locationRepository;
    private final WeatherRepository weatherRepository;

    public LocationServiceImpl(LocationRepository locationRepository, WeatherRepository weatherRepository) {
        this.locationRepository = locationRepository;
        this.weatherRepository = weatherRepository;
    }

    @Override
    public Optional<LocationEntity> add(LocationDto dto) {
        return
                locationRepository
                        .findByLatAndLng(dto.getLat(), dto.getLng())
                        .map(loc -> {
                            loc.getWeathers().addAll(weatherMapper.fromDtos(dto.getWeathers()));
                            return Optional.of(locationRepository.save(loc));
                        })
                        .orElseGet(
                                () -> {
                                    return Optional.of(locationRepository.save(locationMapper.fromDto(dto)));
                                }
                        );
    }

}
