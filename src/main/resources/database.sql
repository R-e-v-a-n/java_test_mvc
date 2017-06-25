-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,

  PRIMARY KEY(id)
)
  ENGINE = InnoDB;

-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role_id INT NOT NULL,

  PRIMARY KEY(id),
  UNIQUE(username),
  FOREIGN KEY(role_id) REFERENCES roles(id)
)
  ENGINE = InnoDB;

-- Insert data
INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO users VALUES (1, 'admin', '$2a$11$euOWBMHVmiOVtR/nvS4bLuWKOmbGtS8Ac89pw8Wdhs.p5xWnL7j5y', 2);