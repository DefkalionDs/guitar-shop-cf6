--liquibase formatted sql

--changeset liquibase:1
--preconditions onFail:HALT onError:HALT
------------------------------------------------------------------------------------------------------------------------

CREATE SEQUENCE guitars_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE guitars
(
    id      BIGINT PRIMARY KEY DEFAULT nextval('guitars_id_seq'),
    name    VARCHAR(255)   NOT NULL,
    fret_no NUMERIC(2)     NOT NULL,
    shape   VARCHAR(255)   NOT NULL,
    price   NUMERIC(10, 2) NOT NULL,
    CONSTRAINT guitars_name_idx UNIQUE (name)
);

------------------------------------------------------------------------------------------------------------------------
