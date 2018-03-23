drop database if exists colegio;
create database colegio;
use colegio;

create table cursos(
    id          int         auto_increment primary key,
    titulo      varchar(20) not null,
    profesor    varchar(20) not null,
    dia         varchar(20) not null,
    turno       varchar(20) not null
);

create table alumnos(
    id          int         auto_increment primary key,
    nombre      varchar(20) not null,
    apellido    varchar(20) not null,
    edad        int         not null,
    idCurso     int         not null
);

-- Restricción de Clave Foranea
-- alter table alumnos
-- add constraint FK_AlumnosIdCurso
-- foreign key(idCurso)
-- references cursos(id)
-- on delete cascade;