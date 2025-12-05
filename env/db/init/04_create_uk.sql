----
---- ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
----

-- ===========================================================================================
--   Application Name	:	KleeContrib.Asta 
--   Script Name		:	04_create_uk.sql
--   Description		:	Script de création des contraintes d'unicité.
-- ===========================================================================================

alter table UTILISATEURS add constraint UK_UTILISATEURS_UTI_EMAIL unique (UTI_EMAIL);
