/*
SELECT SNO,Name
FROM student
WHERE College = '计算机学院';
*/
/*
SELECT *
FROM student
WHERE Age BETWEEN 20 AND 23;
*/
/*
SELECT COUNT(*)
FROM student;
*/
/*
SELECT MAX(Score),MIN(Score),SUM(Score),AVG(Score)
FROM Choose
WHERE CourseID = 'C1';
*/
/*
SELECT CourseID,CourseName
FROM course
WHERE CourseBeforeID is NULL;
*/
/*
SELECT student.SNO,Name,CourseName,Score
FROM student,course,choose
where student.SNO=choose.SNO AND course.CourseID=choose.CourseID;
*/
/*
SELECT *
FROM student x
WHERE EXISTS(
SELECT *
FROM student y
WHERE x.College=y.College AND Name='张三');
*/
/*
SELECT SNO
FROM choose
WHERE CourseID='C1'
UNION
SELECT SNO
FROM choose
WHERE CourseID='C3';
*/
SELECT DISTINCT SNO
FROM choose
WHERE CourseID='C1'
UNION
SELECT DISTINCT SNO
FROM choose
WHERE CourseID='C3';