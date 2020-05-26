CREATE TABLE `angajati` (
	`firstName` VARCHAR(255) NOT NULL,
	`lastName` VARCHAR(255) NOT NULL,
	`domeniul` VARCHAR(255) NOT NULL,
	`status` INTEGER NOT NULL,
	PRIMARY KEY (`firstName`)
);

CREATE TABLE `manageri` (
	`firstName` VARCHAR(255) NOT NULL,
	`lastName` VARCHAR(255) NOT NULL,
	`domeniul` VARCHAR(255) NOT NULL,
	`status` INTEGER NOT NULL,
	PRIMARY KEY (`firstName`)
);
CREATE TABLE `sefi` (
	`firstName` VARCHAR(255) NOT NULL,
	`lastName` VARCHAR(255) NOT NULL,
	`domeniul` VARCHAR(255) NOT NULL,
	`status` INTEGER NOT NULL,
	PRIMARY KEY (`firstName`)
);
CREATE TABLE `proiecte` (
	`name` VARCHAR(255) NOT NULL,
	PRIMARY KEY(`name`)
);
