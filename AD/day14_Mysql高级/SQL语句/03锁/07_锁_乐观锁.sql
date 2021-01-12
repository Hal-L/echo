/*
	悲观锁
		依赖于mysql本身的锁机制（事务管理机制），之前演示的各种锁都属于悲观锁。
	乐观锁
		不是mysql原生支持的安全机制，而是我们根据需要自己完成安校验逻辑。
		本质上是添加一个字段，用于版本或者标识。
		对于修改比较多的表，不适合乐观锁。

*/

-- 创建city表
CREATE TABLE city(
	id INT PRIMARY KEY AUTO_INCREMENT,  -- 城市id
	NAME VARCHAR(20),                   -- 城市名称
	VERSION INT                         -- 版本号
);

-- 添加数据
INSERT INTO city VALUES (NULL,'北京',1),(NULL,'上海',1),(NULL,'广州',1),(NULL,'深圳',1);


-- 将北京修改为北京市
-- 1.将北京的版本号读取出来
SELECT VERSION FROM city WHERE NAME='北京';   -- 1
-- 2.修改北京为北京市，版本号+1.并对比版本号是否相同
UPDATE city SET NAME='北京市',VERSION=VERSION+1 WHERE NAME='北京' AND VERSION=1;

/*
	乐观锁并不是真正意义上的锁，只是一种解决数据安全的方式。
	并发读高使用乐观锁
	
	悲观锁需要借助于数据库的事务特性
	修改多使用悲观锁


*/