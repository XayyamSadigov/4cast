drop table WEATHER;
drop table location;

CREATE table location
(
    id   NUMBER      NOT NULL ,
    name VARCHAR2(128) NOT NULL,
    lat  NUMBER        NOT NULL,
    lng  NUMBER        NOT NULL,
    PRIMARY KEY (id)
);


CREATE table WEATHER
(
    id             NUMBER      NOT NULL,
    WEATHER        VARCHAR2(128) NOT NULL,
    WIND_DIRECTION VARCHAR2(128) NOT NULL,
    TEMPERATURE    NUMBER        NOT NULL,
    WIND_SPEED     NUMBER        NOT NULL,
    EVENT_DATE     TIMESTAMP    not null,
    LOCATION_ID    NUMBER REFERENCES location (ID),
    PRIMARY KEY (id)
);