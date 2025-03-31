select * from Book_Tbl;
select * from Rental_Tbl;
select * from Reserve_Tbl;

insert into Member_Tbl values (1234,'김종호','9999','3','대구','아이폰');
insert into Classification_Tbl values(55556,'박길대');
insert into Book_Tbl values(1111,55556,'이민하','이것이책인가','한빛출판',1);
insert into Rental_Tbl values(77777,1111,1234);
insert into Reserve_Tbl values(77777,1234,'나나나');
insert into  Appendix_Tbl values(1258,1111,'이름몰라');

commit;