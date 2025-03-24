select * from usertbl;

----------------------------
-- where 절
----------------------------

select * from usertbl where name = '김경호';

----------------------------
-- 조건절 + 관계연산자
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

select Name,height from usertbl where addr in('경남','전남','경북');
select * from usertbl where mobile1 in('010','011');

----------------------------
-- LIKE %(모든문자,길이제한x) , _(모든문자,_만큼의 길이)
----------------------------
select name,height from usertbl where name like '김%';
select name,height from usertbl where name like'_재범';

----------------------------
-- NULL CHECK 
----------------------------
select name, mobile1,mobile2 from usertbl where mobile2 is null;
select name, mobile1,mobile2 from usertbl where mobile2 is not null;

----------------------------
-- DISTINCT row중 중복 row 제거
----------------------------
select distinct addr from usertbl;

----------------------------
-- ALIAS 별칭
----------------------------
select name,addr,mobile1 || mobile2 as phone from usertbl;

select * from buytbl;

select * from buytbl where amount>=5;
select UserId,prodName from buytbl where price between 50 and 500;
select * from buytbl where  amount >=10 or price >=100;
select * from buytbl where UserId like 'K%';
select * from buytbl where groupname in ('서적','전자');
select * from buytbl  where prodname='책' or TRIM(userid) like '%W';

