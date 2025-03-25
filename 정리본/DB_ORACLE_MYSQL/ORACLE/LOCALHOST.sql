select * from studenttbl;
select * from examtbl;

select *
from studenttbl s
full outer join examtbl e
on s.studentid = e.studentid;