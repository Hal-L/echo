/*
	排他锁：加锁的数据，不能被其他事务加锁查询或修改
	排他锁创建格式
		SELECT语句 FOR UPDATE;
*/
-- 开启事务
START TRANSACTION;

-- 查询id为1数据，并加入排他锁
-- 给表的索引列加排他锁，此时是行级别，其他事务不允许对该行做加锁操作（加锁查询和增删改都不行）
SELECT * FROM student WHERE id=1 FOR UPDATE;

-- 给表的非索引列加排他锁，此时是表级别，其他事务不允许对该表做加锁操作（加锁查询和增删改都不行）
select *from student where score=99 for update;

-- 提交事务
COMMIT;