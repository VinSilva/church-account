CREATE SCHEMA curso_db;

USE curso_db;

CREATE TABLE LOGIN (

    ID INT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(40) NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    PRIMARY KEY(ID)

);

INSERT INTO LOGIN (NAME, PASSWORD) VALUES ('Rodrigo', 'TESTE');

#################################################
CREATE TABLE EXPENSE (
    ID NOT NULL AUTO_INCREMENT,
    CREATION_DATE  DATE NOT NULL,
    NAME VARCHAR(100) NOT NULL,
    RESPONSIBLE VARCHAR(100) NOT NULL ,
    AMOUNT DOUBLE NOT NULL,
    PRIMARY KEY(ID)
);


CREATE TABLE IF NOT EXISTS EXPENSE (
         ID INT AUTO_INCREMENT PRIMARY KEY,
         NAME VARCHAR(255) NOT NULL,
         CREATION_DATE TIMESTAMP,
         RESPONSIBLE VARCHAR(100) NOT NULL ,
         AMOUNT DOUBLE NOT NULL
     )  ENGINE=INNODB;


SELECT * FROM EXPENSE;

INSERT INTO EXPENSE (NAME, CREATION_DATE, RESPONSIBLE, AMOUNT) VALUES
  ( 'CONTA DE AGUA',
     CURRENT_TIMESTAMP,
     'VINICIUS',
     100.50
   );

CREATE TABLE DEPOSIT(
		ID INT NOT NULL AUTO_INCREMENT,
        DEPOSIT_DATE DATE NOT NULL,
        NAME varchar(100),
        TYPE ENUM('DIZIMO','OFERTA') NOT NULL,
        PAY_TYPE ENUM('DINHEIRO','DEBITO','CREDITO','CHEQUE') NOT NULL,
        AMOUNT DOUBLE NOT NULL,
        PRIMARY KEY(ID)
    );
