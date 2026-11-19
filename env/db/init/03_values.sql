----
---- ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
----

-- ===========================================================================================
--   Application Name	:	KleeContrib.Asta 
--   Script Name		:	03_values.sql
--   Description		:	Script d'insertion des valeurs initiales.
-- ===========================================================================================

/**		Initialisation de la table type_droits		**/
insert into type_droits(tdr_code, tdr_libelle) values('READ', 'Lecture');
insert into type_droits(tdr_code, tdr_libelle) values('WRITE', 'Ecriture');
insert into type_droits(tdr_code, tdr_libelle) values('ADMIN', 'Administration');

/**		Initialisation de la table droits		**/
insert into droits(dro_code, dro_libelle, tdr_code) values('CREATE', 'Création', 'WRITE');
insert into droits(dro_code, dro_libelle, tdr_code) values('READ', 'Lecture', 'READ');
insert into droits(dro_code, dro_libelle, tdr_code) values('UPDATE', 'Mise à jour', 'WRITE');
insert into droits(dro_code, dro_libelle, tdr_code) values('DELETE', 'Suppression', 'ADMIN');

/**		Initialisation de la table profils		**/
insert into profils(pro_id, pro_libelle, pro_date_creation, pro_date_modification) values(1, 'Profil 1', now(), null);
insert into profils(pro_id, pro_libelle, pro_date_creation, pro_date_modification) values(2, 'Profil 2', now(), null);
insert into profils(pro_id, pro_libelle, pro_date_creation, pro_date_modification) values(3, 'Profil 3', now(), null);
insert into profils(pro_id, pro_libelle, pro_date_creation, pro_date_modification) values(4, 'Profil 4', now(), null);

/**		Initialisation de la table droit_profils		**/
insert into droit_profils(dro_code, pro_id) values('CREATE', 1);
insert into droit_profils(dro_code, pro_id) values('READ', 2);
insert into droit_profils(dro_code, pro_id) values('UPDATE', 3);
insert into droit_profils(dro_code, pro_id) values('DELETE', 4);

/**		Initialisation de la table type_utilisateurs		**/
insert into type_utilisateurs(tut_code, tut_libelle) values('ADMIN', 'Administrateur');
insert into type_utilisateurs(tut_code, tut_libelle) values('GEST', 'Gestionnaire');
insert into type_utilisateurs(tut_code, tut_libelle) values('CLIENT', 'Client');

/**		Initialisation de la table utilisateurs		**/
insert into utilisateurs(uti_id, uti_nom, uti_prenom, uti_email, uti_date_naissance, uti_adresse, uti_actif, pro_id, tut_code, uti_nom_fichier_photo, uti_date_creation, uti_date_modification) values(1, 'Jean', 'Michel', 'test1@test.com', null, null, true, 1, 'ADMIN', null, now(), null);
insert into utilisateurs(uti_id, uti_nom, uti_prenom, uti_email, uti_date_naissance, uti_adresse, uti_actif, pro_id, tut_code, uti_nom_fichier_photo, uti_date_creation, uti_date_modification) values(2, 'Gerard', 'Jugnos', 'test2@test.com', null, null, true, 2, 'GEST', null, now(), null);
insert into utilisateurs(uti_id, uti_nom, uti_prenom, uti_email, uti_date_naissance, uti_adresse, uti_actif, pro_id, tut_code, uti_nom_fichier_photo, uti_date_creation, uti_date_modification) values(3, 'Gad', 'El', 'test3@test.com', null, null, true, 3, 'CLIENT', null, now(), null);
insert into utilisateurs(uti_id, uti_nom, uti_prenom, uti_email, uti_date_naissance, uti_adresse, uti_actif, pro_id, tut_code, uti_nom_fichier_photo, uti_date_creation, uti_date_modification) values(4, 'Bernard', 'Bruno', 'test4@test.com', null, null, true, 4, 'ADMIN', null, now(), null);
insert into utilisateurs(uti_id, uti_nom, uti_prenom, uti_email, uti_date_naissance, uti_adresse, uti_actif, pro_id, tut_code, uti_nom_fichier_photo, uti_date_creation, uti_date_modification) values(5, 'Sisi', 'Brindacier', 'test5@test.com', null, null, true, 1, 'GEST', null, now(), null);
insert into utilisateurs(uti_id, uti_nom, uti_prenom, uti_email, uti_date_naissance, uti_adresse, uti_actif, pro_id, tut_code, uti_nom_fichier_photo, uti_date_creation, uti_date_modification) values(6, 'Bibi', 'Baba', 'test6@test.com', null, null, true, 2, 'CLIENT', null, now(), null);
insert into utilisateurs(uti_id, uti_nom, uti_prenom, uti_email, uti_date_naissance, uti_adresse, uti_actif, pro_id, tut_code, uti_nom_fichier_photo, uti_date_creation, uti_date_modification) values(7, 'Dédé', 'Dédé', 'test7@test.com', null, null, true, 3, 'GEST', null, now(), null);
insert into utilisateurs(uti_id, uti_nom, uti_prenom, uti_email, uti_date_naissance, uti_adresse, uti_actif, pro_id, tut_code, uti_nom_fichier_photo, uti_date_creation, uti_date_modification) values(8, 'Ran', 'Tanplan', 'test8@test.com', null, null, true, 4, 'ADMIN', null, now(), null);
