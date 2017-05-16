CREATE TABLE wfcity (   
    id              NUMBER(10),
    city_name       VARCHAR2 (50) NOT NULL,
    country         VARCHAR2 (50) NOT NULL,
    region          VARCHAR2 (255) NOT NULL,
    CONSTRAINT pk_wfcity PRIMARY KEY (id)
);

CREATE TABLE wfdate (
    id              NUMBER(10),
    forecast_date   DATE NOT NULL,
    CONSTRAINT pk_wfdate PRIMARY KEY (id)
);

CREATE TABLE weather (
    city_id         NUMBER(10) NOT NULL,
    date_id         NUMBER(10) NOT NULL,
    temp_high       NUMBER(3) NOT NULL,
    temp_low        NUMBER(3) NOT NULL,
    CONSTRAINT pk_weather_forecast PRIMARY KEY (city_id, date_id),
    CONSTRAINT fk_weather_wfcity_id FOREIGN KEY (city_id) REFERENCES wfcity (id) ON DELETE CASCADE,
    CONSTRAINT fk_weather_wfdate_id FOREIGN KEY (date_id) REFERENCES wfdate (id)
);

CREATE SEQUENCE wfcity_seq START WITH 1;

CREATE SEQUENCE wfdate_seq START WITH 1;

CREATE OR REPLACE TRIGGER wfcity_id_trg
BEFORE INSERT ON wfcity
FOR EACH ROW
BEGIN
    SELECT wfcity_seq.NEXTVAL INTO :NEW.id FROM dual;
END;

CREATE OR REPLACE TRIGGER wfdate_id_trg
BEFORE INSERT ON wfdate
FOR EACH ROW
BEGIN
    SELECT wfdate_seq.NEXTVAL INTO :NEW.id FROM dual;
END;
