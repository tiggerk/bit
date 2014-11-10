/* DISTINCT
   중복 데이터 제거
   => DISTINCT를 붙이지 않으면 기본으로 ALL 이다.
       SELECT ALL PNO FROM ORDERS;
 */

/* 1. 모든 제품 번호를 출력하라. */
SELECT /*ALL*/ PNO FROM PRODUCTS;

/* 2) 모든 주문 제품의 번호를 출력하라. */
SELECT /*ALL*/ PNO FROM ORDERS;

/* 3) 주문한 제품이 무엇무엇이 있는지 목록을 출력하라. */
SELECT DISTINCT PNO FROM ORDERS;


/* ORDER BY 절
   출력 결과를 정렬
   문법:
    ORDER BY /*ASC*/ 컬럼명, /*ASC*/ 컬럼명, ...
    ORDER BY 컬럼명, ASC 컬럼명, ... DESC;
 * 
   => 나열된 컬럼 순서대로 정렬한다. 기본은 상향 정렬오름차순(ㄱ ~ ㅎ)이다.
 * 
 * 정렬조건:
   ASC(ASCENDING) => 오름차순
   DESC(DESCENDING) => 내림차순 
 
 * ORDER BY 절 수행 후 SELECT 실행 
 */

/* 1) 기본 출력*/
SELECT UID, UNAME, EMAIL FROM MEMBERS;

/* 2) 이름을 오림 차순으로 정렬하라. */
SELECT UID, UNAME, EMAIL FROM MEMBERS ORDER BY UNAME /*ASC*/;

/* 3) 이름을 내림 차순으로 정렬하라. */
SELECT UID, UNAME, EMAIL FROM MEMBERS ORDER BY UNAME DESC;

/* 4) 주문 정보를 제품 번호의 오름 차순으로 정렬하라 */
select * from  ORDERS order by PNO;

/* 5) 주문 정보를 제품 번호의 오름 차순으로 정렬하고,
      사용자아이디(UID)로 오름차순 정렬하라. */
select * from  ORDERS order by PNO, UID;

/* 6) 주문 정보를 제품 번호의 오름 차순으로 정렬하고,
      사용자아이디(UID)로 내림차순 정렬하라. */
select * from  ORDERS order by PNO, UID desc;

/* 7) 주문 정보를 제품 번호의 오름 차순으로 정렬하고,
      사용자아이디(UID)로 내림차순 정렬하라. 
       => 정렬을 먼저 한 다음  SELECT를 실행한다. */
select ONO, ODATE from  ORDERS order by PNO, UID desc;


/* 별명 붙이기 ALIAS 
   문법:
    SELECT 컬럼명 [AS] 별명, ...
     => AS 생략가능! 별명 중간에 공백이 들어갈 경우에는 '' 사용!
 */
select ONO as NO, ODATE as 'Order Date', PNO 'Product No', UID id
from ORDERS;


/* WHERE 절
   문법:
    WHERE 조건1 (AND | OR) 조건2 ...
 */


/* 연산자 사용 */
/* 1) 더하기 연산자 */
select ONO, QTY, QTY * 500000 as TOTAL from ORDERS;

/* 2) 비교 연산자 */
select ONO, QTY from ORDERS
where QTY > 2;

select ONO, QTY from ORDERS
where QTY = 1;

select ONO, QTY from ORDERS
where QTY > 1 and QTY <= 5;

/* 문자열 비교 */
select UID, UNAME, EMAIL from MEMBERS
where UNAME = '홍길동';

/* '%' 는 0개 이상의 글자 */
select uid, uname, email from MEMBERS
where uname like '김%';

/* '_' 는 1개의 글자 */
select uid, uname, email from MEMBERS
where uname like '김_진';

/* 제품명에 '럭시'라는 글자를 포함한 모든 제품 선택하기
   => 주의! 검색 속도가 매우 느리다. */
select pno, pname
from PRODUCTS
where pname like '%럭시%';

/* IN
   표현식 IN (값, 값, 값, ...)
   => 표현식이 IN에 들어있는 값과 일치하면 TRUE
 */
/* 삼성과 애플 제품을 출력하시오. */
select pno,pname,mkno
from PRODUCTS
where mkno=1 or mkno=2;

select pno,pname,mkno
from PRODUCTS
where mkno in (1, 2);


/* NULL 여부 검사 */
select * from PROD_PHOTS
where pno is null;

select * from PROD_PHOTS
where pno is not null;


/* BETWEEN A AND B */
SELECT * FROM ORDERS
WHERE qty >= 1 AND qty <= 3;

SELECT * FROM ORDERS
WHERE qty BETWEEN 1 AND 3;


/* UNION => 결과의 결합 */
/* 두 개의 결과를 합쳐서 하나로 다루고 싶을 때 
   예) 제품 이름과 제조사이름을 알고 싶다.  */
select pname from PRODUCTS
UNION
select mkname from MAKERS;

/* 예) 2014년 7월 이후의 주문 정보와 애플 제품 주문 정보를 출력하시오. */
/* UNION => 두 결과 데이터를 합칠 때 중복 데이터 제거 */
select * from ORDERS where odate >= '2014-7-1'
union
select * from ORDERS where pno in (1, 2, 3);

/* UNION ALL => 두 결과 데이터를 중복에 상관없이 합친다. */
select * from ORDERS where odate >= '2014-7-1'
union all
select * from ORDERS where pno in (1, 2, 3);

/* 7월 이후 주문 정보 중에서 애플 제품을 제외한 주문 정보 */
/* MySQL은 MINUS가 없다. 다른 문법으로 대체해야 한다. */
/*
select * from ORDERS
where odate >= '2014-7-1'
MINUS
select * from ORDERS
where PNO in (1, 2, 3);
*/
select * from ORDERS
where
odate >= '2014-7-1'
and pno not in (1, 2, 3);


/* 서브 쿼리 */
/* 1) 주문 제품의 주문 번호와 제품명을 출력하라 */
select 
ono,
pno,
(select pname from PRODUCTS where pno=T1.pno) as NAME,
qty
from ORDERS T1;

/* 2) where절에 서브쿼리 => 검색어와 일치하는 회사 제품의 주문 정보를 출력하시오. */
select * from ORDERS
where pno in (select pno from PRODUCTS where mkno=1);

/* 3) from절에 서브쿼리 => '2014-7-1' 이후에 주문한 정보 중에서 u01, u05가 주문한 것
 */
select * from (select * from ORDERS where odate >= '2014-7-1') as T1
where uid in ('u01', 'u05');


