CREATE database IF NOT EXISTS `finalt13` ;

USE `finalt13` ;

-- -----------------------------------------------------
-- Table `finalt13`.`tbl_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finalt13`.`tbl_usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `linkfoto` VARCHAR(200) NULL DEFAULT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `racf` VARCHAR(7) NOT NULL,
  `senha` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_email_usuario` (`email`) ,
  UNIQUE KEY `UK_racf_usuario` (`racf`) );

-- -----------------------------------------------------
-- INSERTION ON `tbl_usuario`
-- -----------------------------------------------------

insert into tbl_usuario values (null, 'emerson@paduan.pro.br', 'https://hennesseyonline.com/wp-content/uploads/2015/05/staff-placeholder-male.jpg', 'Emerson Paduan', '12345', '1234');

-- -----------------------------------------------------
-- Table `finalt13`.`itmn_comunidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finalt13`.`itmn_comunidade` (
  `id_comunidade` INT NOT NULL AUTO_INCREMENT,
  `nome_comunidade` VARCHAR(100) NOT NULL,
  `id_usuario` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_comunidade`),
  KEY `FK_comunidade_usuario` (`id_usuario`),
  CONSTRAINT `FK_comunidade_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `finalt13`.`tbl_usuario` (`id`));

-- -----------------------------------------------------
-- INSERTION ON `tbl_comunidade`
-- -----------------------------------------------------

insert into itmn_comunidade values (null, 'Comunidade 01', 1);
insert into itmn_comunidade values (null, 'Comunidade 02', 1);

-- -----------------------------------------------------
-- Table `finalt13`.`itmn_modernizacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finalt13`.`itmn_modernizacao` (
  `num_seq` INT NOT NULL AUTO_INCREMENT,
  `data_modernizacao` DATE NULL DEFAULT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  `percentual` FLOAT NULL DEFAULT NULL,
  `id_comunidade` INT NULL DEFAULT NULL,
  PRIMARY KEY (`num_seq`),
  KEY `FK_modernizacao_usuario` (`id_comunidade`),
  CONSTRAINT `FK_modernizacao_usuario`
    FOREIGN KEY (`id_comunidade`)
    REFERENCES `finalt13`.`itmn_comunidade` (`id_comunidade`));

