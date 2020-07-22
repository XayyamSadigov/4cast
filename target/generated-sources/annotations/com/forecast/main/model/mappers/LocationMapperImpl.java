package com.forecast.main.model.mappers;

import com.forecast.main.entity.LocationEntity;
import com.forecast.main.entity.WeatherEntity;
import com.forecast.main.model.LocationDto;
import com.forecast.main.model.WeatherDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-22T16:56:34+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14 (Oracle Corporation)"
)
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationDto toDto(LocationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        LocationDto locationDto = new LocationDto();

        locationDto.setName( entity.getName() );
        locationDto.setLat( entity.getLat() );
        locationDto.setLng( entity.getLng() );
        locationDto.setWeathers( weatherEntityListToWeatherDtoList( entity.getWeathers() ) );

        return locationDto;
    }

    @Override
    public LocationEntity fromDto(LocationDto dto) {
        if ( dto == null ) {
            return null;
        }

        LocationEntity locationEntity = new LocationEntity();

        locationEntity.setName( dto.getName() );
        locationEntity.setLat( dto.getLat() );
        locationEntity.setLng( dto.getLng() );
        locationEntity.setWeathers( weatherDtoListToWeatherEntityList( dto.getWeathers() ) );

        return locationEntity;
    }

    protected WeatherDto weatherEntityToWeatherDto(WeatherEntity weatherEntity) {
        if ( weatherEntity == null ) {
            return null;
        }

        WeatherDto weatherDto = new WeatherDto();

        weatherDto.setWeather( weatherEntity.getWeather() );
        weatherDto.setTemperature( (int) weatherEntity.getTemperature() );
        weatherDto.setWindSpeed( (int) weatherEntity.getWindSpeed() );
        weatherDto.setWindDirection( weatherEntity.getWindDirection() );
        weatherDto.setTime( weatherEntity.getTime() );

        return weatherDto;
    }

    protected List<WeatherDto> weatherEntityListToWeatherDtoList(List<WeatherEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<WeatherDto> list1 = new ArrayList<WeatherDto>( list.size() );
        for ( WeatherEntity weatherEntity : list ) {
            list1.add( weatherEntityToWeatherDto( weatherEntity ) );
        }

        return list1;
    }

    protected WeatherEntity weatherDtoToWeatherEntity(WeatherDto weatherDto) {
        if ( weatherDto == null ) {
            return null;
        }

        WeatherEntity weatherEntity = new WeatherEntity();

        weatherEntity.setTemperature( weatherDto.getTemperature() );
        weatherEntity.setWindSpeed( weatherDto.getWindSpeed() );
        weatherEntity.setWindDirection( weatherDto.getWindDirection() );
        weatherEntity.setWeather( weatherDto.getWeather() );
        weatherEntity.setTime( weatherDto.getTime() );

        return weatherEntity;
    }

    protected List<WeatherEntity> weatherDtoListToWeatherEntityList(List<WeatherDto> list) {
        if ( list == null ) {
            return null;
        }

        List<WeatherEntity> list1 = new ArrayList<WeatherEntity>( list.size() );
        for ( WeatherDto weatherDto : list ) {
            list1.add( weatherDtoToWeatherEntity( weatherDto ) );
        }

        return list1;
    }
}
