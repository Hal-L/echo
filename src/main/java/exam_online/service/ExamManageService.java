package KnowledgePoints.myInterface.interFalse.exam_online.service;

import KnowledgePoints.myInterface.interFalse.exam_online.domain.ExamManage;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Page;

import java.util.List;

public interface ExamManageService {

    /**
     * 查询所有
     * @return
     */
    public List<ExamManage> findAll();

    /**
     * 分页查询
     * @param page 当前页码
     * @param size 每页显示记录数
     * @return
     */
    public Page<ExamManage> findPage(Integer page, Integer size);

    /**
     * 根据主键ID查询考试信息
     * @param examCode 主键ID
     * @return
     */
    public ExamManage findByExamCode(Integer examCode);

    /**
     * 新增考试信息
     * @param examManage  考试对象中包含要新增的数据
     * @return
     */
    public int add(ExamManage examManage);

    /**
     * 修改考试信息
     * @param examCode  主键ID
     * @param examManage 修改考试对象的数据
     * @return
     */
    public int update(Integer examCode, ExamManage examManage);
    /**
     * 根据传入的参数修改考试信息
     * @param examCode  主键ID
     * @param examManage 修改考试对象的数据
     * @return
     */
    public int edit(Integer examCode, ExamManage examManage);

    /**
     * 根据ID删除数据
     * @param examCode 主键ID
     * @return
     */
    public int deleteByExamCode(Integer examCode);
}
