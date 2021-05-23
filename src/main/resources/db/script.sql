CREATE TABLE role (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  description varchar(100) DEFAULT NULL,
  role_name varchar(50) DEFAULT NULL
) ENGINE=INNODB;

CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username varchar(50) NOT NULL,
  password varchar(255) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  document varchar(15) NOT NULL,
  phone varchar(20) NOT NULL,
  email varchar(50) NOT NULL
)ENGINE=INNODB;

CREATE TABLE user_role (
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  CONSTRAINT FK_SECURITY_USER_ID FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT FK_SECURITY_ROLE_ID FOREIGN KEY (role_id) REFERENCES role (id)
);

-- USERS
-- non-encrypted password: letmein
INSERT INTO users (username, password, first_name, last_name, document, phone, email) VALUES
('admin', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Administrator', 'Adminstrator', '2345467', '321354685', 'admin@yahoo.com'),
('csr_jane', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Jane', 'Doe', '2345467', '321354001', 'jane@yahoo.com'),
('csr_mark', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Mark', 'Smith', '456786453', '321354601', 'mark@yahoo.com'),
('wally', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu', 'Walter', 'Adams', '64897684', '321354600', 'wally@yahoo.com');

insert into users (username, password, first_name, last_name, document, phone, email) values
('strays0', 'NzMD4DFBKs', 'Saundra', 'Trays', '0064346005', '1053072807', 'strays0@yahoo.com')
, ('sgoodright1', 'fOtam22vLRK', 'Stafford', 'Goodright', '9946576775', '2392048969', 'sgoodright1@wikipedia.org')
, ('vseydlitz2', 'ra1cLk', 'Vivyanne', 'Seydlitz', '4638071112', '4353068165', 'vseydlitz2@abc.net.au')
, ('amacterrelly3', 'ufe4N7IHa', 'Abbi', 'MacTerrelly', '3154953418', '2987680535', 'amacterrelly3@cbslocal.com')
, ('bcarmel4', 'Gthopsqnbdn', 'Blane', 'Carmel', '3002903787', '3243318973', 'bcarmel4@hexun.com')
, ('cfer5', 'LSztkO', 'Conny', 'Fer', '3811034065', '9987447784', 'cfer5@gnu.org')
, ('mdebrett6', 'q0lsfX', 'Min', 'De Brett', '4673120604', '4807828545', 'mdebrett6@rediff.com')
, ('tackenhead7', 'Ccii67BIkD1t', 'Thia', 'Ackenhead', '2531134492', '4317589176', 'tackenhead7@marriott.com')
, ('dtitt8', '9W5Yus', 'Drud', 'Titt', '9155435114', '9346809629', 'dtitt8@accuweather.com')
, ('wskehan9', 'Ir6Ki2l9nuqJ', 'Wadsworth', 'Skehan', '5316196414', '5368941098', 'wskehan9@cnbc.com')

INSERT INTO role (id, role_name, description) VALUES
 (1, 'ROLE_ADMIN', 'Administrator')
, (2, 'ROLE_CSR', 'Customer Service Register')
, (3, 'ROLE_USER', 'User');

CREATE TABLE trademark(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50)
    )ENGINE=INNODB;

CREATE TABLE typedevice(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50)
    )ENGINE=INNODB;

CREATE TABLE device (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  serial varchar(30) NOT NULL,
  plaque varchar(15) NOT NULL,
  observation varchar(150) NOT NULL,
  state char(1) NOT NULL,
  idtrademark BIGINT NOT NULL,
  idtypedevice BIGINT NOT NULL,
  CONSTRAINT FK_DEVICE_TRADEMARK FOREIGN KEY (idtrademark) REFERENCES trademark (id),
  CONSTRAINT FK_DEVICE_TYPE_DEVICE FOREIGN KEY (idtypedevice) REFERENCES typedevice (id)
)ENGINE=INNODB;

