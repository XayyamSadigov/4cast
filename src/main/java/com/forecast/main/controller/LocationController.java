package com.forecast.main.controller;

import com.forecast.main.logger.SafeLogger;
import com.forecast.main.model.LocationDto;
import com.forecast.main.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Location API")
public class LocationController {

    private static final SafeLogger log = SafeLogger.getLogger(LocationController.class);
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(path = "/location/input", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Saves changes of Weather information")
    public ResponseEntity<?> weatherChangedMessage(@Valid @RequestBody LocationDto dto, Errors errors) {
        log.debug("LocationController:weatherChangedMessage method invoked for {} with {}", dto, errors);
        if (errors.hasErrors()) {
            String validationFailReason = errors.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.joining(", "));
            log.error("location validation failed for request {} with validations {}", dto, validationFailReason);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validationFailReason);
        }

        return locationService.
                add(dto).
                map(location -> ResponseEntity.ok().body(location)).
                orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
