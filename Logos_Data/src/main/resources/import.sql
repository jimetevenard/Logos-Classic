-- TROIS USERS
--  WILLY LEPANTE (ÉLÈVE) LOGIN : "a", PASS : "a",
--  SEBASTIEN PERICARD (prof) LOGIN : "b", PASS : "b",
--  PATRICE FERNANDEZ (prof) LOGIN : "c", PASS : "c"

-- WILLY suit 2 des 6 cours
-- il a lu des chapitres du premier cours

-- tous les cours ont des chapitres et un niveau/langue


-- Il il y un exercice composé de quatre question dans le chapitre 1 du cours "vocabulaire marin"
-- (chapitre ID : 1) (evaluation ID 1)
-- 		une question ouverte
-- 		une question QCM 
-- 		une question à trous
-- 		une question drag drop

-- 		Willy a réalisé cet exercice.
-- 		Il a formé une réponse à la question ouverte
--		Il a répondu correctement au QCM
--		Il s'est trompé dans la phrase à trou
--		Il a répondu correctement au DragAndDrop

-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Mar 27 Juin 2017 à 16:24
-- Version du serveur :  5.5.38
-- Version de PHP :  5.6.2



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `logos_ogma`
--
--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`type_utilisateur`, `id_utilisateur`, `login_utilisateur`, `mail_utilisateur`, `nom_utilisateur`, `password_utilisateur`, `photo_utilisateur`, `prenom_utilisateur`, `premium_eleve`) VALUES('Eleve', 1, 'a', 'toto@to.to', 'Lepante', 'a', NULL, 'Willy', 0);
INSERT INTO `utilisateur` (`type_utilisateur`, `id_utilisateur`, `login_utilisateur`, `mail_utilisateur`, `nom_utilisateur`, `password_utilisateur`, `photo_utilisateur`, `prenom_utilisateur`, `premium_eleve`) VALUES('Professeur', 2, 'b', 'seb@afcepf.fr', 'Péricard', 'b', NULL, 'Sebastien', NULL);
INSERT INTO `utilisateur` (`type_utilisateur`, `id_utilisateur`, `login_utilisateur`, `mail_utilisateur`, `nom_utilisateur`, `password_utilisateur`, `photo_utilisateur`, `prenom_utilisateur`, `premium_eleve`) VALUES('Professeur', 3, 'c', 'patrice@afcepf.fr', 'Fernandez', 'c', NULL, 'Patrice', NULL);


--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `titre_categorie`) VALUES(1, 'Vocabulaire');
INSERT INTO `categorie` (`id_categorie`, `titre_categorie`) VALUES(2, 'Conjuguaison');

--
-- Contenu de la table `langue`
--

INSERT INTO `langue` (`id_langue`, `code_iso`, `libelle_langue`) VALUES(1, 'en', 'Anglais');
INSERT INTO `langue` (`id_langue`, `code_iso`, `libelle_langue`) VALUES(2, 'es', 'Espagnol');
INSERT INTO `langue` (`id_langue`, `code_iso`, `libelle_langue`) VALUES(3, 'ge', 'Allemand');
INSERT INTO `langue` (`id_langue`, `code_iso`, `libelle_langue`) VALUES(4, 'cn', 'Chinois');
INSERT INTO `langue` (`id_langue`, `code_iso`, `libelle_langue`) VALUES(5, 'gr', 'Grec');

--
-- Contenu de la table `niveau`
--

INSERT INTO `niveau` (`id_niveau`, `libelle_niveau`, `valeur_niveau`, `id_langue`) VALUES(1, 'A1', 10, 1);
INSERT INTO `niveau` (`id_niveau`, `libelle_niveau`, `valeur_niveau`, `id_langue`) VALUES(2, 'B2', 30, 1);
INSERT INTO `niveau` (`id_niveau`, `libelle_niveau`, `valeur_niveau`, `id_langue`) VALUES(3, 'A1', 10, 2);
INSERT INTO `niveau` (`id_niveau`, `libelle_niveau`, `valeur_niveau`, `id_langue`) VALUES(4, 'B2', 30, 2);


