create database StockMaster;

-- DROP SCHEMA public;
select now () :: timestamp;
show timezone;

CREATE SCHEMA public AUTHORIZATION pg_database_owner;

-- public."Provider" definition

-- Drop table

-- DROP TABLE public."Provider";

CREATE TABLE public."provider" (
	id_prov int4 NOT NULL DEFAULT nextval('"Provider_id_seq"'::regclass),
	"name" varchar NOT NULL,
	email varchar NOT NULL,
	CONSTRAINT provider_pk PRIMARY KEY (id_prov)
);

ALTER TABLE public.provider ADD telephone varchar NULL;


-- public."Product" definition

-- Drop table

-- DROP TABLE public."Product";

CREATE TABLE public."product" (
	id serial4 NOT NULL,
	"name" varchar NULL,
	id_provider int4 NULL,
	CONSTRAINT product_pk PRIMARY KEY (id)
);


-- public."Product" foreign keys

ALTER TABLE public."product" ADD CONSTRAINT product_fk FOREIGN KEY (id_provider) REFERENCES public."Provider"(id_prov);
ALTER TABLE public."product" ADD description varchar NULL;
ALTER TABLE public."product" ADD imageurl varchar NULL;


-- public."Stored" definition

-- Drop table

-- DROP TABLE public."Stored";

CREATE TABLE public."stored" (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	id_product int4 NULL,
	CONSTRAINT stored_pk PRIMARY KEY (id)
);


-- public."Stored" foreign keys

ALTER TABLE public."stored" ADD CONSTRAINT stored_fk FOREIGN KEY (id_product) REFERENCES public."Product"(id);
ALTER TABLE public."stored" ADD available int4 NULL;
ALTER TABLE public."stored" ADD updated date NULL;

-- public."Input" definition

-- Drop table

-- DROP TABLE public."Input";

CREATE TABLE public."input" (
	id serial4 NOT NULL,
	"name" varchar NULL,
	id_stored int4 NULL,
	CONSTRAINT input_pk PRIMARY KEY (id)
);


-- public."Input" foreign keys

ALTER TABLE public."input" ADD CONSTRAINT input_storeed_fk FOREIGN KEY (id_stored) REFERENCES public."Stored"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."input" ADD amount int4 NULL;
ALTER TABLE public."input" ADD updated date NULL;


-- public."Output" definition

-- Drop table

-- DROP TABLE public."Output";

CREATE TABLE public."output" (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	id_stored int4 NULL,
	CONSTRAINT output_pk PRIMARY KEY (id)
);


-- public."Output" foreign keys

ALTER TABLE public."output" ADD CONSTRAINT output_fk FOREIGN KEY (id_stored) REFERENCES public."Stored"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."output" ADD amount int4 NULL;
ALTER TABLE public."output" ADD updated date NULL;

-- public."User" definition

-- Drop table

-- DROP TABLE public."User";

CREATE TABLE public."token" (
	id serial4 NOT NULL,
	"content" varchar NULL,
	"active" boolean NULL,
	"timestamp" timestamp null,
	id_user int4 NULL,
	CONSTRAINT token_pk PRIMARY KEY (id),
	CONSTRAINT token_user_fk FOREIGN KEY (id_user) REFERENCES public."user"(id) ON DELETE CASCADE ON UPDATE CASCADE
);

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

--DROP TABLE public."userxproccess";

CREATE TABLE public."userxproccess" (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	id_user int4 NULL,
	id_input int4 NULL,
	id_output int4 NULL,
	CONSTRAINT userxproccess_pk PRIMARY KEY (id)
);


-- public."UserXproccess" foreign keys

ALTER TABLE public."userxproccess" ADD CONSTRAINT userxproccess_input_fk FOREIGN KEY (id_input) REFERENCES public."input"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."userxproccess" ADD CONSTRAINT userxproccess_output_fk FOREIGN KEY (id_output) REFERENCES public."output"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."userxproccess" ADD CONSTRAINT userxproccess_user_fk FOREIGN KEY (id_user) REFERENCES public."user"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."userxproccess" ADD description varchar NULL;
--ALTER TABLE public."input" ADD updated date NULL;

-- public."Detail" definition

-- Drop table

-- DROP TABLE public."detail";

CREATE TABLE public."detail" (
	id serial4 NOT NULL,
	"name" varchar NOT NULL,
	description varchar null,
	id_input int4 NULL,
	id_output int4 NULL,
	id_userxproccess int4 NULL,
	id_user int4 NULL,
	CONSTRAINT detail_pk PRIMARY KEY (id)
);


-- public."Detail" foreign keys

ALTER TABLE public."detail" ADD CONSTRAINT detail_input_fk FOREIGN KEY (id_input) REFERENCES public."input"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."detail" ADD CONSTRAINT detail_output_fk FOREIGN KEY (id_output) REFERENCES public."output"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."detail" ADD CONSTRAINT detail_user_fk FOREIGN KEY (id_user) REFERENCES public."user"(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE public."detail" ADD CONSTRAINT detail_userxproccess_fk FOREIGN KEY (id_userxproccess) REFERENCES public."userxproccess"(id) ON DELETE CASCADE ON UPDATE CASCADE;




--ALTER TABLE public."Detail" RENAME TO detail;
--ALTER TABLE public."Input" RENAME TO "input";
--ALTER TABLE public."Output" RENAME TO "output";
--ALTER TABLE public."Product"  RENAME TO product;
--ALTER TABLE public."Provider" RENAME TO provider;
--ALTER TABLE public."Stored" RENAME TO "stored";
--ALTER TABLE public."User" RENAME TO "user";
--ALTER TABLE public."UserXproccess" RENAME TO userxproccess;


INSERT INTO public."user"
("name", username, email, "password", isadmin)
VALUES('moises', 'moi123', 'moises@email.com', '1234', false);

INSERT INTO public.provider
("name", email)
VALUES('naturas', 'naturas@email.com');

INSERT INTO public.product
("name", id_provider)
VALUES('tomatoes', 1);


INSERT INTO public."stored"
("name", id_product)
VALUES('ewee', 1);

INSERT INTO public."input"
("name", id_stored)
VALUES('dfd', 1);

INSERT INTO public.detail
("name", id_input, id_output, id_userxproccess, id_user)
VALUES('sddff', 0, 0, 0, 0);

INSERT INTO public.userxproccess
("name", id_user, id_input, id_output)
VALUES('sdf', 1, 0, 0);

INSERT INTO public.detail
("name", id_input, id_output, id_userxproccess, id_user)
VALUES('sddff', 0, 0, 0, 0);