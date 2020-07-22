package com.forecast.main.repository;

import com.forecast.main.entity.LocationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends CrudRepository<LocationEntity,Long> {

    public Optional<LocationEntity> findByLatAndLng(double lat, double lng);
}
