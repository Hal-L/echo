package KnowledgePoints.myInterface.interFalse.exam_online.dao;

import KnowledgePoints.myInterface.interFalse.exam_online.domain.ExamManage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamManageMapper {

    @Select("select * from exammanage")
    public List<ExamManage> findAll();

    @Select("select * from exammanage where examCode = #{examCode}")
    public ExamManage findById(Integer examCode);

    @Insert("insert into exammanage (description,source,paperId,examDate,totalTime,grade,term ,major,institute,totalScore,type,tips) values(#{description},#{source},#{paperId},#{examDate},#{totalTime},#{grade},#{term},#{major},#{institute},#{totalScore},#{type},#{tips})")
    public int insertExamManage(ExamManage examManage);


    @Update("update exammanage set description=#{description},source=#{source},paperId=#{paperId},examDate=#{examDate},totalTime=#{totalTime},grade=#{grade},term=#{term},major=#{major},institute=#{institute},totalScore=#{totalScore},type=#{type},tips=#{tips} where examCode = #{examCode}")
    public int update(ExamManage examManage);

    public int updateBySelective(ExamManage examManage);

    @Delete("delete from exammanage where examCode = #{id}")
    public int deleteById(Integer examCode);
}
