-- Dados de inicialização para testes

INSERT INTO cargo VALUES (1, 'Administrador', '2900.25');
INSERT INTO cargo VALUES (2, 'Vendedor', '2000.75');
INSERT INTO cargo VALUES (3, 'Auxiliar', '1600.38');

INSERT INTO funcionario (id_func, name, data_nasc, cargo_id_cargo) VALUES (1, 'John Silva', TO_DATE('17/12/1987', 'DD/MM/YYYY'), 1);
INSERT INTO funcionario (id_func, name, data_nasc, cargo_id_cargo) VALUES (2, 'Maria Lena', TO_DATE('12/05/1995', 'DD/MM/YYYY'), 2);
INSERT INTO funcionario (id_func, name, data_nasc, cargo_id_cargo) VALUES (3, 'Pedro Bino', TO_DATE('05/01/1992', 'DD/MM/YYYY'), 2);
