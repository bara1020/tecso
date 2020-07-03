
#### CONSIDERACIONES GENERALES ####

- En términos generales, el sistema que se trabaja en este proyecto es del ámbito bancario, involucrando la gestión de titulares de cuentas, cuentas y movimientos asociados a las mismas.

- Todos los ejercicios se resuelven en el mismo proyecto, no es necesario separarlos.

- Se debe desarrollar un frontend para todas las funcionalidades (Angular, React, etc... algún framework basado en javascript). No es necesario trabajar sobre consideraciones estéticas o de interfaz de usuario
avanzadas. Será suficiente con que se implemente una interfaz básica, ordenada y completa que permita probar las funcionalidades.


=====================================================================================================================================================================================
#### Ejercicio 1 ####

Desarollar todos los artefactos necesarios en el backend (controller, servicio, repositorio, modelo, etc) y proyecto de frontend para implementar la "gestión de titulares de cuentas corrientes", según las siguientes consideraciones:

- Un titular puede ser tanto una persona física como jurídica.
	
- Si el titular es una persona física, los atributos requeridos serán los siguientes: nombre (máximo 80 caracteres), apellido (máximo 250 caracteres) y CC.
   
- Si el titular es una persona jurídica, los atributos requeridos serán los siguientes: razón social (máximo 100 caracteres) y año de fundación.
	
- Tanto para las personas físicas como jurídicas, se requiere RUT.
	
- No pueden existir 2 titulares con el mismo RUT.

=====================================================================================================================================================================================
#### Ejercicio 2 ####

Desarollar todos los artefactos necesarios en el backend (controller, servicio, repositorio, modelo, etc) y proyecto de frontend para implementar la "gestión de cuentas y movimientos", según las siguientes consideraciones:

- Una cuenta corriente puede tener n movimientos.

- Los movimientos no pueden eliminarse ni modificarse.

- Las cuentas solo pueden eliminarse si no tienen movimientos asociados.

- Las cuentas poseen un número de cuenta (valor requerido y único), una moneda (peso, dolar, euro) y un saldo (valor numérico de 2 decimales).

- Los movimientos poseen fecha y hora, tipo de movimiento (débito o crédito), descripción (200 caracteres) e importe (numérico de 2 decimales).

- Cada vez que se incorpora un nuevo movimiento se debe actualizar el saldo de la cuenta asociada.

- Si la aplicación de un movimiento fuera a generar un saldo negativo en la cuenta mayor a 1000 (para cuentas en pesos), 300 (para cuentas en dólares) o 150 (para cuentas en euros)... se deberá rechazar.

cuentas
--------
numeroCuenta
idMoneda
saldo

moneda
-------
id 
moneda


movimientos
----------
id
idCuenta
timespam
description
importe


tipomovimiento
------------
id
type




En la capa REST, los endpoints requeridos son los siguientes:
   1. *crear cuenta*
   2. *eliminar cuenta*
   3. *listar cuentas*
   4. *agregar movimiento*
   5. *listar movimientos x cuenta* (ordenados de forma decreciente, por fecha)

Se deberán aplicar todas las validaciones funcionales que se consideren oportunas, informando los errores de manera conveniente.



=====================================================================================================================================================================================
#### Ejercicio 3 ####
#### Funcionalidades adicionales ####

Implementar la mayor cantidad de funcionalidades adicionales posibles.

Ejemplos/propuestas:

- Registración y autenticación de usuario.

- Mecanismo de autorización de acceso a las funcionalidades desarrolladas.

- Pruebas unitarias (Junit) de los distintos componentes.

- Reemplazar la base de datos configurada en memoria (H2) por una a elección de entre las siguientes: PostgreSQL o MySQL.
	De hacerlo, la solución deberá incluir:
		- Información sobre la BD utilizada.
            MySql 5.7.24
		- Script de creación e inicialización de datos.
            Se encuentra en el archivo bank.sql
		- Modificación correspondiente en la configuración del datasource.
        spring:
            profiles: dev
            jpa:
                database-platform: org.hibernate.dialect.MySQL5Dialect
                show-sql: true
                hibernate:
                ddl-auto: update
            datasource:
                url: jdbc:mysql://localhost:3306/bank
                driver-class-name: com.mysql.jdbc.Driver
                username: tecso
                password: tecso
                #initialization-mode: always
		- Cualquier otra información que considere necesaria.

- etc (cualquier funcionalidad adicional que el candidato considere pertinente).
spring:
	profiles: dev
	jpa:
		database-platform: org.hibernate.dialect.MySQL5Dialect
		show-sql: true
		hibernate:
		ddl-auto: update
	datasource:
		url: jdbc:mysql://localhost:3306/bank
		driver-class-name: com.mysql.jdbc.Driver
		username: tecso
		password: tecso
		#initialization-mode: always


{
    "rut":"12345",
    "holderType":{
        "id":"1"
    },
    "naturalPerson":{
        "name":"Juan Manuel",
        "lastName":"Baracaldo",
        "nit":1037616282
    }
}

{
    "rut":"123456",
    "creationTimestamp":"2020-06-06",
    "holderType":{
        "id":"1"
    },
    "naturalPerson":{
        "name":"Juan Manuel",
        "lastName":"Baracaldo",
        "nit":1037616282
    }
}


EJERCICIO 2


{
    "rut":"12345",
    "holderType":{
        "id":"2"
    },
    "legalEntity":{
        "name":"tecso",
        "foudationDate":"20-06-2020"
    }
}

{
    "numberAccount":"123456",
    "balance":"131.12",
    "currency":{
        "id":1
    }
}


ERROR
{"code":"","message":"","details":""}
ApiError [code=" + code + ", message=" + message + ", details=" + details + "]