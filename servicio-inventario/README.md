# Servicio de Inventario

Proyecto de Spring Boot 3 con Maven para gestionar un servicio de inventario.

## Requisitos Previos

- Java 17 o superior
- Maven 3.6 o superior

## Dependencias Incluidas

- **Spring Web**: Para crear aplicaciones web RESTful
- **Spring Data JPA**: Para acceso a datos con persistencia
- **H2 Database**: Base de datos en memoria para desarrollo y pruebas
- **Lombok**: Para reducir boilerplate de código

## Compilación

```bash
mvn clean install
```

## Ejecución

```bash
mvn spring-boot:run
```

## Acceso a H2 Console

Una vez que la aplicación esté en ejecución, puedes acceder a la consola H2 en:

```
http://localhost:8080/h2-console
```

Credenciales:
- URL JDBC: `jdbc:h2:mem:testdb`
- Usuario: `sa`
- Contraseña: (vacía)

## Estructura del Proyecto

```
servicio-inventario/
├── src/
│   ├── main/
│   │   ├── java/com/inventario/
│   │   │   └── ServicioInventarioApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/inventario/
├── pom.xml
└── README.md
```
