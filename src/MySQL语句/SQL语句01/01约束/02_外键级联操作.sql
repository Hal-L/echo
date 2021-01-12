/*
	添加外键约束，同时添加级联更新  标准语法：
	ALTER TABLE 表名 ADD CONSTRAINT 外键名 FOREIGN KEY (本表外键列名) REFERENCES 主表名(主键列名) 
	ON UPDATE CASCADE;
	
	添加外键约束，同时添加级联删除  标准语法：
	ALTER TABLE 表名 ADD CONSTRAINT 外键名 FOREIGN KEY (本表外键列名) REFERENCES 主表名(主键列名) 
	ON DELETE CASCADE;
	
	添加外键约束，同时添加级联更新和级联删除  标准语法：
	ALTER TABLE 表名 ADD CONSTRAINT 外键名 FOREIGN KEY (本表外键列名) REFERENCES 主表名(主键列名) 
	ON UPDATE CASCADE ON DELETE CASCADE;
	
	级联工作中肯定不用
	数据删除要谨慎
		订单数据、浏览记录数据、收藏数据
		
		物理删除
			直接从数据库删除所有记录
		
		逻辑删除
			添加一个额外的字段（是否删除），如果执行了删除的动作，其实是修改了该字段的值（eg:从0变成1）
			
			之后查询该表的时候，只需要添加一个查询条件  where 是否删除 = 0
*/
-- 删除外键约束
ALTER TABLE orderlist DROP FOREIGN KEY ou_fk1;

-- 添加外键约束，同时添加级联更新和级联删除
ALTER TABLE orderlist ADD CONSTRAINT ou_fk1 FOREIGN KEY (uid) REFERENCES USER(id)
ON UPDATE CASCADE ON DELETE CASCADE;


-- 将李四这个用户的id修改为3,订单表中的uid也自动修改
UPDATE USER SET id=3 WHERE id=2;

-- 将李四这个用户删除,订单表中的该用户所属的订单也自动删除
DELETE FROM USER WHERE id=3;