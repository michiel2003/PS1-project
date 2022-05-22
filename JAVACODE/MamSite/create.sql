create table image (id integer not null auto_increment, height integer, url varchar(255), width integer, primary key (id));
create table option (id integer not null auto_increment, option varchar(255), primary key (id));
create table question (id integer not null auto_increment, mail varchar(255), message varchar(255), naam varchar(255), subject varchar(255), primary key (id));
