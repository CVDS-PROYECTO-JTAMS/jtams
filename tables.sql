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
	values ((select count(*)+1 from "initiative"),'mas parqueaderos','parqueadero',0,(select now()),1015475103,(select now()),'En revision');

insert into Keywords (id,keyword ,idinitiative ) values ((select count(*)+1 from Keywords),'parqueadero',1);

-- Consultas
select
		i.id ,
		i.area ,
		i.creation_date,
		i.description,
		i.modify_date,
		i.num_votos,
		t.status,
		k.keyWord
	from initiative as i
	inner join type_status as t on i.type_status_id = t.id
	inner join keywords as k on i.id = k.idinitiative
	where k.keyword in ('parqueadero');

SELECT
        i.id,
        i.num_votos,
        i.description,
        i.area,
        i.creation_date,
        i.modify_date,
        i.user_id,
        u.id as user_id,
        u.name as user_name,
        u.email as user_email,
        u.type_user as user_type_user,
        u.password as user_password,
        ts.id,
        ts.status
        FROM Initiative as i
        INNER JOIN "User" as u on u.id = i.user_id
        INNER JOIN Type_Status as ts on ts.status = i.type_status_id;

select
		i.id,
		c.initiative
		from "Comments" as c
		inner join initiative as i on c.initiative =i.id ;

select
		u.id,
		c.user
		from "Comments" as c
		inner join "User" as u on c."user" = u.id ;

select
		i.area
		from initiative as i;

