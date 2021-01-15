package com.itheima.utils;

import org.apache.ibatis.session.SqlSession;

/**
 * 事务控制类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class TransactionUtil {

    /**
     * 提交释放
     * @param sqlSession
     */
    public static void commit(SqlSession sqlSession){
        System.out.println("j-utils-TransactionUtil-!!!-commit");
        if(sqlSession!=null) {
            sqlSession.commit();
        }
    }

    /**
     * 回滚释放
     * @param sqlSession
     */
    public static void rollback(SqlSession sqlSession){
        System.out.println("j-utils-TransactionUtil-!!!-rollback");
        if(sqlSession!=null) {
            sqlSession.rollback();
        }
    }

    /**
     * 单独释放
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        System.out.println("j-utils-TransactionUtil-!!!-close.");
        if(sqlSession!=null) sqlSession.close();
    }
}
