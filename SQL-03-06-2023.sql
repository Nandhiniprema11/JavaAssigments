1. Display all the information of the EMP table.

select * from emp;

desc emp;

select * from emp;

2. Display unique Jobs from EMP table.

select distinct job from emp;

3. Display the details of all MANAGERS.

select distinct mgr from emp where mgr is not null;

4. List the emps who joined before 1981.

select * from emp where hiredate<=to_date('31-12-1980','DD/MM/YYYY');

5. Display the Empno, Ename, Job, Hiredate, and experience of all Managers.

select Empno, Ename, Job, Hiredate,round(MONTHS_BETWEEN (sysdate,hiredate)) experience
from emp where empno in (select distinct mgr from emp) ;

6. List the Empno, Ename, Sal, Exp of all emps working for Mgr 7839.

select Empno, Ename,Sal,round(MONTHS_BETWEEN (sysdate,hiredate)) experience from emp where mgr='7839';

7. Display all the details of the emps whose Comm. Is more than their Sal.

select * from emp where COMM >= SAL;

8. List the emps along with their Exp and whose Daily Sal is more than Rs. 100.

select empno,ename,round(MONTHS_BETWEEN (sysdate,hiredate)) experience from emp where sal>=100;

9. List the emps who are working for the Deptno 10 or 20.

SELECT * FROM emp  WHERE Deptno IN (10, 20);

10. List the emps who are working under any Manager.

SELECT * FROM emp WHERE mgr IS NOT NULL;

11. List all the Clerks of Deptno 20.

SELECT * FROM emp WHERE Deptno = 20 AND job =upper('Clerk');

12. Display the details of SMITH.

 SELECT * FROM emp WHERE ENAME = 'SMITH';

13. Display the Empno, Ename, Deptno from EMP table.

SELECT Empno, Ename, Deptno FROM EMP;

14. Write a query to display the Empno and the Deptno of all emps.

SELECT Empno, Deptno FROM EMP;

15. Display the unique Depts of emps.
 SELECT DISTINCT Deptno FROM EMP;

16. List the emps whose Salary is more than 3000 after giving 20% increment.

 SELECT * FROM emp WHERE sal * 1.2 > 3000;

17. List the Ename and Sal increased by 15% and expressed as No. of Dollars.

 SELECT Ename, Sal * 1.15 AS Increased_Salary FROM emp;

18. Produce the output of EMP table EMP_AND_JOB for Ename and job.

 SELECT Ename,'_',Job FROM EMP;

19. Display the Empno, Ename, Salary of all Managers.

 SELECT Empno, Ename, SAl FROM emp WHERE job = 'MANAGER';

20. Define a variable representing the expression used to calculate on emps total annual remuneration use the variable in a statement which finds all emps 

who can earn 30000 a year or more.