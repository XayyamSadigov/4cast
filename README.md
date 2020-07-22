# Forecasting Application - Test Project

## About this project
This is a test project

## Technologies

- Java 11
- Spring Boot
- Spring Data JPA
- Hibernate
- Oracle
- H2
- Swagger
- Junit

## DB structure

```sql
CREATE TABLE LOCATION
(
    id   NUMBER,
    name VARCHAR2(128),
    lat  NUMBER,
    lng  NUMBER,
    PRIMARY KEY (id)
);

CREATE TABLE WEATHER
(
    id             NUMBER,
    WEATHER        VARCHAR2(128),
    WIND_DIRECTION VARCHAR2(128),
    TEMPERATURE    NUMBER,
    WIND_SPEED     NUMBER,
    EVENT_DATE     TIMESTAMP,
    LOCATION_ID    NUMBER REFERENCES location (ID),
    PRIMARY KEY (id)
);
```

## Add data

```sql
INSERT INTO FORECAST.LOCATION (
   ID, LAT, LNG, 
   NAME) 
VALUES ( /* ID */,
 /* LAT */,
 /* LNG */,
 /* NAME */ );

INSERT INTO FORECAST.WEATHER (
   ID, TEMPERATURE, EVENT_DATE, 
   WEATHER, WIND_DIRECTION, WIND_SPEED, 
   LOCATION_ID) 
VALUES ( /* ID */,
 /* TEMPERATURE */,
 /* EVENT_DATE */,
 /* WEATHER */,
 /* WIND_DIRECTION */,
 /* WIND_SPEED */,
 /* LOCATION_ID */ );
```

## application.yml
```yaml
server:
  port: 8100

spring:
  application:
    name: 4cast
  datasource:
    driver-class-name=oracle: oracle.jdbc.driver.OracleDriver
    url: jdbc:oracle:thin:@localhost:1521:XE
    username: forecast
    password: abc123
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: update

api:
  version: 1.0

swagger:
  enabled: true
  title: 4cast API
  description: Forecast Test Project
  useDefaultResponseMessages: false
  enableUrlTemplating: false
  deepLinking: true
  defaultModelsExpandDepth: 1
  defaultModelExpandDepth: 1
  displayOperationId: false
  displayRequestDuration: false
  filter: false
  maxDisplayedTags: 0
  showExtensions: false
```      

## Run this project

mvn package && java -jar target/4cast-0.1.jar

## Swagger
```
http://localhost:8100/swagger-ui.html
```

## Endpoints

| Endpoint                                                          | Method            | Desccription                  |
| -------------                                                     |:-------------:    | -----:                        |
| http://localhost:8100/weather/get?time={time}&lat={lat}&lng={lng} | GET               | Get Weather Info by closest Coordinates |
| http://localhost:8100/location/input                               | POST              | Add weather info                        |