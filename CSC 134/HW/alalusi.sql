create table Candidateyalaa(
Candidateyalaa_id number,
First_name varchar(50),
Last_name varchar(50),
DOB date,
Salary number(8),
Partyyala_id number,
constraint Candidateyalaa_Primarykey Primary key (Candidateyalaa_id),
constraint Candidateyalaa_First_name_unique unique (First_name),
constraint Candidateyalaa_Last_name_unique unique (Last_name),
constraint Candidateyalaa_Salary_check check(salary>10000 and salary<50000),
constraint Candidateyalaa_Partyyala_id_ForeignKey foreign key (Partyyala_id) references Partyyala(Partyyala_id)

);

create table Partyyala(
Partyyala_id number,
PartyyalaDesc varchar(500) not null,
constraint Partyyala_Primarykey Primary key (Partyyala_id),
constraint Partyyala_PartyyalaDesc_unique unique (PartyyalaDesc)
);