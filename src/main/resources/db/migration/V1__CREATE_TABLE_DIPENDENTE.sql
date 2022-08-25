CREATE TABLE dipendente
(
    id   BIGINT,
    nome VARCHAR(500),
    cognome VARCHAR(500)
);
INSERT INTO dipendente(id, nome, cognome)
VALUES (nextval('hibernate_sequence'), 'Mario', 'Rossi');