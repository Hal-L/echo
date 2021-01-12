/*
	条件查询
	标准语法：
		SELECT 列名列表 FROM 表名 WHERE 条件;
*/
-- 查询库存大于20的商品信息
SELECT * FROM product WHERE stock > 20;


-- 查询品牌为华为的商品信息
SELECT * FROM product WHERE brand='华为';

-- 查询金额在4000 ~ 6000之间的商品信息
SELECT * FROM product WHERE price >= 4000 AND price <= 6000;
SELECT * FROM product WHERE price BETWEEN 4000 AND 6000;


-- 查询库存为14、30、23的商品信息
SELECT * FROM product WHERE stock=14 OR stock=30 OR stock=23;
SELECT * FROM product WHERE stock IN(14,30,23);

-- 查询库存为null的商品信息
-- 在SQL  null <> null
SELECT * FROM product WHERE stock IS NULL;
-- 某条记录中，如果某个列的显示的是null，这里的null仅仅是一个占位符，并不表示该列的值为null。下面写法有误
SELECT * FROM product WHERE stock = NULL;

-- 查询库存不为null的商品信息
SELECT * FROM product WHERE stock IS NOT NULL;
-- 下面写法也不对
SELECT * FROM product WHERE stock != NULL;

-- 总结：所有关于是否为null的判断，全部使用is null 或者 is not null


-- 查询名称以小米为开头的商品信息 %表示0个或多个符号
SELECT * FROM product WHERE NAME LIKE '小米%';

-- 查询名称第二个字是为的商品信息
SELECT * FROM product WHERE NAME LIKE '_为%';

-- 查询名称为四个字符的商品信息
SELECT * FROM product WHERE NAME LIKE '____';

-- 查询名称中包含电脑的商品信息
SELECT * FROM product WHERE NAME LIKE '%电脑%';