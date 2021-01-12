/*
	查询隔离级别：SELECT @@TX_ISOLATION;
	修改隔离级别：SET GLOBAL TRANSACTION ISOLATION LEVEL 级别字符串;
*/
-- 查询事务隔离级别
SELECT @@tx_isolation;

-- 修改事务隔离级别(修改后需要重新连接)
SET GLOBAL TRANSACTION ISOLATION LEVEL READ COMMITTED;