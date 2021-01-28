/*
	左外连接
	标准语法：
		SELECT 列名 FROM 表名1 LEFT [OUTER] JOIN 表名2 ON 主外键对等 LEFT JOIN 表名3 ON 主外键对等 WHERE 其他条件;
		
	如果要查询出主表所有的符合条件是数据，我们一般使用外链接，因为内连接可能会丢失部分数据
*/
-- 查询所有用户信息，以及用户对应的订单信息
SELECT
	u.*,
	o.number
FROM
	USER u
LEFT  JOIN
	orderlist o
ON
	o.uid=u.id;
	


/*
	右外连接
	标准语法：
		SELECT 列名 FROM 表名1 RIGHT [OUTER] JOIN 表名2 ON 条件;
*/
-- 查询所有订单信息，以及订单所属的用户信息
SELECT
	o.*,
	u.name
FROM
	USER u
RIGHT OUTER JOIN
	orderlist o
ON
	o.uid=u.id;
	
-- 查询所有订单信息，以及订单所属的用户信息(使用左外连接查询)
-- 左外/右外是可以相互转换的，我们只需要记一个就可以。
SELECT
	o.*,
	u.name
FROM
	orderlist o
LEFT OUTER JOIN
	USER u
ON
	o.uid=u.id;