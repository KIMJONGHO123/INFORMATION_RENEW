select * from Book_Tbl;
select * from Rental_Tbl;
select * from Reserve_Tbl;

insert into Member_Tbl values (1234,'����ȣ','9999','3','�뱸','������');
insert into Classification_Tbl values(55556,'�ڱ��');
insert into Book_Tbl values(1111,55556,'�̹���','�̰���å�ΰ�','�Ѻ�����',1);
insert into Rental_Tbl values(77777,1111,1234);
insert into Reserve_Tbl values(77777,1234,'������');
insert into  Appendix_Tbl values(1258,1111,'�̸�����');

commit;