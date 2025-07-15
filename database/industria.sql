-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: industria_db
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionarios` (
  `id_funcionario` int NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `cargo` text,
  `id_setor` int NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  KEY `id_setor` (`id_setor`),
  CONSTRAINT `funcionarios_ibfk_1` FOREIGN KEY (`id_setor`) REFERENCES `setores` (`id_setor`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (1,'Carlos Silva','Analista de Produção',1),(2,'Ana Costa','Coordenadora de Vendas',2),(3,'Roberto Souza','Supervisor de Produção',1),(4,'Julia Almeida','Gerente de RH',3),(5,'Marcos Pereira','Vendedor',2),(6,'Fernanda Oliveira','Assistente Administrativa',3),(7,'Paulo Santos','Técnico de Manutenção',1),(8,'Claudia Lima','Assistente de Vendas',2),(9,'Ricardo Martins','Supervisor de Produção',1),(10,'Camila Rocha','Gerente de TI',3),(11,'Pedro Azevedo','Coordenador de Produção',1),(12,'Larissa Fonseca','Assistente Administrativa',3),(13,'Lucas Pinto','Analista de TI',1),(14,'Gabriela Nunes','Consultora de Vendas',2),(15,'Vinícius Lima','Técnico de Produção',1),(16,'Luana Pereira','Coordenadora de Marketing',3),(17,'José Ramos','Gerente de Produção',1),(18,'Tatiane Duarte','Vendedora',2),(19,'Eduardo Barbosa','Assistente de Produção',1),(20,'Simone Rodrigues','Assistente de Vendas',2);
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producao`
--

DROP TABLE IF EXISTS `producao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producao` (
  `id_producao` int NOT NULL AUTO_INCREMENT,
  `id_produto` int NOT NULL,
  `id_funcionario` int NOT NULL,
  `data_producao` date NOT NULL,
  `quantidade` int NOT NULL,
  PRIMARY KEY (`id_producao`),
  KEY `id_produto` (`id_produto`),
  KEY `id_funcionario` (`id_funcionario`),
  CONSTRAINT `producao_ibfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id_produto`),
  CONSTRAINT `producao_ibfk_2` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionarios` (`id_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producao`
--

LOCK TABLES `producao` WRITE;
/*!40000 ALTER TABLE `producao` DISABLE KEYS */;
INSERT INTO `producao` VALUES (1,1,1,'2023-06-01',100),(2,2,2,'2023-06-02',200),(3,3,3,'2023-06-03',150),(4,4,4,'2023-06-04',120),(5,5,5,'2023-06-05',180),(6,6,6,'2023-06-06',130),(7,7,7,'2023-06-07',140),(8,8,8,'2023-06-08',110),(9,9,9,'2023-06-09',160),(10,10,10,'2023-06-10',170),(11,11,11,'2023-06-11',190),(12,12,12,'2023-06-12',210),(13,13,13,'2023-06-13',140),(14,14,14,'2023-06-14',120),(15,15,15,'2023-06-15',200),(16,16,16,'2023-06-16',180),(17,17,17,'2023-06-17',150),(18,18,18,'2023-06-18',160),(19,19,19,'2023-06-19',110),(20,20,20,'2023-06-20',130);
/*!40000 ALTER TABLE `producao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `id_produto` int NOT NULL AUTO_INCREMENT,
  `nome_produto` text NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'Produto A','Produto utilizado em sistemas hidráulicos e industriais.'),(2,'Produto B','Equipamento para medição de pressão de alta precisão.'),(3,'Produto C','Componente eletrônico de baixo consumo de energia.'),(4,'Produto D','Material de construção de alta resistência.'),(5,'Produto E','Peça automotiva para motores de combustão interna.'),(6,'Produto F','Instrumento de análise de dados para laboratório.'),(7,'Produto G','Tecnologia para comunicação sem fio de longo alcance.'),(8,'Produto H','Dispositivo para controle de temperatura em fornos.'),(9,'Produto I','Acessório de segurança para trabalho industrial pesado.'),(10,'Produto J','Equipamento de proteção contra radiação UV.'),(11,'Produto K','Solução prática para armazenamento de dados digitais.'),(12,'Produto L','Equipamento para testagem de componentes elétricos.'),(13,'Produto M','Produto orgânico para fertilização de solo.'),(14,'Produto N','Material reciclado para construção sustentável.'),(15,'Produto O','Dispositivo de segurança para transporte de cargas.'),(16,'Produto P','Equipamento para medição de vazão de líquidos.'),(17,'Produto Q','Sistema para automação de processos industriais.'),(18,'Produto R','Ferramenta de corte para metais de alta dureza.'),(19,'Produto S','Equipamento para monitoramento de qualidade ambiental.'),(20,'Produto T','Tecnologia para análise e controle de redes elétricas.');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setores`
--

DROP TABLE IF EXISTS `setores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setores` (
  `id_setor` int NOT NULL AUTO_INCREMENT,
  `nome_setor` text NOT NULL,
  `responsavel` text,
  PRIMARY KEY (`id_setor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setores`
--

LOCK TABLES `setores` WRITE;
/*!40000 ALTER TABLE `setores` DISABLE KEYS */;
INSERT INTO `setores` VALUES (1,'Produção','Carlos Silva'),(2,'Vendas','Ana Costa'),(3,'Administração','Julia Almeida');
/*!40000 ALTER TABLE `setores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-14 21:18:50
