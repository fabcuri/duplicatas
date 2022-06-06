drop database if exists CadastroDuplicata;
create database CadastroDuplicata;
use CadastroDuplicata;
create table duplicata(
idduplicata int primary key auto_increment,
cedente varchar(30)not null,
dataVencimento  varchar(12)not null, 
valor varchar(20)not null,
banco varchar(30)not null,
notaFiscal varchar(12)not null,
pago varchar(10)not null
);
desc duplicata;