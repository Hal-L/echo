/*
	聚合函数
	标准语法：
		SELECT 函数名(列名) FROM 表名 [WHERE 条件];
		
	count(*)				表只有一列且没有主键，性能最好					不用
	count(id主键)		表有主键（这一列的值不能为空，且不能重复）的时候，性能最好
	count(1)				表有多列，且没有主键的时候，性能最好		不用
*/
-- 计算product表中总记录条数
SELECT COUNT(*) FROM product;

-- 获取最高价格
SELECT MAX(price) FROM product;


-- 获取最低库存
SELECT MIN(stock) FROM product;


-- 获取总库存数量
SELECT SUM(stock) FROM product;


-- 获取品牌为苹果的总库存数量
SELECT SUM(stock) FROM product WHERE brand='苹果';

-- 获取品牌为小米的平均商品价格
SELECT AVG(price) FROM product WHERE brand='小米';
