-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema professores
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `professores`;

-- -----------------------------------------------------
-- Schema professores
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `professores` DEFAULT CHARACTER SET utf8;
USE `professores` ;

-- -----------------------------------------------------
-- Table `professores`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `professores`.`professor` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(50) NOT NULL,
    `titulacao` VARCHAR(45) NOT NULL,
    `instituto_id` INT NOT NULL,
    PRIMARY KEY(`id`, `instituto_id`),
    UNIQUE INDEX `id_UNIQUE`(`id` ASC) VISIBLE,
    INDEX `fk_proessor_instituto_idx`(`instituto_id` ASC) VISIBLE,
    CONSTRAINT `fk_professor_instituto` FOREIGN KEY(`instituto_id`) REFERENCES `professores`.`instituto`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
    ) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `professores`.`instituto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `professores`.`instituto`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `nome` VARCHAR(50) NOT NULL,
    `sigla` VARCHAR(10) NOT NULL,
    UNIQUE INDEX `id_UNIQUE`(`id` ASC) VISIBLE)
    ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;