# 🛒 Tienda Online - Spring Boot

Aplicación web de una tienda en línea desarrollada con Spring Boot, Spring Security, JPA y Thymeleaf.  
Permite el registro y autenticación de usuarios con roles, gestión de productos y control de acceso según permisos.

---

## 🚀 Tecnologías utilizadas

- Java 21
- Spring Boot 4
- Spring Security
- Spring Data JPA
- Hibernate
- Thymeleaf
- MySQL
- Maven
- Lombok

---

## 🔐 Funcionalidades principales

- Registro de usuarios
- Inicio de sesión con autenticación
- Encriptación de contraseñas con BCrypt
- Sistema de roles:
  - ROLE_USER
  - ROLE_ADMIN
- Protección de rutas con Spring Security
- Persistencia de datos con JPA
- Conexión a base de datos MySQL
- Vistas dinámicas con Thymeleaf

---

## 🗂️ Estructura del proyecto
src/main/java/com/sosastore/tienda
─ config → Configuración de seguridad
─ controller → Controladores MVC
─ model → Entidades JPA
─ repository → Interfaces JPA
─ service → Lógica de negocio

---

## 🛠️ Configuración del proyecto

### 1️⃣ Clonar el repositorio
git clone https://github.com/93Cast/sosastore.git

cd tienda-online

### 2️⃣ Configurar la base de datos

Crear base de datos en MySQL:
CREATE DATABASE tienda_spring;

Configurar `application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/tienda_spring
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


### 3️⃣ Ejecutar el proyecto

Desde IntelliJ o con Maven:
mvn spring-boot:run

Aplicación disponible en:
http://localhost:8080

---

## 📌 Estado del proyecto

Proyecto en desarrollo 🚧  
Actualmente implementando:

- Sistema completo de autenticación
- Control de acceso por roles
- Gestión de productos
- Panel administrativo

---

## 🎯 Objetivo del proyecto

Este proyecto fue desarrollado como práctica para reforzar conocimientos en:

- Arquitectura MVC
- Seguridad con Spring Security
- Persistencia con JPA
- Manejo de roles y autorización
- Desarrollo backend profesional con Java

---

## 👨‍💻 Autor

Desarrollado por Daniel Sosa  
Estudiante de Ingeniería en Sistemas y desarrollador backend en formación.
