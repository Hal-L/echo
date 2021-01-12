package KnowledgePoints.myInterface.interFalse.exam_online.service.impl;

import KnowledgePoints.myInterface.interFalse.exam_online.dao.FillquestionMapper;
import KnowledgePoints.myInterface.interFalse.exam_online.dao.JudgequestionMapper;
import KnowledgePoints.myInterface.interFalse.exam_online.dao.MultiquestionMapper;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Fillquestion;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Judgequestion;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Multiquestion;
import KnowledgePoints.myInterface.interFalse.exam_online.service.PaperManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PaperManageServiceImpl implements PaperManageService {


    @Autowired
    private MultiquestionMapper multiquestionMapper;
    @Autowired
    private FillquestionMapper fillquestionMapper;
    @Autowired
    private JudgequestionMapper judgequestionMapper;


    @Override
    public Map findById(Integer paperId) {
        Map map = new HashMap();
        //1根据试卷ID查询选择题集合
        List<Multiquestion> multiquestions = multiquestionMapper.findList(paperId);
        map.put("1",multiquestions);
        //2.根据试卷ID查询填空题集合
        List<Fillquestion> fillquestions = fillquestionMapper.findList(paperId);
        map.put("2",fillquestions);
        //3.根据试卷ID查询判断题集合
        List<Judgequestion> judgequestions = judgequestionMapper.findList(paperId);
        map.put("3",judgequestions);
        return map;
    }
}
