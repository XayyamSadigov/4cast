package com.forecast.main.model.mappers;

import com.forecast.main.entity.WeatherEntity;
import com.forecast.main.model.WeatherDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WeatherMapper {
    WeatherDto toDto(WeatherEntity entity);
    WeatherEntity fromDto(WeatherDto dto);

    List<WeatherDto> toDtos(List<WeatherEntity> entity);
    List<WeatherEntity> fromDtos(List<WeatherDto> dto);
}
