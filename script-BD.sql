drop database finalt13;

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

use finalt13;

INSERT INTO `finalt13`.`itmn_modernizacao` (`data_modernizacao`, `descricao`, `percentual`, `id_comunidade`) VALUES ('2021-01-22', 'Evolução Mobile Pessoa Física', '10', '1');

UPDATE `finalt13`.`itmn_comunidade` SET `nome_comunidade` = 'Canais' WHERE (`id_comunidade` = '1');
UPDATE `finalt13`.`itmn_comunidade` SET `nome_comunidade` = 'Pagamentos' WHERE (`id_comunidade` = '2');
INSERT INTO `finalt13`.`itmn_comunidade` (`nome_comunidade`, `id_usuario`) VALUES ('Cartoes', '1');
INSERT INTO `finalt13`.`itmn_comunidade` (`nome_comunidade`, `id_usuario`) VALUES ('Iti', '1');

INSERT INTO `finalt13`.`tbl_usuario` (`email`, `linkfoto`, `nome`, `racf`, `senha`) VALUES ('marina@itau.com.br', '../images/foto_marina.png', 'Marina Hamada', 'yhamada', '111111');

UPDATE `finalt13`.`itmn_comunidade` SET `id_usuario` = '2' WHERE (`id_comunidade` = '2');
UPDATE `finalt13`.`itmn_comunidade` SET `id_usuario` = '2' WHERE (`id_comunidade` = '3');

select * from tbl_usuario;
select * from itmn_comunidade;
select * from itmn_modernizacao;

desc tbl_usuario;
desc itmn_comunidade;
desc itmn_modernizacao;