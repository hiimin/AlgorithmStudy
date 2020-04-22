# SQL

##  ORDER BY

###  기본 구조

```sql
SELECT * FROM TABLE_NAME 
ORDER BY COLUMN_NAME (ASC, DESC);
```

 ASC 는 오름차순\(기본값\), DESC 는 내림차

###  여러 열을 기준으로 사용

```sql
SELECT * FROM TABLE_NAME 
ORDER BY 3, 1 DESC;
```

3번째 열을 기준으로 오름차순으로 정렬한 상태에서 1번째 열을 기준으로 내림차순으로 정렬하는 쿼

### LIMIT

```sql
SELECT * FROM TABLE_NAME
LIMIT 10;
```

 상위 N개의 행만 출력

### MIN, MAX

```sql
SELECT MAX(COLUMN_NAME1), MIN(COLUMN_NAME2) FROM TABLE_NAME;
```

 컬럼의 최대값 및 최소값 출력

### COUNT

```sql
SELECT COUNT(*) FROM TABLE_NAME;
```

 테이블 전체의 행 숫자를 알고 싶다면 COUNT\(\*\)를 사용하고 특정 컬럼의 숫자를 확인하려면 COUNT\(컬럼명\)을 사용한다.

### DISTINCT

```sql
SELECT DISTINCT COLUMN_NAME FROM TABLE_NAME;
```

 지정한 열의 데이터가 중복될 경우, 중복된 값을 제거하고 하나만 출력

### GROUP BY

```sql
SELECT COLUMN_NAME 
FROM TABEL_NAME
GROUP BY COLUMN_NAME;
```

 동일한 값을 가진 데이터를 집계해서 조회하고자 할 때 사용하는 문장. 

* 집계할 컬럼을 GROUP BY절 뒤에 적어준다.
* SELECT 절에는 GROUP BY에 명시된 컬럼만 사용할 수 있다.
* WHERE절과 ORDER BY절 사이에 위치

### HAVING

 집계함수를 가지고 조건비교를 할 때 사용한다.\(WHERE 절에서는 집계함수 사용 불가\) GROUP BY절과 함께 사용됨.

```sql
SELECT NAME, COUNT(NAME)
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
HAVING COUNT(NAME) > 1
ORDER BY NAME ASC;
```

이름이 NULL이 아니고 같은 이름이 1개 이상인 이름과 개수를 출력.

```sql
SELECT HOUR(DATETIME), COUNT(DATETIME)
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) > 8 AND HOUR(DATETIME) < 20
GROUP BY HOUR(DATETIME);
```

9시부터 19시까지, 각 시간대별로 존재하는 컬럼 개수 출력. HOUR\(DATETIME\)은 DATETIME에서 시간만 뽑아

### IS NULL

```sql
SELECT * FROM TABLE_NAME WHERE COLUMN_NAME IS NULL;
```

 필드 값이 비어있는 컬럼 출

### IS NOT NULL

```sql
SELECT * FROM TABLE_NAME WHERE COLUMN_NAME IS NOT NULL;
```

 필드 값이 존재하는 컬럼 출력

### IFNULL

```sql
SELECT COLUMN_NAME1, IFNULL(COLUMN_NAME2,"TEXT"), COLUMN_NAME3
FROM TABLE_NAME;
```

 해당 컬럼의 값이 비어있을 경우\(NULL\) "TEXT"로 대체

## JOIN

 두개 이상의  테이블이나 데이터베이스를 연결하여 데이터를 검색하는 방법이다. 자신이 검색하고 싶은 컬럼이 다른 테이블에 있을 경우 주로 사용하는 방법이며 여러개의 테이블을 마치 하나의 테이블인 것처럼 활용하는 방법. 보통 Primary Key 혹은 Foreign Key로 두 테이블을 연결한다. 테이블을 연결하려면 적어도 하나의 컬럼은 서로 공유되고 있어야 한다. 벤다이어그램을 활용하면 쉽게 이해할 수 있음

### INNER JOIN

![](../.gitbook/assets/image%20%2849%29.png)

*  교집합
*  기준테이블과 Join한 테이블의 중복된 값을 보여줌
* 결과값은 A테이블과 B테이블이 모두 가지고 있는 데이터만 검색된다.

```sql
SELECT
테이블별칭.조회할칼럼,
테이블별칭.조회할칼럼
FROM 기준테이블 별칭
INNER JOIN 조인테이블 별칭 ON 기준테이블별칭.기준키 = 조인테이블별칭.기준키....

--예제--
SELECT
A.NAME, --A테이블의 NAME조회
B.AGE --B테이블의 AGE조회
FROM EX_TABLE A
INNER JOIN JOIN_TABLE B ON A.NO_EMP = B.NO_EMP AND A.DEPT = B.DEPT
```

### LEFT OUTER JOIN

![](../.gitbook/assets/image%20%2869%29.png)

*  기준 테이블의 값 + 테이블과 기준 테이블의 중복된 값을 보여줌
*  왼쪽 테이블을 기준으로 JOIN
*  A테이블의 모든 데이터와 A테이블과 B테이블의 중복되는 값이 검색됨

