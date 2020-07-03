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
INSERT INTO `currency_account` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `code`, `currency`, `min_value`) VALUES
(1, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, '$', 'peso', '1000.00'),
(2, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, '$', 'dolar', '300.00'),
(3, '2020-06-29 21:52:07', '2020-06-29 21:52:07', 1, '€', 'euro', '150.00');
--END INSERTS TO CURRENCY TABLE


--BEGIN INSERTS TO ACCOUNT TABLE
INSERT INTO `account` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `balance`, `number_account`, `id_currency_type`) VALUES
(13, '2020-07-02 18:38:26', NULL, 4, '6712005.67', '123456789', 3),
(12, '2020-07-02 18:38:15', NULL, 4, '989049.70', '12345678', 2),
(11, '2020-07-02 18:37:55', NULL, 3, '1139999.50', '1234567', 1);
--END INSERTS TO ccount TABLE

--BEGIN INSERTS TO HOLDER TABLE
INSERT INTO `holder` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `rut`, `id_holder_type`, `legal_entity_id`, `natural_person_id`) VALUES
(12, '2020-07-02 18:04:18', NULL, 0, '1037616283', 1, NULL, 14),
(11, '2020-07-02 18:03:27', NULL, 0, '1037616282', 1, NULL, 13),
(13, '2020-07-02 18:33:37', NULL, 0, '12345678', 2, 5, NULL),
(10, '2020-07-02 17:55:33', NULL, 2, '2345678', 2, 4, NULL);
--END INSERTS TO HOLDER TABLE

--BEGIN INSERTS TO LEGAL_ENTITY TABLE
INSERT INTO `legal_entity` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `foundation_year`, `name`) VALUES
(5, NULL, NULL, 0, 2009, 'Company S.A'),
(4, NULL, NULL, 3, 2013, 'TECSO');
--END INSERTS TO LEGAL_ENTITY TABLE

--BEGIN INSERTS TO NATURAL_PERSON TABLE
INSERT INTO `natural_person` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `last_name`, `name`, `nit`) VALUES
(14, '2020-07-02 18:04:18', NULL, 1, 'Baracaldo Roldan', 'Matias', 1037616283),
(13, '2020-07-02 18:03:27', NULL, 0, 'Baracaldo Marín', 'Juan Manuel', 1037616282);
--END INSERTS TO NATURAL_PERSON TABLE


--BEGIN INSERTS TO M0VEMENT TABLE
INSERT INTO `movement` (`id`, `creation_timestamp`, `modification_timestamp`, `version_number`, `amount`, `description`, `account_id`, `id_movement_type`) VALUES
(16, '2020-07-02 18:42:02', NULL, 0, '-599.65', 'Compra de navera', 12, 2),
(15, '2020-07-02 18:41:47', NULL, 0, '-350.65', 'Compra de televisor ', 12, 2),
(14, '2020-07-02 18:40:52', NULL, 0, '120000.00', 'Consignación Desde Cajero', 13, 1),
(13, '2020-07-02 18:39:59', NULL, 0, '-157628.98', 'Compra supermercado', 13, 2),
(12, '2020-07-02 18:39:35', NULL, 0, '-250365.35', 'Pago servicios públicos', 13, 2),
(11, '2020-07-02 18:38:56', NULL, 0, '6000000.00', 'Pago de nómina', 13, 1),
(17, '2020-07-02 18:42:23', NULL, 0, '-20000.00', 'Compra de carro', 12, 2),
(18, '2020-07-02 18:42:38', NULL, 0, '10000.00', 'Pago de nómina', 12, 1),
(19, '2020-07-02 18:42:55', NULL, 0, '10000.00', 'Pago de nómina', 11, 1),
(20, '2020-07-02 18:43:11', NULL, 0, '250000.00', 'Consignación desde cajero', 11, 1),
(21, '2020-07-02 18:43:30', NULL, 0, '-120000.50', 'Compra supermercado', 11, 2);
--END INSERTS TO M0VEMENT TABLE
