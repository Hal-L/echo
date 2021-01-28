-- 创建db2数据库
CREATE DATABASE db2;

-- 使用db2数据库
USE db2;

/*
	外键约束
	标准语法：
		CONSTRAINT 外键名 FOREIGN KEY (本表外键列名) REFERENCES 主表名(主表主键列名)
		
	外键分类：
		物理外键
				有外键字段，并且使用foreign key在数据库层面关联表
		逻辑外键
				有外键字段，但是没有使用foreign key在数据库层面关联表，而是在后台程序中维护外键关系
				
		应用场景分析
				互联网系统用户量大，并发度高。
							物理外键需要数据库维护事物的特性，资源消耗大。数据库服务器不易扩展，数据库性能容易成为系统的瓶颈。
							逻辑外键可以让数据库表的关系在后台项目代码内控制，让应用服务器承担此部分的压力，且应用服务器易拓展。
				传统行业软件项目并发量可控，数据量也一般不会超大。
							物理外键可以借助数据库产品自身的特性实现表与关联表之间的数据一致性和更新，降低开发成本
							逻辑外键会提高开发成本，降低开发效率和速度。

	物理外键适用于传统普通项目，逻辑外键适用于互联网大型项目。
*/
-- 建表时添加外键约束
-- 创建user用户表
CREATE TABLE USER(
	id INT PRIMARY KEY AUTO_INCREMENT,    -- id
	NAME VARCHAR(20) NOT NULL             -- 姓名
);
-- 添加用户数据
INSERT INTO USER VALUES (NULL,'张三'),(NULL,'李四');


-- 创建orderlist订单表
CREATE TABLE orderlist(
	id INT PRIMARY KEY AUTO_INCREMENT,    -- id
	number VARCHAR(20) NOT NULL,          -- 订单编号
	uid INT,			      -- 外键列
	CONSTRAINT ou_fk1 FOREIGN KEY (uid) REFERENCES USER(id)
);
-- 添加订单数据
INSERT INTO orderlist VALUES (NULL,'hm001',1),(NULL,'hm002',1),
(NULL,'hm003',2),(NULL,'hm004',2);


-- 添加一个订单，但是没有真实用户。添加失败
INSERT INTO orderlist VALUES (NULL,'hm005',3);

-- 删除李四用户。删除失败
DELETE FROM USER WHERE NAME='李四';




/*
	删除外键约束
	标准语法：
		ALTER TABLE 表名 DROP FOREIGN KEY 外键名;
*/
-- 删除外键约束
ALTER TABLE orderlist DROP FOREIGN KEY ou_fk1;



/*
	建表后单独添加外键约束
	标准语法：
		ALTER TABLE 表名 ADD CONSTRAINT 外键名 FOREIGN KEY (本表外键列名) REFERENCES 主表名(主键列名);
*/
-- 添加外键约束
ALTER TABLE orderlist ADD CONSTRAINT ou_fk1 FOREIGN KEY (uid) REFERENCES USER(id);