--
-- Copyright (c) Oracle Corporation 1999. All Rights Reserved.
--
-- NAME
-- demobld.sql
--
-- DESCRIPTION
-- This script creates the SQL*Plus demonstration tables in the
-- current schema. It should be STARTed by each user wishing to
-- access the tables. To remove the tables use the demodrop.sql
-- script.
--
-- USAGE
-- SQL> START demobld.sql
--
-- 

SET TERMOUT ON
PROMPT Building demonstration tables. Please wait.
SET TERMOUT OFF

DROP TABLE EMP;
DROP TABLE DEPT;
DROP TABLE BONUS;
DROP TABLE SALGRADE;
DROP TABLE DUMMY;

CREATE TABLE EMP
(EMPNO NUMBER(4) NOT NULL,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR NUMBER(4),
HIREDATE DATE,
SAL NUMBER(7, 2),
COMM NUMBER(7, 2),
DEPTNO NUMBER(2));

INSERT INTO EMP VALUES
(7369, 'SMITH', 'CLERK', 7902,
TO_DATE('17-DEC-1980', 'DD-MON-YYYY'), 800, NULL, 20);
INSERT INTO EMP VALUES
(7499, 'ALLEN', 'SALESMAN', 7698,
TO_DATE('20-FEB-1981', 'DD-MON-YYYY'), 1600, 300, 30);
INSERT INTO EMP VALUES
(7521, 'WARD', 'SALESMAN', 7698,
TO_DATE('22-FEB-1981', 'DD-MON-YYYY'), 1250, 500, 30);
INSERT INTO EMP VALUES
(7566, 'JONES', 'MANAGER', 7839,
TO_DATE('2-APR-1981', 'DD-MON-YYYY'), 2975, NULL, 20);
INSERT INTO EMP VALUES
(7654, 'MARTIN', 'SALESMAN', 7698,
TO_DATE('28-SEP-1981', 'DD-MON-YYYY'), 1250, 1400, 30);
INSERT INTO EMP VALUES
(7698, 'BLAKE', 'MANAGER', 7839,
TO_DATE('1-MAY-1981', 'DD-MON-YYYY'), 2850, NULL, 30);
INSERT INTO EMP VALUES
(7782, 'CLARK', 'MANAGER', 7839,
TO_DATE('9-JUN-1981', 'DD-MON-YYYY'), 2450, NULL, 10);
INSERT INTO EMP VALUES
(7788, 'SCOTT', 'ANALYST', 7566,
TO_DATE('09-DEC-1982', 'DD-MON-YYYY'), 3000, NULL, 20);
INSERT INTO EMP VALUES
(7839, 'KING', 'PRESIDENT', NULL,
TO_DATE('17-NOV-1981', 'DD-MON-YYYY'), 5000, NULL, 10);
INSERT INTO EMP VALUES
(7844, 'TURNER', 'SALESMAN', 7698,
TO_DATE('8-SEP-1981', 'DD-MON-YYYY'), 1500, 0, 30);
INSERT INTO EMP VALUES
(7876, 'ADAMS', 'CLERK', 7788,
TO_DATE('12-JAN-1983', 'DD-MON-YYYY'), 1100, NULL, 20);
INSERT INTO EMP VALUES
(7900, 'JAMES', 'CLERK', 7698,
TO_DATE('3-DEC-1981', 'DD-MON-YYYY'), 950, NULL, 30);
INSERT INTO EMP VALUES
(7902, 'FORD', 'ANALYST', 7566,
TO_DATE('3-DEC-1981', 'DD-MON-YYYY'), 3000, NULL, 20);
INSERT INTO EMP VALUES
(7934, 'MILLER', 'CLERK', 7782,
TO_DATE('23-JAN-1982', 'DD-MON-YYYY'), 1300, NULL, 10);

CREATE TABLE DEPT
(DEPTNO NUMBER(2),
DNAME VARCHAR2(14),
LOC VARCHAR2(13) );

INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT VALUES (20, 'RESEARCH', 'DALLAS');
INSERT INTO DEPT VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');

CREATE TABLE BONUS
(ENAME VARCHAR2(10),
JOB VARCHAR2(9),
SAL NUMBER,
COMM NUMBER);

CREATE TABLE SALGRADE
(GRADE NUMBER,
LOSAL NUMBER,
HISAL NUMBER);

INSERT INTO SALGRADE VALUES (1, 700, 1200);
INSERT INTO SALGRADE VALUES (2, 1201, 1400);
INSERT INTO SALGRADE VALUES (3, 1401, 2000);
INSERT INTO SALGRADE VALUES (4, 2001, 3000);
INSERT INTO SALGRADE VALUES (5, 3001, 9999);

CREATE TABLE DUMMY
(DUMMY NUMBER);

INSERT INTO DUMMY VALUES (0);

COMMIT;

SET TERMOUT ON
PROMPT Demonstration table build is complete.


select empno,ename from emp;
select empno,ename,sal from emp;

select empno,ename,sal as salary from emp;
select empno,ename,sal as "Annual Salary" from emp;//alais should be enclosed within " "

select empno,ename,sal "Annual salary" from emp;
select empno,ename,sal,sal+2000 Bonus from emp;

select distinct deptno,sal,ename from emp;

select ename|| ' works for ' || mgr "manager Details" from emp;

select ename|| q'[ work's for ]' || mgr "manager Details" from emp;

desc emp;

select empno,ename,sal as salary from emp where ename='SMITh';

select empno,ename,sal as salary,job from emp where ename='SMITH' and job='CLERK';

select empno,ename,sal as salary,job from emp where ename='SMITH' or sal>2500;

select empno,ename,sal as salary,job from emp where sal between 1000 and 3000;

select empno,ename,sal as salary,job from emp where ename not like 'A%';

select empno,ename,sal as salary,job from emp where ename not like '_A%';

select empno,ename,sal as salary,job,deptno from emp where deptno not in(10,20);

select empno,ename,sal as as salary,job,deptno from emp order by ename desc;

select empno,ename en,sal as as salary,job,deptno from emp order by en;

select empno,ename en,sal as salary,job,deptno from emp where salary>1000 order by en;//Alias name we can't use in where clause.

select &enae from &etab wherer &s=&var;
select ename from emp where sal=&sal;

SELECT CONCAT('Hello', NULL, 'World') from dual; -- Output: 'HelloWorld'
SELECT 'Hello' || NULL || 'World' from dual; -- Output: NULL

select lower(ename) from emp;
select upper('hello') from emp;
select initcap(ename) from emp;

select ename,substr(ename,3) from emp;

select replace ('ambrtam','am','jj') from dual;--consider the string

select translate ('ambrtam','amb','bo4') from dual;--consider the character

select length(' hei ') from dual;
select length(trim(' hei ')) from dual;
select lpad('Hello',10,'#') from dual;


select round(45.926,2) from dual;
select round(45.926,0) from dual;
select round(45.926,-1) from dual;
select round(45.926,3) from dual;
select round(45.926,-2) from dual;

select trunc(45.926,2) from dual;
select trunc(45.926,0) from dual;
select trunc(45.926,-1) from dual;
select trunc(45.926,3) from dual;
select trunc(45.926,-2) from dual;

//TRUNC() removes the decimal portion, effectively truncating the number towards zero.
//On the other hand, ROUND() rounds the number to the specified number of decimal places, considering the value in the next decimal place.

select mod(45.926,2) from dual;
select mod(45.926,0) from dual;
select mod(45.926,-1) from dual;
select mod(45.926,3) from dual;
select mod(45.926,-2) from dual;

select sysdate from dual;--Date format DD-MON-RR (DD-MM-RR)

select current_timestamp from dual;

