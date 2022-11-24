-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`achvm`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`achvm` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` VARCHAR(100) NOT NULL,
  `img_src` VARCHAR(200) NOT NULL,
  `reward` INT NULL,
  `hidden` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`title` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `pw_find_question_id` INT NOT NULL,
  `pw_find_answer` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NULL DEFAULT NULL,
  `height` INT NULL DEFAULT '0',
  `weight` DOUBLE NULL DEFAULT '0',
  `body_fat` DOUBLE NULL DEFAULT NULL,
  `muscle_mass` DOUBLE NULL DEFAULT '0',
  `point` INT NULL DEFAULT '0',
  `rprsn_achvm_id` INT NULL,
  PRIMARY KEY (`seq`),
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(45) NULL DEFAULT NULL,
  `reg_date` DATE NULL DEFAULT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_user1_idx` (`user_seq` ASC) VISIBLE,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`user` (`seq`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`exercise_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`exercise_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `part` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`pw_find_question_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pw_find_question_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `question` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`quotes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`quotes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`record` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_seq` INT NOT NULL,
  `reg_date` DATE NOT NULL,
  `exercise_part` VARCHAR(45) NOT NULL,
  `exercise_name` VARCHAR(45) NOT NULL,
  `set_cnt` INT NULL DEFAULT '0',
  `time_cnt` INT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  INDEX `fk_diary_user_idx` (`user_seq` ASC) VISIBLE,
  CONSTRAINT `fk_diary_user`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`user` (`seq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`user_achvm_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_achvm_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_seq` INT NOT NULL,
  `achvm_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_achievement_list_user1_idx` (`user_seq` ASC) VISIBLE,
  INDEX `fk_user_achvm_list_achvm1_idx` (`achvm_id` ASC) VISIBLE,
  CONSTRAINT `fk_achievement_list_user1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`user` (`seq`),
  CONSTRAINT `fk_user_achvm_list_achvm1`
    FOREIGN KEY (`achvm_id`)
    REFERENCES `mydb`.`achvm` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`quest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`quest` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `due_date` DATE NULL,
  `type` INT NULL,
  `goal` INT NULL,
  `modify_cnt` INT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_quest_user1_idx` (`user_seq` ASC) VISIBLE,
  CONSTRAINT `fk_quest_user1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`user` (`seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO achvm VALUES
(0, '물먹는 하마', '7일 연속으로 물을 3잔씩 마셨다!', '대충 이미지링크1', 50, 0),
(0, '헬창의 삶', '7일 연속으로 헬스장에 출석했다!', '대충 이미지링크2', 100, 1),
(0, '월요병 극복', '5주 연속으로 월요일에 헬스장에 출석했다!', '대충 이미지링크3', 60, 0),
(0, '계란 한 판!', '30일 연속으로 헬스장에 출석했다!', '대충 이미지링크4', 500, 1);

INSERT INTO pw_find_question_list
VALUES (0, "어머니의 성함은?"), (0, "아버지의 성함은?"), (0, "학창시절 별명은?"), (0, "기억에 남는 추억의 장소는?"), (0, "자신의 인생 좌우명은?"),
(0, "좋아하는 동물은?"), (0, "인상 깊게 읽은 책 제목은?"), (0, "자신의 보물 1호는?");


INSERT INTO quotes
VALUES (0, "먹어봤자 내가 아는 그 맛"), (0, "맛과 멋은 같이 갈 수 없다"), (0, "오늘 걷지 않으면 내일은 뛰어야 한다."), (0, "뇌세포는 죽지만 비만세포는 죽지 않는다"),
(0, "다이어트는 변화이자 신선한 자극이다. 그러기 위해선 내가 변해야 한다."), (0, "인생은 살이 쪘을 때와 안 쪘을 때로 나뉜다."), (0, "먹는데 1분 빼는데 1시간"),
(0, "몸매가 곧 패션이다"), (0, "음식이 아깝다고 생각하지 말고 네 몸이 아깝다고 생각해라"), (0, "땀은 지방의 눈물이다"), (0, "먹는 것을 줄여야 맞는 옷이 늘어난다"),
(0, "천천히 빠지는 살은 있어도 안 빠지는 살은 없다"), (0, "체중조절은 최고의 자기 관리"), (0, "힘들지 않으면 바뀌지 않는다"), (0, "내일이 곧 평생이 된다"),
(0, "고통은 지나가지만 아름다움은 남는다"), (0, "한 순간에 만들어지는 것은 아무것도 없다"), (0, "편안함도 욕심이다"),
(0, "먹어도 안 찌는 체질은 없다"), (0, "세상에서 내 의지로 바꾸기 가장 쉬운 것이 바로 몸이다");

INSERT INTO quest VALUES
        (0, date_format(now(), '%Y-%m-%d'), 1, 40, 0, 11);
        
INSERT INTO record VALUES
(0, 11, "2022-11-11", "상체", "체스트프레스", 8, 0),
(0, 11, "2022-11-11", "하체", "레그프레스", 5, 0),
(0, 11, "2022-11-11", "유산소", "체스트프레스", 0, 40);

INSERT INTO exercise_list VALUES
(0, "체스트프레스", "상체"),
(0, "레그프레스", "하체"),
(0, "달리기", "유산소"),
(0, "랫풀다운", "상체"),
(0, "숄더프레스", "상체"),
(0, "데드리프트", "코어");
