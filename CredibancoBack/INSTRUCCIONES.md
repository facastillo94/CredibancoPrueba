PROYECTO REALIZADO EN: Intellij IDEA 2022


1. Montar Base de datos en Mysql (MariaDB) archivo credibancobd.sql
2. Importar Proyecto en este IDE
3. Configurar el acceso a la BD en el archivo src/main/resources/application.properties
4. Configurar el servidor MAVEN para que haga run con: spring-boot:run  JRE 1.8
5. Hacer RUN, esta en Servidor MAVEN
6. Probar preferiblemente en POSTMAN, ya que allí fue donde hice todas las pruebas y exportaciones

Quedo atento a cualquier solicitud. Mil gracias.

Consumos alcanzados a realizar (Ver carpeta "Evidencias y Postman"):


1. Consultar Tarjetas: http://localhost:4000/card/all

Verbo: GET
SIN BODY

2. Consultar Tarjeta por ID Primario, (EJ): http://localhost:4000/card/3

Verbo: GET
SIN BODY

3. NUEVA TARJETA: http://localhost:4000/card/enroll

Verbo: POST

BODY EJEMPLO:
{
    "numeroproducto": "0987654321",
    "numerotarjeta": "0987654321123456",
    "fechacreacion": "2023-09-12",
    "fechavencimiento": "2025-09-12",
    "saldo": "1000000",
    "activa_tarjeta": 1,
    "bloqueada_tarjeta": 0
}

4. (BLOQUEAR TARJETA), Ejemplo: http://localhost:4000/card/4

Verbo: DELETE
SIN BODY

5. SUMAR BALANCE: http://localhost:4000/card/balance

Verbo: POST 

BODY EJEMPLO:
{
    "numerotarjeta": "1234567890121456",
    "saldo": "10000"
}

6. CONSULTAR SALDO POR CARDID, EJEMPLO: http://localhost:4000/card/balance/1234567890121456

Verbo: GET
SIN BODY
