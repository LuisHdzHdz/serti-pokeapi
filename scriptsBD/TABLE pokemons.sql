CREATE TABLE `pokeapi`.`pokemons` (
  `idpokemons` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `base_experience` INT NULL,
  `height` INT NULL,
  `is_default` TINYINT NULL,
  `order` INT NULL,
  `weight` INT NULL,
  PRIMARY KEY (`idpokemons`),
  UNIQUE INDEX `idpokemons_UNIQUE` (`idpokemons` ASC) VISIBLE);