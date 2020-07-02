INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('AR','ARGENTINA', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('BR','BRASIL', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('UY','URUGUAY', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('CH','CHILE', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

--BEGIN INSERTS TO HOLDERTYPE TABLE
INSERT INTO holder_type (holder_type, creation_timestamp, modification_timestamp, version_number) 
VALUES ('NATURAL', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO holder_type (holder_type, creation_timestamp, modification_timestamp, version_number) 
VALUES ('JURIDICO', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);
--END INSERTS TO HOLDERTYPE TABLE

--BEGIN INSERTS TO MOVEMENTTYPE TABLE
INSERT INTO movement_type (type, creation_timestamp, modification_timestamp, version_number) 
VALUES ('débito', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO movement_type (type, creation_timestamp, modification_timestamp, version_number) 
VALUES ('crédito', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);
--END INSERTS TO MOVEMENTTYPE TABLE

--BEGIN INSERTS TO CURRENCY TABLE
INSERT INTO currency_account (currency, code, creation_timestamp, modification_timestamp, version_number) 
VALUES ('peso', '$', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO currency_account (currency, code, creation_timestamp, modification_timestamp, version_number) 
VALUES ('dolar', '$', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO currency_account (currency, code, creation_timestamp, modification_timestamp, version_number) 
VALUES ('euro', '€',CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);
--END INSERTS TO CURRENCY TABLE


--BEGIN INSERTS TO CURRENCY TABLE
INSERT INTO account (number_account, balance, creation_timestamp, modification_timestamp, version_number) 
VALUES ('123456', '123456.99', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO account (number_account, balance, creation_timestamp, modification_timestamp, version_number) 
VALUES ('456789', '12343454.54', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO account (number_account, balance, creation_timestamp, modification_timestamp, version_number) 
VALUES ('10111213', '100062583.76', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);
--END INSERTS TO CURRENCY TABLE

--BEGIN INSERTS TO MOVENT TABLE
--INSERT INTO movement (id_account, description, amount, id_movement_type, creation_timestamp, modification_timestamp, version_number) 
--VALUES (1, 'Pago de nómina', 6000000.00, 1,  CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

--INSERT INTO movement (id_account, description, amount, id_movement_type, creation_timestamp, modification_timestamp, version_number) 
--VALUES (1,  'Cédito 1', -500000.00, 2,  CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

--INSERT INTO movement (id_account, description, amount, id_movement_type, creation_timestamp, modification_timestamp, version_number) 
--VALUES (1,  'Tranferencia cajero', 1000000.00, 1,  CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);
--END INSERTS TO MOVENT TABLE
