select * from buytbl;

-- GROUP BY
select userid,sum(price*amount) as �����Ѿ�
from buytbl
group by userid;

--
select userid, count(*)from buytbl group by userid;

--

select addr, count(*) as ����ڼ� 
from usertbl
group by addr;
--

select groupname, sum(price*amount) as �Ǹž�
from buytbl
where groupname is not null
group by groupname;

-- ����⵵ ���� ����� ��
select birthyear, count(*) as �ο���
from usertbl
group by birthyear
order by birthyear;

-- ��������
select name,mdate from usertbl order by mdate;
select name,mdate from usertbl order by name;

-- ��������
select name,mdate from usertbl order by mdate desc;
select name,mdate from usertbl order by name desc;

select name, height from usertbl order by height desc, name;

-- ��������
select * from
(select rownum as rn, usertbl.* from usertbl) where rn=2;

select * from (select rownum as rn, usertbl.* from usertbl)
where rn>=2 and rn<=4;

-- GROUP BY ����
--1
select addr, count(*) from usertbl group by addr;
--2
select userid,sum(price*amount)as �ѱ��ž� from buytbl group by userid;
--3
-- COALESCE �� SQL ǥ�� (���� ������ ����)
select coalesce(groupname,'�̺з�'), sum(price*amount) from buytbl group by groupname;
-- NVL�� ORACLE ������ ����
select NVL(groupname,'�̺з�'), sum(price*amount) from buytbl group by groupname;
-- CASE - IS NULL THEN
select
    case
        when groupname is null then '�̺з�'
        else groupname
    end
    as ī�װ�, sum(amount)
from buytbl
group by groupname;

--4
select birthyear,avg(height) from usertbl group by birthyear;
--5
select prodname, sum(price*amount) as �ѱ��ž�,count(*)as ����Ƚ�� from buytbl 
group by prodname order by ����Ƚ�� desc;
--6
select count(mobile1) from usertbl where mobile1 is not null group by mobile1;
--7
select u.addr, sum(b.price * b.amount)as  �ѱ��ž� from usertbl u join buytbl b on u.userid = b.userid group by u.addr;

-- select * from usertbl;
--8
select *from buytbl;
select userid,groupname ,count(groupname) from buytbl group by userid,groupname;
--9
select extract(year from mdate) as ���Կ���, count(*) as �����ڼ� from usertbl
group by extract(year from mdate) order by ���Կ���;
-- 10��
select Floor((2025 - a.birthyear)/10)*10 as ���ɴ�,
        sum(b.price * b.amount) as �����Ѿ�
from usertbl a 
join buytbl b
on a.userid = b.userid 
group by floor((2025 - a.birthyear)/10)*10
order by ���ɴ�;


-- HAVING
select userid, sum(price * amount) as �ѱ��ž� from buytbl group by userid
having sum(price * amount) >=1000;

--
select addr, avg(height) as ���Ű from usertbl
group by addr 
having avg(height) >=175;

--
select userid, sum(price * amount) as �ѱ��ž� from buytbl group by userid
having count(*)>=2;

--
select u.addr,nvl(b.groupname,'�̺з�'),sum(b.amount * b.price) as ���� from usertbl u join buytbl b on u.userid = b.userid
group by u.addr, b.groupname
order by ���� desc;

-- ���� GROUP BY
select floor((2023-birthyear)/10)*10 as ���ɴ�,b.prodname,count(*) ����Ƚ��,
sum(b.price * b.amount)as �ѱ��ž�
from usertbl u
join buytbl b
on u.userid = b.userid
group by floor((2023-birthyear)/10)*10, b.prodname
order by ���ɴ�;


-- ���� GROUP BY
select * from buytbl;
select addr,extract(year from mdate) as ���Կ���, count(*)as ȸ������ 
from usertbl u
join buytbl b
on u.userid = b.userid
group by extract(year from mdate) ,u.addr
order by addr,���Կ���;

-- GROUP BY �Լ��� ROLLUP(�Ұ�� �հ踦 �ڵ����� ������ִ� �Լ��Դϴ�.)
select groupname, sum(price*amount) as �Ǹž�
from buytbl where groupname is not null
group by rollup(groupname);

-- GROUP BY �Լ��� CUBE(��� ������ ������ �Ұ�� �հ踦 ����մϴ�.)
















-- HAVING ����
-- COUNT(*)�� "�ش� �׷��� �� ��"�� ����Ѵٴ� ���̴�.
select userid,sum(price*amount) from buytbl group by userid having sum(price*amount)>=1000;
select * from usertbl;
select addr ,count(*) from usertbl group by addr having count(*) >=2;
select * from buytbl;
select prodname, avg(price * amount) from buytbl group by prodname having avg(price *amount)>=100;


