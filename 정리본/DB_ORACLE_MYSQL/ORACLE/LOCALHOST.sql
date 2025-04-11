select * from tbl_class_202201;
select * from tbl_member_202201;
select * from tbl_teacher_202201;
commit;

create table login_tbl (
    id varchar(20) primary key,
    pw varchar(20),
    role varchar(20)
);
select * from login_tbl;
update login_tbl set ROLE='ROLE_ADMIN' where ID='good'; 
commit;