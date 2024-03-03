CREATE TABLE proyectos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre CHAR(50) NOT NULL,
    fecha_creacion DATE NOT NULL,
    tareas INT NOT NULL);

CREATE TABLE tareas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion CHAR(50) NOT NULL,
    fecha_limite DATE NOT NULL,
    orden INT NOT NULL,
    completada BOOLEAN NOT NULL,
    proyecto_id BIGINT);
