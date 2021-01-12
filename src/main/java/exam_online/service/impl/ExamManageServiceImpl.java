package KnowledgePoints.myInterface.interFalse.exam_online.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import KnowledgePoints.myInterface.interFalse.exam_online.dao.ExamManageMapper;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.ExamManage;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Page;
import KnowledgePoints.myInterface.interFalse.exam_online.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExamManageServiceImpl implements ExamManageService{

    @Autowired
    private ExamManageMapper examManageMapper;

    @Override
    public List<ExamManage> findAll() {
        return examManageMapper.findAll();
    }

    @Override
    public Page<ExamManage> findPage(Integer page, Integer size) {
        if(page ==null || page < 1){
            page = 1;
        }
        if(size ==null || size < 0){
            size = 10;
        }
        PageHelper.startPage(page,size);

        List<ExamManage> list = examManageMapper.findAll();

        PageInfo<ExamManage> pageInfo = new PageInfo<>(list);

        //pageInfo中就包含了所需要的所有分页数据
        int pageNum = pageInfo.getPageNum();//当前页码
        int pageSize = pageInfo.getPageSize();//每页显示记录条数
        int pages = pageInfo.getPages();//总页数
        long total = pageInfo.getTotal();//总记录数
        List<ExamManage> result = pageInfo.getList();//当前页的列表集合

        return new Page<>(pageNum,pageSize,pages,total,result);
    }


    @Override
    public ExamManage findByExamCode(Integer examCode) {
        return examManageMapper.findById(examCode);
    }

    @Override
    public int add(ExamManage examManage) {
        return examManageMapper.insertExamManage(examManage);
    }

    @Override
    public int update(Integer examCode, ExamManage examManage) {
        //1.判断examManage是否为NULL
        if(examManage==null){
            throw new RuntimeException("传入的对象值为空");
        }

        //2.判断examCode和examManage中的examCode是否一致。
        //2.1不一致
        //抛出异常
        //2.2一致
        //调用Dao修改数据
        Integer id = examManage.getExamCode();
        if(examCode!= null && id!=null && examCode.intValue() != id.intValue()){
            throw new RuntimeException("传递的ID不一致");
        }

        //3.调用Dao修改数据
        int result = examManageMapper.update(examManage);


        return result;
    }

    @Override
    public int edit(Integer examCode, ExamManage examManage) {
        //1.判断examManage是否为NULL
        if(examManage==null){
            throw new RuntimeException("传入的对象值为空");
        }

        //2.判断examCode和examManage中的examCode是否一致。
        //2.1不一致
        //抛出异常
        //2.2一致
        //调用Dao修改数据
        Integer id = examManage.getExamCode();
        if(examCode!= null && id!=null && examCode.intValue() != id.intValue()){
            throw new RuntimeException("传递的ID不一致");
        }

        //3.调用Dao修改数据
        int result = examManageMapper.updateBySelective(examManage);


        return result;
    }

    @Override
    public int deleteByExamCode(Integer examCode) {
        return examManageMapper.deleteById(examCode);
    }
}
