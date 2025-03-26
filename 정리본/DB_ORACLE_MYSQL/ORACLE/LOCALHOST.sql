-- INNER JOIN ����

-- �� ��� ȸ���� �̸��� ������ ��ǰ��, �ܰ�, ���� ��ȸ (�������� ���� ȸ�� ����)
-- �̸�, ��ǰ��, �ܰ�, ���� ���
-- (���� ���)
--select * from buytbl;
select name,prodname,price,amount from usertbl u
join buytbl b on u.userid = b.userid
where b.groupname is not null;

-- �� ȸ���� �� ���� �ݾ�(�ܰ� �� ������ ��) ���
-- �̸�, �ѱ��űݾ� ���. �ݾ� ���� �� ����
select * from usertbl;
select u.name,sum(b.amount * b.price) as �ѱ��ž� from usertbl u 
join buytbl b on u.userid = b.userid 
group by u.name
order by �ѱ��ž� desc;

-- �� 'å'�� ������ ȸ�� �̸� �ߺ� ���� ��ȸ
select * from buytbl;
select distinct u.name from usertbl u
join buytbl b on u.userid = b.userid
where b.prodname = 'å';

-- �� 2010�� ���� ������ ȸ���� ������ ��ǰ ���� ��ȸ
-- �̸�, ������, ��ǰ�� ���

select * from usertbl;
select u.name as �̸�, u.mdate as ������, b.prodname ��ǰ�� from usertbl u 
join buytbl b on u.userid = b.userid
where u.mdate > = to_date('2010-01-01','YYYY-MM-DD');

-- �� ��ǰ�� ���� ���� ������ ȸ��(���� ����) 1�� ���
-- �̸�, �Ѽ��� ���
select max(�Ѽ���) from
(select u.userid,sum(b.amount) as �Ѽ��� from usertbl u
join buytbl b on u.userid = b.userid
group by u.userid);

-- LEFT OUTER JOIN ����

-- �� ��� ȸ���� �̸��� ���� ����(���� ��� NULL�� ǥ��)
-- �̸�, ��ǰ��, ���� ���
select * from usertbl;
select u.name,b.prodname,b.price from usertbl u
left outer join buytbl b on u.userid = b.userid;

-- �� ���� �̷��� ���� ȸ���� ��ȸ (���� �� �� ��� ã��)
-- �̸�, ID ���
select * from buytbl;
select u.userid, u.name from usertbl u
left outer join buytbl b on u.userid = b.userid
where b.userid is null;

-- �� ������ ȸ�� �̸��� ���� ���� (���� ������ NULL)
-- ����, �̸�, ���� ���
select u.addr, u.name,b.amount from usertbl u
left outer join buytbl b on u.userid = b.userid;

-- �� ȸ���� �� ���� �ݾ� (������ 0���� ǥ��)
-- �̸�, �ѱݾ� ���
select u.userid, nvl(sum(b.price * b.amount),0)as ���űݾ�
from usertbl u 
left outer join buytbl b
on u.userid= b.userid
group by u.userid
order by ���űݾ� desc;

-- NATURAL JOIN (�� ���̺��� ������ �̸��� ���� ��� �÷��� ���� �ڵ����� ���� ������ �����մϴ�.)
select * 
from usertbl u
natural join buytbl b;

select *
from usertbl u
join buytbl b
on u.userid = b.userid;


-- INNER JOIN(USING)
select *
from usertbl u
join buytbl b
using(userid);


-- ��������

-- ���ȣ���� Ű�� ū ����� ��ȸ
SELECT userID, name, height 
FROM userTbl
WHERE height > (SELECT height FROM userTbl WHERE name = '���ȣ');

-- �泲 ������ ��� ����ڿ� ���� Ű�� ���� ����� ��ȸ
SELECT userID, name, addr, height
FROM userTbl
WHERE height IN (SELECT height FROM userTbl WHERE addr = '�泲');

SELECT userID, name, addr, height -- any�� or ���꿡 ������.
FROM userTbl
WHERE height >= any (SELECT height FROM userTbl WHERE addr = '�泲');


SELECT userID, name, addr, height -- all�� and ���꿡 ������.
FROM userTbl
WHERE height >= all (SELECT height FROM userTbl WHERE addr = '�泲');

-- �ּҺ��� ���� Ű�� ū ����� ��ȸ
select userid,name,addr,height
from usertbl
where (addr,height)
in (select addr, max(height) from usertbl group by addr);


-- �������� ����

--1. ���� ������ �����ϴ� ȸ�� ��, ��ü ��� Ű���� ū ȸ���� �̸��� Ű�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�.
select name,height from usertbl
where addr = '����' and height>=(select avg(height) from usertbl);


--2.��ǰ�� �� ���̶� ������ ���� �ִ� ȸ���� �̸��� �ּҸ� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�.
--(��, buyTbl�� userID ����)
select * from buytbl;
select name,addr from usertbl where userid in (select distinct userid from buytbl);


-- 3.�����ڡ� �з� ��ǰ �� ���� ��� ��ǰ�� ������ ȸ���� �̸��� ��ǰ��, ������ ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�.