```sql
SELECT
테이블별칭.조회할칼럼,
테이블별칭.조회할칼럼
FROM 기준테이블 별칭
LEFT OUTER JOIN 조인테이블 별칭 ON 기준테이블별칭.기준키 = 조인테이블별칭.기준키 .....

--예제--
SELECT
A.NAME, --A테이블의 NAME조회
B.AGE --B테이블의 AGE조회
FROM EX_TABLE A
LEFT OUTER JOIN JOIN_TABLE B ON A.NO_EMP = B.NO_EMP AND A.DEPT = B.DEPT
```



### RIGHT OUTER JOIN

![](../.gitbook/assets/image%20%2827%29.png)

*  기준 테이블의 값 + 테이블과 기준 테이블의 중복된 값을 보여줌
*  오쪽 테이블을 기준으로 JOIN
*  B테이블의 모든 데이터와 A테이블과 B테이블의 중복되는 값이 검색됨

```sql
SELECT
테이블별칭.조회할칼럼,
테이블별칭.조회할칼럼
FROM 기준테이블 별칭
RIGHT OUTER JOIN 조인테이블 별칭 ON 기준테이블별칭.기준키 = 조인테이블별칭.기준키 .....

--예제--
SELECT
A.NAME, --A테이블의 NAME조회
B.AGE --B테이블의 AGE조회
FROM EX_TABLE A
RIGHT OUTER JOIN JOIN_TABLE B ON A.NO_EMP = B.NO_EMP AND A.DEPT = B.DEPT
```

### FULL OUTER JOIN

![](../.gitbook/assets/image%20%2864%29.png)

*  합집합
*  A테이블이 가지고 있는 데이터, B테이블이 가지고있는 데이터 모두 검

```sql
SELECT
테이블별칭.조회할칼럼,
테이블별칭.조회할칼럼
FROM 기준테이블 별칭
FULL OUTER JOIN 조인테이블 별칭 ON 기준테이블별칭.기준키 = 조인테이블별칭.기준키 .....

--예제--
SELECT
A.NAME, --A테이블의 NAME조회
B.AGE --B테이블의 AGE조회
FROM EX_TABLE A
FULL OUTER JOIN JOIN_TABLE B ON A.NO_EMP = B.NO_EMP AND A.DEPT = B.DEPT
```

### CROSS JOIN

![](../.gitbook/assets/image%20%2879%29.png)

*  모든 경우의 수를 전부 표

```sql
--문법(첫번째방식)--
SELECT
테이블별칭.조회할칼럼,
테이블별칭.조회할칼럼
FROM 기준테이블 별칭
CROSS JOIN 조인테이블 별칭

--예제(첫번째방식)--
SELECT
A.NAME, --A테이블의 NAME조회
B.AGE --B테이블의 AGE조회
FROM EX_TABLE A
CROSS JOIN JOIN_TABLE B

================================================================

--문법(두번째방식)--
SELECT
테이블별칭.조회할칼럼,
테이블별칭.조회할칼럼
FROM 기준테이블 별칭,조인테이블 별칭

--예제(두번째방식)--
SELECT
A.NAME, --A테이블의 NAME조회
B.AGE --B테이블의 AGE조회
FROM EX_TABLE A,JOIN_TABLE B
```

### SELF JOIN

![](../.gitbook/assets/image%20%287%29.png)

*  자기자신과 자기자신을 조인
*  자신이 가지고 있는 칼럼을 다양하게 변형시켜 활용할 경우 사용

```sql
--문법--
SELECT
테이블별칭.조회할칼럼,
테이블별칭.조회할칼럼
FROM 테이블 별칭,테이블 별칭2

--예제--
SELECT
A.NAME, --A테이블의 NAME조회
B.AGE --B테이블의 AGE조회
FROM EX_TABLE A,EX_TABLE B
```

## LIKE

 특정 문자열이 포함된 데이터 검색

```sql
-- 문법
SELECT COLUMN_NAME
FROM TABLE_NAME
WHERE COLUMN_NAME
LIKE '%특정문자열%';

--  예제
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NAME LIKE '%EL%'
AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME;
```

## CASE WHEN THEN

*  조건에 따라 값을 지정
* 컬럼이 조건1 일 경우 값1, 조건2 일 경우 값2를 반환하고, 조건에 맞지 않을 경우 값3 반

```sql
-- 문
CASE 컬럼  
WHEN 조건1 THEN 값1 
WHEN 조건2 THEN 값2 
ELSE 값3 
END

-- 예제
SELECT ProductNumber, Name,
CASE  
WHEN ListPrice = 0 THEN 'Mfg item - not for resale'  
WHEN ListPrice < 50 THEN 'Under $50'  
WHEN ListPrice >= 50 and ListPrice < 250 THEN 'Under $250'  
WHEN ListPrice >= 250 and ListPrice < 1000 THEN 'Under $1000'  
ELSE 'Over $1000' 
END  
FROM Production.Product ORDER BY ProductNumber;
```

##  DATE\_FORMAT\(\)

 DATETIME의 형식 변환

{% embed url="https://www.w3schools.com/sql/func\_mysql\_date\_format.asp" %}



