/*
	多对多
		A表多条记录和B表中多条记录有关系
	
	建表原则
		借助中间表，该标最少有两个字段，分别作为外键指向另外两张表的主键
		
	从A、B表任意一表的角度出发，都是多对多关系
		从中间表角度出发，是一对多关系。
		多对多的关系可以成分多个一对多。
		
	中间表建表原则
		
		如果中间表只需要有两个外键字段，该表仅仅是作为中间表使用，不需要单独定义主键，可以使用联合主键
			利用两个外键作为该中间表的联合主键（多个列一起作为主键）使用
			CREATE TABLE stu_course2 (
				sid INT,
				cid INT,
				PRIMARY KEY (sid,cid),
				CONSTRAINT `stu_course2_ibfk_1` FOREIGN KEY (sid) REFERENCES student (id),
				CONSTRAINT `stu_course2_ibfk_2` FOREIGN KEY (cid) REFERENCES course (id)
			) 

		如果该中间表中有其他业务字段，此时是该表一张业务表，就需要定义一个额外主键
			增加一个字段，单独作为主键使用
			CREATE TABLE stu_course (
				id INT PRIMARY KEY AUTO_INCREMENT,
				sid INT,
				cid INT,
				xxx VARCHAR(20),     -- 业务字段
				desc VARCHAR(120),
				CONSTRAINT `sc_fk1` FOREIGN KEY (sid) REFERENCES student (id),
				CONSTRAINT `sc_fk2` FOREIGN KEY (cid) REFERENCES course (id)
			) 
*/

-- 创建student表
CREATE TABLE student(
	id INT PRIMARY KEY AUTO_INCREMENT,	-- 主键id
	NAME VARCHAR(20)			-- 学生姓名
);
-- 添加数据
INSERT INTO student VALUES (NULL,'张三'),(NULL,'李四');

-- 创建course表
CREATE TABLE course(
	id INT PRIMARY KEY AUTO_INCREMENT,	-- 主键id
	NAME VARCHAR(10)			-- 课程名称
);
-- 添加数据
INSERT INTO course VALUES (NULL,'语文'),(NULL,'数学');


-- 创建中间表
CREATE TABLE stu_course(
	id INT PRIMARY KEY AUTO_INCREMENT,	-- 主键id
	sid INT,  -- 用于和student表中的id进行外键关联
	cid INT,  -- 用于和course表中的id进行外键关联
	CONSTRAINT sc_fk1 FOREIGN KEY (sid) REFERENCES student(id), -- 添加外键约束
	CONSTRAINT sc_fk2 FOREIGN KEY (cid) REFERENCES course(id)   -- 添加外键约束
);
-- 添加数据
INSERT INTO stu_course VALUES (NULL,1,1),(NULL,1,2),(NULL,2,1),(NULL,2,2);

/*


*/