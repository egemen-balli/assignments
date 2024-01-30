-- 1. Display employee names in uppercase along with their job titles in lowercase.
SELECT UPPER(ENAME), LOWER(JOB) FROM EMP
-- 2. Display the first three characters of each employee’s name
SELECT SUBSTRING(ENAME, 1, 3) FROM EMP
-- 3. Display names and jobs of employees concatenated with ”/” and use the alias ”EMPLOYEES”
SELECT CONCAT(ENAME, '/', JOB) FROM EMP
-- 4. Display names of employees and the number of characters in their names
SELECT ENAME, LENGTH(ENAME) FROM EMP
-- 5. Display names of employees with department names
SELECT ENAME, DNAME FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO
-- 6. Display department names and employee names (all departments must be displayed)
SELECT DEPT.DNAME, COALESCE(ENAME, 'No employees') FROM DEPT LEFT OUTER JOIN EMP ON DEPT.DEPTNO = EMP.DEPTNO
-- 7. Display a list of departments that have no employees
SELECT DEPT.DNAME FROM DEPT LEFT OUTER JOIN EMP ON DEPT.DEPTNO = EMP.DEPTNO WHERE EMP.EMPNO IS NULL
-- 8. Display names, salaries, and salary grades of employees
SELECT ENAME, SAL, GRADE FROM EMP JOIN SALGRADE ON EMP.SAL <= SALGRADE.HISAL AND EMP.SAL >= SALGRADE.LOSAL
-- 9. Display names of employees and names of their managers
SELECT A.ENAME, B.ENAME AS MANAGER FROM EMP A, EMP B WHERE A.MGR = B.EMPNO
-- 10. Display the details of employees who earn a commission, including their employee number, employee name, job, salary, commission, department number, and department name.
SELECT EMPNO, ENAME, JOB, SAL, COMM, EMP.DEPTNO, DNAME FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO WHERE COMM IS NOT NULL AND COMM > 0