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
   Type_Status_id varchar(50)  NOT NULL,
   CONSTRAINT initiative_pk PRIMARY KEY (id)
);

CREATE TABLE Type_Status (
   id int  NOT NULL,
   status varchar(50)  NOT NULL,
   CONSTRAINT Type_Status_uk UNIQUE (status),
   CONSTRAINT Type_Status_pk PRIMARY KEY (id)
);

--Foreing Key

ALTER TABLE Initiative ADD CONSTRAINT Initiative_User
   FOREIGN KEY (User_id)
   REFERENCES "User" (id) 
;

ALTER TABLE Initiative ADD CONSTRAINT Initiative_Type_Status
   FOREIGN KEY (Type_Status_id)
   REFERENCES Type_Status (status)
;

/*
 * Para los tipo usuario se tienen de la siguiente forma:
 * 0 - Administrador
 * 1 - Personal
 * 2 - Proponente
 * 3 - Publico
 * */
 

insert into "User" values (111111111,'sebastian','sebasvilla@gmail.com','sebastian1213',2);
insert into "User" values (1015475102,'nikolai','nikolai9906n@gmail.com','nikolai1213',0);
insert into "User" values (1015475103,'Verbo','verbo@gmail.com','verbo1213',1);
insert into "User" values (1015475104,'Juan','juan@gmail.com','juan1213',3);

insert into Initiative (id,description,area,num_votos,creation_date,User_id,modify_date,Type_status_id)
					values ((select count(*)+1 from "Initiative"),
						'bajar precios de los k','economia',3,(select now()),
						123456,(select now()),'En espera de revisión') ;
						
				
insert into Initiative (id,description,area,num_votos,creation_date,User_id,modify_date,Type_status_id)
					values ((select count(*)+1 from "Initiative"),
						'dar mas intersemestrales para ing Sistemas','Bienestar U',100,(select now()),
						1234567,(select now()),'En espera de revisión') ;