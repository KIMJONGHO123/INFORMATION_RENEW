-- INNER JOIN 문제

-- ① 모든 회원의 이름과 구매한 상품명, 단가, 수량 조회 (구매하지 않은 회원 제외)
-- 이름, 상품명, 단가, 수량 출력
-- (조인 사용)
--select * from buytbl;
select name,prodname,price,amount from usertbl u
join buytbl b on u.userid = b.userid
where b.groupname is not null;

-- ② 회원별 총 구매 금액(단가 × 수량의 합) 출력
-- 이름, 총구매금액 출력. 금액 높은 순 정렬
select * from usertbl;
select u.name,sum(b.amount * b.price) as 총구매액 from usertbl u 
join buytbl b on u.userid = b.userid 
group by u.name
order by 총구매액 desc;

-- ③ '책'을 구매한 회원 이름 중복 없이 조회
select * from buytbl;
select distinct u.name from usertbl u
join buytbl b on u.userid = b.userid
where b.prodname = '책';

-- ④ 2010년 이후 가입한 회원이 구매한 상품 내역 조회
-- 이름, 가입일, 상품명 출력

select * from usertbl;
select u.name as 이름, u.mdate as 가입일, b.prodname 상품명 from usertbl u 
join buytbl b on u.userid = b.userid
where u.mdate > = to_date('2010-01-01','YYYY-MM-DD');

-- ⑤ 상품을 가장 많이 구매한 회원(수량 기준) 1명만 출력
-- 이름, 총수량 출력
select max(총수량) from
(select u.userid,sum(b.amount) as 총수량 from usertbl u
join buytbl b on u.userid = b.userid
group by u.userid);

-- LEFT OUTER JOIN 문제

-- ① 모든 회원의 이름과 구매 내역(없는 경우 NULL로 표시)
-- 이름, 상품명, 가격 출력
select * from usertbl;
select u.name,b.prodname,b.price from usertbl u
left outer join buytbl b on u.userid = b.userid;

-- ② 구매 이력이 없는 회원만 조회 (구매 안 한 사람 찾기)
-- 이름, ID 출력
select * from buytbl;
select u.userid, u.name from usertbl u
left outer join buytbl b on u.userid = b.userid
where b.userid is null;

-- ③ 지역별 회원 이름과 구매 수량 (구매 없으면 NULL)
-- 지역, 이름, 수량 출력
select u.addr, u.name,b.amount from usertbl u
left outer join buytbl b on u.userid = b.userid;

-- ④ 회원별 총 구매 금액 (없으면 0으로 표시)
-- 이름, 총금액 출력
select u.userid, nvl(sum(b.price * b.amount),0)as 구매금액
from usertbl u 
left outer join buytbl b
on u.userid= b.userid
group by u.userid
order by 구매금액 desc;

-- NATURAL JOIN (두 테이블에서 동일한 이름을 가진 모든 컬럼에 대해 자동으로 동등 조인을 수행합니다.)
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


-- 서브쿼리

-- 김경호보다 키가 큰 사용자 조회
SELECT userID, name, height 
FROM userTbl
WHERE height > (SELECT height FROM userTbl WHERE name = '김경호');

-- 경남 지역에 사는 사용자와 같은 키를 가진 사용자 조회
SELECT userID, name, addr, height
FROM userTbl
WHERE height IN (SELECT height FROM userTbl WHERE addr = '경남');

SELECT userID, name, addr, height -- any는 or 연산에 가깝다.
FROM userTbl
WHERE height >= any (SELECT height FROM userTbl WHERE addr = '경남');


SELECT userID, name, addr, height -- all은 and 연산에 가깝다.
FROM userTbl
WHERE height >= all (SELECT height FROM userTbl WHERE addr = '경남');

-- 주소별로 가장 키가 큰 사람들 조회
select userid,name,addr,height
from usertbl
where (addr,height)
in (select addr, max(height) from usertbl group by addr);


-- 서브쿼리 문제

--1. 서울 지역에 거주하는 회원 중, 전체 평균 키보다 큰 회원의 이름과 키를 조회하는 SQL문을 작성하시오.
select name,height from usertbl
where addr = '서울' and height>=(select avg(height) from usertbl);


--2.물품을 한 번이라도 구매한 적이 있는 회원의 이름과 주소를 조회하는 SQL문을 작성하시오.
--(단, buyTbl의 userID 기준)
select * from buytbl;
select name,addr from usertbl where userid in (select distinct userid from buytbl);


-- 3.‘전자’ 분류 상품 중 가장 비싼 상품을 구매한 회원의 이름과 상품명, 가격을 조회하는 SQL문을 작성하시오.