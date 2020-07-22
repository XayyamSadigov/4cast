package com.forecast.main;

import com.forecast.main.entity.LocationEntity;
import com.forecast.main.repository.LocationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Sql({"/test-sql/create_oracle.sql", "/test-sql/insert.sql"})
@Transactional
public class LocationRepositoryTest {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void testFindByLatAndLng() {
        Optional<LocationEntity> locationEntity = locationRepository.findByLatAndLng(1, 1);
        Assertions.assertThat(locationEntity).isPresent();
    }

    @Test
    public void testFindByLatAndLngIsEmpty() {
        Optional<LocationEntity> locationEntity = locationRepository.findByLatAndLng(2, 2);
        Assertions.assertThat(locationEntity).isNotPresent();
    }

}
