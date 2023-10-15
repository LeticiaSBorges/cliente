/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  letic
 * Created: 11 de out. de 2023
 */

CREATE TABLE ALUNO(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    matricula INTEGER,
    nome VARCHAR(100)
);

CREATE TABLE PUBLICACAO(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    codigo INTEGER,
    titulo VARCHAR(100),
    ano INTEGER,
    autor VARCHAR(100),
    tipo VARCHAR(100)
);

CREATE TABLE EMPRESTIMO(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    dtdevolucao DATE,
    dtemprestimo DATE,
    idaluno INTEGER REFERENCES ALUNO(id),
    idpublicacao INTEGER REFERENCES PUBLICACAO(id)
);