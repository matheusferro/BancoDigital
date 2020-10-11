create database db_banco_digital;
use db_banco_digital;
create table TB_CLIENTE(
TB_CLIENTE_ID int auto_increment primary key  not null,
TB_CLIENTE_NOME varchar(255) not null,
TB_CLIENTE_SOBRENOME varchar(255) not null,
TB_CLIENTE_CPF varchar(14) not null,
TB_CLIENTE_EMAIL varchar(255) not null,
TB_CLIENTE_CNH varchar(11) not null,
TB_CLIENTE_DT_NASC date
);

create table TB_ENDERECO(
TB_ENDERECO_ID int auto_increment primary key  not null,
TB_ENDERECO_CEP varchar(9) not null,
TB_ENDERECO_RUA varchar(255) not null,
TB_ENDERECO_BAIRRO varchar(255) not null,
TB_ENDERECO_COMPLEMENTO varchar(255) not null,
TB_ENDERECO_CIDADE varchar(255) not null,
TB_ENDERECO_ESTADO varchar(255) not null,
TB_CLIENTE_ID int not null,
constraint  CLIENTE_FK_ENDERECO_PK
foreign key (TB_CLIENTE_ID)
references TB_CLIENTE(TB_CLIENTE_ID)
); 
 
 select * from tb_cliente; 
 select * from tb_ENDERECO; 
