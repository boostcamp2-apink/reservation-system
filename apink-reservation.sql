use apink_reservation;
-- naver  연동 로그인을 위한 USERS테이블  : https://developers.naver.com/docs/login/devguide/ 신규시스템 네아(네이버로그인)를 이용 부분을 참고함
CREATE  TABLE USERS (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NULL ,
  `email` VARCHAR(100) NULL ,
  `tel` VARCHAR(50) NULL ,
  `nickname` VARCHAR(50) NULL ,
  `sns_id` VARCHAR(255) NULL ,
  `sns_type` varchar(10)  NULL,
  `sns_profile` varchar(255)  NULL,
  `admin_flag` INT NOT NULL,
  `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `modify_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `idx1_username` (`username` ASC) ,
  INDEX `idx2_email` (`email` ASC),
  INDEX `idx3_sns_id` (`sns_id` ASC)
);

CREATE TABLE CATEGORIES(
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `product_count` INT default 0 NOT NULL,
  PRIMARY KEY(`id`)
);

-- 상품 기본정보, 전시정보, 상세정보
-- 상품판매여부 : sales_flag - 0 : 판매안됨 1: 판매 됨
CREATE TABLE PRODUCTS (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_id` INT NOT NULL,
  `represent_file_id` INT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(100) NULL,
  `sales_start` DATETIME NOT NULL,
  `sales_end` DATETIME NULL,
  `sales_flag` INT(1) NOT NULL,
  `event` VARCHAR(4000),
  `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `modify_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `comment_count` INT default 0 NOT NULL,
  `total_score` INT default 0 NOT NULL,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`category_id`) REFERENCES CATEGORIES(`id`) ON UPDATE CASCADE ON DELETE CASCADE

);

CREATE TABLE PRODUCTS_DISPLAY(
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `observation_time` VARCHAR(100) NOT NULL,
  `display_start` DATETIME NOT NULL,
  `display_end` DATETIME NOT NULL,
  `place_name` VARCHAR(50) NOT NULL,
  `place_lot` VARCHAR(100) ,
  `place_street` VARCHAR(100),
  `tel` VARCHAR(20) ,
  `homepage` VARCHAR(255),
  `email` VARCHAR(255),
  `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `modify_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCTS(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE PRODUCTS_DETAIL(
  `product_id` INT NOT NULL,
  `content` TEXT,
  `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `modify_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY(`product_id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCTS(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE PRODUCTS_PRICES_TYPES(
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_price_type` VARCHAR(50) NOT NULL,
  `description` VARCHAR(250) NOT NULL,
  PRIMARY KEY(`id`)
);
-- price_type : 1, 일반  2 :청소년 3: 어린이 , CODE 테이블이 사실 필요하다.
CREATE TABLE PRODUCTS_PRICES (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `product_price_type_id` INT NOT NULL,
  `price` INT NOT NULL,
  `discount_rate` DECIMAL(5,2) NOT NULL,
  `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `modify_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCTS(`id`) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(`product_price_type_id`) REFERENCES PRODUCTS_PRICES_TYPES(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE FILES (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `file_name` VARCHAR(255) NOT NULL,
  `save_file_name` VARCHAR(4000) NOT NULL,
  `file_length` INT NOT NULL,
  `content_type` VARCHAR(255) NOT NULL,
  `delete_flag` INT(1) NOT NULL,
  `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `modify_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`user_id`) REFERENCES USERS(`id`)
);


-- type : 대표이미지 - 1 , 부가이미지 - 2
-- delete_flag 0 :삭제안됨, 1: 삭제된 이미지
CREATE TABLE PRODUCTS_IMAGES (
  `product_id` INT NOT NULL,
  `file_id` INT NOT NULL,
  `type` INT(1) NOT NULL,
  PRIMARY KEY(`product_id`,`file_id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCTS(`id`) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(`file_id`) REFERENCES FILES(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);


-- 예약은 상품의 스냅샷을 저장하도록 할 것인가? 아니면 그냥 상품 id만을 가지도록 할 것인가?
CREATE TABLE RESERVATIONS(
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `reservation_name` VARCHAR(50) NOT NULL,
  `reservation_tel` VARCHAR(255) NOT NULL,
  `reservation_email` VARCHAR(255) NOT NULL,
  `reservation_date` DATETIME NOT NULL,
  `reservation_type` INT,
  `total_price` INT,
  `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `modify_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCTS(`id`) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(`user_id`) REFERENCES USERS(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE RESERVATIONS_TICKETS(
	`reservation_id` INT NOT NULL,
    `product_price_id` INT NOT NULL,
    `count` INT NOT NULL,
    `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `modify_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	primary key(`reservation_id`,`product_price_id`),
    foreign key(`reservation_id`) references RESERVATIONS(`id`) ON UPDATE CASCADE ON DELETE CASCADE,
	foreign key(`product_price_id`) references PRODUCTS_PRICES(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE COMMENTS (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `score` DECIMAL(2,1) NOT NULL,
  `comment` TEXT NOT NULL,
  `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `modify_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES PRODUCTS(`id`) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(`user_id`) REFERENCES USERS(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE COMMENTS_IMAGES (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comment_id` INT NOT NULL,
  `file_id` INT NOT NULL,
  `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  `modify_date` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`comment_id`) REFERENCES COMMENTS(`id`) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY(`file_id`) REFERENCES FILES(`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

