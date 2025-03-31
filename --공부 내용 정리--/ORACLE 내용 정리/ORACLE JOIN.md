# ORACLE JOIN

## SQL JOIN 정리

---

### 🔹 **INNER JOIN**

- **역할**: 두 테이블에서 **조건이 일치하는 행만** 반환
- **즉**, 공통된 값이 있는 행만 보여줌
- **예시**:
    
    ```sql
    SELECT *
    FROM employees e
    INNER JOIN departments d ON e.dept_id = d.dept_id;
    ```
    

---

### 🔹 **LEFT OUTER JOIN** (LEFT JOIN)

- **역할**: **왼쪽 테이블의 모든 행** + 일치하는 오른쪽 테이블의 값
- 일치하지 않는 오른쪽 값은 `NULL`로 채워짐
- **예시**:
    
    ```sql
    SELECT *
    FROM employees e
    LEFT JOIN departments d ON e.dept_id = d.dept_id;
    ```
    

---

### 🔹 **RIGHT OUTER JOIN** (RIGHT JOIN)

- **역할**: **오른쪽 테이블의 모든 행** + 일치하는 왼쪽 테이블의 값
- 일치하지 않는 왼쪽 값은 `NULL`로 채워짐
- **예시**:
    
    ```sql
    SELECT *
    FROM employees e
    RIGHT JOIN departments d ON e.dept_id = d.dept_id;
    ```
    

---

### 🔹 **FULL OUTER JOIN**

- **역할**: 양쪽 테이블의 **모든 행**을 다 보여줌
    - 일치하면 결합
    - 일치하지 않으면 나머지 컬럼은 `NULL`
- **예시**:
    
    ```sql
    SELECT *
    FROM employees e
    FULL OUTER JOIN departments d ON e.dept_id = d.dept_id;
    ```
    

## 📊 조인 비교 요약

| 종류 | 왼쪽 일치 | 오른쪽 일치 | 일치하지 않음 |
| --- | --- | --- | --- |
| INNER JOIN | ✅ | ✅ | ❌ |
| LEFT OUTER JOIN | ✅ | ✅ / NULL | 왼쪽 기준 유지 |
| RIGHT OUTER JOIN | ✅ / NULL | ✅ | 오른쪽 기준 유지 |
| FULL OUTER JOIN | ✅ / NULL | ✅ / NULL | 전부 포함 |

```sql
select * from studenttbl;
select * from examtbl;

select *
from studenttbl s
full outer join examtbl e
on s.studentid = e.studentid;
```

---

## 📌 표준조인 (NATURAL JOIN)

> 공통된 컬럼(이름이 같은 컬럼)을 기준으로 자동으로 조인
> 

### ✅ 특징

- `ON` 절이 필요 없음
- 공통된 컬럼 이름이 있어야 함
- 자동으로 동일한 이름의 컬럼을 기준으로 내부 조인 수행

```sql
SELECT *
FROM A
NATURAL JOIN B;
```

### ⚠️ 주의

- 명시적인 조건이 없으므로 **예상치 못한 결과**가 나올 수 있음
- 컬럼 이름이 같고 의미가 다를 경우 위험

## 📌 USING 절

> 두 테이블 간에 같은 이름의 컬럼을 기준으로 조인할 때 사용하는 구문
> 

### ✅ 기본 문법

```sql
SELECT *
FROM 테이블1
JOIN 테이블2
USING (공통컬럼);
```

### ✅ 특징

- **컬럼 이름이 두 테이블에 모두 존재해야 함**
- 결과에서는 **공통 컬럼이 한 번만 표시됨**
- `NATURAL JOIN`처럼 자동이지만, **명시적으로 어떤 컬럼을 사용할지 지정** 가능
- `ON A.col = B.col`을 간단하게 `USING (col)`로 표현

### ✅ 예시

### 1. ON 절 사용

```sql
SELECT *
FROM orders o
JOIN customers c
ON o.customer_id = c.customer_id;
```

### 2. USING 절 사용 (같은 의미)

```sql
SELECT *
FROM orders
JOIN customers
USING (customer_id);
```

### ⚠️ 주의할 점

- `USING`은 **컬럼명이 반드시 같아야 함**
- 컬럼명이 다르면 `ON` 절을 사용해야 함
- `USING`을 사용하면 **공통 컬럼이 하나로 통합되어 출력**됨

---

## 🔄 ON vs USING vs NATURAL JOIN 비교

| 구분 | ON | USING | NATURAL JOIN |
| --- | --- | --- | --- |
| 조건 명시 | O (자유롭게) | O (공통 컬럼만) | X (자동 적용) |
| 컬럼 이름 같아야 하나요? | 필요 없음 | 반드시 같아야 함 | 반드시 같아야 함 |
| 명시적 조인 컬럼 | 직접 지정 | 컬럼 이름만 지정 | 자동 탐지 |
| 가독성 | 명확 | 간결 | 위험할 수 있음 |

---

## 📌 서브쿼리 (Subquery)

> 하나의 SQL문 안에 포함된 또 다른 SELECT문
> 

### ✅ 종류

1. **스칼라 서브쿼리**
    - 하나의 값만 반환
    
    ```sql
    ELECT name
    FROM employees
    WHERE salary = (SELECT MAX(salary) FROM employees);
    ```
    
2. **인라인 뷰 (FROM절에 서브쿼리)**
    - 서브쿼리를 테이블처럼 사용
    
    ```sql
    SELECT *
    FROM (SELECT name, salary FROM employees) AS temp
    WHERE salary > 5000;
    ```
    
3. **서브쿼리 in WHERE 절**
    - 특정 조건의 존재 여부 확인
    
    ```sql
    SELECT name
    FROM employees
    WHERE department_id IN (SELECT id FROM departments WHERE location = 'Seoul');
    ```
    
4. **EXISTS 서브쿼리**
    - 결과가 존재하는지 여부만 체크
    
    ```sql
    SELECT name
    FROM employees e
    WHERE EXISTS (
      SELECT 1 FROM departments d WHERE e.department_id = d.id
    );
    ```
    

## 연습한 쿼리

```sql
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
```
