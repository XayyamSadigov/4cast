package com.forecast.main.model.mappers;

import com.forecast.main.entity.LocationEntity;
import com.forecast.main.model.LocationDto;
import org.mapstruct.Mapper;

@Mapper
public interface LocationMapper {

    LocationDto toDto(LocationEntity entity);
    LocationEntity fromDto(LocationDto dto);
}
