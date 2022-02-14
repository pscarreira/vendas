CREATE TABLE Cliente(
    id integer primary key auto_increment,
    nome varchar(100)
);

CREATE TABLE Produto(
    id integer primary key auto_increment,
    descricao varchar(100),
    preco_unitario numeric(20,2)
);

CREATE TABLE Pedido(
    id integer primary key auto_increment,
    cliente_id integer references Cliente(id),
    data_pedido timestamp,
    total numeric(20,2)
);

create table Item_Pedido(
   id integer primary key auto_increment,
   pedido_id integer references Pedido(id),
   produto_id integer references Produto(id),
   quantidade integer
)
