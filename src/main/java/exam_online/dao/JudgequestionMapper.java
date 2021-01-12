package KnowledgePoints.myInterface.interFalse.exam_online.dao;

import KnowledgePoints.myInterface.interFalse.exam_online.domain.Judgequestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JudgequestionMapper {

    @Select("select * from judgequestion where questionId in(select  questionId  from papermanage where paperId = #{paperId} and questionType = 3)")
    public List<Judgequestion> findList(Integer paperId);
}
