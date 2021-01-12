package KnowledgePoints.myInterface.interFalse.exam_online.dao;

import KnowledgePoints.myInterface.interFalse.exam_online.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface StudentMapper {

    @Select("select * from student where studentId = #{username} and pwd = #{pwd}")
    public Student queryByUsernameAndPwd(@Param("username") Integer username, @Param("pwd") String password);
}
