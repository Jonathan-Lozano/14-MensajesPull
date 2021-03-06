CREATE DATABASE mensajesPull;
USE mensajesPull;

CREATE TABLE users(
    idUser INT AUTO_INCREMENT PRIMARY KEY,
    userName VARCHAR(120)
)ENGINE=InnoDB;

CREATE TABLE messages(
    idMessage INT AUTO_INCREMENT PRIMARY KEY,
    idUser INT,
    FOREIGN KEY (idUser) REFERENCES users(idUser),
    dateMessage DATE,
    timeMessage TIME,
    message VARCHAR(500)
)ENGINE=InnoDB;
