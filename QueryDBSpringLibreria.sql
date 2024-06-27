create database springlibreria;
use springlibreria;

create table libri
(
	id int primary key auto_increment,
    autore varchar(100),
    titolo varchar(100)
);

insert into libri
(autore, titolo)
values
("Autore 1","Titolo 1"),
("Autore 2","Titolo 2");

select	*
from	libri;