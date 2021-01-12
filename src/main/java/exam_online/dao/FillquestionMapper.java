package KnowledgePoints.myInterface.interFalse.exam_online.dao;

import KnowledgePoints.myInterface.interFalse.exam_online.domain.Fillquestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FillquestionMapper {

    @Select("select * from fillquestion where questionId in(select  questionId  from papermanage where paperId = #{paperId} and questionType = 2)")
    public List<Fillquestion> findList(Integer paperId);
}
