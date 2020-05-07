CREATE TABLE "User" (
	id int  NOT NULL,
	name varchar(50)  NOT NULL,
	email varchar(100)  NOT NULL,
	Password varchar(30)  NOT NULL,
	Type_user varchar(50)  NOT NULL,
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
   Type_Status_id varchar(50)  NOT NULL,
   CONSTRAINT initiative_pk PRIMARY KEY (id)
);

create table Keywords (
	id int not null,
	keyword varchar(50) not null,
	idInitiative int not null,
	constraint keyword_pk primary key (id),
	constraint id_key unique (keyword,idinitiative)
);
create table Votes (
	id int not null,
	user_id int not null references "User"(id),
	ini_id int not null references Initiative(id)
);

CREATE TABLE InitiativeRelations(
   initiative int not null references Initiative(id) ,
   iniRelation int not null references Initiative(id),
   primary key (initiative,iniRelation)
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

alter table keywords add constraint keyword_initiative
	foreign key (idInitiative)
	references Initiative(id)
;

alter table "Comments" add constraint comment_initiative
	foreign key (initiative)
	references Initiative (id)
;
alter table "Comments" add constraint comment_user
	foreign key ("user")
	references "User" (id)
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
insert into "User" values (1015475104,'Juan','juan','juan',2);
insert into "User" values (1015475105,'Sebastian','proponente@prueba.com','proponente',2);

insert into Initiative (id,description,area,num_votos,creation_date,user_id,modify_date,type_status_id)
	values ((select count(*)+1 from Initiative),'mas parqueaderos','parqueadero',0,(select now()),1015475103,(select now()),'En Revision');

insert into Initiative (id,description,area,num_votos,creation_date,user_id,modify_date,type_status_id)
	values ((select count(*)+1 from Initiative),'Mas mesas en los kioskos','Kioskos',0,(select now()),1015475104,(select now()),'En Revision');

insert into Keywords (id,keyword ,idinitiative ) values ((select count(*)+1 from Keywords),'parqueadero',1);
insert into Keywords (id,keyword ,idinitiative ) values ((select count(*)+1 from Keywords),'carros',1);

INSERT INTO "Comments" (id, initiative, creationDate, modifyDate, message, "user")
        VALUES ((select count(*)+1 from "Comments"),1,(select now()),(select now()),'Me gusta la idea, la apoyo',1015475104);

insert into initiativerelations values (1,2);
insert into initiativerelations values (2,1);


