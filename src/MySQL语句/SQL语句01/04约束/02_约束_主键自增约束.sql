创建学生表(编号、姓名、年龄)  编号设为主键自增
/*
	int/long  自动增长
	自增一般和其他键约束配合使用，最常用的是和主键一起配合使用

*/
CREATE TABLE student(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(30),
	age INT
);

-- 查询学生表的详细信息
DESC student;

-- 添加数据
INSERT INTO student VALUES (NULL,'张三',23),(NULL,'李四',24);

-- 删除自增约束
ALTER TABLE student MODIFY id INT;
INSERT INTO student VALUES (NULL,'张三',23);

-- 建表后单独添加自增约束
ALTER TABLE student MODIFY id INT AUTO_INCREMENT;