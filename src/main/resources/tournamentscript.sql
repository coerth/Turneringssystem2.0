-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Tournament
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Tournament
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Tournament` DEFAULT CHARACTER SET utf8 ;
USE `Tournament` ;

-- -----------------------------------------------------
-- Table `Tournament`.`Tournament`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Tournament`.`Tournament` ;

CREATE TABLE IF NOT EXISTS `Tournament`.`Tournament` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `registration_date` DATE NULL,
  `game_type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tournament`.`Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Tournament`.`Team` ;

CREATE TABLE IF NOT EXISTS `Tournament`.`Team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tournament`.`Match`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Tournament`.`Match` ;

CREATE TABLE IF NOT EXISTS `Tournament`.`Match` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `Tournament_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Match_Tournament1_idx` (`Tournament_id` ASC) VISIBLE,
  CONSTRAINT `fk_Match_Tournament1`
    FOREIGN KEY (`Tournament_id`)
    REFERENCES `Tournament`.`Tournament` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tournament`.`Match_has_Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Tournament`.`Match_has_Team` ;

CREATE TABLE IF NOT EXISTS `Tournament`.`Match_has_Team` (
  `Match_id` INT NOT NULL,
  `Team_id` INT NOT NULL,
  PRIMARY KEY (`Match_id`, `Team_id`),
  INDEX `fk_Match_has_Team_Team1_idx` (`Team_id` ASC) VISIBLE,
  INDEX `fk_Match_has_Team_Match1_idx` (`Match_id` ASC) VISIBLE,
  CONSTRAINT `fk_Match_has_Team_Match1`
    FOREIGN KEY (`Match_id`)
    REFERENCES `Tournament`.`Match` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Match_has_Team_Team1`
    FOREIGN KEY (`Team_id`)
    REFERENCES `Tournament`.`Team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tournament`.`Tournament_has_Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Tournament`.`Tournament_has_Team` ;

CREATE TABLE IF NOT EXISTS `Tournament`.`Tournament_has_Team` (
  `Tournament_id` INT NOT NULL,
  `Team_id` INT NOT NULL,
  PRIMARY KEY (`Tournament_id`, `Team_id`),
  INDEX `fk_Tournament_has_Team_Team1_idx` (`Team_id` ASC) VISIBLE,
  INDEX `fk_Tournament_has_Team_Tournament1_idx` (`Tournament_id` ASC) VISIBLE,
  CONSTRAINT `fk_Tournament_has_Team_Tournament1`
    FOREIGN KEY (`Tournament_id`)
    REFERENCES `Tournament`.`Tournament` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tournament_has_Team_Team1`
    FOREIGN KEY (`Team_id`)
    REFERENCES `Tournament`.`Team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
