/*
	查询所有数据库
	标准语法：
		SHOW DATABASES;
*/
-- 查询所有数据库
SHOW DATABASES;


/*
	查询某个数据库的创建语句
	标准语法：
		SHOW CREATE DATABASE 数据库名称;
*/
-- 查询mysql数据库的创建语句
SHOW CREATE DATABASE mysql;



/*
	创建数据库
	标准语法：
		CREATE DATABASE 数据库名称;
*/
-- 创建db1数据库
CREATE DATABASE db1;


/*
	创建数据库，判断、如果不存在则创建
	标准语法：
		CREATE DATABASE IF NOT EXISTS 数据库名称;
*/
-- 创建数据库db2(判断，如果不存在则创建)
CREATE DATABASE IF NOT EXISTS db2;


/*
	创建数据库、并指定字符集
	标准语法：
		CREATE DATABASE 数据库名称 CHARACTER SET 字符集名称;
*/
-- 创建数据库db3、并指定字符集utf8
CREATE DATABASE db3 CHARACTER SET utf8;

-- 查看db3数据库的字符集
SHOW CREATE DATABASE db3;


-- 练习：创建db4数据库、如果不存在则创建，指定字符集为gbk
CREATE DATABASE IF NOT EXISTS db4 CHARACTER SET gbk;


-- 查看db4数据库的字符集
SHOW CREATE DATABASE db4;



/*
	完整的创建数据库的语法
	
	CREATE DATABASE [IF NOT EXISTS] 数据库名字 [CHARACTER SET 字符集名称];

	第三方工具中，SQL语法校验不严格，；可以不写
*/
CREATE DATABASE db55



/*
	修改数据库的字符集
	标准语法：
		ALTER DATABASE 数据库名称 CHARACTER SET 字符集名称;
*/
-- 修改数据库db4的字符集为utf8
ALTER DATABASE db4 CHARACTER SET utf8;

-- 查看db4数据库的字符集
SHOW CREATE DATABASE db4;





/*
	删除数据库
	标准语法：
		DROP DATABASE 数据库名称;
*/
-- 删除db1数据库
DROP DATABASE db1;

/*
	删除数据库，判断、如果存在则删除
	标准语法：
		DROP DATABASE IF EXISTS 数据库名称;
*/
-- 删除数据库db2，如果存在
DROP DATABASE IF EXISTS db2;




/*
	使用数据库
	标准语法：
		USE 数据库名称;
*/
-- 使用db4数据库
USE db4;


/*
	查询当前使用的数据库
	标准语法：
		SELECT DATABASE();
*/
-- 查询当前正在使用的数据库
SELECT DATABASE();
