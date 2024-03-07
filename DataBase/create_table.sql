
\connect "funkydrive";

DROP TABLE IF EXISTS "roles";
DROP SEQUENCE IF EXISTS roles_id_seq;
CREATE SEQUENCE roles_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."roles" (
    "id" integer DEFAULT nextval('roles_id_seq') NOT NULL,
    "text" character varying(255) NOT NULL,
    "rang" integer DEFAULT '0' NOT NULL,
    "date_create" timestamptz DEFAULT 'NOW()' NOT NULL,
    CONSTRAINT "PK_b36bcfe02fc8de3c57a8b2391c2" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "roles" ("id", "text", "rang", "date_create") VALUES
(1,	'Admin',	100,	'NOW()'),
(2,	'Utilisateur',	2,	'NOW()'),
(3,	'Visiteur',	0,	'NOW()');

