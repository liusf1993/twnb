CREATE TABLE Article
(
  id INT(11) NOT NULL AUTO_INCREMENT,
  title CHAR(100) NOT NULL,
  content BLOB,
  author VARCHAR(30),
  publishdate DATETIME,
  comment BLOB,
  CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);
CREATE TABLE User
(
  id INT(11) NOT NULL COMMENT 'User infomation' AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255),
  email VARCHAR(255),
  phone VARCHAR(255),
  sex VARCHAR(1) COMMENT '0 female,1male',
  company VARCHAR(255),
  name VARCHAR(255) COMMENT 'nickname',
  CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);
CREATE UNIQUE INDEX USER_INDEX ON User (username);