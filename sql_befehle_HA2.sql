drop table HA2_roles cascade constraints;
create table HA2_roles (
rolename varchar(20) not null primary key
);

drop table HA2_user_roles cascade constraints;
create table HA2_user_roles (
username varchar(20) not null,
rolename varchar(20) not null,
primary key (username, rolename),
constraint user_roles_fk1 foreign key(username) references HA2_user(username),
constraint user_roles_fk2 foreign key(rolename) references HA2_roles(rolename)
);

insert into HA2_user (id, username, password) values (1, 'hugo', '123');
insert into HA2_user (id, username, password) values (2, 'susi', '123');
insert into HA2_roles (rolename) values ('MATERIALMANAGER');
insert into HA2_roles (rolename) values ('ARZT');
insert into HA2_user_roles (username, rolename) values ('hugo', 'MATERIALMANAGER');
insert into HA2_user_roles (username, rolename) values ('susi', 'ARZT');