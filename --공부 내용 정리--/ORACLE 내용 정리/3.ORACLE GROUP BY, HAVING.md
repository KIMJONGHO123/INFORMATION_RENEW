# ORACLE GROUP BY, HAVING

## 📌 SQL 정리

---

### 🔹 **WHERE**

- **역할**: 조건에 맞는 행(row)을 필터링
- **사용 위치**: `FROM` 바로 다음
- **예시**:
    
    ```sql
    SELECT * FROM employees
    WHERE department = 'Sales';
    ```
    

---

### 🔹 **GROUP BY**

- **역할**: 특정 컬럼 기준으로 데이터를 그룹화
- **보통 함께 쓰이는 함수**: `COUNT()`, `SUM()`, `AVG()`, `MAX()`, `MIN()` 등
- **예시**:
    
    ```sql
    SELECT department, COUNT(*)
    FROM employees
    GROUP BY department;
    ```
    

---

### 🔹 **HAVING**

- **역할**: 그룹화된 결과에 조건을 걸 때 사용
- **`WHERE`와의 차이점**: `WHERE`는 **행 기준**, `HAVING`은 **그룹 기준**
- **예시**:
    
    ```sql
    SELECT department, COUNT(*)
    FROM employees
    GROUP BY department
    HAVING COUNT(*) > 10;
    ```
    

---

## 🧩 단일행 함수 (Single Row Functions)

### 🔸 문자형 함수

- `LOWER(str)`: 소문자로 변환
- `UPPER(str)`: 대문자로 변환
- `SUBSTR(str, start, length)`: 문자열 일부 추출
- `LENGTH(str)`: 문자열 길이

### 🔸 숫자형 함수

- `ROUND(num, n)`: 반올림 (소수 n자리까지)
- `TRUNC(num, n)`: 버림
- `MOD(a, b)`: 나머지

### 🔸 변환 함수

- `TO_CHAR(value, format)`: 숫자/날짜 → 문자
- `TO_DATE(str, format)`: 문자 → 날짜
- `TO_NUMBER(str)`: 문자 → 숫자

### 🔸 NULL 관련 함수

- `NVL(expr1, expr2)`: expr1이 NULL이면 expr2 반환
- `NVL2(expr1, expr2, expr3)`: expr1이 NULL 아니면 expr2, NULL이면 expr3
- `COALESCE(a, b, c, ...)`: NULL이 아닌 첫 번째 값 반환

### 🔸 조건부 함수

- `CASE WHEN 조건 THEN 값 [ELSE 값] END`
- `DECODE(컬럼, 조건1, 결과1, 조건2, 결과2, ..., 기본값)` (Oracle 전용)

---

## 🧮 다중행 함수 (Multi Row Functions)

### 🔸 그룹 함수 (Group Functions)

- `COUNT(*)`: 개수
- `SUM(컬럼)`: 총합
- `AVG(컬럼)`: 평균
- `MAX(컬럼)`: 최댓값
- `MIN(컬럼)`: 최솟값

> 👉 GROUP BY와 함께 사용됨
> 

---

### 🔸 분석 함수 (Window Functions)

- **형식**:
    
    ```sql
    함수명() OVER (PARTITION BY 컬럼 ORDER BY 컬럼)
    ```
    
- **주요 함수들**:
    - `ROW_NUMBER()`: 정렬 기준으로 행 번호
    - `RANK()`: 동일값에 같은 순위, 다음 순위 건너뜀
    - `DENSE_RANK()`: 동일값에 같은 순위, 다음 순위 안 건너뜀
    - `SUM() OVER(...)`, `AVG() OVER(...)` 등도 가능
- **예시**:
    
    ```sql
    SELECT name, salary,
           RANK() OVER (PARTITION BY department ORDER BY salary DESC) AS rank
    FROM employees;
    ```
    

---

```sql
select userid ,count(*) from buytbl group by amount having count(*) >=2;
```

