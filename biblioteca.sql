-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generato il: 28 feb, 2012 at 05:16 PM
-- Versione MySQL: 5.1.44
-- Versione PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `biblioteca`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(13) NOT NULL,
  `title` varchar(150) NOT NULL,
  `author` varchar(40) NOT NULL,
  `publisher` varchar(40) NOT NULL,
  `img` varchar(80) NOT NULL,
  `url` varchar(400) NOT NULL,
  `numpages` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn` (`isbn`),
  UNIQUE KEY `isbn_2` (`isbn`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=110 ;

--
-- Dump dei dati per la tabella `book`
--

INSERT INTO `book` (`id`, `isbn`, `title`, `author`, `publisher`, `img`, `url`, `numpages`) VALUES
(1, '9788884518781', 'Harry Potter e i doni della morte', 'J. K. Rowling', 'Salani', 'http://ecx.images-amazon.com/images/I/514hvLWd58L._SL160_.jpg', 'http://www.amazon.it/Harry-Potter-doni-della-morte/dp/8884518784%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8884518784', 701),
(2, '9788862562829', 'Harry Potter e il Principe Mezzosangue', 'J. K. Rowling', 'Salani', 'http://ecx.images-amazon.com/images/I/41nxjJofv9L._SL160_.jpg', 'http://www.amazon.it/Harry-Potter-Principe-Mezzosangue-Rowling/dp/8862562829%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8862562829', 592),
(5, '9788884510495', 'Harry Potter e il calice di fuoco: 4', 'J. K. Rowling', 'Salani', 'http://ecx.images-amazon.com/images/I/51WXRBQJ8GL._SL160_.jpg', 'http://www.amazon.it/Harry-Potter-calice-fuoco-4/dp/888451049X%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D888451049X', 627),
(6, '9788804616320', 'Steve Jobs (Ingrandimenti)', 'Walter Isaacson', 'Mondadori', 'http://ecx.images-amazon.com/images/I/31x9FYsTwwL._SL160_.jpg', 'http://www.amazon.it/Steve-Jobs-Ingrandimenti-Walter-Isaacson/dp/8804616326%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804616326', 642),
(7, '9788806204259', 'Tre atti e due tempi', 'Giorgio Faletti', 'Einaudi', 'http://ecx.images-amazon.com/images/I/31CbEyALWlL._SL160_.jpg', 'http://www.amazon.it/atti-tempi-Einaudi-Stile-libero/dp/8806204254%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806204254', 151),
(8, '9788854131941', 'Il mercante di libri maledetti', 'Marcello Simoni', 'NEWTON COMPTON EDITORI  SRL', 'http://ecx.images-amazon.com/images/I/41S0eTzABdL._SL160_.jpg', 'http://www.amazon.it/mercante-libri-maledetti-narrativa-Newton/dp/8854131946%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8854131946', 351),
(9, '9788804613893', 'Le prime luci del mattino ', 'Fabio Volo', 'Mondadori', 'http://ecx.images-amazon.com/images/I/31wlMjIEI8L._SL160_.jpg', 'http://www.amazon.it/prime-luci-del-mattino-Arcobaleno/dp/8804613890%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804613890', 244),
(10, '9788820051358', '22/11/63 (Pandora)', 'Stephen King', 'Sperling & Kupfer', 'http://ecx.images-amazon.com/images/I/41QAnMrHPLL._SL160_.jpg', 'http://www.amazon.it/22-11-Pandora-Stephen-King/dp/8820051354%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8820051354', 767),
(11, '9788811364979', 'Il fu Mattia Pascal (I grandi libri)', 'Luigi Pirandello', 'Garzanti Libri', 'http://ecx.images-amazon.com/images/I/31VD16OiRYL._SL160_.jpg', 'http://www.amazon.it/Mattia-Pascal-grandi-libri/dp/8811364973%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8811364973', 319),
(12, '9788806173562', 'Arancia meccanica (Super ET)', 'Anthony Burgess', 'Einaudi', 'http://ecx.images-amazon.com/images/I/311I17pVsbL._SL160_.jpg', 'http://www.amazon.it/Arancia-meccanica-Super-Anthony-Burgess/dp/8806173561%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806173561', 240),
(13, '9788804492948', 'La coscienza di Zeno (Oscar classici moderni)', 'Italo Svevo', 'Mondadori', 'http://ecx.images-amazon.com/images/I/118Z9BQH4WL._SL160_.jpg', 'http://www.amazon.it/coscienza-Zeno-Oscar-classici-moderni/dp/8804492945%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804492945', 416),
(14, '9788845290053', 'Il Signore degli anelli (I libri di Tolkien)', 'John R. R. Tolkien', 'Bompiani', 'http://ecx.images-amazon.com/images/I/41koQO4JSpL._SL160_.jpg', 'http://www.amazon.it/Signore-degli-anelli-libri-Tolkien/dp/8845290050%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8845290050', 1359),
(15, '9788804596745', 'Il simbolo perduto (Omnibus)', 'Dan Brown', 'Mondadori', 'http://ecx.images-amazon.com/images/I/41wlQrQEXrL._SL160_.jpg', 'http://www.amazon.it/simbolo-perduto-Omnibus-Dan-Brown/dp/8804596740%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804596740', 604),
(16, '9788820347772', 'Steve Jobs. L''uomo che ha inventato il futuro (Business & technology)', 'Jay Elliot', 'Hoepli', 'http://ecx.images-amazon.com/images/I/51y74MQOcZL._SL160_.jpg', 'http://www.amazon.it/Steve-inventato-futuro-Business-technology/dp/8820347776%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8820347776', 256),
(17, '9788804483632', 'La storia d''Italia a fumetti. Dall''impero romano all''anno 2000 (I supermiti)', 'Enzo Biagi', 'Mondadori', 'http://ecx.images-amazon.com/images/I/41dj6fibL5L._SL160_.jpg', 'http://www.amazon.it/dItalia-fumetti-Dallimpero-allanno-supermiti/dp/8804483636%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804483636', 734),
(18, '9788850320684', 'Java 2 SDK 1.4. Guida per il programmatore (Wrox)', 'Ivor Horton', 'Apogeo', 'http://ecx.images-amazon.com/images/I/315wWTCqtOL._SL160_.jpg', 'http://www.amazon.it/Java-1-4-Guida-programmatore-Wrox/dp/885032068X%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D885032068X', 1008),
(19, '9788807018428', 'Dieci donne (I narratori)', 'Marcela Serrano', 'Feltrinelli', 'http://ecx.images-amazon.com/images/I/31rUnxYMeZL._SL160_.jpg', 'http://www.amazon.it/Dieci-donne-narratori-Marcela-Serrano/dp/880701842X%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D880701842X', 285),
(20, '9788806208127', 'Il leopardo (Einaudi. Stile libero big)', 'Jo Nesbø', 'Einaudi', 'http://ecx.images-amazon.com/images/I/41Qn-OuqxXL._SL160_.jpg', 'http://www.amazon.it/leopardo-Einaudi-Stile-libero-big/dp/8806208128%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806208128', 767),
(21, '9788860881649', 'Togliamo il disturbo. Saggio sulla libertà di non studiare (Narratori della Fenice)', 'Paola Mastrocola', 'Guanda', 'http://ecx.images-amazon.com/images/I/31WW8QWxppL._SL160_.jpg', 'http://www.amazon.it/Togliamo-disturbo-libert%C3%A0-studiare-Narratori/dp/8860881641%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8860881641', 271),
(22, '9788804609162', 'Cose che nessuno sa (Scrittori italiani e stranieri)', 'Alessandro D''Avenia', 'Mondadori', 'http://ecx.images-amazon.com/images/I/31GaSJblDDL._SL160_.jpg', 'http://www.amazon.it/Cose-nessuno-Scrittori-italiani-stranieri/dp/8804609168%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804609168', 332),
(23, '9788850323043', 'PHP 5 (Guida completa)', 'Andi Gutmans', 'Apogeo', 'http://ecx.images-amazon.com/images/I/41suqEbzCIL._SL160_.jpg', 'http://www.amazon.it/PHP-Guida-completa-Andi-Gutmans/dp/8850323042%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8850323042', 576),
(24, '9788873036210', 'TCL/TK. Guida di riferimento', 'Paul Raines', 'Apogeo', 'http://ecx.images-amazon.com/images/I/31ncbNYZI2L._SL160_.jpg', 'http://www.amazon.it/TCL-Guida-riferimento-Paul-Raines/dp/887303621X%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D887303621X', 488),
(25, '9788873039808', 'XML (Guida completa)', 'Devan Shepherd', 'Apogeo', 'http://ecx.images-amazon.com/images/I/315JxB2EU3L._SL160_.jpg', 'http://www.amazon.it/XML-Guida-completa-Devan-Shepherd/dp/8873039804%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8873039804', 483),
(26, '9788806192587', 'Firmino. Avventure di un parassita metropolitano (Einaudi. Stile libero big)', 'Sam Savage', 'Einaudi', 'http://ecx.images-amazon.com/images/I/21474kcr5EL._SL160_.jpg', 'http://www.amazon.it/Firmino-Avventure-parassita-metropolitano-Einaudi/dp/8806192582%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806192582', 179),
(27, '9788806171360', 'Aspetta primavera, Bandini (Einaudi. Stile libero)', 'John Fante', 'Einaudi', 'http://ecx.images-amazon.com/images/I/31d8M3-T9eL._SL160_.jpg', 'http://www.amazon.it/Aspetta-primavera-Bandini-Einaudi-libero/dp/8806171364%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806171364', 271),
(28, '9788888320304', 'Il dono (Narrativa)', 'Toni Morrison', 'Frassinelli', 'http://ecx.images-amazon.com/images/I/31wWfC%2BDQrL._SL160_.jpg', 'http://www.amazon.it/dono-Narrativa-Toni-Morrison/dp/888832030X%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D888832030X', 176),
(29, '9788870786538', 'I nuovi adolescenti. Padri e madri di fronte a una sfida (Psicologia clinica e psicoterapia)', 'Gustavo Pietropolli Charmet', 'Cortina Raffaello', 'http://ecx.images-amazon.com/images/I/31HNwEdlVcL._SL160_.jpg', 'http://www.amazon.it/adolescenti-fronte-Psicologia-clinica-psicoterapia/dp/8870786536%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8870786536', 300),
(30, '9788850211562', 'Il nuovo venuto. Un''indagine del commissario Bordelli (Teadue)', 'Marco Vichi', 'TEA', 'http://ecx.images-amazon.com/images/I/41tUbPn-DYL._SL160_.jpg', 'http://www.amazon.it/venuto-Unindagine-commissario-Bordelli-Teadue/dp/8850211562%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8850211562', 429),
(31, '9788806193096', 'Il giovane Holden (Super ET)', 'Jerome D. Salinger', 'Einaudi', 'http://ecx.images-amazon.com/images/I/21yYko0XByL._SL160_.jpg', 'http://www.amazon.it/giovane-Holden-Super-Jerome-Salinger/dp/8806193090%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806193090', 248),
(32, '9788806204655', 'Ogni cosa alla sua stagione (Frontiere Einaudi)', 'Enzo Bianchi', 'Einaudi', 'http://ecx.images-amazon.com/images/I/31tMtxlgCmL._SL160_.jpg', 'http://www.amazon.it/Ogni-cosa-stagione-Frontiere-Einaudi/dp/8806204653%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806204653', 127),
(33, '9788845924347', 'Le cose che non ho detto (La collana dei casi)', 'Azar Nafisi', 'Adelphi', 'http://ecx.images-amazon.com/images/I/31AhDQTSInL._SL160_.jpg', 'http://www.amazon.it/cose-che-detto-collana-casi/dp/8845924343%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8845924343', 342),
(34, '9788806191115', 'Libertà (Supercoralli)', 'Jonathan Franzen', 'Einaudi', 'http://ecx.images-amazon.com/images/I/51Z0Y%2BYD0sL._SL160_.jpg', 'http://www.amazon.it/Libert%C3%A0-Supercoralli-Jonathan-Franzen/dp/880619111X%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D880619111X', 622),
(35, '9788831706810', 'Il predicatore (Farfalle)', 'Camilla Läckberg', 'Marsilio', 'http://ecx.images-amazon.com/images/I/31Pr-MFQ%2B1L._SL160_.jpg', 'http://www.amazon.it/predicatore-Farfalle-Camilla-L%C3%A4ckberg/dp/8831706810%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8831706810', 462),
(36, '9788807491108', 'Vieni via con me (Varia)', 'Roberto Saviano', 'FELTRINELLI', 'http://ecx.images-amazon.com/images/I/410thISOh-L._SL160_.jpg', 'http://www.amazon.it/Vieni-via-Varia-Roberto-Saviano/dp/8807491109%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8807491109', 160),
(37, '9788817009911', 'Lettera a un insegnante (Saggi italiani)', 'Vittorino Andreoli', 'Rizzoli', 'http://ecx.images-amazon.com/images/I/31TTbp9YtfL._SL160_.jpg', 'http://www.amazon.it/Lettera-insegnante-italiani-Vittorino-Andreoli/dp/8817009911%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8817009911', 174),
(38, '9788830419629', 'Casa Rossa (La Gaja scienza)', 'Francesca Marciano', 'Longanesi', 'http://ecx.images-amazon.com/images/I/31W0--jSPkL._SL160_.jpg', 'http://www.amazon.it/Casa-Rossa-scienza-Francesca-Marciano/dp/8830419621%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8830419621', 387),
(39, '9788882467111', 'Che animale sei? Storia di una pennuta (Narratori della Fenice)', 'Paola Mastrocola', 'Guanda', 'http://ecx.images-amazon.com/images/I/41oEe2RD5IL._SL160_.jpg', 'http://www.amazon.it/animale-Storia-pennuta-Narratori-Fenice/dp/8882467112%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8882467112', 192),
(40, '9788876417962', 'L''eleganza del riccio (Dal mondo)', 'Muriel Barbery', 'E/O', 'http://ecx.images-amazon.com/images/I/41NbbIe4hlL._SL160_.jpg', 'http://www.amazon.it/Leleganza-del-riccio-Dal-mondo/dp/8876417966%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8876417966', 384),
(41, '9788838924538', 'Il nipote del Negus (La memoria)', 'Andrea Camilleri', 'Sellerio Editore Palermo', 'http://ecx.images-amazon.com/images/I/41oV69dG6vL._SL160_.jpg', 'http://www.amazon.it/nipote-del-Negus-memoria/dp/8838924538%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8838924538', 277),
(42, '9788838922855', 'Il campo del vasaio (La memoria)', 'Andrea Camilleri', 'Sellerio Editore Palermo', 'http://ecx.images-amazon.com/images/I/417CnF0VRYL._SL160_.jpg', 'http://www.amazon.it/campo-del-vasaio-memoria/dp/8838922853%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8838922853', 280),
(43, '9788831794985', 'La ragazza che giocava con il fuoco (Farfalle)', 'Stieg Larsson', 'Marsilio', 'http://ecx.images-amazon.com/images/I/51B2rtjU53L._SL160_.jpg', 'http://www.amazon.it/ragazza-che-giocava-fuoco-Farfalle/dp/8831794981%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8831794981', 754),
(44, '9788806191016', 'Che la festa cominci (Einaudi. Stile libero big)', 'Niccolò Ammaniti', 'Einaudi', 'http://ecx.images-amazon.com/images/I/31eEKusAZmL._SL160_.jpg', 'http://www.amazon.it/festa-cominci-Einaudi-Stile-libero/dp/8806191012%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806191012', 328),
(45, '9788806157852', 'Non siamo capaci di ascoltarli. Riflessioni sull''infanzia e l''adolescenza (Einaudi. Stile libero)', 'Paolo Crepet', 'Einaudi', 'http://ecx.images-amazon.com/images/I/21I9-b9eciL._SL160_.jpg', 'http://www.amazon.it/ascoltarli-Riflessioni-sullinfanzia-ladolescenza-Einaudi/dp/880615785X%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D880615785X', 129),
(46, '9788804578727', 'Al buio (Omnibus)', 'Patricia D. Cornwell', 'Mondadori', 'http://ecx.images-amazon.com/images/I/31KxlwPD2tL._SL160_.jpg', 'http://www.amazon.it/Al-buio-Omnibus-Patricia-Cornwell/dp/8804578726%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804578726', 198),
(47, '9788817866613', 'Antologia di Spoon River (Superbur classici)', 'E. Lee Masters', 'BUR Biblioteca Univ. Rizzoli', 'http://ecx.images-amazon.com/images/I/31KxlwPD2tL._SL160_.jpg', 'http://www.amazon.it/Al-buio-Omnibus-Patricia-Cornwell/dp/8804578726%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804578726', 324),
(48, '9788806178475', 'La mia scuola. Chi insegna si racconta (Gli struzzi)', 'Brossura', 'Einaudi', 'http://ecx.images-amazon.com/images/I/314znxQ9l6L._SL160_.jpg', 'http://www.amazon.it/mia-scuola-insegna-racconta-struzzi/dp/8806178474%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806178474', 189),
(49, '9788804499237', 'L''età incerta. I nuovi adolescenti (Oscar saggi)', 'Silvia Vegetti Finzi', 'Mondadori', 'http://ecx.images-amazon.com/images/I/51gK7hfzHbL._SL160_.jpg', 'http://www.amazon.it/incerta-nuovi-adolescenti-Oscar-saggi/dp/8804499230%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804499230', 377),
(50, '9788806142100', 'Io non ho paura (Einaudi. Stile libero)', 'Niccolò Ammaniti', 'Einaudi', 'http://ecx.images-amazon.com/images/I/41YPWHFGSDL._SL160_.jpg', 'http://www.amazon.it/non-paura-Einaudi-Stile-libero/dp/8806142100%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806142100', 219),
(51, '9788806143046', 'Almost blue (Einaudi. Stile libero)', 'Carlo Lucarelli', 'Einaudi', 'http://ecx.images-amazon.com/images/I/41aqYsEdt-L._SL160_.jpg', 'http://www.amazon.it/Almost-blue-Einaudi-Stile-libero/dp/8806143042%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806143042', 194),
(52, '9788806169558', 'Tramonto e polvere (Einaudi. Stile libero big)', 'Joe R. Lansdale', 'Einaudi', 'http://ecx.images-amazon.com/images/I/41I0-SS95FL._SL160_.jpg', 'http://www.amazon.it/Tramonto-polvere-Einaudi-Stile-libero/dp/8806169556%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806169556', 372),
(53, '9788806178697', 'L''albero dei giannizzeri (Einaudi. Stile libero big)', 'Jason Goodwin', 'Einaudi', 'http://ecx.images-amazon.com/images/I/41MrrTtPkLL._SL160_.jpg', 'http://www.amazon.it/Lalbero-giannizzeri-Einaudi-Stile-libero/dp/8806178695%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806178695', 382),
(54, '9788850206209', 'Il commissario Bordelli (Teadue)', 'Marco Vichi', 'TEA', 'http://ecx.images-amazon.com/images/I/41mlIKnoZXL._SL160_.jpg', 'http://www.amazon.it/commissario-Bordelli-Teadue-Marco-Vichi/dp/8850206208%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8850206208', 204),
(55, '9788807017377', 'I quaderni del pianto (I narratori)', 'Marcela Serrano', 'Feltrinelli', 'http://ecx.images-amazon.com/images/I/41L%2BZiDoS4L._SL160_.jpg', 'http://www.amazon.it/quaderni-del-pianto-narratori/dp/8807017377%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8807017377', 128),
(56, '9788830424586', 'Le stagioni dell''acqua (La Gaja scienza)', 'Laura Bosio', 'Longanesi', 'http://ecx.images-amazon.com/images/I/41vUOnd6zgL._SL160_.jpg', 'http://www.amazon.it/stagioni-dellacqua-Gaja-scienza/dp/8830424587%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8830424587', 264),
(57, '9788807017247', 'Giallo su giallo (I narratori)', 'Gianni Mura', 'Feltrinelli', 'http://ecx.images-amazon.com/images/I/41UjvozAgvL._SL160_.jpg', 'http://www.amazon.it/Giallo-giallo-narratori-Gianni-Mura/dp/8807017245%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8807017245', 227),
(58, '9788804504115', 'È una vita che ti aspetto (Arcobaleno)', 'Fabio Volo', 'Mondadori', 'http://ecx.images-amazon.com/images/I/21S2xja1xgL._SL160_.jpg', 'http://www.amazon.it/una-vita-che-aspetto-Arcobaleno/dp/8804504110%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804504110', 179),
(59, '9788806188702', 'Chesil Beach (Supercoralli)', 'Ian McEwan', 'Einaudi', 'http://ecx.images-amazon.com/images/I/31obwTHMMKL._SL160_.jpg', 'http://www.amazon.it/Chesil-Beach-Supercoralli-Ian-McEwan/dp/8806188704%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806188704', 136),
(60, '9788877827029', 'Harry Potter e la pietra filosofale: 1', 'J. K. Rowling', 'Salani', 'http://ecx.images-amazon.com/images/I/41HXrttAZXL._SL160_.jpg', 'http://www.amazon.it/Harry-Potter-pietra-filosofale-1/dp/8877827025%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8877827025', 293),
(61, '9788877827036', 'Harry Potter e la camera dei segreti: 2', 'J. K. Rowling', 'Salani', 'http://ecx.images-amazon.com/images/I/41yp7eD5DQL._SL160_.jpg', 'http://www.amazon.it/Harry-Potter-camera-dei-segreti/dp/8877827033%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8877827033', 307),
(62, '9788877828521', 'Harry Potter e il prigioniero di Azkaban: 3', 'J. K. Rowling', 'Salani', 'http://ecx.images-amazon.com/images/I/41qYM8gZLhL._SL160_.jpg', 'http://www.amazon.it/Harry-Potter-prigioniero-Azkaban-3/dp/8877828528%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8877828528', 366),
(63, '9788884513441', 'Harry Potter e l''Ordine della Fenice: 5', 'J. K. Rowling', 'Salani', 'http://ecx.images-amazon.com/images/I/21HR5TDBP4L._SL160_.jpg', 'http://www.amazon.it/Harry-Potter-lOrdine-della-Fenice/dp/8884513448%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8884513448', 807),
(64, '9788884516374', 'Harry Potter e il Principe Mezzosangue: 6', 'J. K. Rowling', 'Salani', 'http://ecx.images-amazon.com/images/I/51HkbHA7YfL._SL160_.jpg', 'http://www.amazon.it/Harry-Potter-Principe-Mezzosangue-6/dp/8884516374%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8884516374', 591),
(65, '9788817025621', 'La deriva. Perché l''Italia rischia il naufragio', 'G. Antonio Stella', 'Rizzoli', 'http://ecx.images-amazon.com/images/I/41iBCXA9K5L._SL160_.jpg', 'http://www.amazon.it/deriva-Perch%C3%A9-lItalia-rischia-naufragio/dp/8817025623%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8817025623', 327),
(66, '9788817017145', 'La casta. Così i politici italiani sono diventati intoccabili (Saggi italiani)', 'G. Antonio Stella', 'Rizzoli', 'http://ecx.images-amazon.com/images/I/41PG5kT9nFL._SL160_.jpg', 'http://www.amazon.it/casta-politici-italiani-diventati-intoccabili/dp/8817017140%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8817017140', 284),
(67, '9788845262418', 'Il bambino che sognava la fine del mondo (Narratori italiani)', 'Antonio Scurati', 'Bompiani', 'http://ecx.images-amazon.com/images/I/31fB6VmR02L._SL160_.jpg', 'http://www.amazon.it/bambino-sognava-mondo-Narratori-italiani/dp/8845262413%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8845262413', 295),
(68, '9788804595182', 'Bianca come il latte, rossa come il sangue (Scrittori italiani e stranieri)', 'Alessandro D''Avenia', 'Mondadori', 'http://ecx.images-amazon.com/images/I/31admvSBrBL._SL160_.jpg', 'http://www.amazon.it/Bianca-sangue-Scrittori-italiani-stranieri/dp/8804595183%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804595183', 254),
(69, '9788804577027', 'La solitudine dei numeri primi (Scrittori italiani e stranieri)', 'Paolo Giordano', 'Mondadori', 'http://ecx.images-amazon.com/images/I/41bu5c0%2ByFL._SL160_.jpg', 'http://www.amazon.it/solitudine-numeri-Scrittori-italiani-stranieri/dp/8804577029%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804577029', 304),
(70, '9788807017728', 'Vento scomposto (I narratori)', 'Simonetta Agnello Hornby', 'Feltrinelli', 'http://ecx.images-amazon.com/images/I/41ip0xWMR5L._SL160_.jpg', 'http://www.amazon.it/scomposto-narratori-Simonetta-Agnello-Hornby/dp/8807017725%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8807017725', 405),
(71, '9788804583066', 'L''aquila e il pollo fritto. Perchè amiamo e odiamo l''America (Frecce)', 'Vittorio Zucconi', 'Mondadori', 'http://ecx.images-amazon.com/images/I/31h3BlW4WhL._SL160_.jpg', 'http://www.amazon.it/Laquila-fritto-Perch%C3%A8-amiamo-lAmerica/dp/8804583061%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804583061', 309),
(72, '9788806190828', 'Il club dei padri estinti (Einaudi. Stile libero big)', 'Matt Haig', 'Einaudi', 'http://ecx.images-amazon.com/images/I/31ltOKDE0pL._SL160_.jpg', 'http://www.amazon.it/padri-estinti-Einaudi-Stile-libero/dp/8806190822%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806190822', 330),
(73, '9788806189068', 'Non avevo capito niente (I coralli)', 'Diego De Silva', 'Einaudi', 'http://ecx.images-amazon.com/images/I/41fyRl-bmzL._SL160_.jpg', 'http://www.amazon.it/Non-avevo-capito-niente-coralli/dp/8806189069%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806189069', 309),
(74, '9788807016059', 'Il sogno più dolce (I narratori)', 'Doris Lessing', 'Feltrinelli', 'http://ecx.images-amazon.com/images/I/41g-oaMzyQL._SL160_.jpg', 'http://www.amazon.it/sogno-pi%C3%B9-dolce-narratori/dp/8807016052%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8807016052', 456),
(75, '9788838644009', 'Guida a PHP (HandBook)', 'Tim Converse', 'McGraw-Hill Companies', 'http://ecx.images-amazon.com/images/I/21A3ANGps0L._SL160_.jpg', 'http://www.amazon.it/Guida-PHP-HandBook-Tim-Converse/dp/8838644004%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8838644004', 1040),
(76, '9788804555261', 'Langenscheidt. Viaggiare e farsi capire (I fraseologici)', 'Brossura', 'Mondadori', 'http://ecx.images-amazon.com/images/I/31fEvpkODHL._SL160_.jpg', 'http://www.amazon.it/Langenscheidt-Viaggiare-farsi-capire-fraseologici/dp/8804555262%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804555262', 255),
(77, '9788842664727', 'Fisica per moduli. Tanti, tanti problemi di fisica svolti e proposti e tanti test. Modulo B: I moti e le forze. Per le Scuole superiori', 'Bianca Manassero Barnini', 'Il Capitello', 'http://ecx.images-amazon.com/images/I/515E7TYt2gL._SL160_.jpg', 'http://www.amazon.it/Fisica-moduli-problemi-fisica-proposti/dp/8842664723%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8842664723', 224),
(78, '9788808127631', 'La seconda prova di fisica. Testi e svolgimenti dal 1995. Con espansione online. Per i Licei scientifici', 'Paolo Cavallo', 'Zanichelli', 'http://ecx.images-amazon.com/images/I/41kE7rV7xbL._SL160_.jpg', 'http://www.amazon.it/seconda-fisica-svolgimenti-espansione-scientifici/dp/880812763X%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D880812763X', 110),
(79, '9788804483694', 'Guinness World Records 2001 (Arcobaleno)', 'Brossura', 'Mondadori', 'http://ecx.images-amazon.com/images/I/411quwepi9L._SL160_.jpg', 'http://www.amazon.it/Guinness-World-Records-2001-Arcobaleno/dp/8804483695%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804483695', 272),
(80, '9781439196830', 'The Playbook', 'Barney Stinson', 'Simon + Schuster Inc.', 'http://ecx.images-amazon.com/images/I/61OJFPRA1SL._SL160_.jpg', 'http://www.amazon.it/Playbook-Barney-Stinson/dp/1439196834%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1439196834', 141),
(81, '9780194316491', 'Oxford advanced learner''s dictionary. Con CD-ROM', 'Albert S. Hornby', 'Oxford University Press', 'http://ecx.images-amazon.com/images/I/51rkThhSw3L._SL160_.jpg', 'http://www.amazon.it/Oxford-advanced-learners-dictionary-CD-ROM/dp/0194316491%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0194316491', 945),
(82, '9788804523413', 'Il Codice da Vinci (Omnibus)', 'Dan Brown', 'Mondadori', 'http://ecx.images-amazon.com/images/I/210XVPRHW9L._SL160_.jpg', 'http://www.amazon.it/Codice-Vinci-Omnibus-Dan-Brown/dp/8804523417%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804523417', 523),
(83, '9788811686439', 'La lettrice bugiarda (Narratori moderni)', 'Brunonia Barry', 'Garzanti Libri', 'http://ecx.images-amazon.com/images/I/513GYzq-4TL._SL160_.jpg', 'http://www.amazon.it/lettrice-bugiarda-Narratori-moderni/dp/8811686431%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8811686431', 389),
(84, '9788804584780', 'La paziente privata (Omnibus)', 'P. D. James', 'Mondadori', 'http://ecx.images-amazon.com/images/I/31zDcE8UBJL._SL160_.jpg', 'http://www.amazon.it/paziente-privata-Omnibus-P-James/dp/8804584785%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804584785', 464),
(85, '9788817035545', 'Noi (Rizzoli best)', 'Walter Veltroni', 'Rizzoli', 'http://ecx.images-amazon.com/images/I/31654KOmKQL._SL160_.jpg', 'http://www.amazon.it/Noi-Rizzoli-best-Walter-Veltroni/dp/8817035548%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8817035548', 347),
(86, '9788845264085', 'Tutta mio padre (Narratori italiani)', 'Rosa Matteucci', 'Bompiani', 'http://ecx.images-amazon.com/images/I/31qVxe8xmbL._SL160_.jpg', 'http://www.amazon.it/Tutta-mio-padre-Narratori-italiani/dp/8845264084%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8845264084', 286),
(87, '9788804603177', 'La caduta dei giganti. The century trilogy: 1 (Omnibus)', 'Ken Follett', 'Mondadori', 'http://ecx.images-amazon.com/images/I/41MKu6IY9WL._SL160_.jpg', 'http://www.amazon.it/caduta-dei-giganti-century-trilogy/dp/8804603178%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8804603178', 999),
(88, '9788806201555', 'Uomo nel buio (Super ET)', 'Paul Auster', 'Einaudi', 'http://ecx.images-amazon.com/images/I/31oRX5JEpSL._SL160_.jpg', 'http://www.amazon.it/Uomo-buio-Super-Paul-Auster/dp/8806201557%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806201557', 152),
(89, '9788817680196', 'Buio (Scala italiani)', 'Dacia Maraini', 'Rizzoli', 'http://ecx.images-amazon.com/images/I/31JwVc6q6rL._SL160_.jpg', 'http://www.amazon.it/Buio-Scala-italiani-Dacia-Maraini/dp/8817680192%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8817680192', 215),
(90, '9788817871624', 'Vita (Scala italiani)', 'Melania G. Mazzucco', 'Rizzoli', 'http://ecx.images-amazon.com/images/I/416A3R75ARL._SL160_.jpg', 'http://www.amazon.it/Vita-Scala-italiani-Melania-Mazzucco/dp/8817871621%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8817871621', 398),
(91, '9788806144524', 'Viaggio in Portogallo (Einaudi tascabili)', 'José Saramago', 'Einaudi', 'http://ecx.images-amazon.com/images/I/31D1qeIlQNL._SL160_.jpg', 'http://www.amazon.it/Viaggio-Portogallo-Einaudi-tascabili-Saramago/dp/8806144529%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806144529', 516),
(92, '9788806136659', 'La storia (Einaudi tascabili)', 'Elsa Morante', 'Einaudi', 'http://ecx.images-amazon.com/images/I/310NHtDKVUL._SL160_.jpg', 'http://www.amazon.it/storia-Einaudi-tascabili-Elsa-Morante/dp/8806136658%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806136658', 700),
(93, '9788804456971', 'Per amore. Il romanzo di Eloisa: la storia di un amore assoluto raccontata dopo mille anni', 'Edgarda Ferri', 'Mondadori', 'http://ecx.images-amazon.com/images/I/310NHtDKVUL._SL160_.jpg', 'http://www.amazon.it/storia-Einaudi-tascabili-Elsa-Morante/dp/8806136658%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806136658', 144),
(94, '9788804453161', 'Nel chiaro della notte (Scrittori italiani e stranieri)', 'Fulvio Tomizza', 'Mondadori', 'http://ecx.images-amazon.com/images/I/310NHtDKVUL._SL160_.jpg', 'http://www.amazon.it/storia-Einaudi-tascabili-Elsa-Morante/dp/8806136658%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806136658', 198),
(95, '9788806149352', 'La vacanza (Supercoralli)', 'Dacia Maraini', 'Einaudi', 'http://ecx.images-amazon.com/images/I/31AlGfYqN2L._SL160_.jpg', 'http://www.amazon.it/vacanza-Supercoralli-Dacia-Maraini/dp/8806149350%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806149350', 153),
(96, '9788806184339', 'Fuoco amico', 'Abraham Yehoshua', 'Einaudi', 'http://ecx.images-amazon.com/images/I/41gIMVHItcL._SL160_.jpg', 'http://www.amazon.it/Fuoco-amico-Abraham-Yehoshua/dp/8806184334%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806184334', 399),
(97, '9788806163709', 'La sposa liberata (Supercoralli)', 'Abraham Yehoshua', 'Einaudi', 'http://ecx.images-amazon.com/images/I/31yl6BcxVAL._SL160_.jpg', 'http://www.amazon.it/sposa-liberata-Supercoralli-Abraham-Yehoshua/dp/8806163701%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806163701', 592),
(98, '9788806153380', 'Naufragi. Tre storie di confine (I coralli)', 'Paolo Crepet', 'Einaudi', 'http://ecx.images-amazon.com/images/I/41CexXsuP5L._SL160_.jpg', 'http://www.amazon.it/Naufragi-Tre-storie-confine-coralli/dp/8806153382%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806153382', 108),
(99, '9788806148478', 'Tutti i nomi (Supercoralli)', 'José Saramago', 'Einaudi', 'http://ecx.images-amazon.com/images/I/418Z6bTtYzL._SL160_.jpg', 'http://www.amazon.it/Tutti-nomi-Supercoralli-Jos%C3%A9-Saramago/dp/8806148478%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806148478', 253),
(100, '9788806176891', 'Sabato (Supercoralli)', 'Ian McEwan', 'Einaudi', 'http://ecx.images-amazon.com/images/I/418nUc2QA5L._SL160_.jpg', 'http://www.amazon.it/Sabato-Supercoralli-Ian-McEwan/dp/8806176897%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806176897', 292),
(101, '9788806147457', 'Un infinito numero. Virgilio e Mecenate nel paese dei Rasna (Supercoralli)', 'Sebastiano Vassalli', 'Einaudi', 'http://ecx.images-amazon.com/images/I/31fl7g5BXLL._SL160_.jpg', 'http://www.amazon.it/infinito-numero-Virgilio-Mecenate-Supercoralli/dp/8806147455%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8806147455', 254),
(102, '9788807018626', 'Mr Gwyn (I narratori)', 'Alessandro Baricco', 'Feltrinelli', 'http://ecx.images-amazon.com/images/I/31IRBFl%2B2tL._SL160_.jpg', 'http://www.amazon.it/Mr-Gwyn-narratori-Alessandro-Baricco/dp/8807018624%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8807018624', 158),
(103, '9781430210450', 'Beginning Groovy and Grails: From Novice to Professional (Beginning from Novice to Professional)', 'Christopher M. Judd', 'Apress', 'http://ecx.images-amazon.com/images/I/51mi58r9nuL._SL160_.jpg', 'http://www.amazon.it/Beginning-Groovy-Grails-Novice-Professional/dp/1430210451%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D1430210451', 440),
(104, '9780007208777', 'English Dictionary (Collins GEM)', 'Brossura', 'Collins', 'http://ecx.images-amazon.com/images/I/51ylI55ZwWL._SL160_.jpg', 'http://www.amazon.it/English-Dictionary-Collins-GEM/dp/0007208774%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0007208774', 704),
(105, '9788807018558', 'I pesci non chiudono gli occhi (I narratori)', 'Erri De Luca', 'Feltrinelli', 'http://ecx.images-amazon.com/images/I/41YSPS59rdL._SL160_.jpg', 'http://www.amazon.it/pesci-non-chiudono-occhi-narratori/dp/8807018551%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8807018551', 115),
(106, '9788838925764', 'La Traccia Dell''Angelo (La memoria)', 'Benni Stefano', 'Sellerio Editore', 'http://ecx.images-amazon.com/images/I/31%2Be-rT9ElL._SL160_.jpg', 'http://www.amazon.it/Traccia-DellAngelo-memoria-Benni-Stefano/dp/8838925763%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8838925763', 112),
(108, '9788807018312', 'Le Beatrici (I narratori)', 'Stefano Benni', 'Feltrinelli', 'http://ecx.images-amazon.com/images/I/41T3tKG%2BUTL._SL160_.jpg', 'http://www.amazon.it/Beatrici-I-narratori-Stefano-Benni/dp/8807018314%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D8807018314', 92),
(109, '9780340994689', 'One Day', 'David Nicholls', 'Hodder and Stoughton Ltd.', 'http://ecx.images-amazon.com/images/I/417fMnys1kL._SL160_.jpg', 'http://www.amazon.it/One-Day-David-Nicholls/dp/0340994681%3FSubscriptionId%3DAKIAIKT6Z5BWQTPWUGOQ%26tag%3Dbooks0c56-20%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D0340994681', 437);

-- --------------------------------------------------------

--
-- Struttura della tabella `lend`
--

CREATE TABLE IF NOT EXISTS `lend` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `id_book` int(100) NOT NULL,
  `id_user` int(100) NOT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  `returndate` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dump dei dati per la tabella `lend`
--

INSERT INTO `lend` (`id`, `id_book`, `id_user`, `startdate`, `enddate`, `returndate`) VALUES
(1, 6, 3, '2011-11-02', '2011-11-21', '0000-00-00'),
(2, 5, 4, '2011-11-23', '2011-12-25', '2011-11-25'),
(3, 32, 4, '2011-11-01', '2011-11-16', '2011-11-15'),
(4, 57, 1, '2011-11-26', '2011-12-26', '2011-11-26'),
(5, 9, 1, '2011-11-26', '2011-12-26', '2011-12-12'),
(6, 72, 1, '2011-11-26', '2011-12-26', '2011-12-12'),
(7, 67, 1, '2011-11-28', '2011-12-28', '2011-12-12'),
(8, 82, 1, '2011-11-28', '2011-12-28', '2011-12-12'),
(9, 18, 1, '2011-12-05', '2012-01-04', '2011-12-12'),
(10, 1, 1, '2011-12-12', '2012-01-11', '2012-02-23'),
(11, 42, 1, '2011-12-12', '2012-01-11', '2011-12-12'),
(12, 18, 1, '2011-12-12', '2012-01-11', '0000-00-00'),
(13, 1, 1, '2012-02-23', '2012-03-24', '0000-00-00'),
(14, 44, 4, '2012-02-25', '2012-03-26', '0000-00-00'),
(15, 67, 4, '2012-02-25', '2012-03-26', '0000-00-00');

-- --------------------------------------------------------

--
-- Struttura della tabella `lending_view`
--

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `biblioteca`.`lending_view` AS select `l`.`id` AS `id_lend`,`b`.`id` AS `id_book`,`u`.`id` AS `id_user`,`b`.`isbn` AS `isbn`,`b`.`title` AS `title`,`u`.`user` AS `user`,`l`.`startdate` AS `startdate`,`l`.`enddate` AS `enddate`,`l`.`returndate` AS `returndate` from ((`biblioteca`.`lend` `l` join `biblioteca`.`book` `b`) join `biblioteca`.`user` `u`) where ((`b`.`id` = `l`.`id_book`) and (`u`.`id` = `l`.`id_user`));

--
-- Dump dei dati per la tabella `lending_view`
--

INSERT INTO `lending_view` (`id_lend`, `id_book`, `id_user`, `isbn`, `title`, `user`, `startdate`, `enddate`, `returndate`) VALUES
(4, 57, 1, '9788807017247', 'Giallo su giallo (I narratori)', 'zerbinati.francesco', '2011-11-26', '2011-12-26', '2011-11-26'),
(5, 9, 1, '9788804613893', 'Le prime luci del mattino ', 'zerbinati.francesco', '2011-11-26', '2011-12-26', '2011-12-12'),
(6, 72, 1, '9788806190828', 'Il club dei padri estinti (Einaudi. Stile libero big)', 'zerbinati.francesco', '2011-11-26', '2011-12-26', '2011-12-12'),
(7, 67, 1, '9788845262418', 'Il bambino che sognava la fine del mondo (Narratori italiani)', 'zerbinati.francesco', '2011-11-28', '2011-12-28', '2011-12-12'),
(8, 82, 1, '9788804523413', 'Il Codice da Vinci (Omnibus)', 'zerbinati.francesco', '2011-11-28', '2011-12-28', '2011-12-12'),
(9, 18, 1, '9788850320684', 'Java 2 SDK 1.4. Guida per il programmatore (Wrox)', 'zerbinati.francesco', '2011-12-05', '2012-01-04', '2011-12-12'),
(10, 1, 1, '9788884518781', 'Harry Potter e i doni della morte', 'zerbinati.francesco', '2011-12-12', '2012-01-11', '2012-02-23'),
(11, 42, 1, '9788838922855', 'Il campo del vasaio (La memoria)', 'zerbinati.francesco', '2011-12-12', '2012-01-11', '2011-12-12'),
(12, 18, 1, '9788850320684', 'Java 2 SDK 1.4. Guida per il programmatore (Wrox)', 'zerbinati.francesco', '2011-12-12', '2012-01-11', '0000-00-00'),
(13, 1, 1, '9788884518781', 'Harry Potter e i doni della morte', 'zerbinati.francesco', '2012-02-23', '2012-03-24', '0000-00-00'),
(1, 6, 3, '9788804616320', 'Steve Jobs (Ingrandimenti)', 'giacomz', '2011-11-02', '2011-11-21', '0000-00-00'),
(2, 5, 4, '9788884510495', 'Harry Potter e il calice di fuoco: 4', 'matteob', '2011-11-23', '2011-12-25', '2011-11-25'),
(3, 32, 4, '9788806204655', 'Ogni cosa alla sua stagione (Frontiere Einaudi)', 'matteob', '2011-11-01', '2011-11-16', '2011-11-15'),
(14, 44, 4, '9788806191016', 'Che la festa cominci (Einaudi. Stile libero big)', 'matteob', '2012-02-25', '2012-03-26', '0000-00-00'),
(15, 67, 4, '9788845262418', 'Il bambino che sognava la fine del mondo (Narratori italiani)', 'matteob', '2012-02-25', '2012-03-26', '0000-00-00');

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `cf` varchar(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(100) NOT NULL,
  `tel` varchar(100) NOT NULL,
  `indirizzo` varchar(100) NOT NULL,
  `mail` varchar(500) NOT NULL,
  `user` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cf` (`cf`,`mail`),
  UNIQUE KEY `user` (`user`),
  UNIQUE KEY `mail` (`mail`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`id`, `cf`, `nome`, `cognome`, `tel`, `indirizzo`, `mail`, `user`, `pwd`, `admin`) VALUES
(1, 'ZRBFNC89R34R327R', 'Francesco', 'Zerbinati', '3456548831', 'Via Carducci 29', 'francesco@gmail.com', 'zerbinati.francesco', 'password', 1),
(2, 'RSSMRA70A01F254W ', 'Mario', 'Rossi', '0376280034', 'Via Campi', 'rossim@yahoo.it', 'rossi.mario', 'rossi', 0),
(3, 'MZZGCM89A01E775D ', 'Giacomo', 'Mazzoni', '3321095378', 'Via Don Giovanni Barzi', 'giacomz@hotmail.it', 'giacomz', 'mazzo', 1),
(4, 'BGIMTT89A01E394Y ', 'Matteo', 'Bigi', '3401695734', 'Via Sgarzari', 'matteo.bigi@gmail.com', 'matteob', 'bigi89', 0);
