----
---- ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
----

-- ===========================================================================================
--   Application Name	:	KleeContrib.Asta 
--   Script Name		:	03_create_fk.sql
--   Description		:	Script de création des indexes et des clef étrangères.
-- ===========================================================================================

/**
  * Création de l'index de clef étrangère pour DROIT_PROFILS.DRO_CODE
 **/
create index IDX_DPR_DRO_CODE_FK on DROIT_PROFILS (
	DRO_CODE ASC
);

/**
  * Génération de la contrainte de clef étrangère pour DROIT_PROFILS.DRO_CODE
 **/
alter table DROIT_PROFILS
	add constraint FK_DROIT_PROFILS_DRO_CODE foreign key (DRO_CODE)
		references DROITS (DRO_CODE);

/**
  * Création de l'index de clef étrangère pour DROIT_PROFILS.PRO_ID
 **/
create index IDX_DPR_PRO_ID_FK on DROIT_PROFILS (
	PRO_ID ASC
);

/**
  * Génération de la contrainte de clef étrangère pour DROIT_PROFILS.PRO_ID
 **/
alter table DROIT_PROFILS
	add constraint FK_DROIT_PROFILS_PRO_ID foreign key (PRO_ID)
		references PROFILS (PRO_ID);

/**
  * Création de l'index de clef étrangère pour DROITS.TDR_CODE
 **/
create index IDX_DRO_TDR_CODE_FK on DROITS (
	TDR_CODE ASC
);

/**
  * Génération de la contrainte de clef étrangère pour DROITS.TDR_CODE
 **/
alter table DROITS
	add constraint FK_DROITS_TDR_CODE foreign key (TDR_CODE)
		references TYPE_DROITS (TDR_CODE);

/**
  * Création de l'index de clef étrangère pour UTILISATEURS.PRO_ID
 **/
create index IDX_UTI_PRO_ID_FK on UTILISATEURS (
	PRO_ID ASC
);

/**
  * Génération de la contrainte de clef étrangère pour UTILISATEURS.PRO_ID
 **/
alter table UTILISATEURS
	add constraint FK_UTILISATEURS_PRO_ID foreign key (PRO_ID)
		references PROFILS (PRO_ID);

/**
  * Création de l'index de clef étrangère pour UTILISATEURS.TUT_CODE
 **/
create index IDX_UTI_TUT_CODE_FK on UTILISATEURS (
	TUT_CODE ASC
);

/**
  * Génération de la contrainte de clef étrangère pour UTILISATEURS.TUT_CODE
 **/
alter table UTILISATEURS
	add constraint FK_UTILISATEURS_TUT_CODE foreign key (TUT_CODE)
		references TYPE_UTILISATEURS (TUT_CODE);