### → 이 쿼리는 틀렸다.

**틀린 이유:**

- `SELECT userid, COUNT(*)`인데
- `GROUP BY amount`라고 하면,
- `userid`는 **GROUP BY에 포함되지도 않았고**, **집계 함수로도 묶이지 않았다.**

👉 이건 SQL 문법에서 "GROUP BY와 SELECT 컬럼이 일치해야 한다"는 원칙에 어긋나기 때문이다.

---

### 📌 SQL에서 꼭 지켜야 하는 규칙:

- `SELECT`에 있는 컬럼은 아래 중 하나여야 한다:
    1. `GROUP BY`에 포함된 컬럼
    2. 집계 함수로 묶인 컬럼 (`COUNT()`, `SUM()` 등)

```sql
select mdate,avg(height)as 평균키 from usertbl group by name having avg(height) >=175
order by 평균키 desc;
```

### → 이 쿼리는 틀렸다.

### ✅ SQL 규칙 다시 상기:

> SELECT에 들어가는 컬럼은 반드시 GROUP BY에 포함되거나, 집계 함수로 묶여야 해요.
> 

### 정상 쿼리

```sql
select mdate,avg(height)as 평균키 from usertbl group by mdate
having avg(height) >=175
order by 평균키 desc;
```

## 연습한 쿼리

```sql
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

-- 공백 제거
select trim(' sql ') as trim_result,  -- 양쪽 공백 제거: 'SQL'
        ltrim(' sql') as ltrim_result,  -- 왼쪽 공백 제거: 'SQL '
        rtrim('sql ') as rtrim_result  -- 오른쪽 공백 제거: ' SQL'
from dual;

-- 문자열 치환
select name,
        -- replace(mobile1,NULL,'없음') as replace_null, -- replace()함수는 문자열
        -- 안에서 특정 문자열을 찾아서 바꾸는 함수인데 null은 문자열이 아니라 "존재하지 않는 값"
        -- 이기 때문에 replace()로 처리되지 않는다.
        COALESCE(mobile1,'없음'),
        replace(addr,'서울','SEOUL') as replace_addr
from usertbl;

-- 문자열 연결
select name,
        concat(mobile1,'-') as part1,   -- 휴대폰 국번과 '-' 연결
        concat(concat(mobile1,'-'),mobile2) as mobile, -- 국번-전화번호 형식으로 연결
        mobile1 || '-' || mobile2 as phone_number  -- 연결 연산자 사용
from usertbl;

-- 조인

--구매한 회원의 이름, 상품명, 가격, 수량을 출력
select u.userid,name,birthyear,addr,prodname,groupname,price -- userid하면 에러남 u.userid인지 b.userid인지 적어야한다.
from usertbl u
join buytbl b on u.userid = b.userid;
--회원별 총 구매 금액
select u.userid, u.name, sum(b.price * b.amount)
from usertbl u
join buytbl b on u.userid = b.userid
group by u.userid, u.name;

-- 상품을 가장 많이 구매한 회원(수량기준)
select rownum as RN,name, 총수량 from
(select u.name,sum(b.amount) as 총수량
from usertbl u
join buytbl b on u.userid = b.userid
group by u.name
order by 총수량 desc);

-- 외부조인
-- LEFT OUTER JOIN
-- RIGHT OUTER JOIN
-- FULL OUTER JOIN

--LEFT OUTER JOIN
-- ① 모든 회원의 이름과 구매 내역(없는 경우 NULL로 표시)
select * from usertbl u 
left join buytbl b
on u.userid= b.userid;

-- ② 구매 이력이 없는 회원 조회
select * from usertbl u
left join buytbl b on u.userid = b.userid
where b.userid is null;

-- RIGHT OUTER JOIN
-- ① 구매 내역을 기준으로 회원 정보 조회
select * from buytbl b
right join usertbl u
on u.userid= b.userid;
```
