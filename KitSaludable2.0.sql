-- -----------------------------------------------------
-- Schema KitSaludableDB
-- -----------------------------------------------------
create database if not exists KitSaludableDB2;

use KitSaludableDB2;

-- -----------------------------------------------------
-- Tabla Personas
-- -----------------------------------------------------

create table if not exists Personas(
	PS_ID int(11) not null auto_increment primary key,
	PS_Nombre varchar(30) not null,
	PS_Apellido varchar(30) not null,
	PS_Edad int(11) not null,
	PS_Peso float not null,
	FK_Rutinas int(11) not null,
	FK_Dietas int(11) not null,
	CONSTRAINT `FK_Rutinas`	
	FOREIGN KEY (FK_Rutinas)
	    REFERENCES Rutinas(RU_ID)
        ON DELETE CASCADE
        ON UPDATE NO ACTION, 
	CONSTRAINT `FK_Dietas`
	FOREIGN KEY (FK_Dietas)
		REFERENCES Dietas(DI_ID)
        ON DELETE CASCADE
        ON UPDATE NO ACTION
) ENGINE=INNODB;

-- -----------------------------------------------------
-- Tabla Ejercicios
-- -----------------------------------------------------

create table if not exists Ejercicios(
	EJ_ID int(11) not null auto_increment primary key,
	EJ_Nombre varchar (30) not null,
	EJ_intensidad varchar(30) not null,
) ENGINE=INNODB;

-- -----------------------------------------------------
-- Tabla Rutinas
-- -----------------------------------------------------

create table if not exists Rutinas(
	RU_ID int(11) not null primary key,
	RU_Nombre varchar (30) not null,
	RU_intensidad varchar(30) not null,
) ENGINE=INNODB;

-- -----------------------------------------------------
-- Tabla Ejercicios-Rutina
-- -----------------------------------------------------

create table if not exists Ejercicios-Rutinas(
	ER_ID int(11) not null auto_increment primary key,
	FK_Ejercicios int(11) not null,
	FK_Rutinas int(11) not null,
	
	FOREIGN KEY (FK_Ejercicios) REFERENCES Ejercicios(EJ_ID),
	FOREIGN KEY (FK_Rutinas) REFERENCES Rutinas(RU_ID)
) ENGINE=INNODB;

-- -----------------------------------------------------
-- Tabla Alimentos
-- -----------------------------------------------------

create table if not exists Alimentos(
	AL_ID int(11) not null auto_increment primary key,
	AL_Nombre varchar (30) not null,
	AL_Calorias int(11) not null
) ENGINE=INNODB;

-- -----------------------------------------------------
-- Tabla Dietas
-- -----------------------------------------------------

create table if not exists Dietas(
	DI_ID int(11) not null primary key,
	DI_Nombre varchar (30) not null,
	DI_Calorias int(11) not null
) ENGINE=INNODB;

-- -----------------------------------------------------
-- Tabla Alimentos-Dietas
-- -----------------------------------------------------

create table if not exists Alimentos-Dietas(
	AD_ID int(11) not null auto_increment primary key,
	FK_Alimentos int(11) not null,
	FK_Dietas int(11) not null,
	
	FOREIGN KEY (FK_Alimentos) REFERENCES Alimentos(AL_ID),
	FOREIGN KEY (FK_Dietas) REFERENCES Dietas(DI_ID)
) ENGINE=INNODB;
