-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `LegoDB` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
USE `LegoDB` ;

-- -----------------------------------------------------
-- Table `LegoDB`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LegoDB`.`user`;
CREATE TABLE IF NOT EXISTS `LegoDB`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `LegoDB`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LegoDB`.`Order`;
CREATE TABLE IF NOT EXISTS `LegoDB`.`Order` (
  `OrderID` INT(11) NOT NULL AUTO_INCREMENT,
  `Height` INT(11) NOT NULL,
  `LenX` INT(11) NOT NULL,
  `LenY` INT(11) NOT NULL,
  `numberOfBricks` INT(11) NOT NULL,
  `TotalPrice` INT(11) NOT NULL,
  `Created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`OrderID`, `user_id`),
  INDEX `fk_Order_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_Order_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `LegoDB`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1001
DEFAULT CHARACTER SET = latin1;

USE `LegoDB` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
