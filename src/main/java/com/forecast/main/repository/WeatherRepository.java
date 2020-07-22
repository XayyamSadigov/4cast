package com.forecast.main.repository;

import com.forecast.main.entity.WeatherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherEntity,Long> {
}