--
-- Contenu de la table `cours`
--

INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(1, '2017-06-01 00:00:00', '2017-06-01 00:00:00', 'introduction vocabulaire maritime anglais ', 'Vocabulaire maritime anglais', 2, 2);
-- INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(2, '2017-06-01 00:00:00', '2017-06-02 00:00:00', 'Un cours pas fait pour les poules mouillées...', 'Vocabulaire marin Anglais', 2, 1);
INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(3, '2017-06-03 00:00:00', '2017-06-03 00:00:00', 'Devenez maitre de la conjugaison espagnole', 'Verbes irréguliers espagnols', 2, 4);
INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(4, '2017-06-13 00:00:00', '2017-06-13 00:00:00', 'Dinez avec la reine', 'Parlez politique en UK', 2, 1);
INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(5, '2017-06-12 00:00:00', '2017-06-12 00:00:00', 'Allez, soyez pas timides !', 'Déclarer sa flamme à NY', 2, 2);
INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(6, '2017-06-14 00:00:00', '2017-06-14 00:00:00', 'Il n''y a pas que la paella', 'Vocabulaire de la cuisine espagnole !', 2, 3);
INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(7, '2017-06-13 00:00:00', '2017-06-13 00:00:00', 'Paaablooo, Paaaablooo !', 'Décrire une oeuvre d''art en espagnol', 2, 4);

--
-- Contenu de la table `chapitre`
--

INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(1, 'Pourquoi avoir limité la date la plus basse à 1753 ? Ce n''est bien entendu pas par hasard.\r\nMais ce second mystère nécessite de nous plonger un peu dans l''Histoire...\r\nEn effet au cours du temps et compte tenu de la précision accrue des calculs astronomiques, on constate que le calendrier julien élaboré en 46 avant JC souffre d''un manque de précision : la durée de l''année julienne est trop longue d''un peu plus de 11 minutes (365,25 jours au lieu de 365,2422) et au fil du temps, le calendrier finit par retarder de plusieurs jours. C''est le pape Grégoire XIII qui entreprend de réformer le calendrier : Pour cela, 10 jours furent supprimés de l''année 1582, où le 4 octobre fut immédiatement suivi par le 15 octobre. Pour éviter de nouvelles dérives, la sur évaluation de l''année julienne fut corrigée par la suppression de 3 jours tous les 400 ans. On ignore donc la règle des années bissextiles les années séculaires, sauf pour celles qui sont divisibles par 400.\r\nIl y a donc 97 années bissextiles par période de 400 ans et la durée moyenne d''une année grégorienne est 365 + 97/100, c''est-à-dire 365,2425 jours.', 'Paré à embarquer !', 1);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(2, 'Pourquoi avoir limité la date la plus basse à 1753 ? Ce n''est bien entendu pas par hasard.\r\nMais ce second mystère nécessite de nous plonger un peu dans l''Histoire...\r\nEn effet au cours du temps et compte tenu de la précision accrue des calculs astronomiques, on constate que le calendrier julien élaboré en 46 avant JC souffre d''un manque de précision : la durée de l''année julienne est trop longue d''un peu plus de 11 minutes (365,25 jours au lieu de 365,2422) et au fil du temps, le calendrier finit par retarder de plusieurs jours. C''est le pape Grégoire XIII qui entreprend de réformer le calendrier : Pour cela, 10 jours furent supprimés de l''année 1582, où le 4 octobre fut immédiatement suivi par le 15 octobre. Pour éviter de nouvelles dérives, la sur évaluation de l''année julienne fut corrigée par la suppression de 3 jours tous les 400 ans. On ignore donc la règle des années bissextiles les années séculaires, sauf pour celles qui sont divisibles par 400.\r\nIl y a donc 97 années bissextiles par période de 400 ans et la durée moyenne d''une année grégorienne est 365 + 97/100, c''est-à-dire 365,2425 jours.', 'Un peu plus de vocabulaire', 1);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(3, 'Pourquoi avoir limité la date la plus basse à 1753 ? Ce n''est bien entendu pas par hasard.\r\nMais ce second mystère nécessite de nous plonger un peu dans l''Histoire...\r\nEn effet au cours du temps et compte tenu de la précision accrue des calculs astronomiques, on constate que le calendrier julien élaboré en 46 avant JC souffre d''un manque de précision : la durée de l''année julienne est trop longue d''un peu plus de 11 minutes (365,25 jours au lieu de 365,2422) et au fil du temps, le calendrier finit par retarder de plusieurs jours. C''est le pape Grégoire XIII qui entreprend de réformer le calendrier : Pour cela, 10 jours furent supprimés de l''année 1582, où le 4 octobre fut immédiatement suivi par le 15 octobre. Pour éviter de nouvelles dérives, la sur évaluation de l''année julienne fut corrigée par la suppression de 3 jours tous les 400 ans. On ignore donc la règle des années bissextiles les années séculaires, sauf pour celles qui sont divisibles par 400.\r\nIl y a donc 97 années bissextiles par période de 400 ans et la durée moyenne d''une année grégorienne est 365 + 97/100, c''est-à-dire 365,2425 jours.', 'Pour aller plus loin...', 1);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(4, 'L’Espagne, en forme longue, le Royaume d''Espagne, en castillan España () et Reino de España, est un pays d''Europe du Sud et, selon les définitions, de l''Ouest, qui occupe la plus grande partie de la péninsule Ibérique.', 'Premier groupe', 3);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(5, 'Chapitre 2 : L’Espagne, en forme longue, le Royaume d''Espagne, en castillan España () et Reino de España, est un pays d''Europe du Sud et, selon les définitions, de l''Ouest, qui occupe la plus grande partie de la péninsule Ibérique.', 'Verbes du deuxièmeme groupe', 3);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(6, 'Chapitre 3 : L’Espagne, en forme longue, le Royaume d''Espagne, en castillan España () et Reino de España, est un pays d''Europe du Sud et, selon les définitions, de l''Ouest, qui occupe la plus grande partie de la péninsule Ibérique.', 'Verbes du troisième groupe', 3);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(7, 'Chapitre 4 : L’Espagne, en forme longue, le Royaume d''Espagne, en castillan España () et Reino de España, est un pays d''Europe du Sud et, selon les définitions, de l''Ouest, qui occupe la plus grande partie de la péninsule Ibérique.', 'Un dernier chapitre pour la route ', 3);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(8, 'Contenu du chapitre 1', 'Premier Chapitre', 4);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(9, 'Contenu du chapitre 2', 'Chapitre 2', 4);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(10, 'Contenu du chapitre 3', 'Chapitre 3', 4);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(11, 'Contenu du chapitre 4', 'Chapitre 4', 4);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(12, 'Contenu du chapitre 5', 'Chapitre 5', 4);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(13, 'Déclarer sa flamme à NY : Contenu du chapitre 1', 'Flamme NY chap 1', 5);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(14, 'Déclarer sa flamme à NY : Contenu du chapitre 2', 'Flamme NY chap 2', 5);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(15, 'Cuisine espagnole : contenu chap 1 entrées', 'La Cuisine espagnole : entrées', 6);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(16, 'Cuisine espagnole : contenu chap 2 plats', 'La Cuisine espagnole : plats', 6);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(17, 'Cuisine espagnole : contenu chap 3 desserts', 'La Cuisine espagnole : desserts', 6);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(18, 'Contenu Picasso...', 'Pablo picasso et ses amis (chapitre 1)', 7);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(19, 'Contenu Dali...', 'Salvador Dali et ses amis (chapitre 1)', 7);


--
-- Contenu de la table `evaluation`
--

