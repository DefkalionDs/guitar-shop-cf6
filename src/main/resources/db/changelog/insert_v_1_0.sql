--liquibase formatted sql

--changeset liquibase:1
--preconditions onFail:HALT onError:HALT
------------------------------------------------------------------------------------------------------------------------

INSERT INTO guitars (id, name, fret_no, shape, price)
VALUES (nextval('guitars_id_seq'), 'Jackson ProPlus Series Rhoads Deep BK', 24, 'V-Style', 1399);
INSERT INTO guitars (id, name, fret_no, shape, price)
VALUES (nextval('guitars_id_seq'), 'Charvel Pro Mod DK22 Satchel WB', 22, 'ST-Style', 1399);

------------------------------------------------------------------------------------------------------------------------
