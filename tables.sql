CREATE TABLE "User" (
	id int  NOT NULL,
	name varchar(50)  NOT NULL,
	email varchar(100)  NOT NULL,
	Password varchar(30)  NOT NULL,
	Type_user int  NOT NULL,
	CONSTRAINT email UNIQUE (email) NOT DEFERRABLE  INITIALLY IMMEDIATE,
	CONSTRAINT user_pk PRIMARY KEY (id)
);


CREATE TABLE vote (
	User_id int  NOT NULL,
	Initiative_id int  NOT NULL,
	CONSTRAINT vote_pk PRIMARY KEY (User_id,Initiative_id)
);

CREATE TABLE Comment (
   id int  NOT NULL,
   comment varchar(200)  NOT NULL,
   User_id int  NOT NULL,
   Initiative_id int  NOT NULL,
   CONSTRAINT Comment_pk PRIMARY KEY (id)
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

CREATE TABLE word_initiative (
   Initiative_id int  NOT NULL,
   Key_words_id int  NOT NULL,
   CONSTRAINT word_initiative_pk PRIMARY KEY (Initiative_id,Key_words_id)
);

CREATE TABLE Key_words (
   id int  NOT NULL,
   word varchar(15)  NOT NULL,
   CONSTRAINT Key_words_pk PRIMARY KEY (id)
);

--Foreing Key

ALTER TABLE Comment ADD CONSTRAINT Comment_User
   FOREIGN KEY (User_id)
   REFERENCES "User" (id)  
   NOT DEFERRABLE 
   INITIALLY IMMEDIATE
;

ALTER TABLE vote ADD CONSTRAINT vote_User
   FOREIGN KEY (User_id)
   REFERENCES "User" (id)  
   NOT DEFERRABLE 
   INITIALLY IMMEDIATE
;

ALTER TABLE Initiative ADD CONSTRAINT Initiative_User
   FOREIGN KEY (User_id)
   REFERENCES "User" (id)  
   NOT DEFERRABLE 
   INITIALLY IMMEDIATE
;

ALTER TABLE vote ADD CONSTRAINT vote_Initiative
   FOREIGN KEY (Initiative_id)
   REFERENCES Initiative (id)  
   NOT DEFERRABLE 
   INITIALLY IMMEDIATE
;

ALTER TABLE Comment ADD CONSTRAINT Comment_Initiative
   FOREIGN KEY (Initiative_id)
   REFERENCES Initiative (id)  
   NOT DEFERRABLE 
   INITIALLY IMMEDIATE
;

ALTER TABLE Initiative ADD CONSTRAINT Initiative_Type_Status
   FOREIGN KEY (Type_Status_id)
   REFERENCES Type_Status (status)  
   NOT DEFERRABLE 
   INITIALLY IMMEDIATE
;

ALTER TABLE word_initiative ADD CONSTRAINT word_initiative_Initiative
   FOREIGN KEY (Initiative_id)
   REFERENCES Initiative (id)  
   NOT DEFERRABLE 
   INITIALLY IMMEDIATE
;

ALTER TABLE word_initiative ADD CONSTRAINT word_initiative_Key_words
   FOREIGN KEY (Key_words_id)
   REFERENCES Key_words (id)  
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

insert into "type_status" values (1, 'En espera de revisión');
insert into "type_status" values (2, 'En revisión');
insert into "type_status" values (3, 'Proyecto');
insert into "type_status" values (4, 'Solucionado');

insert into "initiative" (id,description,area,num_votos,creation_date,user_id,modify_date,type_status_id)
					values ((select count(*)+1 from "initiative"),
						'Se requieren mas kioscos','construccion',0,(select now()),
						1015475102,(select now()),'En espera de revisión') ;
						
insert into "initiative" (id,description,area,num_votos,creation_date,user_id,modify_date,type_status_id)
					values ((select count(*)+1 from "initiative"),
						'Se requieren mas parqueaderos','parqueadero',0,(select now()),
						111111111,(select now()),'En espera de revisión') ;					