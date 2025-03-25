select * from buytbl;

-- GROUP BY
select userid,sum(price*amount) as 구매총액
from buytbl
group by userid;

--
select userid, count(*)from buytbl group by userid;

--

select addr, count(*) as 사용자수 
from usertbl
group by addr;
--

select groupname, sum(price*amount) as 판매액
from buytbl
where groupname is not null
group by groupname;

-- 출생년도 기준 사용자 수
select birthyear, count(*) as 인원수
from usertbl
group by birthyear
order by birthyear;

-- 오름차순
select name,mdate from usertbl order by mdate;
select name,mdate from usertbl order by name;

-- 내림차순
select name,mdate from usertbl order by mdate desc;
select name,mdate from usertbl order by name desc;

select name, height from usertbl order by height desc, name;

-- 서브쿼리
select * from
(select rownum as rn, usertbl.* from usertbl) where rn=2;

select * from (select rownum as rn, usertbl.* from usertbl)
where rn>=2 and rn<=4;

-- GROUP BY 문제
--1
select addr, count(*) from usertbl group by addr;
--2
select userid,sum(price*amount)as 총구매액 from buytbl group by userid;
--3
-- COALESCE 는 SQL 표준 (인자 여러개 가능)
select coalesce(groupname,'미분류'), sum(price*amount) from buytbl group by groupname;
-- NVL는 ORACLE 에서만 가능
select NVL(groupname,'미분류'), sum(price*amount) from buytbl group by groupname;
-- CASE - IS NULL THEN
select
    case
        when groupname is null then '미분류'
        else groupname
    end
    as 카테고리, sum(amount)
from buytbl
group by groupname;

--4
select birthyear,avg(height) from usertbl group by birthyear;
--5
select prodname, sum(price*amount) as 총구매액,count(*)as 구매횟수 from buytbl 
group by prodname order by 구매횟수 desc;
--6
select count(mobile1) from usertbl where mobile1 is not null group by mobile1;
--7
select u.addr, sum(b.price * b.amount)as  총구매액 from usertbl u join buytbl b on u.userid = b.userid group by u.addr;

-- select * from usertbl;
--8
select *from buytbl;
select userid,groupname ,count(groupname) from buytbl group by userid,groupname;
--9
select extract(year from mdate) as 가입연도, count(*) as 가입자수 from usertbl
group by extract(year from mdate) order by 가입연도;
-- 10번
select Floor((2025 - a.birthyear)/10)*10 as 연령대,
        sum(b.price * b.amount) as 구매총액
from usertbl a 
join buytbl b
on a.userid = b.userid 
group by floor((2025 - a.birthyear)/10)*10
order by 연령대;


-- HAVING
select userid, sum(price * amount) as 총구매액 from buytbl group by userid
having sum(price * amount) >=1000;

--
select addr, avg(height) as 평균키 from usertbl
group by addr 
having avg(height) >=175;

--
select userid, sum(price * amount) as 총구매액 from buytbl group by userid
having count(*)>=2;

--
select u.addr,nvl(b.groupname,'미분류'),sum(b.amount * b.price) as 총합 from usertbl u join buytbl b on u.userid = b.userid
group by u.addr, b.groupname
order by 총합 desc;

-- 복합 GROUP BY
select floor((2023-birthyear)/10)*10 as 연령대,b.prodname,count(*) 구매횟수,
sum(b.price * b.amount)as 총구매액
from usertbl u
join buytbl b
on u.userid = b.userid
group by floor((2023-birthyear)/10)*10, b.prodname
order by 연령대;


-- 복합 GROUP BY
select * from buytbl;
select addr,extract(year from mdate) as 가입연도, count(*)as 회원가입 
from usertbl u
join buytbl b
on u.userid = b.userid
group by extract(year from mdate) ,u.addr
order by addr,가입연도;

-- GROUP BY 함수와 ROLLUP(소계와 합계를 자동으로 계산해주는 함수입니다.)
select groupname, sum(price*amount) as 판매액
from buytbl where groupname is not null
group by rollup(groupname);

-- GROUP BY 함수와 CUBE(모든 가능한 조합의 소계와 합계를 계산합니다.)
-- select * from buytbl;
select groupname,prodname ,sum(price*amount) as 판매액
from buytbl where groupname is not null
group by cube(groupname,prodname);

--GROUPING SETS(특정 그룹화 조합의 결과를 UNION ALL로 결합한 것과 같은 결과를 제공합니다.)
SELECT groupName, prodName, SUM(price * amount) AS 판매액
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


-- HAVING 문제
-- COUNT(*)은 "해당 그룹의 행 수"를 계산한다는 뜻이다.

--1
select userid,sum(price*amount) from buytbl group by userid having sum(price*amount)>=1000;
--2
select addr ,count(*) from usertbl group by addr having count(*) >=2;
--3
select prodname, avg(price * amount) from buytbl
group by prodname having avg(price *amount)>=100;
--4
-- select * from usertbl;
select name,birthyear,avg(height)as 평균키 from usertbl
group by name,birthyear
having avg(height) >=175
order by 평균키 desc;

select mdate,avg(height)as 평균키 from usertbl group by mdate
having avg(height) >=175
order by 평균키 desc;
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
select count(*) as 구매횟수, sum(price * amount) as 총구매액 from buytbl group by userid
having count(*) >=3 and sum(price * amount) >=500;

--8
select * from(select addr, avg(height) as 평균키 from usertbl group by addr)
where 평균키 =(select max(avg(height)) as 평균키 from usertbl group by addr);

SELECT addr, AVG(height) AS 평균키
FROM usertbl
GROUP BY addr
HAVING AVG(height) = (
    SELECT MAX(평균키)
    FROM (
        SELECT AVG(height) AS 평균키
        FROM usertbl
        GROUP BY addr
    )
);

-- 9
select userid, avg(amount * price)
from buytbl group by userid 
having avg(amount * price )>= (select avg(amount * price) from buytbl);

--10
--1) usertbl과 buytb을 조인하고
--2) 같은(addr)에 사는 
--3)이 지역별 평균 구매액보다 높은 사용자(userid)를 조회하는 SQL문을 작성하시오.(서브쿼리와 HAVING 사용)

select u.userid, sum(b.amount * b.price)
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.userid;

-- 함수

-- 대소문자 변환
select userid, lower(userid) as lower_id from usertbl;
select userid, upper(userid) as upper_id from usertbl;
select userid, initcap(lower(userid)) as init_cap from usertbl;

-- 문자열 길이
select name,
        length(name) as name_length,
        length(addr)as addr_length
from usertbl;

-- 문자열 추출
select name,
        substr(name,1,1) as first_char, -- 이름의 첫 글자
        substr(userid,2) as userid_part -- userID의 두 번째 문자부터 끝까지
from usertbl;

-- 문자 위치 찾기
select name,
        instr(name,'김') as position_kim -- '김'이 있는 위치 (없으면 0)
from usertbl;

-- 문자열 채우기

select userid,
            lpad(userid,10,'*') as Ipad_id, -- userID 왼쪽을 *로 채워 10자리로
            rpad(name,10,'-') as rpad_name -- name 오른쪽을 -로 채워 10자리로
from usertbl;
