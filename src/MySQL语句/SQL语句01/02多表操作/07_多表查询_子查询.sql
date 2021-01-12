/*
	子查询
		把第一次查询的结果作为第二次查询的条件/虚拟表 参与到第二次查询中。
		
		子查询先执行，主查询后执行。

	按照子查询的结果集不同，有不同的使用方式。子查询结果集为：

	单行单列：作为条件，放在主查询的where后面
	
	
	
	多行单例/单行单列：作为条件，放在主查询的where后面，使用 IN() 
	
	
	
	多行多列/单行多列：作为虚拟表，放在from后面，这种情况下，一般会为虚拟表起别名，方便使用
		
	
	查询订单表中id大于4的订单信息和所属用户信息
	
	
	注意：
		很多情况，子查询和内外连接查询时可以相互转换  而达到相同的效果
		这个是有，优先使用内外连接查询，查询次数少，性能更高。
	
	
	标准语法：
		SELECT 列名 FROM 表名 WHERE 列名=(SELECT 列名 FROM 表名 [WHERE 条件]);
*/
-- 查询年龄最高的用户姓名
SELECT MAX(age) FROM USER;
SELECT NAME,age FROM USER WHERE age=(SELECT MAX(age) FROM USER);


/*
	结果是多行单列的
	标准语法：
		SELECT 列名 FROM 表名 WHERE 列名 [NOT] IN (SELECT 列名 FROM 表名 [WHERE 条件]); 
*/
-- 查询张三和李四的订单信息
SELECT * FROM orderlist WHERE uid IN (1,2);
SELECT id FROM USER WHERE NAME IN ('张三','李四');
SELECT * FROM orderlist WHERE uid IN (SELECT id FROM USER WHERE NAME IN ('张三','李四'));


/*
	结果是多行多列的
	标准语法：
		SELECT 列名 FROM 表名 [别名],(SELECT 列名 FROM 表名 [WHERE 条件]) [别名] [WHERE 条件];
*/
-- 查询订单表中id大于4的订单信息和所属用户信息



SELECT * FROM orderlist WHERE id > 4;
SELECT
	u.name,
	o.number
FROM
	USER u,
	(SELECT * FROM orderlist WHERE id > 4) o
WHERE
	o.uid=u.id
	
	
-- 能使用连接查询，就不需要使用子查询
SELECT
	u.*,o.*
FROM
	orderlist o
LEFT JOIN
	`USER` u
ON
	o.uid=u.id
WHERE
	o.id > 4;
	
/*
子查询分类
	按照子查询的结果集不同，有不同的使用方式。结果集为：

	单行单列：作为条件，放在主查询的where后面
		eg:
		-- 查询年龄最高的用户姓名
		SELECT MAX( age )  FROM USER;
			
		SELECT 
			name,
			age 
		FROM
			USER 
		WHERE
			age = ( SELECT MAX( age ) FROM USER );
	
	多/单行单列：作为条件，放在where后面，使用IN连接
		eg:
		-- 查询张三和李四的订单信息
		SELECT * FROM orderlist WHERE uid IN (1,2);
		SELECT id FROM USER WHERE NAME IN ('张三','李四');
		SELECT
			* 
		FROM
			orderlist 
		WHERE
			uid IN ( SELECT id FROM USER WHERE NAME IN ( '张三', '李四' ) );
			
	多行多列/单行多列：作为虚拟表，放在from后面
		-- 查询订单表中id大于4的订单信息和所属用户信息
		SELECT * FROM orderlist WHERE id > 4;
		SELECT
			u.name,
			o.number
		FROM
			USER u,
			(SELECT * FROM orderlist WHERE id > 4) o
		WHERE
			o.uid=u.id;

*/