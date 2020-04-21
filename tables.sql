CREATE TABLE "User" (
	id int  NOT NULL,
	name varchar(50)  NOT NULL,
	email varchar(100)  NOT NULL,
	Password varchar(30)  NOT NULL,
	Type_user int  NOT NULL,
	CONSTRAINT email UNIQUE (email),
	CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE Initiative (
   id int  NOT NULL,
   description varchar(150)  NOT NULL,
   area varchar(100)  NOT NULL,
   num_votos int  NOT NULL,
   creation_date date  NOT NULL,
   User_id int  NOT NULL,
   modify_date date  NOT NULL,
   Type_Status_id int  NOT NULL,
   CONSTRAINT initiative_pk PRIMARY KEY (id)
);

create table Keywords (
	id int not null,
	keyWord varchar(50) not null,
	idInitiative int not null,
	constraint keyword_pk primary key (id),
	constraint id_key unique (keyWord,idinitiative)
);

CREATE TABLE Type_Status (
   id int  NOT NULL,
   status varchar(50)  NOT NULL,
   CONSTRAINT Type_Status_uk UNIQUE (status),
   CONSTRAINT Type_Status_pk PRIMARY KEY (id)
);

create table "Comments"(
	id int not null,
	initiative int not null,
	creationDate date not null,
	modifyDate date not null,
	message varchar(150) not null,
	"user" int not null,
	constraint Comments_pk primary key (id)
);




--Foreing Key

ALTER TABLE Initiative ADD CONSTRAINT Initiative_User
   FOREIGN KEY (User_id)
   REFERENCES "User" (id)
;

ALTER TABLE Initiative ADD CONSTRAINT Initiative_Type_Status
   FOREIGN KEY (Type_Status_id)
   REFERENCES Type_Status (id)
;

alter table keywords add constraint keyword_initiative
	foreign key (idInitiative)
	references Initiative(id)
;

/*
 * Para los tipo usuario se tienen de la siguiente forma:
 * 0 - Administrador
 * 1 - Personal
 * 2 - Proponente
 * 3 - Publico
 * */

--Values

insert into "User" values (1015475102,'nikolai','niko','niko',0);
insert into "User" values (1015475103,'Verbo','verbo','verbo',2);

insert into type_status values (1,'En revision');

insert into initiative (id,description,area,num_votos,creation_date,user_id,modify_date,type_status_id)
	values ((select count(*)+1 from initiative),'mas parqueaderos','parqueadero',0,(select now()),1015475103,(select now()),1);
insert into initiative (id,description,area,num_votos,creation_date,user_id,modify_date,type_status_id)
	values ((select count(*)+1 from initiative),'mas restaurantes','restaurante',0,(select now()),1015475103,(select now()),1);
insert into initiative (id,description,area,num_votos,creation_date,user_id,modify_date,type_status_id)
	values ((select count(*)+1 from initiative),'mas computadores','laboratorio',0,(select now()),1015475103,(select now()),1);
insert into initiative (id,description,area,num_votos,creation_date,user_id,modify_date,type_status_id)
	values ((select count(*)+1 from initiative),'menor precio de parqueadero','parqueadero',0,(select now()),1015475103,(select now()),1);

insert into Keywords (id,keyword ,idinitiative ) values ((select count(*)+1 from Keywords),'parqueadero',1015475103);
insert into Keywords (id,keyword ,idinitiative ) values ((select count(*)+1 from Keywords),'restaurante',1);
insert into Keywords (id,keyword ,idinitiative ) values ((select count(*)+1 from Keywords),'laboratorio',1);

