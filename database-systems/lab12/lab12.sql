-- 1. Display names and salaries of employees who earn more than JONES(EMPNO=7566)
SELECT ENAME,SAL FROM EMP WHERE SAL > (SELECT SAL FROM EMP WHERE EMPNO=7566)
-- 2. Display employee number and names for all employees who earn more than the average salary
SELECT EMPNO,ENAME FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP)
-- 3. Display names of managers
SELECT ENAME FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP)
-- 4. Display employees’ names and salaries whose salary is greater than the average salaries of all
departments (Hint: Use ALL)
SELECT ENAME, SAL FROM EMP WHERE SAL > ALL (SELECT AVG(SAL) FROM EMP GROUP BY DEPTNO)
-- 5. Display names and jobs of employees who are not clerks and whose salary is less than any clerk
(Hint: Use ANY)
SELECT ENAME, JOB FROM EMP WHERE JOB <> 'CLERK' AND SAL < ANY (SELECT SAL FROM EMP WHERE JOB = 'CLERK')
-- 6. Insert a row into dept table without using column names (SOFTWARE, 50)
INSERT INTO DEPT VALUES (50, 'SOFTWARE', NULL)
-- 7. Insert a row into emp table using column names ename, empno and hiredate (EMPLOYEE1,
1234, CURRENT DATE())
INSERT INTO EMP (ENAME, EMPNO, HIREDATE) VALUES ('EMPLOYEE1', 1234, CURDATE())
-- 8. Insert employees who assigned commission into the bonus table with all required values
INSERT INTO BONUS (ENAME, JOB, SAL, COMM) SELECT ENAME, JOB, SAL, COMM FROM EMP WHERE COMM IS NOT NULL AND COMM <> 0
-- 9. Update dept table as’SOFTWARE’ department’s location to ’IZMIR’
UPDATE DEPT SET LOC = 'IZMIR' WHERE DNAME = 'SOFTWARE'
-- 10. Update salaries of all employees increasing 10 percent
UPDATE EMP SET SAL = SAL * 1.1
-- 11. Delete employee with empno 1234
DELETE FROM EMP WHERE EMPNO = 1234
-- 12. Delete departments with no employees
DELETE FROM DEPT WHERE DEPTNO NOT IN (SELECT DEPTNO FROM EMP GROUP BY DEPTNO)