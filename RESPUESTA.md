## ----------------------- ##   
## DOCUMENTACIÓN SOLUCIÓN: ##
## ----------------------- ##

## CONSUMO DE WEBSERVICES 

## GENERAL

Autenticación del usuario:
curl -H "Accept: application/json" -H "Content-Type: application/json" -X POST "http://localhost:8080/api/authenticate" -d "{\"username\":\"admin\",\"password\":\"pass\"}"

## EJERCICIO 1

## Creación de un titular persona física
curl -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDA4NzYyMiwiaWF0IjoxNTkzNDgyODIyfQ.HecdFCuhGPFYYqmw7opjka4LQ6c6fGJmlgEImEinmngryN85u5Jr4VxMmer56WPC4rAB0lTWMM0Rn8dObVWeNw" -X POST "http://localhost:8080/api/holder" -d "{\"creationTimestamp\":\"2020-07-02T22:46:18.525Z\",\"holderType\":{\"id\":1},\"rut\":777777777,\"naturalPerson\":{\"creationTimestamp\":\"2020-07-02T22:46:18.525Z\",\"name\":\"Juan Manuel \",\"lastName\":\"Baracaldo Marin\",\"nit\":1037616282}}"

## Creación de un titular persona jurídica
curl -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDA4NzYyMiwiaWF0IjoxNTkzNDgyODIyfQ.HecdFCuhGPFYYqmw7opjka4LQ6c6fGJmlgEImEinmngryN85u5Jr4VxMmer56WPC4rAB0lTWMM0Rn8dObVWeNw" -X POST "http://localhost:8080/api/holder" -d "{\"creationTimestamp\":\"2020-07-02T22:55:32.573Z\",\"holderType\":{\"id\":2},\"rut\":33333333333,\"legalEntity\":{\"name\":\"YourSoftTeam\",\"foundationYear\":\"2020\"}}"

## Edición de un titular persona física
curl -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDA4NzYyMiwiaWF0IjoxNTkzNDgyODIyfQ.HecdFCuhGPFYYqmw7opjka4LQ6c6fGJmlgEImEinmngryN85u5Jr4VxMmer56WPC4rAB0lTWMM0Rn8dObVWeNw" -X PUT "http://localhost:8080/api/holder" -d "{\"id\":12,\"versionNumber\":0,\"creationTimestamp\":\"2020-07-02T23:04:18.000+0000\",\"modificationTimestamp\":null,\"rut\":\"1037616283\",\"holderType\":{\"id\":1,\"versionNumber\":1,\"creationTimestamp\":\"2020-06-30T02:52:07.000+0000\",\"modificationTimestamp\":\"2020-06-30T02:52:07.000+0000\",\"holderType\":\"NATURAL\",\"description\":\"class coop.tecso.examen.model.HolderType ID:1\"},\"legalEntity\":null,\"naturalPerson\":{\"id\":14,\"versionNumber\":1,\"creationTimestamp\":\"2020-07-02T23:04:18.000+0000\",\"modificationTimestamp\":null,\"name\":\"Matias\",\"lastName\":\"Baracaldo Roldann\",\"nit\":1037616283,\"description\":\"class coop.tecso.examen.model.NaturalPerson ID:14\"},\"description\":\"class coop.tecso.examen.model.Holder ID:12\"}"

## Edición de un titular persona jurídica
curl -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDA4NzYyMiwiaWF0IjoxNTkzNDgyODIyfQ.HecdFCuhGPFYYqmw7opjka4LQ6c6fGJmlgEImEinmngryN85u5Jr4VxMmer56WPC4rAB0lTWMM0Rn8dObVWeNw" -X PUT "http://localhost:8080/api/holder" -d "{\"id\":10,\"versionNumber\":2,\"creationTimestamp\":\"2020-07-02T22:55:33.000+0000\",\"modificationTimestamp\":null,\"rut\":\"2345678\",\"holderType\":{\"id\":2,\"versionNumber\":1,\"creationTimestamp\":\"2020-06-30T02:52:07.000+0000\",\"modificationTimestamp\":\"2020-06-30T02:52:07.000+0000\",\"holderType\":\"JURIDICO\",\"description\":\"class coop.tecso.examen.model.HolderType ID:2\"},\"legalEntity\":{\"id\":4,\"versionNumber\":3,\"creationTimestamp\":null,\"modificationTimestamp\":null,\"name\":\"TECSO\",\"foundationYear\":2013,\"description\":\"class coop.tecso.examen.model.LegalEntity ID:4\"},\"naturalPerson\":null,\"description\":\"class coop.tecso.examen.model.Holder ID:10\"}"

