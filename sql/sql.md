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

{% embed url="https://programmers.co.kr/learn/challenges" %}

