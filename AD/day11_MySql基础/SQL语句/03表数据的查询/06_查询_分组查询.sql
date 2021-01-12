/*
	分组查询
	标准语法：
		SELECT 列名 FROM 表名 [WHERE 条件] GROUP BY 分组列名 [HAVING 分组后条件过滤] [ORDER BY 排序列名 排序方式];
		
	分组查询的注意点：
		1. 要查询出来的所有列中，除了聚合函数相关的列之外，其他列都要出现在GROUP BY关键字后面
			SELECT id,brand,SUM(price) FROM product GROUP BY brand,id;
		2. 
		
*/
-- 按照品牌分组，获取每组商品的总金额
SELECT brand,SUM(price) FROM product GROUP BY brand;

SELECT * FROM product;

-- 对金额大于4000元的商品，按照品牌分组,获取每组商品的总金额
SELECT brand,SUM(price) FROM product WHERE price > 4000 GROUP BY brand;

-- 对金额大于4000元的商品，按照品牌分组，获取每组商品的总金额，只显示总金额大于7000元的
SELECT brand,SUM(price) getSum FROM product WHERE price > 4000 GROUP BY brand HAVING getSum > 7000;

/*
	按照数据库中已有的字段名进行筛选使用where
	按照结果集中的字段名进行筛选使用having
*/
/*
	Navicat中，选中某个SQL语句，点击菜单栏 美化SQL，可以格式化SQL
*/
-- 对金额大于4000元的商品，按照品牌分组，获取每组商品的总金额，只显示总金额大于7000元的、并按照总金额的降序排列
SELECT
	brand,
	SUM( price ) getSum 
FROM
	product 
WHERE
	price > 4000 
GROUP BY
	brand 
HAVING
	getSum > 7000 
ORDER BY
	getSum DESC;