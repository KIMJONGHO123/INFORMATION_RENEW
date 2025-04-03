create table user_tbl(
    USERID VARCHAR2(100) PRIMARY KEY,
    PASSWORD VARCHAR2(100) NOT NULL
);

select * from user_tbl;

commit;