create database db_banco_digital;
use db_banco_digital;
create table TB_CLIENTE(
TB_CLIENTE_ID int auto_increment primary key  not null,
TB_CLIENTE_NOME varchar(255) not null,
TB_CLIENTE_SOBRENOME varchar(255) not null,
TB_CLIENTE_EMAIL varchar(255) not null,
TB_CLIENTE_CNH varchar(11) not null,
TB_CLIENTE_DT_NASC varchar(20) /* VARCHAR PROVISORIO */
);


 select * from tb_cliente;