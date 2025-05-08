--INSERT IGNORE → 중복되면 그 행은 무시하고, 나머지는 삽입
insert ignore into tbl_a values(1,111);
insert ignore into tbl_a values(2,222);
insert ignore into tbl_a values(3,333);