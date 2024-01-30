create table department(
ID char(5),
name varchar(40) not null,
budget numeric(8,2),
primary key(ID))

create table instructor(
ID char(5),
name varchar(40) not null,
salary numeric(8,2),
dept_id char(5),
primary key(ID),
foreign key(dept_id) references department(ID))

create table student(
ID char(5),
name varchar(40) not null,
tot_cred numeric(8,2),
dept_id char(5),
advisor_id char(5),
primary key(ID),
foreign key(dept_id) references department(ID),
foreign key(advisor_id) references instructor(ID))

create table course(
ID char(5),
title varchar(40) not null,
credits smallint,
dept_id char(5),
primary key(ID),
foreign key(dept_id) references department(ID))

create table timeslot(
ID char(5),
day varchar(20),
start_time varchar(40),
end_time varchar(40),
primary key(ID))

create table classroom(
building varchar(5),
room_number smallint,
capacity int,
primary key(building, room_number))

create table section(
ID char(5),
semester varchar(40),
year int,
course_id char(5),
ins_id char(5),
building varchar(5),
room_number smallint,
slot_id char(5),
primary key(ID,semester,year,course_id),
foreign key(course_id) references course(ID),
foreign key(ins_id) references instructor(ID),
foreign key(slot_id) references timeslot(ID),
foreign key(building,room_number) references classroom(building,room_number))

create table prereq(
course_id char(5),
prereq_id char(5),
primary key(course_id,prereq_id),
foreign key(course_id) references course(ID))

create table takes(
std_id char(5),
sec_id char(5),
semester varchar(40),
year int,
course_id char(5),
grade smallint,
primary key(std_id, sec_id, semester, year, course_id),
foreign key(std_id) references student(ID),
foreign key(sec_id,year,semester,course_id) references section(ID,year,semester,course_id))