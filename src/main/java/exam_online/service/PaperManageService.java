package KnowledgePoints.myInterface.interFalse.exam_online.service;

import java.util.Map;

public interface PaperManageService {

    /**
     * 根据试卷的ID查询试卷对应的题目
     * @param paperId
     * @return
     */
    public Map findById(Integer paperId);
}
