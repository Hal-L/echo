/*
	共享锁：数据可以被多个事务查询，但是不能修改
	创建锁的格式
		SELECT语句 LOCK IN SHARE MODE;
	一个事务中的增删改会自动加行级别的写锁
*/
-- 开启事务
START TRANSACTION;

-- 查询id为1数据，并加入共享锁
-- 给表的索引列加共享锁，此时是行级别，其他事务不允许对该行加写锁操作
SELECT * FROM student WHERE id=1 LOCK IN SHARE MODE;

-- 查询分数为99的数据，并加入共享锁
-- 给表的非索引列加共享锁，此时是表级别，其他事务不允许对该表加写锁操作
SELECT * FROM student WHERE score=99 LOCK IN SHARE MODE;

-- 提交事务
COMMIT;