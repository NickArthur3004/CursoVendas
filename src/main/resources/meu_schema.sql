CREATE TABLE Cliente (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100)
);

Create table Produto(
	id integer primary key auto_increment,
    descricao varchar(100),
    preco_unitario numeric(20,2)
);

Create table Pedido(
	id integer primary key auto_increment,
    cliente_id integer references Cliente(id),
    data_pedido timestamp,
    total numeric(20,2)
);

Create table Item_Pedido(
	id integer primary key auto_increment,
    pedido_id integer references Pedido(id),
    produto_id integer references Produto(id),
    quantidade integer
);

