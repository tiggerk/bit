/* 1) CROSS 조인
    => 두 개의 테이블 데이터를 M:N 조인 */
select ono, pno, qty from ORDERS;
select pno, pname from PRODUCTS;

select ono, T1.pno, T1.qty, pname
from ORDERS T1, PRODUCTS T2;


/* 2) NATURAL 조인
    => 두 개의 테이블의 공통 컬럼을 기준으로 조인한다.
    => 외부키를 기준으로 조인을 수행한다. */
select ono, T1.pno, T1.qty, pname
from ORDERS T1, PRODUCTS T2
where T1.pno = T2.pno;

/* 2) NATURAL 조인 => T1 JOIN T2 USING(컬럼명, 컬럼명, ...) 
    => 단, 조인할 때 기준이 되는 컬럼명이 같아야 한다. */
select ono, T1.pno, T1.qty, pname
from ORDERS T1 join PRODUCTS T2 using(pno);

/* 2) NATURAL 조인 => T1 JOIN T2 ON 조인조건1 ... 
    => 조인의 기준이 되는 컬럼명이 다를 때 사용. */
select ono, T1.pno, T1.qty, pname
from ORDERS T1 join PRODUCTS T2 on T1.pno = T2.pno;


/* 3) OUTER JOIN */
/* 모든 제품정보를 출력하되, 사진정보도 함께 출력하라.
   => 다음 질의문은 조인 가능한 결과만 출력한다. */
select T1.pno, T1.pname, T2.url
from PRODUCTS T1 join PROD_PHOTS T2 on T1.pno=T2.pno;

/* 조인이 불가능하더라도, 즉 조인할 데이터가 상대 테이블에 없더라도
   반드시 기준이 되는 테이블의 데이터를 모두 출력하고 싶다면 OUTER 조인을 사용하라!
   문법: 왼쪽 T1 테이블을 기준으로 T2 테이블과 조인하라!
    => T1 LEFT OUTER JOIN T2 ON 조인조건1 ...
    => 기준 테이블인 T1의 데이터는 모두 출력될 것이다.  */
select T1.pno, T1.pname, T2.url
from PRODUCTS T1 left outer join PROD_PHOTS T2 on T1.pno=T2.pno;

/* 사진 테이블을 기준으로 조인을 하고 싶다면 */
select T1.pno, T1.pname, T2.url
from PRODUCTS T1 right outer join PROD_PHOTS T2 on T1.pno=T2.pno;


/* 문제: 다음 결과를 출력하시오!
   주문번호, 제품명, 제조사명, 주문수량, 잔여수량, 고객명, 고객이메일 */
select
T1.ono as '주문번호',
T2.pname '제품명',
T4.mkname '제조사명',
T1.qty '주문수량',
T2.qty '잔여수량',
T3.uname '고객명',
T3.email '고객이메일'
from ORDERS T1
left outer join PRODUCTS T2 on T1.pno=T2.pno
left outer join MEMBERS T3 on T1.uid=T3.uid
left outer join MAKERS T4 on T2.mkno=T4.mkno;





