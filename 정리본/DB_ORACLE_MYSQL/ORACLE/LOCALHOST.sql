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
-- select * from buytbl;
select groupname,prodname ,sum(price*amount) as �Ǹž�
from buytbl where groupname is not null
group by cube(groupname,prodname);

--GROUPING SETS(Ư�� �׷�ȭ ������ ����� UNION ALL�� ������ �Ͱ� ���� ����� �����մϴ�.)
SELECT groupName, prodName, SUM(price * amount) AS �Ǹž�
FROM buyTbl
WHERE groupName IS NOT NULL
GROUP BY GROUPING SETS((groupName), (prodName),());

select groupname, null as prodname ,sum(price * amount) from buytbl 
where groupname is not null
group by groupname
union all
select prodname, null as prodname,sum(price * amount) from buytbl
where groupname is not null
group by prodname;


-- HAVING ����
-- COUNT(*)�� "�ش� �׷��� �� ��"�� ����Ѵٴ� ���̴�.

--1
select userid,sum(price*amount) from buytbl group by userid having sum(price*amount)>=1000;
--2
select addr ,count(*) from usertbl group by addr having count(*) >=2;
--3
select prodname, avg(price * amount) from buytbl
group by prodname having avg(price *amount)>=100;
--4
-- select * from usertbl;
select name,birthyear,avg(height)as ���Ű from usertbl
group by name,birthyear
having avg(height) >=175
order by ���Ű desc;

select mdate,avg(height)as ���Ű from usertbl group by mdate
having avg(height) >=175
order by ���Ű desc;
--5
-- select * from buytbl;
select userid,count(distinct prodname) from buytbl
group by userid
having count(distinct prodname) >=2;

--6
select u.addr,sum(b.price * b.amount) from usertbl u join buytbl b on u.userid = b.userid
group by u.addr
having sum(b.price * b.amount)>=200;

--7
select count(*) as ����Ƚ��, sum(price * amount) as �ѱ��ž� from buytbl group by userid
having count(*) >=3 and sum(price * amount) >=500;

--8
select * from(select addr, avg(height) as ���Ű from usertbl group by addr)
where ���Ű =(select max(avg(height)) as ���Ű from usertbl group by addr);

SELECT addr, AVG(height) AS ���Ű
FROM usertbl
GROUP BY addr
HAVING AVG(height) = (
    SELECT MAX(���Ű)
    FROM (
        SELECT AVG(height) AS ���Ű
        FROM usertbl
        GROUP BY addr
    )
);

-- 9
select userid, avg(amount * price)
from buytbl group by userid 
having avg(amount * price )>= (select avg(amount * price) from buytbl);

--10
--1) usertbl�� buytb�� �����ϰ�
--2) ����(addr)�� ��� 
--3)�� ������ ��� ���ž׺��� ���� �����(userid)�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�.(���������� HAVING ���)

select u.userid, sum(b.amount * b.price)
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.userid;

-- �Լ�

-- ��ҹ��� ��ȯ
select userid, lower(userid) as lower_id from usertbl;
select userid, upper(userid) as upper_id from usertbl;
select userid, initcap(lower(userid)) as init_cap from usertbl;

-- ���ڿ� ����
select name,
        length(name) as name_length,
        length(addr)as addr_length
from usertbl;

-- ���ڿ� ����
select name,
        substr(name,1,1) as first_char, -- �̸��� ù ����
        substr(userid,2) as userid_part -- userID�� �� ��° ���ں��� ������
from usertbl;

-- ���� ��ġ ã��
select name,
        instr(name,'��') as position_kim -- '��'�� �ִ� ��ġ (������ 0)
from usertbl;

-- ���ڿ� ä���

select userid,
            lpad(userid,10,'*') as Ipad_id, -- userID ������ *�� ä�� 10�ڸ���
            rpad(name,10,'-') as rpad_name -- name �������� -�� ä�� 10�ڸ���
from usertbl;
