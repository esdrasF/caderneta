SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `notas` ;
CREATE SCHEMA IF NOT EXISTS `notas` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `notas` ;

-- -----------------------------------------------------
-- Table `notas`.`TB_Serie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notas`.`TB_Serie` ;

CREATE  TABLE IF NOT EXISTS `notas`.`TB_Serie` (
  `TbSerie_id` INT NOT NULL AUTO_INCREMENT ,
  `serie` INT NOT NULL ,
  `status` VARCHAR(1) NOT NULL ,
  PRIMARY KEY (`TbSerie_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `notas`.`TB_Endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notas`.`TB_Endereco` ;

CREATE  TABLE IF NOT EXISTS `notas`.`TB_Endereco` (
  `TbEndereco_id` INT NOT NULL AUTO_INCREMENT ,
  `logradouro` VARCHAR(255) NULL ,
  `complemento` VARCHAR(50) NULL ,
  `numero` VARCHAR(10) NULL ,
  `bairro` VARCHAR(45) NULL ,
  `cep` VARCHAR(9) NULL ,
  `cidade` VARCHAR(50) NULL ,
  `estado` VARCHAR(50) NULL ,
  PRIMARY KEY (`TbEndereco_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `notas`.`TB_AnoLetivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notas`.`TB_AnoLetivo` ;

CREATE  TABLE IF NOT EXISTS `notas`.`TB_AnoLetivo` (
  `TbAnoLetivo_id` INT NOT NULL AUTO_INCREMENT ,
  `ano` INT NOT NULL ,
  `status` CHAR NULL ,
  PRIMARY KEY (`TbAnoLetivo_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `notas`.`TB_Aluno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notas`.`TB_Aluno` ;

CREATE  TABLE IF NOT EXISTS `notas`.`TB_Aluno` (
  `alu_id` INT NOT NULL AUTO_INCREMENT ,
  `alu_nome` VARCHAR(255) NULL ,
  `alu_sexo` VARCHAR(1) NULL ,
  `alu_dataNasc` VARCHAR(10) NULL ,
  `alu_naturalidade` VARCHAR(45) NULL ,
  `alu_nacionalidade` VARCHAR(45) NULL ,
  `alu_deficiencia` VARCHAR(3) NULL ,
  `alu_descDeficiencia` VARCHAR(45) NULL ,
  `alu_comoAluVaiAEscola` VARCHAR(45) NULL ,
  `alu_paisSeparados` VARCHAR(3) NULL ,
  `alu_fone` VARCHAR(13) NULL ,
  `alu_foneContato1` VARCHAR(10) NULL ,
  `alu_nomeContato1` VARCHAR(20) NULL ,
  `alu_foneContato2` VARCHAR(10) NULL ,
  `alu_nomeContato2` VARCHAR(20) NULL ,
  `alu_foneContato3` VARCHAR(10) NULL ,
  `alu_nomeContato3` VARCHAR(20) NULL ,
  `alu_email` VARCHAR(50) NULL ,
  `alu_status` CHAR NOT NULL ,
  `alu_dataMatricula` DATE NOT NULL ,
  `serie_ser_id` INT NOT NULL ,
  `endereco_endereco_id` INT NOT NULL ,
  `anoLetivo_anoLetivo_id` INT NOT NULL ,
  PRIMARY KEY (`alu_id`) ,
  CONSTRAINT `fk_aluno_serie`
    FOREIGN KEY (`serie_ser_id` )
    REFERENCES `notas`.`TB_Serie` (`TbSerie_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_endereco1`
    FOREIGN KEY (`endereco_endereco_id` )
    REFERENCES `notas`.`TB_Endereco` (`TbEndereco_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_anoLetivo1`
    FOREIGN KEY (`anoLetivo_anoLetivo_id` )
    REFERENCES `notas`.`TB_AnoLetivo` (`TbAnoLetivo_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '						';


-- -----------------------------------------------------
-- Table `notas`.`TB_Caderneta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notas`.`TB_Caderneta` ;

CREATE  TABLE IF NOT EXISTS `notas`.`TB_Caderneta` (
  `notas_id` INT NOT NULL AUTO_INCREMENT ,
  `notas_mensal1` DOUBLE NULL ,
  `notas_mensal2` DOUBLE NULL ,
  `notas_mensal3` DOUBLE NULL ,
  `notas_mensal4` DOUBLE NULL ,
  `notas_bimestral1` DOUBLE NULL ,
  `notas_bimestral2` DOUBLE NULL ,
  `notas_bimestral3` DOUBLE NULL ,
  `notas_bimestral4` DOUBLE NULL ,
  `notas_media1` DOUBLE NULL ,
  `notas_media2` DOUBLE NULL ,
  `notas_media3` DOUBLE NULL ,
  `notas_media4` DOUBLE NULL ,
  `notas_recuperacao1` DOUBLE NULL ,
  `notas_recuperacao2` DOUBLE NULL ,
  `notas_recuperacao3` DOUBLE NULL ,
  PRIMARY KEY (`notas_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `notas`.`TB_Pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notas`.`TB_Pessoa` ;

CREATE  TABLE IF NOT EXISTS `notas`.`TB_Pessoa` (
  `TbPessoa_id` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(255) NULL ,
  `cpf` VARCHAR(14) NULL ,
  `rg` VARCHAR(20) NULL ,
  `fone1` VARCHAR(13) NULL ,
  `fone2` VARCHAR(13) NULL ,
  `email` VARCHAR(50) NULL ,
  `profissao` VARCHAR(45) NULL ,
  `TB_Endereco_id` INT NOT NULL ,
  PRIMARY KEY (`TbPessoa_id`) ,
  CONSTRAINT `fk_TB_Pessoa_TB_Endereco1`
    FOREIGN KEY (`TB_Endereco_id` )
    REFERENCES `notas`.`TB_Endereco` (`TbEndereco_id` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `notas`.`TB_Filiacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notas`.`TB_Filiacao` ;

CREATE  TABLE IF NOT EXISTS `notas`.`TB_Filiacao` (
  `TB_Aluno_id` INT NOT NULL ,
  `TB_Pessoa_id` INT NOT NULL ,
  PRIMARY KEY (`TB_Aluno_id`, `TB_Pessoa_id`) ,
  CONSTRAINT `fk_TB_Aluno_has_TB_Pessoa_TB_Aluno1`
    FOREIGN KEY (`TB_Aluno_id` )
    REFERENCES `notas`.`TB_Aluno` (`alu_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_TB_Aluno_has_TB_Pessoa_TB_Pessoa1`
    FOREIGN KEY (`TB_Pessoa_id` )
    REFERENCES `notas`.`TB_Pessoa` (`TbPessoa_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `notas`.`TB_Turma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notas`.`TB_Turma` ;

CREATE  TABLE IF NOT EXISTS `notas`.`TB_Turma` (
  `TbTurma_id` INT NOT NULL AUTO_INCREMENT ,
  `turma` CHAR NULL ,
  PRIMARY KEY (`TbTurma_id`) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
