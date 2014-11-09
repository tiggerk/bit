/* CREATE DATABASE 문장을 사용하여 테이블들을 보관할 데이터베이스를 만든다. */
CREATE DATABASE

/* USE DATABASE : 테이블을 만들고 조작하기 위해 데이터베이스로 들어가는 명령. */
USE DATABASE

/* CREATE TABLE
 *  테이블 세팅을 시작한다. 테이블에 넣을 데이터의 종류를 분석하여
 *  열 이름과 데이터 타입을 알고 있어야 한다. */

/* DROP TABLE
 *  실수를 하는 경우 테이블을 지울 수 있도록 한다.
 *  하지만 INSERT 문을 사용하여 값을 넣기 전에 하는 것이 좋다. */

/* NULL
 *  NULL 값은 정의되지 않은 값이다. 0이나 빈 값이 아니다.
 *  NULL인 열은 IS NULL이지 EQUAL NULL(NULL과 같다)가 아니다. */

/* NULL과 NOT NULL
 *  분류 검색을 하려면 어떤 열이 NULL값을 가지면 안되는지 알아야 한다.
 *  그리고 테이블을 만들 때 그 열을 NOT NULL로 세팅해야 한다. */

/* DEFAULT
 * 열에 대한 디폴트 값을 정하고, 레코드 삽입 시, 그 열에 대한 값을 넣지 않으면
 * 디폴트 값이 사용된다. */

/* INSERT 문에서 값이 할당되지 않은 열은 디폴트로 NULL이 된다. */



/* 테이블을 만드는 명령어 CREATE TABLE */
CREATE TABLE my_contacts
(
last_name VARCHAR(30),
first_name VARCHAR(20),
email VARCHAR(50),
gender CHAR(1),
birthday DATE,
profession VARCHAR(50),
location VARCHAR(50),
status VARCHAR(20),
interests VARCHAR(100),
seeking VARCHAR(100)
);	

/* 테이블의 구조 정보를 보는 명령어 DESC */
DESC my_contacts;


/* 테이블을 지우는 명령어 DROP TABLE */
DROP TABLE my_contacts;


/* 데이터 타입
CHAR 또는 CHARACTER
 : 데이터가 정해진 길이(length)여야한다. 항상 작은 따옴표를 사용한다.
INT 또는 INTEGER
 : 정수를 나타낸다. 음수도 나타낸다. 따옴표를 사용하지 않는다.
DEC(DECIMAL의 약어)
 : 필요한 만큼의 십진 자릿수를 준다. DEC(3,2) => 전체 3자리,소숫점이하 2자리.
   따옴표를 사용하지 않는다.
DATE
 : 날짜를 다룬다. 시간은 다루지 않는다. 항상 작은 따옴표를 사용한다.
DATETIME 또는 TIMESTAMP
 : 데이터베이스 시스템에 따라 둘 중 하나로 쓴다. 항상 따옴표를 사용한다.
TIME
 : 시간을 다루고 날짜는 다루지 않는다. 항상 따옴표를 사용한다.
BLOB
 : 큰 덩어리의 문자 데이터를 다룬다. 항상 작은 따옴표를 사용한다.
VARCHAR
 : 길이 255개까지의 문자 데이터를 저장한다. 유연해서 데이터의 길이에 맞게 크기를 조절한다.
   항상 작은 따옴표를 사용한다.
*/


/* 테이블에 데이터를 추가. INSERT문 */
INSERT INTO 테이블이름 (열의이름, 열의이름, ...)
VALUES ('값', '값', ...);

INSERT INTO my_contacts
(last_name, first_name, email, gender, birthday, profession, location, status, interests,seeking)
VALUES
('Kang','Da-hyun','jill_anderson@breakneckpizza.com','F','1980-09-05','Technical Writer',
'Palo Alto, CA','Single','kayaking, Reptiles', 'Relationship, Friends');

INSERT INTO my_contacts
(first_name, email, profession, location)
VALUES
('Pat', 'patpost@breakneckpizza.com', 'Postal Worker', 'Princeton, NJ');


/* 테이블 안의 정보 보기 SELECT */
SELECT * FROM my_contacts;
+-----------+------------+----------------------------------+--------+------------+------------------+---------------+--------+--------------------+-----------------------+
| last_name | first_name | email                            | gender | birthday   | profession       | location      | status | interests          | seeking               |
+-----------+------------+----------------------------------+--------+------------+------------------+---------------+--------+--------------------+-----------------------+
| Kang      | Da-hyun    | jill_anderson@breakneckpizza.com | F      | 1980-09-05 | Technical Writer | Palo Alto, CA | Single | kayaking, Reptiles | Relationship, Friends |
| NULL      | Pat        | patpost@breakneckpizza.com       | NULL   | NULL       | Postal Worker    | Princeton, NJ | NULL   | NULL               | NULL                  |
+-----------+------------+----------------------------------+--------+------------+------------------+---------------+--------+--------------------+-----------------------+


/* NULL 제어하기 - NOT NULL은 DESC결과에 표시된다.*/
CREATE TABLE my_contacts
(
last_name VARCHAR(30) NOT NULL,
first_name VARCHAR(20) NOT NULL
);


/* 빈칸을 DEFAULT 값으로 채우기 - 디폴트 값을 쓰면 빈 열을 지정된 값으로 채운다.*/
CREATE TABLE doughnut_list
(
doughnut_name VARCHAR(10) NOT NULL,
doughnut_type VARCHAR(6) NOT NULL,
doughnut_cost DEC(3,2) NOT NULL DEFAULT 1.00
);


/* 더 나은 SELECT문 */
SELECT * FROM 테이블이름
WHERE (열의 이름) = '열에 대한 값';

SELECT * FROM easy_drinks
WHERE drink_name = 'Oh My Gosh';
+------------+--------------+---------+-----------------+---------+---------------------------------------+
| drink_name | main         | amount1 | second          | amount2 | directions                            |
+------------+--------------+---------+-----------------+---------+---------------------------------------+
| Oh My Gosh | peach nectar |     1.0 | pineapple juice |    1.00 | stir with ice, strain into shot glass |
+------------+--------------+---------+-----------------+---------+---------------------------------------+


/* 특정 데이터 SELECT */
SELECT drink_name, main, second
FROM easy_drinks
WHERE main = 'soda';
+------------+------+-----------------+
| drink_name | main | second          |
+------------+------+-----------------+
| Black Moon | soda | blueberry juice |
+------------+------+-----------------+





/* 예제 */
CREATE TABLE easy_drinks 
(
drink_name VARCHAR(16) NOT NULL,
main VARCHAR(20) NOT NULL,
amount1 DEC(3,1) NOT NULL,
second VARCHAR(30) NOT NULL,
amount2 DEC(4,2) NOT NULL,
directions VARCHAR(250) NOT NULL
);

INSERT INTO easy_drinks
VALUES
('Blackthorn', 'tonic water', 1.5, 'pineapple juice', 1,
'stir with ice, strain into cocktail glass with lemon twist');

INSERT INTO easy_drinks
VALUES
('Black Moon', 'soda', 1.5, 'blueberry juice', .75,
'stir with ice, strain into cocktail glass with lemon twist');

INSERT INTO easy_drinks
VALUES
('Oh My Gosh', 'peach nectar', 1, 'pineapple juice', 1,
'stir with ice, strain into shot glass');




