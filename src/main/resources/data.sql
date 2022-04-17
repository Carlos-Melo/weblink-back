INSERT INTO PLANO(id, nome_plano, valor, qtd_mega) VALUES(1, 'Básico', 80.00, '120');
INSERT INTO PLANO(id, nome_plano, valor, qtd_mega) VALUES(2, 'Normal', 100.00, '220');
INSERT INTO PLANO(id, nome_plano, valor, qtd_mega) VALUES(3, 'Ultra', 200.00, '320');
INSERT INTO PLANO(id, nome_plano, valor, qtd_mega) VALUES(4, 'adm', 0.00, 'adm');

INSERT INTO USUARIO(nome, cpf_cnpj, email, senha, cep, estado, cidade, bairro, rua, numero, cliente, administrador, conexao, plano_id) VALUES('Carlos', '70447755439', 'admin@gmail.com', 'admin', '52081-410', 'PE', 'Recife', 'Nova Descoberta', 'Imbauba', '475', false, true, false, 4);