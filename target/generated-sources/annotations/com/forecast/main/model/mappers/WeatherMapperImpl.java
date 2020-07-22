package com.forecast.main.model.mappers;

import com.forecast.main.entity.WeatherEntity;
import com.forecast.main.model.WeatherDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-22T16:56:34+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14 (Oracle Corporation)"
)
public class WeatherMapperImpl implements WeatherMapper {

    @Override
    public WeatherDto toDto(WeatherEntity entity) {
        if ( entity == null ) {
            return null;
        }

        WeatherDto weatherDto = new WeatherDto();

        weatherDto.setWeather( entity.getWeather() );
        weatherDto.setTemperature( (int) entity.getTemperature() );
        weatherDto.setWindSpeed( (int) entity.getWindSpeed() );
        weatherDto.setWindDirection( entity.getWindDirection() );
        weatherDto.setTime( entity.getTime() );

        return weatherDto;
    }

    @Override
    public WeatherEntity fromDto(WeatherDto dto) {
        if ( dto == null ) {
            return null;
        }

        WeatherEntity weatherEntity = new WeatherEntity();

        weatherEntity.setTemperature( dto.getTemperature() );
        weatherEntity.setWindSpeed( dto.getWindSpeed() );
        weatherEntity.setWindDirection( dto.getWindDirection() );
        weatherEntity.setWeather( dto.getWeather() );
        weatherEntity.setTime( dto.getTime() );

        return weatherEntity;
    }

    @Override
    public List<WeatherDto> toDtos(List<WeatherEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<WeatherDto> list = new ArrayList<WeatherDto>( entity.size() );
        for ( WeatherEntity weatherEntity : entity ) {
            list.add( toDto( weatherEntity ) );
        }

        return list;
    }

    @Override
    public List<WeatherEntity> fromDtos(List<WeatherDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<WeatherEntity> list = new ArrayList<WeatherEntity>( dto.size() );
        for ( WeatherDto weatherDto : dto ) {
            list.add( fromDto( weatherDto ) );
        }

        return list;
    }
}
