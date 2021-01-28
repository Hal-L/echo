-- 1.查询用户的编号、姓名、年龄。订单编号
/*
分析
	用户的编号、姓名、年龄  user表      订单编号 orderlist表
	条件：user.id=orderlist.uid
*/



-- 2.查询所有的用户。用户的编号、姓名、年龄。订单编号
/*
分析
	用户的编号、姓名、年龄  user表    订单编号 orderlist表
	条件：user.id=orderlist.uid
	查询所有的用户，左外连接
*/




-- 3.查询所有的订单。用户的编号、姓名、年龄。订单编号
/*
分析
	用户的编号、姓名、年龄 user表    订单编号 orderlist表
	条件：user.id=orderlist.uid
	查询所有的订单，右外连接
*/


	

-- 4.查询用户年龄大于23岁的信息。显示用户的编号、姓名、年龄。订单编号
/*
分析
	用户的编号、姓名、年龄 user表    订单编号 orderlist表
	条件：user.id=orderlist.uid AND user.age > 23
*/



-- 5.查询张三和赵六用户的信息。显示用户的编号、姓名、年龄。订单编号
/*
分析
	用户的编号、姓名、年龄 user表   订单编号 orderlist表
	条件：user.id=orderlist.uid AND user.name IN ('张三','赵六')
	 
	 隐含的查询全部，使用外链接。
*/
SELECT
	u.id,
	u.name,
	u.age,
	o.number
FROM
	USER u
LEFT JOIN
	orderlist o
ON
	u.id=o.uid
WHERE
	u.name IN ('张三','赵六');


-- 6.查询商品分类的编号、分类名称。分类下的商品名称
/*
分析
	商品分类的编号、分类名称 category表    商品名称 product表
	条件：category.id=product.cid
*/



-- 7.查询所有的商品分类。商品分类的编号、分类名称。分类下的商品名称
/*
分析
	商品分类的编号、分类名称 category表    商品名称 product表
	条件：category.id=product.cid
	查询所有的商品分类，左外连接
*/


-- 8.查询所有的商品信息。商品分类的编号、分类名称。分类下的商品名称
/*
分析
	商品分类的编号、分类名称  category表   商品名称 product表
	条件：category.id=product.cid
	查询所有的商品信息，右外连接
*/




-- 9.查询所有的用户和该用户能查看的所有的商品。显示用户的编号、姓名、年龄。商品名称
/*
分析
	用户的编号、姓名、年龄 user表   商品名称 product表    中间表 us_pro
	条件：us_pro.uid=user.id AND us_pro.pid=product.id
	
	user  LEFT JOIN us_pro LEFT JOIN product
*/
SELECT
	u.id,
	u.`NAME`,
	u.age,
	p.`NAME`
FROM
	`USER` u
LEFT JOIN
	us_pro up
ON
	u.id = up.uid
LEFT JOIN
	product p
ON
	up.pid = p.id;




-- 10.查询张三和王二麻子这两个用户可以看到的商品。显示用户的编号、姓名、年龄。商品名称
/*
分析
	用户的编号、姓名、年龄 user表   商品名称 product表   中间表 us_pro
	条件：us_pro.uid=user.id AND us_pro.pid=product.id AND user.name IN ('张三','王二麻子') 
	
	user  LEFT JOIN us_pro LEFT JOIN product
*/
SELECT
	u.id,
	u.`NAME`,
	u.age,
	p.`NAME`
FROM
	`USER` u
LEFT JOIN
	us_pro up
ON
	u.id = up.uid
LEFT JOIN
	product p
ON
	p.id = up.pid
WHERE
	u.`NAME` IN ('张三','王二麻子');