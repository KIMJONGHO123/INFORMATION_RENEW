select * from tbl_member_202005;
select * from tbl_party_202005;

select * from tbl_vote_202005;

select m.m_no,m.m_name,p.p_name,m.p_school,m.m_jumin,m.m_city,p.p_tel1,p.p_tel2,p.p_tel3
from tbl_member_202005 m 
join tbl_party_202005 p
on m.p_code = p.p_code;

commit;