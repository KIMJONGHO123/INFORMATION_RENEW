select * from usertbl;

----------------------------
-- where ��
----------------------------

select * from usertbl where name = '���ȣ';

----------------------------
-- ������ + ���迬����
----------------------------

select * from usertbl where birthyear >=1970 and
height >= 182;

select * from usertbl where birthyear >=1970 or
height >= 182;

----------------------------
-- BETWEEN
----------------------------
select * from usertbl where birthyear >=1970 and
birthyear <= 1980;

select * from usertbl where birthyear between 1970 and 1980;


----------------------------
-- BETWEEN
----------------------------

select Name,height from usertbl where addr in('�泲','����','���');
select * from usertbl where mobile1 in('010','011');

----------------------------
-- LIKE %(��繮��,��������x) , _(��繮��,_��ŭ�� ����)
----------------------------
select name,height from usertbl where name like '��%';
select name,height from usertbl where name like'_���';

----------------------------
-- NULL CHECK 
----------------------------
select name, mobile1,mobile2 from usertbl where mobile2 is null;
select name, mobile1,mobile2 from usertbl where mobile2 is not null;

----------------------------
-- DISTINCT row�� �ߺ� row ����
----------------------------
select distinct addr from usertbl;

----------------------------
-- ALIAS ��Ī
----------------------------
select name,addr,mobile1 || mobile2 as phone from usertbl;

select * from buytbl;

select * from buytbl where amount>=5;
select UserId,prodName from buytbl where price between 50 and 500;
select * from buytbl where  amount >=10 or price >=100;
select * from buytbl where UserId like 'K%';
select * from buytbl where groupname in ('����','����');
select * from buytbl  where prodname='å' or TRIM(userid) like '%W';

