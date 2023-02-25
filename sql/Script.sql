create database StockMaster;

-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION pg_database_owner;

-- public."Provider" definition

-- Drop table

-- DROP TABLE public."Provider";

CREATE TABLE public."Provider" (
	id_prov int4 NOT NULL DEFAULT nextval('"Provider_id_seq"'::regclass),
	"name" varchar NOT NULL,
	email varchar NOT NULL,
	CONSTRAINT provider_pk PRIMARY KEY (id_prov)
);



-- public."Product" definition

-- Drop table

-- DROP TABLE public."Product";

CREATE TABLE public."Product" (
	id serial4 NOT NULL,
	"name" varchar NULL,
	id_provider int4 NULL,
	CONSTRAINT product_pk PRIMARY KEY (id)
);


-- public."Product" foreign keys

ALTER TABLE public."Product" ADD CONSTRAINT product_fk FOREIGN KEY (id_provider) REFERENCES public."Provider"(id_prov);


-- public."Stored" definition

-- Drop table

-- DROP TABLE public."Stored";

CREATE TABLE public."Stored" (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	id_product int4 NULL,
	CONSTRAINT stored_pk PRIMARY KEY (id)
);


-- public."Stored" foreign keys

ALTER TABLE public."Stored" ADD CONSTRAINT stored_fk FOREIGN KEY (id_product) REFERENCES public."Product"(id);


-- public."Input" definition

-- Drop table

-- DROP TABLE public."Input";

CREATE TABLE public."Input" (
	id serial4 NOT NULL,
	"name" varchar NULL,
	id_stored int4 NULL,
	CONSTRAINT input_pk PRIMARY KEY (id)
);


-- public."Input" foreign keys

ALTER TABLE public."Input" ADD CONSTRAINT input_storeed_fk FOREIGN KEY (id_stored) REFERENCES public."Stored"(id) ON DELETE CASCADE ON UPDATE CASCADE;


-- public."Output" definition

-- Drop table

-- DROP TABLE public."Output";

CREATE TABLE public."Output" (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	id_stored int4 NULL,
	CONSTRAINT output_pk PRIMARY KEY (id)
);


-- public."Output" foreign keys

ALTER TABLE public."Output" ADD CONSTRAINT output_fk FOREIGN KEY (id_stored) REFERENCES public."Stored"(id) ON DELETE CASCADE ON UPDATE CASCADE;


-- public."User" definition

-- Drop table

-- DROP TABLE public."User";

CREATE TABLE public."User" (
	id int4 NOT NULL DEFAULT nextval('"Usuarios_id_seq"'::regclass),
	"name" varchar NOT NULL,
	username varchar NOT NULL,
	email varchar NOT NULL,
	"password" varchar NOT NULL,
	isadmin bool NULL,
	CONSTRAINT usuaris_pk PRIMARY KEY (id)
);


-- public."UserXproccess" definition

-- Drop table

-- DROP TABLE public."UserXproccess";

CREATE TABLE public."UserXproccess" (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	id_user int4 NULL,
	id_input int4 NULL,
	id_output int4 NULL,
	CONSTRAINT userxproccess_pk PRIMARY KEY (id)
);


-- public."UserXproccess" foreign keys

ALTER TABLE public."UserXproccess" ADD CONSTRAINT userxproccess_input_fk FOREIGN KEY (id_input) REFERENCES public."Input"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."UserXproccess" ADD CONSTRAINT userxproccess_output_fk FOREIGN KEY (id_output) REFERENCES public."Output"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."UserXproccess" ADD CONSTRAINT userxproccess_user_fk FOREIGN KEY (id_user) REFERENCES public."User"(id) ON DELETE CASCADE ON UPDATE CASCADE;


-- public."Detail" definition

-- Drop table

-- DROP TABLE public."Detail";

CREATE TABLE public."Detail" (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	id_input int4 NULL,
	id_output int4 NULL,
	id_userxproccess int4 NULL,
	id_user int4 NULL,
	CONSTRAINT detail_pk PRIMARY KEY (id)
);


-- public."Detail" foreign keys

ALTER TABLE public."Detail" ADD CONSTRAINT detail_input_fk FOREIGN KEY (id_input) REFERENCES public."Input"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."Detail" ADD CONSTRAINT detail_output_fk FOREIGN KEY (id_output) REFERENCES public."Output"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."Detail" ADD CONSTRAINT detail_user_fk FOREIGN KEY (id_user) REFERENCES public."User"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."Detail" ADD CONSTRAINT detail_userxproccess_fk FOREIGN KEY (id_userxproccess) REFERENCES public."UserXproccess"(id) ON DELETE CASCADE ON UPDATE CASCADE;