INSERT INTO `evaluation` (`type_evaluation`, `id_evaluation`, `titre_evaluation`, `id_niveau`) VALUES('Exercice', 1, 'Etes vous un vrai marin ?', 2);


--
-- Contenu de la table `question`
--

INSERT INTO `question` (`type_question`, `id_question`, `enonce_question`, `phrase_a_trou`) VALUES('QuestionOuverte', 1, 'De quelle couleur est le cheval blanc d''Henri IV ?', NULL);
INSERT INTO `question` (`type_question`, `id_question`, `enonce_question`, `phrase_a_trou`) VALUES('QuestionQcm', 2, 'De quelle couleur est le cheval vert d''Henri IV', NULL);
INSERT INTO `question` (`type_question`, `id_question`, `enonce_question`, `phrase_a_trou`) VALUES('QuestionATrous', 3, 'Complétez les trous :', 'Le ((trou)) blanc d''Henri IV lave plus ((trou)) que blanc.');
INSERT INTO `question` (`type_question`, `id_question`, `enonce_question`, `phrase_a_trou`) VALUES('QuestionDragAndDrop', 4, 'Replacez ces mots dans le bon ordre', 'Le bon ((trou)) Dagobert il a mis sa ((trou)) à l''envers');


--
-- Contenu de la table `proposition_question_qcm`
--

INSERT INTO `proposition_question_qcm` (`id_question`, `proposition_question_qcm`) VALUES(2, 'Jaune pale');
INSERT INTO `proposition_question_qcm` (`id_question`, `proposition_question_qcm`) VALUES(2, 'Blanc');
INSERT INTO `proposition_question_qcm` (`id_question`, `proposition_question_qcm`) VALUES(2, 'Bleu');


--
-- Contenu de la table `realise_evaluation`
--



--
-- Contenu de la table `reponse_eleve`
--
--
-- Contenu de la table `reponse_qcm`
--

-- Contenu de la table `reponse_trous`
--
-- Contenu de la table `solution_question_qcm`
--

INSERT INTO `solution_question_qcm` (`id_question`, `solution_question_qcm`) VALUES(2, 0);
INSERT INTO `solution_question_qcm` (`id_question`, `solution_question_qcm`) VALUES(2, 2);

--
-- Contenu de la table `solution_question_trous`
--

INSERT INTO `solution_question_trous` (`id_question`, `solution_question_trous`) VALUES(3, 'cheval');
INSERT INTO `solution_question_trous` (`id_question`, `solution_question_trous`) VALUES(3, 'blanc');
INSERT INTO `solution_question_trous` (`id_question`, `solution_question_trous`) VALUES(4, 'roi');
INSERT INTO `solution_question_trous` (`id_question`, `solution_question_trous`) VALUES(4, 'culotte');


-- ############################################################

--
-- Contenu de la table `categorie_cours`
--

INSERT INTO `categorie_cours` (`fk_categorie`, `fk_cours`) VALUES(1, 1);
INSERT INTO `categorie_cours` (`fk_categorie`, `fk_cours`) VALUES(2, 3);
INSERT INTO `categorie_cours` (`fk_categorie`, `fk_cours`) VALUES(1, 4);
INSERT INTO `categorie_cours` (`fk_categorie`, `fk_cours`) VALUES(1, 5);
INSERT INTO `categorie_cours` (`fk_categorie`, `fk_cours`) VALUES(2, 5);
INSERT INTO `categorie_cours` (`fk_categorie`, `fk_cours`) VALUES(1, 6);
INSERT INTO `categorie_cours` (`fk_categorie`, `fk_cours`) VALUES(1, 7);


--
-- Contenu de la table `chapitre_exercice`
--

INSERT INTO `chapitre_exercice` (`fk_chapitre`, `fk_exercice`) VALUES(1, 1);


--
-- Contenu de la table `cours_professeur`
--

INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(1, 2);
INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(3, 2);
INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(4, 2);
INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(5, 2);
INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(6, 2);
INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(7, 2);
INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(1, 3);
INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(3, 3);
INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(4, 3);
INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(5, 3);
INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(6, 3);
INSERT INTO `cours_professeur` (`fk_cours_supervise`, `fk_professeur_superviseur`) VALUES(7, 3);


--
-- Contenu de la table `niveau_eleve`
--

INSERT INTO `niveau_eleve` (`fk_niveau`, `fk_eleve`) VALUES(1, 1);
INSERT INTO `niveau_eleve` (`fk_niveau`, `fk_eleve`) VALUES(3, 1);




--
-- Contenu de la table `suivi_cours`
--

INSERT INTO `suivi_cours` (`id_suivi_cours`, `acquis`, `commentaire`, `date_fin_suivi`, `date_inscription`, `note_cours`, `id_cours`, `id_eleve`) VALUES(1, 0, 'Super cours !', NULL, '2017-06-08 00:00:00', NULL, 1, 1);
INSERT INTO `suivi_cours` (`id_suivi_cours`, `acquis`, `commentaire`, `date_fin_suivi`, `date_inscription`, `note_cours`, `id_cours`, `id_eleve`) VALUES(2, NULL, NULL, NULL, '2017-06-21 00:00:00', 4, 3, 1);

--
-- Contenu de la table `suivi_cours_chapitre`
--

INSERT INTO `suivi_cours_chapitre` (`fk_suivi_cours`, `fk_chapitre`) VALUES(1, 1);
INSERT INTO `suivi_cours_chapitre` (`fk_suivi_cours`, `fk_chapitre`) VALUES(1, 2);


--
-- Contenu de la table `question_evaluation`
--

INSERT INTO `question_evaluation` (`fk_question`, `fk_evaluation`) VALUES(1, 1);
INSERT INTO `question_evaluation` (`fk_question`, `fk_evaluation`) VALUES(2, 1);
INSERT INTO `question_evaluation` (`fk_question`, `fk_evaluation`) VALUES(3, 1);
INSERT INTO `question_evaluation` (`fk_question`, `fk_evaluation`) VALUES(4, 1);


--
-- Contenu de la table `conversation`
--

INSERT INTO `conversation` (`id_conversation`, `titre_conversation`) VALUES(1, 'A propos du Cours de Vocabluaire');
INSERT INTO `conversation` (`id_conversation`, `titre_conversation`) VALUES(2, 'Conférence à l''INALCO');

--
-- Contenu de la table `message`
--

INSERT INTO `message` (`id_message`, `contenu_message`, `date_envoi_message`, `date_lecture_message`, `id_auteur_message`, `id_conversation`) VALUES(1, 'Salut Willy !', '2017-07-02 00:00:00', '2017-07-03 11:30:32', 2, 1);
INSERT INTO `message` (`id_message`, `contenu_message`, `date_envoi_message`, `date_lecture_message`, `id_auteur_message`, `id_conversation`) VALUES(2, 'Salut Seb !', '2017-07-02 05:00:00', NULL, 1, 1);
INSERT INTO `message` (`id_message`, `contenu_message`, `date_envoi_message`, `date_lecture_message`, `id_auteur_message`, `id_conversation`) VALUES(3, 'Voici ce que je voulais vous dire :', '2017-07-03 00:00:00', NULL, 1, 2);

--
-- Contenu de la table `utilisateur_conversation`
--

INSERT INTO `utilisateur_conversation` (`fk_utilisateur`, `fk_conversation`) VALUES(1, 1);
INSERT INTO `utilisateur_conversation` (`fk_utilisateur`, `fk_conversation`) VALUES(2, 1);
INSERT INTO `utilisateur_conversation` (`fk_utilisateur`, `fk_conversation`) VALUES(1, 2);
INSERT INTO `utilisateur_conversation` (`fk_utilisateur`, `fk_conversation`) VALUES(2, 2);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
