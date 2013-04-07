-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (i686)
--
-- Host: maxses.com.br    Database: natura_controle_calibracao
-- ------------------------------------------------------
-- Server version	5.0.91-community-cll
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
--
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--
--
-- Table structure for table `anexo`
--
DROP TABLE IF EXISTS `anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anexo` (
  `anexo_id` int(11) NOT NULL auto_increment,
  `anexo_endereco` varchar(255) default NULL,
  PRIMARY KEY  (`anexo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `anexo`
--
LOCK TABLES `anexo` WRITE;
/*!40000 ALTER TABLE `anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `condicao`
--
DROP TABLE IF EXISTS `condicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `condicao` (
  `condicao_id` int(11) NOT NULL auto_increment,
  `condicao_data_inicio` date default NULL,
  `condicao_equipamento` varchar(255) default NULL,
  `equipamento_id` int(11) default NULL,
  PRIMARY KEY  (`condicao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `condicao`
--
LOCK TABLES `condicao` WRITE;
/*!40000 ALTER TABLE `condicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `condicao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `empresa`
--
DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `empresa_id` int(11) NOT NULL auto_increment,
  `empresa_cnpj` varchar(255) default NULL,
  `empresa_nome_fantasia` varchar(255) default NULL,
  `empresa_razao_social` varchar(255) default NULL,
  PRIMARY KEY  (`empresa_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `empresa`
--
LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `empresa_anexo`
--
DROP TABLE IF EXISTS `empresa_anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa_anexo` (
  `anexo_id` int(11) NOT NULL,
  `empresa_id` int(11) NOT NULL,
  PRIMARY KEY  (`anexo_id`,`empresa_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `empresa_anexo`
--
LOCK TABLES `empresa_anexo` WRITE;
/*!40000 ALTER TABLE `empresa_anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa_anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `equipamento`
--
DROP TABLE IF EXISTS `equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento` (
  `equipamento_id` int(11) NOT NULL,
  `empresa_id` int(11) default NULL,
  `equipamento_descricao` varchar(255) default NULL,
  `equipamento_faixa_medicao` varchar(255) default NULL,
  `equipamento_menor_divisao` varchar(255) default NULL,
  `equipamento_modelo` varchar(255) default NULL,
  `equipamento_numero_serie` varchar(255) default NULL,
  `equipamento_tolerancia` double default NULL,
  PRIMARY KEY  (`equipamento_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `equipamento`
--
LOCK TABLES `equipamento` WRITE;
/*!40000 ALTER TABLE `equipamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamento` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `equipamento_anexo`
--
DROP TABLE IF EXISTS `equipamento_anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento_anexo` (
  `anexo_id` int(11) NOT NULL,
  `equipamento_id` int(11) NOT NULL,
  PRIMARY KEY  (`anexo_id`,`equipamento_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `equipamento_anexo`
--
LOCK TABLES `equipamento_anexo` WRITE;
/*!40000 ALTER TABLE `equipamento_anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamento_anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `equipamento_pessoa`
--
DROP TABLE IF EXISTS `equipamento_pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento_pessoa` (
  `pessoa_id` int(11) NOT NULL,
  `equipamento_id` int(11) NOT NULL,
  PRIMARY KEY  (`pessoa_id`,`equipamento_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `equipamento_pessoa`
--
LOCK TABLES `equipamento_pessoa` WRITE;
/*!40000 ALTER TABLE `equipamento_pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamento_pessoa` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `frequencia`
--
DROP TABLE IF EXISTS `frequencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frequencia` (
  `frequencia_id` int(11) NOT NULL auto_increment,
  `equipamento_id` int(11) default NULL,
  `frequencia_calibracao` varchar(255) default NULL,
  PRIMARY KEY  (`frequencia_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `frequencia`
--
LOCK TABLES `frequencia` WRITE;
/*!40000 ALTER TABLE `frequencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `frequencia` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `intervencao`
--
DROP TABLE IF EXISTS `intervencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervencao` (
  `intervencao_id` int(11) NOT NULL auto_increment,
  `empresa_id` int(11) default NULL,
  `equipamento_id` int(11) default NULL,
  `intervencao_aceita_por` varchar(255) default NULL,
  `intervencao_data` date default NULL,
  `intervencao_empresa_codigo_laudo` varchar(255) default NULL,
  `intervencao_observacao` varchar(255) default NULL,
  `intervencao_tipo_id` varchar(255) default NULL,
  PRIMARY KEY  (`intervencao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `intervencao`
--
LOCK TABLES `intervencao` WRITE;
/*!40000 ALTER TABLE `intervencao` DISABLE KEYS */;
/*!40000 ALTER TABLE `intervencao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `intervencao_anexo`
--
DROP TABLE IF EXISTS `intervencao_anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervencao_anexo` (
  `intervencao_id` int(11) NOT NULL,
  `anexo_id` int(11) NOT NULL,
  PRIMARY KEY  (`intervencao_id`,`anexo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `intervencao_anexo`
--
LOCK TABLES `intervencao_anexo` WRITE;
/*!40000 ALTER TABLE `intervencao_anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `intervencao_anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `intervencao_tipo`
--
DROP TABLE IF EXISTS `intervencao_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervencao_tipo` (
  `intervencao_tipo_id` varchar(255) NOT NULL,
  PRIMARY KEY  (`intervencao_tipo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `intervencao_tipo`
--
LOCK TABLES `intervencao_tipo` WRITE;
/*!40000 ALTER TABLE `intervencao_tipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `intervencao_tipo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `laudo_intervencao`
--
DROP TABLE IF EXISTS `laudo_intervencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laudo_intervencao` (
  `laudo_intervencao_id` int(11) NOT NULL auto_increment,
  `intervencao_id` int(11) default NULL,
  `laudo_intervencao_incerteza_medicoes` double default NULL,
  `laudo_intervencao_media_medicoes` double default NULL,
  `laudo_intervencao_valor_padrao` double default NULL,
  `sistema_medicao_id` varchar(255) default NULL,
  PRIMARY KEY  (`laudo_intervencao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `laudo_intervencao`
--
LOCK TABLES `laudo_intervencao` WRITE;
/*!40000 ALTER TABLE `laudo_intervencao` DISABLE KEYS */;
/*!40000 ALTER TABLE `laudo_intervencao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `pessoa`
--
DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `pessoa_id` int(11) NOT NULL auto_increment,
  `pessoa_cpf` varchar(255) default NULL,
  `pessoa_email` varchar(255) default NULL,
  `pessoa_nome` varchar(255) default NULL,
  PRIMARY KEY  (`pessoa_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `pessoa`
--
LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'345.957.308-29','vitor.lima@unifesp.br','Vitor Lima');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `sistema_medicao`
--
DROP TABLE IF EXISTS `sistema_medicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sistema_medicao` (
  `sistema_medicao_id` varchar(255) NOT NULL,
  PRIMARY KEY  (`sistema_medicao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `sistema_medicao`
--
LOCK TABLES `sistema_medicao` WRITE;
/*!40000 ALTER TABLE `sistema_medicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `sistema_medicao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `tolerancia`
--
DROP TABLE IF EXISTS `tolerancia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tolerancia` (
  `sistema_medicao_id` varchar(255) default NULL,
  `tolerancia_valor` double default NULL,
  `equipamento_id` int(11) NOT NULL,
  `tolerancia_id` int(11) NOT NULL,
  PRIMARY KEY  (`equipamento_id`,`tolerancia_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `tolerancia`
--
LOCK TABLES `tolerancia` WRITE;
/*!40000 ALTER TABLE `tolerancia` DISABLE KEYS */;
/*!40000 ALTER TABLE `tolerancia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- Dump completed on 2013-04-03  3:56:14
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (i686)
--
-- Host: maxses.com.br    Database: natura_controle_calibracao
-- ------------------------------------------------------
-- Server version	5.0.91-community-cll
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
--
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--
--
-- Table structure for table `anexo`
--
DROP TABLE IF EXISTS `anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anexo` (
  `anexo_id` int(11) NOT NULL auto_increment,
  `anexo_endereco` varchar(255) default NULL,
  PRIMARY KEY  (`anexo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `anexo`
--
LOCK TABLES `anexo` WRITE;
/*!40000 ALTER TABLE `anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `condicao`
--
DROP TABLE IF EXISTS `condicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `condicao` (
  `condicao_id` int(11) NOT NULL auto_increment,
  `condicao_data_inicio` date default NULL,
  `condicao_equipamento` varchar(255) default NULL,
  `equipamento_id` int(11) default NULL,
  PRIMARY KEY  (`condicao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `condicao`
--
LOCK TABLES `condicao` WRITE;
/*!40000 ALTER TABLE `condicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `condicao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `empresa`
--
DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `empresa_id` int(11) NOT NULL auto_increment,
  `empresa_cnpj` varchar(255) default NULL,
  `empresa_nome_fantasia` varchar(255) default NULL,
  `empresa_razao_social` varchar(255) default NULL,
  PRIMARY KEY  (`empresa_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `empresa`
--
LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `empresa_anexo`
--
DROP TABLE IF EXISTS `empresa_anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa_anexo` (
  `anexo_id` int(11) NOT NULL,
  `empresa_id` int(11) NOT NULL,
  PRIMARY KEY  (`anexo_id`,`empresa_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `empresa_anexo`
--
LOCK TABLES `empresa_anexo` WRITE;
/*!40000 ALTER TABLE `empresa_anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa_anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `equipamento`
--
DROP TABLE IF EXISTS `equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento` (
  `equipamento_id` int(11) NOT NULL,
  `empresa_id` int(11) default NULL,
  `equipamento_descricao` varchar(255) default NULL,
  `equipamento_faixa_medicao` varchar(255) default NULL,
  `equipamento_menor_divisao` varchar(255) default NULL,
  `equipamento_modelo` varchar(255) default NULL,
  `equipamento_numero_serie` varchar(255) default NULL,
  `equipamento_tolerancia` double default NULL,
  PRIMARY KEY  (`equipamento_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `equipamento`
--
LOCK TABLES `equipamento` WRITE;
/*!40000 ALTER TABLE `equipamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamento` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `equipamento_anexo`
--
DROP TABLE IF EXISTS `equipamento_anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento_anexo` (
  `anexo_id` int(11) NOT NULL,
  `equipamento_id` int(11) NOT NULL,
  PRIMARY KEY  (`anexo_id`,`equipamento_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `equipamento_anexo`
--
LOCK TABLES `equipamento_anexo` WRITE;
/*!40000 ALTER TABLE `equipamento_anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamento_anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `equipamento_pessoa`
--
DROP TABLE IF EXISTS `equipamento_pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento_pessoa` (
  `pessoa_id` int(11) NOT NULL,
  `equipamento_id` int(11) NOT NULL,
  PRIMARY KEY  (`pessoa_id`,`equipamento_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `equipamento_pessoa`
--
LOCK TABLES `equipamento_pessoa` WRITE;
/*!40000 ALTER TABLE `equipamento_pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamento_pessoa` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `frequencia`
--
DROP TABLE IF EXISTS `frequencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frequencia` (
  `frequencia_id` int(11) NOT NULL auto_increment,
  `equipamento_id` int(11) default NULL,
  `frequencia_calibracao` varchar(255) default NULL,
  PRIMARY KEY  (`frequencia_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `frequencia`
--
LOCK TABLES `frequencia` WRITE;
/*!40000 ALTER TABLE `frequencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `frequencia` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `intervencao`
--
DROP TABLE IF EXISTS `intervencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervencao` (
  `intervencao_id` int(11) NOT NULL auto_increment,
  `empresa_id` int(11) default NULL,
  `equipamento_id` int(11) default NULL,
  `intervencao_aceita_por` varchar(255) default NULL,
  `intervencao_data` date default NULL,
  `intervencao_empresa_codigo_laudo` varchar(255) default NULL,
  `intervencao_observacao` varchar(255) default NULL,
  `intervencao_tipo_id` varchar(255) default NULL,
  PRIMARY KEY  (`intervencao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `intervencao`
--
LOCK TABLES `intervencao` WRITE;
/*!40000 ALTER TABLE `intervencao` DISABLE KEYS */;
/*!40000 ALTER TABLE `intervencao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `intervencao_anexo`
--
DROP TABLE IF EXISTS `intervencao_anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervencao_anexo` (
  `intervencao_id` int(11) NOT NULL,
  `anexo_id` int(11) NOT NULL,
  PRIMARY KEY  (`intervencao_id`,`anexo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `intervencao_anexo`
--
LOCK TABLES `intervencao_anexo` WRITE;
/*!40000 ALTER TABLE `intervencao_anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `intervencao_anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `intervencao_tipo`
--
DROP TABLE IF EXISTS `intervencao_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervencao_tipo` (
  `intervencao_tipo_id` varchar(255) NOT NULL,
  PRIMARY KEY  (`intervencao_tipo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `intervencao_tipo`
--
LOCK TABLES `intervencao_tipo` WRITE;
/*!40000 ALTER TABLE `intervencao_tipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `intervencao_tipo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `laudo_intervencao`
--
DROP TABLE IF EXISTS `laudo_intervencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laudo_intervencao` (
  `laudo_intervencao_id` int(11) NOT NULL auto_increment,
  `intervencao_id` int(11) default NULL,
  `laudo_intervencao_incerteza_medicoes` double default NULL,
  `laudo_intervencao_media_medicoes` double default NULL,
  `laudo_intervencao_valor_padrao` double default NULL,
  `sistema_medicao_id` varchar(255) default NULL,
  PRIMARY KEY  (`laudo_intervencao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `laudo_intervencao`
--
LOCK TABLES `laudo_intervencao` WRITE;
/*!40000 ALTER TABLE `laudo_intervencao` DISABLE KEYS */;
/*!40000 ALTER TABLE `laudo_intervencao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `pessoa`
--
DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `pessoa_id` int(11) NOT NULL auto_increment,
  `pessoa_cpf` varchar(255) default NULL,
  `pessoa_email` varchar(255) default NULL,
  `pessoa_nome` varchar(255) default NULL,
  PRIMARY KEY  (`pessoa_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `pessoa`
--
LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'345.957.308-29','vitor.lima@unifesp.br','Vitor Lima');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `sistema_medicao`
--
DROP TABLE IF EXISTS `sistema_medicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sistema_medicao` (
  `sistema_medicao_id` varchar(255) NOT NULL,
  PRIMARY KEY  (`sistema_medicao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `sistema_medicao`
--
LOCK TABLES `sistema_medicao` WRITE;
/*!40000 ALTER TABLE `sistema_medicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `sistema_medicao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `tolerancia`
--
DROP TABLE IF EXISTS `tolerancia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tolerancia` (
  `sistema_medicao_id` varchar(255) default NULL,
  `tolerancia_valor` double default NULL,
  `equipamento_id` int(11) NOT NULL,
  `tolerancia_id` int(11) NOT NULL,
  PRIMARY KEY  (`equipamento_id`,`tolerancia_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `tolerancia`
--
LOCK TABLES `tolerancia` WRITE;
/*!40000 ALTER TABLE `tolerancia` DISABLE KEYS */;
/*!40000 ALTER TABLE `tolerancia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- Dump completed on 2013-04-03  4:11:24
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (i686)
--
-- Host: maxses.com.br    Database: natura_controle_calibracao
-- ------------------------------------------------------
-- Server version	5.0.91-community-cll
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
--
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--
--
-- Table structure for table `anexo`
--
DROP TABLE IF EXISTS `anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anexo` (
  `anexo_id` int(11) NOT NULL auto_increment,
  `anexo_endereco` varchar(255) default NULL,
  PRIMARY KEY  (`anexo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `anexo`
--
LOCK TABLES `anexo` WRITE;
/*!40000 ALTER TABLE `anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `condicao`
--
DROP TABLE IF EXISTS `condicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `condicao` (
  `condicao_id` int(11) NOT NULL auto_increment,
  `condicao_data_inicio` date default NULL,
  `condicao_equipamento` varchar(255) default NULL,
  `equipamento_id` int(11) default NULL,
  PRIMARY KEY  (`condicao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `condicao`
--
LOCK TABLES `condicao` WRITE;
/*!40000 ALTER TABLE `condicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `condicao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `empresa`
--
DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `empresa_id` int(11) NOT NULL auto_increment,
  `empresa_cnpj` varchar(255) default NULL,
  `empresa_nome_fantasia` varchar(255) default NULL,
  `empresa_razao_social` varchar(255) default NULL,
  PRIMARY KEY  (`empresa_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `empresa`
--
LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `empresa_anexo`
--
DROP TABLE IF EXISTS `empresa_anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa_anexo` (
  `anexo_id` int(11) NOT NULL,
  `empresa_id` int(11) NOT NULL,
  PRIMARY KEY  (`anexo_id`,`empresa_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `empresa_anexo`
--
LOCK TABLES `empresa_anexo` WRITE;
/*!40000 ALTER TABLE `empresa_anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa_anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `equipamento`
--
DROP TABLE IF EXISTS `equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento` (
  `equipamento_id` int(11) NOT NULL,
  `empresa_id` int(11) default NULL,
  `equipamento_descricao` varchar(255) default NULL,
  `equipamento_faixa_medicao` varchar(255) default NULL,
  `equipamento_menor_divisao` varchar(255) default NULL,
  `equipamento_modelo` varchar(255) default NULL,
  `equipamento_numero_serie` varchar(255) default NULL,
  `equipamento_tolerancia` double default NULL,
  PRIMARY KEY  (`equipamento_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `equipamento`
--
LOCK TABLES `equipamento` WRITE;
/*!40000 ALTER TABLE `equipamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamento` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `equipamento_anexo`
--
DROP TABLE IF EXISTS `equipamento_anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento_anexo` (
  `anexo_id` int(11) NOT NULL,
  `equipamento_id` int(11) NOT NULL,
  PRIMARY KEY  (`anexo_id`,`equipamento_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `equipamento_anexo`
--
LOCK TABLES `equipamento_anexo` WRITE;
/*!40000 ALTER TABLE `equipamento_anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamento_anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `equipamento_pessoa`
--
DROP TABLE IF EXISTS `equipamento_pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento_pessoa` (
  `pessoa_id` int(11) NOT NULL,
  `equipamento_id` int(11) NOT NULL,
  PRIMARY KEY  (`pessoa_id`,`equipamento_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `equipamento_pessoa`
--
LOCK TABLES `equipamento_pessoa` WRITE;
/*!40000 ALTER TABLE `equipamento_pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamento_pessoa` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `frequencia`
--
DROP TABLE IF EXISTS `frequencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frequencia` (
  `frequencia_id` int(11) NOT NULL auto_increment,
  `equipamento_id` int(11) default NULL,
  `frequencia_calibracao` varchar(255) default NULL,
  PRIMARY KEY  (`frequencia_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `frequencia`
--
LOCK TABLES `frequencia` WRITE;
/*!40000 ALTER TABLE `frequencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `frequencia` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `intervencao`
--
DROP TABLE IF EXISTS `intervencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervencao` (
  `intervencao_id` int(11) NOT NULL auto_increment,
  `empresa_id` int(11) default NULL,
  `equipamento_id` int(11) default NULL,
  `intervencao_aceita_por` varchar(255) default NULL,
  `intervencao_data` date default NULL,
  `intervencao_empresa_codigo_laudo` varchar(255) default NULL,
  `intervencao_observacao` varchar(255) default NULL,
  `intervencao_tipo_id` varchar(255) default NULL,
  PRIMARY KEY  (`intervencao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `intervencao`
--
LOCK TABLES `intervencao` WRITE;
/*!40000 ALTER TABLE `intervencao` DISABLE KEYS */;
/*!40000 ALTER TABLE `intervencao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `intervencao_anexo`
--
DROP TABLE IF EXISTS `intervencao_anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervencao_anexo` (
  `intervencao_id` int(11) NOT NULL,
  `anexo_id` int(11) NOT NULL,
  PRIMARY KEY  (`intervencao_id`,`anexo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `intervencao_anexo`
--
LOCK TABLES `intervencao_anexo` WRITE;
/*!40000 ALTER TABLE `intervencao_anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `intervencao_anexo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `intervencao_tipo`
--
DROP TABLE IF EXISTS `intervencao_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `intervencao_tipo` (
  `intervencao_tipo_id` varchar(255) NOT NULL,
  PRIMARY KEY  (`intervencao_tipo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `intervencao_tipo`
--
LOCK TABLES `intervencao_tipo` WRITE;
/*!40000 ALTER TABLE `intervencao_tipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `intervencao_tipo` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `laudo_intervencao`
--
DROP TABLE IF EXISTS `laudo_intervencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laudo_intervencao` (
  `laudo_intervencao_id` int(11) NOT NULL auto_increment,
  `intervencao_id` int(11) default NULL,
  `laudo_intervencao_incerteza_medicoes` double default NULL,
  `laudo_intervencao_media_medicoes` double default NULL,
  `laudo_intervencao_valor_padrao` double default NULL,
  `sistema_medicao_id` varchar(255) default NULL,
  PRIMARY KEY  (`laudo_intervencao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `laudo_intervencao`
--
LOCK TABLES `laudo_intervencao` WRITE;
/*!40000 ALTER TABLE `laudo_intervencao` DISABLE KEYS */;
/*!40000 ALTER TABLE `laudo_intervencao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `pessoa`
--
DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `pessoa_id` int(11) NOT NULL auto_increment,
  `pessoa_cpf` varchar(255) default NULL,
  `pessoa_email` varchar(255) default NULL,
  `pessoa_nome` varchar(255) default NULL,
  PRIMARY KEY  (`pessoa_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `pessoa`
--
LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'345.957.308-29','vitor.lima@unifesp.br','Vitor Lima');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `sistema_medicao`
--
DROP TABLE IF EXISTS `sistema_medicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sistema_medicao` (
  `sistema_medicao_id` varchar(255) NOT NULL,
  PRIMARY KEY  (`sistema_medicao_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `sistema_medicao`
--
LOCK TABLES `sistema_medicao` WRITE;
/*!40000 ALTER TABLE `sistema_medicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `sistema_medicao` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `tolerancia`
--
DROP TABLE IF EXISTS `tolerancia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tolerancia` (
  `sistema_medicao_id` varchar(255) default NULL,
  `tolerancia_valor` double default NULL,
  `equipamento_id` int(11) NOT NULL,
  `tolerancia_id` int(11) NOT NULL,
  PRIMARY KEY  (`equipamento_id`,`tolerancia_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `tolerancia`
--
LOCK TABLES `tolerancia` WRITE;
/*!40000 ALTER TABLE `tolerancia` DISABLE KEYS */;
/*!40000 ALTER TABLE `tolerancia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- Dump completed on 2013-04-03  4:25:31
