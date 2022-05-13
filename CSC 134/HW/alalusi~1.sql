insert into partyyala values (5,'Birth');
insert into partyyala values (6,'Anni');

insert into candidateyalaa values (5, 'Youser','Alalusi','13-Oct-1997',25000,6);
insert into candidateyalaa values (6, 'Aouser','Ylalusi','17-Oct-1997',40000,5);

insert into Candidateyalaa values (7, 'John','Doe',(to_date('022585','mmddyy')),20000,6);
insert into Candidateyalaa values (8,'Jane','Do',(to_date('258902','ddyymm')),22000,5);

select to_char(DOB,'mmddyyyy') from candidateyalaa;

select to_char(DOB, 'ddyyyymm hh12:mi:ss') from candidateyalaa;

insert into candidateyalaa values(9,'jhene','aiko',(to_date('155505','ddyymm')),56000,5);
insert into candidateyalaa values(8, 'jhene','aiko',(to_date('155505','ddyymm')),20000,0);

desc user_constraints;

select table_name, constraint_name, constraint_type FROM user_constraints where table_name = 'CANDIDATE';
select table_name, constraint_name, constraint_type FROM user_constraints where table_name = 'PARTY';
