package KnowledgePoints.myInterface.interFalse.exam_online.dao;

import KnowledgePoints.myInterface.interFalse.exam_online.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    @Select("select * from admin where adminId = #{username} and pwd = #{pwd}")
    public Admin queryByUsernameAndPwd(@Param("username") Integer username,@Param("pwd") String password);
}
