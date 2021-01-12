/*
	查询全部数据
	标准语法：
		SELECT * FROM 表名;
	
	不建议使用select *
		1. 冗余字段会被查出来，后期添加的字段也会被查出来
		2. select * 的性能低于 select 字段名列表
		
*/
-- 查询product表所有数据
SELECT * FROM product;


/*
	查询指定列
	标准语法：
		SELECT 列名1,列名2,... FROM 表名;
*/
-- 查询名称、价格、品牌
SELECT NAME,price,brand FROM product;


/*
	去除重复查询
	标准语法：
		SELECT DISTINCT 列名1,列名2,... FROM 表名;
*/
-- 查询品牌
SELECT brand FROM product;
-- 查询品牌，去除重复
SELECT DISTINCT brand FROM product;



/*
	计算列的值，一般不用，如果需要运算，会在Java代码中运算，传值给SQL
	标准语法：
		SELECT 列名1 运算符(+ - * /) 列名2 FROM 表名;
		
	如果某一列为null，可以进行替换
	ifnull(表达式1,表达式2)
	表达式1：想替换的列
	表达式2：想替换的值
*/
-- 查询商品名称和库存，库存数量在原有基础上加10
SELECT NAME,stock+10 FROM product;

-- 查询商品名称和库存，库存数量在原有基础上加10。进行null值判断
SELECT NAME,IFNULL(stock,0)+10 FROM product;



/*
	起别名
	标准语法：
		SELECT 列名1,列名2,... AS 别名 FROM 表名;
*/
-- 查询商品名称和库存，库存数量在原有基础上加10。进行null值判断。起别名为getSum
SELECT NAME,IFNULL(stock,0)+10 AS getSum FROM product;
SELECT NAME,IFNULL(stock,0)+10 getSum FROM product;