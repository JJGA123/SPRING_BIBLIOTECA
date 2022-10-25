CREATE TABLE USUARIO (
   IDENTIFICACION_USUARIO VARCHAR(10) NOT NULL PRIMARY KEY,
   TIPO_USUARIO INT NOT NULL
);

CREATE TABLE LIBRO (
   ISBN VARCHAR(10) NOT NULL PRIMARY KEY
);

CREATE TABLE PRESTAMO (
   ID INT PRIMARY KEY AUTO_INCREMENT,
   ISBN VARCHAR(10) NOT NULL,
   IDENTIFICACION_USUARIO VARCHAR(10) NOT NULL,
   FECHA_REGISTRO DATE NOT NULL DEFAULT SYSDATE,
   FECHA_DEVOLUCION DATE NOT NULL,
   FOREIGN KEY (ISBN) REFERENCES LIBRO (ISBN),
   FOREIGN KEY (IDENTIFICACION_USUARIO) REFERENCES USUARIO (IDENTIFICACION_USUARIO)
);