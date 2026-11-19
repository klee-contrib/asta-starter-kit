----
---- ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
----

-- ===========================================================================================
--   Application Name	:	KleeContrib.Asta 
--   Script Name		:	02_indexes_and_keys.sql
--   Description		:	Script de création des indexes et des clés étrangères et uniques.
-- ===========================================================================================

/**
  * Création de l'index de clef étrangère pour droit_profils.dro_code
 **/
create index idx_dpr_dro_code_fk on droit_profils (
	dro_code ASC
);

/**
  * Génération de la contrainte de clef étrangère pour droit_profils.dro_code
 **/
alter table droit_profils
	add constraint fk_droit_profils_dro_code foreign key (dro_code)
		references droits (dro_code);

/**
  * Création de l'index de clef étrangère pour droit_profils.pro_id
 **/
create index idx_dpr_pro_id_fk on droit_profils (
	pro_id ASC
);

/**
  * Génération de la contrainte de clef étrangère pour droit_profils.pro_id
 **/
alter table droit_profils
	add constraint fk_droit_profils_pro_id foreign key (pro_id)
		references profils (pro_id);

/**
  * Création de l'index de clef étrangère pour droits.tdr_code
 **/
create index idx_dro_tdr_code_fk on droits (
	tdr_code ASC
);

/**
  * Génération de la contrainte de clef étrangère pour droits.tdr_code
 **/
alter table droits
	add constraint fk_droits_tdr_code foreign key (tdr_code)
		references type_droits (tdr_code);

/**
  * Création de l'index de clef étrangère pour utilisateurs.pro_id
 **/
create index idx_uti_pro_id_fk on utilisateurs (
	pro_id ASC
);

/**
  * Génération de la contrainte de clef étrangère pour utilisateurs.pro_id
 **/
alter table utilisateurs
	add constraint fk_utilisateurs_pro_id foreign key (pro_id)
		references profils (pro_id);

/**
  * Création de l'index de clef étrangère pour utilisateurs.tut_code
 **/
create index idx_uti_tut_code_fk on utilisateurs (
	tut_code ASC
);

/**
  * Génération de la contrainte de clef étrangère pour utilisateurs.tut_code
 **/
alter table utilisateurs
	add constraint fk_utilisateurs_tut_code foreign key (tut_code)
		references type_utilisateurs (tut_code);

/**
  * Création de l'index uk_utilisateurs_uti_email sur utilisateurs.
 **/
alter table utilisateurs add constraint uk_utilisateurs_uti_email unique (uti_email);
