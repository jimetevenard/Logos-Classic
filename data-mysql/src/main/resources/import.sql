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

INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(1, '2017-06-01 00:00:00', '2017-06-01 00:00:00', 'introduction au présent en anglais ', 'Présent simple et présent continu', 2, 2);
-- INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(2, '2017-06-01 00:00:00', '2017-06-02 00:00:00', 'Un cours pas fait pour les poules mouillées...', 'Vocabulaire marin Anglais', 2, 1);
INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(3, '2017-06-03 00:00:00', '2017-06-03 00:00:00', 'Devenez maitre de la conjugaison espagnole', 'Verbes irréguliers espagnols', 2, 4);
INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(4, '2017-06-13 00:00:00', '2017-06-13 00:00:00', 'Dinez avec la reine', 'Parlez politique en UK', 2, 1);
INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(5, '2017-06-12 00:00:00', '2017-06-12 00:00:00', 'Allez, soyez pas timides !', 'Déclarer sa flamme à NY', 2, 2);
INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(6, '2017-06-14 00:00:00', '2017-06-14 00:00:00', 'Il n''y a pas que la paella', 'Vocabulaire de la cuisine espagnole !', 2, 3);
INSERT INTO `cours` (`id_cours`, `dateCreation_cours`, `dateMiseAJour_cours`, `introduction_cours`, `titre_cours`, `id_auteur`, `id_niveau`) VALUES(7, '2017-06-13 00:00:00', '2017-06-13 00:00:00', 'Paaablooo, Paaaablooo !', 'Décrire une oeuvre d''art en espagnol', 2, 4);

--
-- Contenu de la table `chapitre`
--

INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(1, '<p align="justify">			Et oui, en anglais, nous ferons une distinction entre le <strong>présent				d’habitude</strong> (ou présent simple) et le présent immédiat (aussi appelé			présent continu, ou progressif).		</p>		<p align="justify">Cette notion de présent d’habitude est inconnue			pour les français, c’est pourquoi nous pouvons nous tromper au début.			Cependant, pas de panique, c’est très simple :</p>				<h3>Construction :</h3>		<p align="justify">			La construction du présent simple est …très simple. <strong>La				construction ne change jamais, sauf pour la troisième personne du				singulier, où il faut mettre un “S” à la fin du verbe</strong>. Prenons par			exemple le verbe <strong>to read</strong> <em>lire</em> :		</p>		<p align="center">I read</p>		<p align="center">You read</p>		<p align="center">			he/she/it read<strong>s</strong> (notez le S à la troisième personne			du singulier)		</p>		<p align="center">we read</p>		<p align="center">you read</p>		<p align="center">they read.</p>		<p align="justify">C’est toujours comme ça. Au présent simple il			n’y a pas de verbe régulier, irrégulier, ou différent, c’est toujours			invariable sauf avec he/she/it (troisième personne du singulier) où			il faut mettre un S à la fin du verbe.</p>		<p align="justify">			Pour les verbes qui se terminent pas une voyelle, on ne rajoute pas			un S mais ES à la troisième personne du singulier. Exemple : He go<strong>es.</strong>..			ou encore : She do<strong>es</strong> …		</p>		<h3>Utilisation :</h3>		<p align="justify">			On utilise le présent simple en tant que <strong>présent				d’habitude</strong>. Notez que cette distinction du présent d’habitude			n’existe pas en français. Le présent d’habitude est tout simplement			le temps que l’on emploie quad on parle d’une habitude! Par exemple,			si vous allez au travail tous les matins (habitude) vous direz : I <strong>go</strong>			to work every morning. En revanche, si vous voulez dire que c’est			exeptionnel, et que vous allez travailler ce matin, vous emploierez			le présent progressif : I <strong>am going</strong> to work this			morning.(<em>je vais au travail ce matin,</em> dans le sens <em>:				je suis en train d’y aller.</em>)		</p>', 'Le présent simple', 1);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(2, '<h3>Construction :</h3>		<p>			Pour construire le présent continu, on a besoin de l’auxiliaire <strong>BE</strong>.			Ensuite, on ajoute <strong>ING</strong> à la fin du verbe que l’on			veut utiliser.		</p>		<p>			Par exemple, pour le verbe <strong>to learn</strong> <em>apprendre</em>,&nbsp;			cela donnera :		</p>		<p align="center">			I am learn<strong>ing</strong>		</p>		<p align="center">			You are learn<strong>ing</strong>		</p>		<p align="center">			He/she/it is learn<strong>ing</strong>		</p>		<p align="center">			We are learn<strong>ing</strong>		</p>		<p align="center">			You are learn<strong>ing</strong>		</p>		<p align="center">			They are learn<strong>ing</strong>		</p>		<p align="justify">			On reconnait l’<strong>auxiliaire BE conjugué suivi de				learn+ING</strong>. (Note : pour la leçon sur les auxiliaires, <a				title="Auxiliaires" href="les-auxiliaires.html">cliquez ic</a>i.)		</p>		<h3>			<strong>Utilisation :</strong>		</h3>		<p align="justify">On utilise le présent continu quand on veut			parler d’une action qui est en train de se dérouler sur le moment			même où l’on parle.</p>		<p align="justify">			<strong>Astuce :</strong> Si vous pouvez traduire en français par “<strong>en				train de</strong>“, alors vous pouvez utilisez le présent progressif.		</p>		<p align="justify">Exemple :</p>		<p align="justify">			Vous êtes assis sur un fauteuil à lire un livre. Vous direz : “I <strong>am				reading</strong>” (<em>je suis en train de lire</em>).		</p>		<p align="justify">			En revanche, si vous voulez dire que vous lisez tous les jours			(habitude) vous direz plutôt “I <strong>read</strong> everyday.”			(présent simple)		</p>', 'Le présent continu', 1);
INSERT INTO `chapitre` (`id_chapitre`, `contenu_chapitre`, `titre_chapitre`, `id_cours`) VALUES(3, ' <div id="texte">      Le <strong>prétérit progressif</strong>, ou <strong>prétérit continu</strong>, et un temps      utilisé en anglais pour parler d’une action longue ou qui était en train de se dérouler à un      moment donné du passé.    </div>    <p><strong>Comment le construire et comment l’utiliser</strong> ? C’est ce que nous allons voir    dans ce cours d’anglais.</p>    <p><strong>Résumé de la leçon en deux lignes :</strong></p>        <h2><strong>Comment le construire :</strong> <strong>BE au passé + verbe en ING</strong></h2>    <p>Pour construire le prétérit progressif, il faut utiliser <strong><a title="Auxiliaires"    href="les-auxiliaires.html">l’auxiliaire BE</a></strong>, et mettre le verbe que l’on veut    utiliser à la forme <strong>verbe+ING</strong>.</p>    <p><strong>Par exemple :</strong></p>    <p align="center"><strong>I was waiting</strong>.</span>    (I = Sujet ; <strong>was</strong> = BE au preterit ; <strong>waiting</strong> = Wait + ING )</p>    <p align="center"><strong><You were reading</strong>    (<strong>You</strong> = sujet ; <strong>were</strong></span> = BE au preterit ; <strong>reading</strong> = read + ING)</p>    <p><em>Le prétérit progressif est au prétérit ce que le present progressif est au présent</em>.    Cela se forme exactement de la même manière, sauf que l’on met l’auxiliaire BE au prétérit.</p>    <p>Exemple :</p>    <p>Au <em>présent</em> progressif (ou continu): <strong>I am going</strong> donne au    <em>prétérit</em> progressif (ou continu) <strong>I was going</strong>.</p>    <h2><strong>Quand l’utiliser :</strong></h2>    <p>La plupart du temps, on utilise le prétérit progressif pour parler d’une action <strong>qui    était en cours à un moment donné</strong>. En fait, c’est un peu comme le présent progressif,    qui se traduit par “est en train de…”, mais au passé, c’est donc l’équivalent de “<strong>était    en train de..</strong>.”.</p>    <p>Il s’agit souvent d’une action qui dure un certain moment. Pour une action brève on utilise    plutôt le prétérit.</p>    <p><strong>Par exemple :</strong></p>    <ul>      <li><strong><span style="jimdrop-color: #339966;">I was driving</span></strong> when I saw an      accident. <em>J<span style="jimdrop-color: #339966;">‘étais en train de</span> conduire quand j’ai vu      un accident.</em> (<strong>I was driving</strong> ici c’est l’action qui dure, et <strong>I      saw an accident</strong> c’est une action plutôt soudaine, brève).</li>    </ul>    <ul>      <li>I went into the room. <strong><span style="jimdrop-color: #339966;">Harry was      sitting</span></strong> near the window. <em>J’entrai dans la pièce. <span style=      "jimdrop-color: #339966;">Harry était assis</span> près de la fenêtre</em>. (On pourrait presque dire      <em>“<span style="jimdrop-color: #339966;">Harry était en train d</span>‘être assis près de la      fenêtre”</em>, ce serait un peu lourd mais c’est le même sens).</li>    </ul>    <ul>      <li><strong><span style="jimdrop-color: #339966;">I was thinking</span></strong> when I suddenly had      an idea. <em>J<span style="jimdrop-color: #339966;">‘étais en train de</span> penser quand j’ai      soudainement eu une idée.</em></li>    </ul>    <p>Expliqué ici cela peut paraître un peu abstrait mais ne vous arrêtez pas à ces explications.    Le but est surtout de vous faire comprendre les nuances. Or comprendre une nuance est plutôt    quelque chose d’intuitif. Après avoir fait quelques exercices, vous devriez commencer à sentir    ces nuances assez bien et vous n’aurez plus trop besoin de ces explications ;).</p>    <div class="download-box">      <a class="manual-optin-trigger" href="#" data-optin-slug="px5evxhcersayvfc">Cliquez ici pour      accéder à la formation entière sur les Temps de l’anglais (gratuite)</a>    </div>    <p><strong><a title="gymglish" href="apprendre-anglais-avec-gymglish-avis-et-test.html">Des    cours d’anglais dans votre boite mail ? testez Gymglish gratuitement.</a></strong></p>  ', 'Le prététit progressif', 1);
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

INSERT INTO `categorie_cours` (`fk_categorie`, `fk_cours`) VALUES(2, 1);
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

INSERT INTO `conversation` (`id_conversation`, `titre_conversation`) VALUES(1, 'A propos du Cours de Vocabulaire');
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
