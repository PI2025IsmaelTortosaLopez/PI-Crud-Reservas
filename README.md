# Sistema de Gestión de Reservas

## Descripción del proyecto 
Este proyecto consiste en una aplicación de consola desarrollada en Java que permite gestionar un sistema de reservas de recursos (como pistas deportivas), aplicando el patrón de arquitectura MVC (Modelo-Vista-Controlador) y conexión a base de datos MySQL mediante JDBC.

El sistema permite la gestión completa de usuarios, recursos, horarios y reservas, incluyendo validaciones avanzadas para asegurar la integridad de los datos.

---

## Arquitectura MVC

El proyecto está estructurado siguiendo el patrón MVC:

- **Model**: Contiene las clases que representan las entidades del sistema (Usuario, Recurso, Reserva, Horario).
- **DAO**: Encargado del acceso a la base de datos (consultas SQL).
- **Controller**: Contiene la lógica de negocio y validaciones.
- **View**: Interfaz de usuario en consola (menús y entrada de datos).

---

## Base de Datos

El sistema utiliza una base de datos MySQL con las siguientes tablas:

- `usuario`
- `usuarionormal`
- `administrador`
- `recurso`
- `horario`
- `reserva`
- `disponibleen`

Relaciones principales:
- Un usuario puede ser administrador o usuario normal.
- Un recurso puede tener múltiples reservas.
- Las reservas están asociadas a usuarios y recursos.

---

## Funcionalidades

### Usuarios
- Crear usuario administrador
- Crear usuario normal
- Modificar usuario
- Eliminar usuario
- Listar usuarios
- Buscar por nombre y correo

### Recursos
- Crear recurso
- Modificar recurso
- Eliminar recurso
- Listar recursos
- Buscar por nombre

### Horarios
- Crear horario
- Modificar horario
- Eliminar horario
- Listar horarios

### Reservas
- Crear reserva
- Modificar reserva
- Eliminar reserva
- Listar reservas
- Buscar por usuario
- Buscar por recurso

---

## Validaciones Implementadas

Para garantizar la integridad del sistema, se han implementado las siguientes validaciones en el Controller:

-  No se permiten reservas en fechas pasadas
-  La hora de fin debe ser mayor que la hora de inicio
-  No se pueden realizar reservas solapadas en el mismo recurso
-  No se puede superar la capacidad del recurso

Estas validaciones se realizan antes de insertar los datos en la base de datos.

---

## Tecnologías utilizadas

- Java (JDK 21)
- JDBC
- MySQL
- IntelliJ IDEA

---


---

## Conclusión

Este proyecto implementa un sistema completo de gestión de reservas aplicando buenas prácticas de programación, separación de responsabilidades y validación de datos, cumpliendo con los requisitos de un CRUD completo bajo arquitectura MVC.

He tenido algunas dificultades a lo largo de la realización del proyecto, principalmente al implementar Map en la consultas.
Creo que la realización de este proyecto me ha ayudado a mejorar muchas cosas que antes me costaba mucho realizar y despúes de esto manejo con bastante seguridad.
