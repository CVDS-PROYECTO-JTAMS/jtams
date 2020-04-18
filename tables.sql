CREATE TABLE "User" (
	id int  NOT NULL,
	name varchar(50)  NOT NULL,
	email varchar(100)  NOT NULL,
	Password varchar(30)  NOT NULL,
	Type_user int  NOT NULL,
	CONSTRAINT email UNIQUE (email) NOT DEFERRABLE  INITIALLY IMMEDIATE,
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
   CONSTRAINT Type_Status_uk UNIQUE (status) NOT DEFERRABLE  INITIALLY IMMEDIATE,
   CONSTRAINT Type_Status_pk PRIMARY KEY (id)
);

--Foreing Key

ALTER TABLE Initiative ADD CONSTRAINT Initiative_User
   FOREIGN KEY (User_id)
   REFERENCES "User" (id)  
   NOT DEFERRABLE 
   INITIALLY IMMEDIATE
;

ALTER TABLE Initiative ADD CONSTRAINT Initiative_Type_Status
   FOREIGN KEY (Type_Status_id)
   REFERENCES Type_Status (status)  
   NOT DEFERRABLE 
   INITIALLY IMMEDIATE
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


insert into "initiative" (id,description,area,num_votos,creation_date,user_id,modify_date,type_status_id)
					values ((select count(*)+1 from "initiative"),
						'Se requieren mas kioscos','construccion',0,(select now()),
						1015475102,(select now()),'En espera de revisión') ;
						
insert into "initiative" (id,description,area,num_votos,creation_date,user_id,modify_date,type_status_id)
					values ((select count(*)+1 from "initiative"),
						'Se requieren mas parqueaderos','parqueadero',0,(select now()),
						111111111,(select now()),'En espera de revisión') ;					