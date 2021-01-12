package KnowledgePoints.myInterface.interFalse.exam_online.dao;

import KnowledgePoints.myInterface.interFalse.exam_online.domain.Multiquestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MultiquestionMapper {


    @Select("select * from multiquestion where questionId in(select  questionId  from papermanage where paperId = #{paperId} and questionType = 1)")
    public List<Multiquestion> findList(Integer paperId);
}
