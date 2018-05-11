drop database if exists colegio2;
create database colegio2;
use colegio2;

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
    edad        int         not null
);

create table inscripciones(
	idCurso		int,
	idAlumno	int,
	primary key(idCurso,idAlumno)
);