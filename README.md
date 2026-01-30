# 🏋️‍♂️ Gimnasio Campus API: Sistema de Gestión de Rutinas

¡Bienvenido al core digital de **Gimnasio Campus**! Esta es una API REST robusta desarrollada con **Spring Boot** diseñada para conectar a los entusiastas del fitness con sus planes de entrenamiento ideales. 

El sistema permite una gestión integral de clientes y un catálogo dinámico de rutinas, permitiendo que cada atleta tenga un seguimiento personalizado de su progreso.

---

## 🚀 Tecnologías y Dependencias implementadas
El proyecto está construido sobre el ecosistema de **Spring Boot 3**, utilizando las siguientes herramientas:

* **Spring Data JPA:** Para la persistencia de datos y manejo de la relación Many-to-Many.
* **MySQL Driver:** Conector para la base de datos de producción.
* **Jakarta Bean Validation:** Validación de datos de entrada (`@NotBlank`, `@Valid`).
* **SpringDoc OpenAPI (Swagger):** Documentación interactiva y pruebas de endpoints.
* **Maven:** Gestor de dependencias y construcción del proyecto.

---

## ⚙️ Configuración de la Base de Datos
**IMPORTANTE:** Para que el sistema funcione, asegúrate de configurar tu archivo `src/main/resources/application.properties` con tus credenciales de MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gimnasio_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
---
📖 Documentación Interactiva (Swagger)
Una vez que el proyecto esté en marcha, puedes explorar y probar todos los endpoints sin necesidad de herramientas externas:

🔗 URL de Swagger UI: http://localhost:8080/swagger-ui/index.html

---
🛠️ Instrucciones de Ejecución
1. Clonar o descargar: Descarga el código y abre la carpeta raíz.

2. Configurar DB: Crea una base de datos en MySQL llamada gimnasio_db.

3. Compilar: Ejecuta el comando mvn clean install para descargar las dependencias.

4. Correr: Inicia la aplicación desde tu IDE (IntelliJ/VS Code) o mediante mvn spring-boot:run.

5. Probar: Abre Swagger o Insomnia para comenzar a registrar clientes y asignar rutinas.

--- 
👥 Equipo de Desarrollo 
Este proyecto fue posible gracias a la colaboración de:

- ✨ Ashly

- 🔥 Duban

- 🛠️ Justin

---

🔗 Link video de sustentación:  
