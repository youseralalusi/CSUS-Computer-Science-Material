INSERT INTO classya values (0, 'English');
INSERT INTO classya values (1, 'Math');


INSERT INTO studentya values ('111223333', 'Alalusi','Youser',10000,(to_date('952609','YYDDMM')),'560 N. Main ST', 'Y');
INSERT INTO studentya values ('222334444', 'Wang', 'Ali',0,'09-Feb-1995','722 Canyon RD','N');


INSERT INTO studentya_classya values('111223333',0);
INSERT INTO studentya_classya values('111223333',1);
INSERT INTO studentya_classya values('222334444',0);


INSERT INTO studentya values ('333445555','Alalusi','Youser',400,'12-Apr-1991','722 Canyon RD','Y');



INSERT INTO studentya values ('333445555','Wang','Ali',400,'12-Apr-1991','722 Canyon RD','z');





INSERT INTO studentya_classya values ('111223333',3);

INSERT INTO studentya_classya values ('555223333',1);

INSERT INTO studentya_classya values ('111223333',0);


ALTER TABLE studentya_classya DISABLE CONSTRAINT ssnya_fk;

INSERT INTO studentya_classya values ('999119999',0);










ALTER TABLE studentya_classya ENABLE CONSTRAINT ssn_fk;




DELETE FROM studentya_classya;





TRUNCATE TABLE studentya;





DROP INDEX ssnya_dobya_idxya;


Alter table studentya_classya Drop constraint classyaCode_fk;
Alter table studentya_classya Drop constraint ssnya_fk;











DROP TABLE studentya;


























