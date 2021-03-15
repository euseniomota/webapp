/* Banco de dados postgresql */
create database webapp;

drop table tbl_titulo;

create table if not exists tbl_titulo
(
	id serial unique,
	descricao varchar(100) not null,
	tipo char(1) default 'D' not null, -- 'D' -> titulo de direito, 'O' -> Titulo de Obrigação
	dtavencimento date default current_date,
	status char(1) default 'A' not null, -- 'A' -> titulo em aberto, 'Q' -> titulo quitado
	valor numeric(10,4)
);

insert into tbl_titulo(descricao,tipo,status,valor) values('Americanas','O','A',100);
insert into tbl_titulo(descricao,tipo,status,valor) values('Padaria JM','O','A',20);
insert into tbl_titulo(descricao,tipo,status,valor) values('Borracharia Silva','O','A',10);
insert into tbl_titulo(descricao,tipo,status,valor) values('Acougue Boi Gordo','O','A',70);
insert into tbl_titulo(descricao,tipo,status,valor) values('M&M Modas','D','A',150);

select * from tbl_titulo;

select t1.id,
	   t1.descricao,
	   case t1.tipo when 'O' then 'OBRIGACAO'
	   			 when 'D' then 'DIREITO'
	   end	as tipo,
	   t1.dtavencimento,
	   case t1.status when 'A' then 'EM ABERTO'
	   			   when 'Q' then 'QUITADO'
	   end as status,
	   concat('R$: ', t1.valor) as valor
from tbl_titulo t1;

/*
update tbl_titulo
set status = 'Q'
where status = 'O';
*/

create or replace view vw_titulos as
select id,
	   descricao,
	   case tipo when 'O' then 'OBRIGACAO'
	   			 when 'D' then 'DIREITO'
	   end	as tipo,
	   dtavencimento,
	   case status when 'A' then 'EM ABERTO'
	   			   when 'Q' then 'QUITADO'
	   end as status,
	   valor
from tbl_titulo;

select * from vw_titulos;

select sum(valor) from tbl_titulo where tipo = 'O';