## Eliminar un titular
curl -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDA4NzYyMiwiaWF0IjoxNTkzNDgyODIyfQ.HecdFCuhGPFYYqmw7opjka4LQ6c6fGJmlgEImEinmngryN85u5Jr4VxMmer56WPC4rAB0lTWMM0Rn8dObVWeNw" -X DELETE "http://localhost:8080/api/holder/13"

## EJERCICIO 2 

## Obtener las cuentas disponibles
curl -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDA4NzYyMiwiaWF0IjoxNTkzNDgyODIyfQ.HecdFCuhGPFYYqmw7opjka4LQ6c6fGJmlgEImEinmngryN85u5Jr4VxMmer56WPC4rAB0lTWMM0Rn8dObVWeNw" -X GET "http://localhost:8080/api/account"

## Obtener información a partir de un número de cuenta
curl -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDA4NzYyMiwiaWF0IjoxNTkzNDgyODIyfQ.HecdFCuhGPFYYqmw7opjka4LQ6c6fGJmlgEImEinmngryN85u5Jr4VxMmer56WPC4rAB0lTWMM0Rn8dObVWeNw" -X GET "http://localhost:8080/api/account/1234567"

## Creación de un nuevo número de cuenta
curl -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDA4NzYyMiwiaWF0IjoxNTkzNDyODIyfQ.HecdFCuhGPFYYqmw7opjka4LQ6c6fGJmlgEImEinmngryN85u5Jr4VxMmer56WPC4rAB0lTWMM0Rn8dObVWeNw" -X POST "http://localhost:8080/api/account" -d "{\"currency\":{\"id\":1},\"balance\":\"111111111.00\",\"numberAccount\":22222222,\"creationTimestamp\":\"2020-07-02T22:29:36.888Z\"}"

## Eliminar una cuenta
curl -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDA4NzYyMiwiaWF0IjoxNTkzNDgyODIyfQ.HecdFCuhGPFYYqmw7opjka4LQ6c6fGJmlgEImEinmngryN85u5Jr4VxMmer56WPC4rAB0lTWMM0Rn8dObVWeNw" -X DELETE "http://localhost:8080/api/account/11"

## Obtener todos los movimientos asociados a una cuenta
curl -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDA4NzYyMiwiaWF0IjoxNTkzNDgyODIyfQ.HecdFCuhGPFYYqmw7opjka4LQ6c6fGJmlgEImEinmngryN85u5Jr4VxMmer56WPC4rAB0lTWMM0Rn8dObVWeNw" -X GET "http://localhost:8080/api/account/movement/11"

## Guardar un nuevo movimiento
curl -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDA4NzYyMiwiaWF0IjoxNTkzNDgyODIyfQ.HecdFCuhGPFYYqmw7opjka4LQ6c6fGJmlgEImEinmngryN85u5Jr4VxMmer56WPC4rAB0lTWMM0Rn8dObVWeNw" -X POST "http://localhost:8080/api/account/movement" -d "{\"movementType\":{\"id\":1},\"account\":{\"id\":4},\"description\":\"compra tv\",\"creationTimestamp\":\"2020-07-02T22:42:15.254Z\",\"amount\":\"123123123.00\"}"


## ---------------------------- ##   
## DOCUMENTACIÓN BASE DE DATOS: ##
## ---------------------------- ##

•	Versión de la base de datos: MYSql 5.7.24
•	Script de creación de la base de datos:
Se encuentra en el archivo bank.sql
•	Usuario configurado para acceso a la base de datos:
    User: tecso
    Password: tecso

## ---------------------------- ##   
## NOTAS IMPORTANTE: ##
## ---------------------------- ##

•	En el yml se deja activada la opción de la creación de base de datos y la inserción de registros configurado en el data.sql

•	En caso se requerirlo se adjunta tambien el script para la construcción de la base de datos llamado bank.sql

•   La solución al 1.ejercicio-modelado se deja en el archivo PDF llamado ejercicio-modelado.pdf. Para este punto se tiene 