select to_char(sysdate,'fmDDth "of" Mon yy') from dual;

//Number--Right Aligned
//String--Left Aligned
select to_char(hiredate,'ddth "of" Mon YYYY')from emp;

select round(to_date('06-Jul-21','dd-Mon-yy'),'month') from dual;
select round(to_date('16-Jul-21','dd-Mon-yy'),'month') from dual;
select round(to_date('06-Jul-21','dd-Mon-yy'),'year') from dual;

select  to_char(sysdate,'MONTH DD, YEAR') from dual;
select  to_char(sysdate,'MON DD, YYYY') from dual;
select  to_char(sysdate,'MON DD, YY DAY') from dual;
select  to_char(sysdate,'dd/mm/yy') from dual;
select  to_char(sysdate,'dd-mm-yy') from dual; 
select  to_char(sysdate,'ddspth "of" Mon yy') from dual; 
select  to_char(sysdate,'fmddth "of" Mon yy hh24:mi:ss') from dual;

select to_char(to_date('12-apr-1972'),'ddth "of" Mon YYYY') from dual; 
select to_char(hiredate,'ddth "of" Mon YYYY') from emp; 
select to_char(sal,'$99,999.000') from emp; 
select to_number('1000') from dual; 
select '10000'||'200' from dual;
select '10000'+'20' from dual;

//https://docs.oracle.com/cd/E41183_01/DR/Date_Format_Types.html ---->Date Format Types

select add_months( DATE '2016-02-29',1) from dual;

select months_between( DATE '2017-07-01',DATE '2017-01-01') from dual;

select next_day(DATE '2023-06-02','FRIDAY') from dual;

select LAST_DAY(DATE '2023-06-02') from dual;

NVL(expr1,expr2)--If e1=null then e2 else e1
NVL2(expr1,expr2,expr3)--If e1=null then e3 else e2.
NULLIF(expr1,expr2)--If e1=e2 then null else e1.

select ename,comm,nvl(comm,100) from emp;
select ename,comm,nvl2(comm,comm+100,100) from emp;
select ename,comm,nullif(comm,300) from emp;

select ename,job,sal,
case job when 'MANAGER' THEN SAL*10
WHEN 'ANALYST' THEN SAL*5
WHEN 'SALESMAN' THEN SAL*2
else 
SAL
END "REVISED SALARY"
FROM EMP;


select sum(sal),count(*),min(sal),max(sal),avg(sal) from emp;

select count(comm),ename from emp group by ename;

select count(nvl(comm,1)) from emp ;

--group by clause
 1) The columns in the select list  must be available in the groupby clause
 select job,deptno from emp group by deptno,job;
 
2) The columns in the group by may or maynot available in the select list
 select job from emp group by deptno,job;

 3) Group by clause will not accept alias name
 select deptno dn from emp group by dn;

 4) When the select list has an aggregate function , along with column name , its illegal
 select ename, min(sal) from emp where sal>1000;  --illegal
 
5) The column in the select list within the group function, may or maynot be available in the group by
select min(sal),deptno from emp group by deptno;
 
6) Restrict the no. of rows within groups use having clause.
select min(sal),deptno from emp group by deptno having deptno=20;
 
7) The column in the having clause should be available in the groupby clause
select min(sal),deptno from emp group by deptno,sal having sal>1000;
select min(sal),deptno from emp group by deptno,sal having deptno>20;
 
8) The column in the having clause within the aggregate/group function  may or maynot be there in group by clause
select min(sal),deptno from emp group by deptno having min(sal)>900;
 
9) having clause wont acccpt alias name
select min(sal),deptno  from emp group by deptno dn having dn=30; -- illegal
 
10) sequence  -- select from where , group by, having, order by
select min(sal),deptno from emp where sal>=950 group by deptno having min(sal)>900 order by deptno;
 
11) where clause will not accept group function
select sal,deptno from emp where min(sal)>=950  -- illegal
