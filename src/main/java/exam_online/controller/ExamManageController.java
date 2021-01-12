package KnowledgePoints.myInterface.interFalse.exam_online.controller;

import KnowledgePoints.myInterface.interFalse.exam_online.domain.ApiResult;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.ExamManage;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Page;
import KnowledgePoints.myInterface.interFalse.exam_online.service.ExamManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ExamManageController {


    @Autowired
    private ExamManageService examManageService;

    /**
     * 不分页查询所有的考试信息
     * @return
     */
    @GetMapping("/exams")
    public ApiResult findAll(){
        try{
            log.info("执行了不分页查询....");
            List<ExamManage> list = examManageService.findAll();
            return new ApiResult(200,"查询所有成功",list);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResult(400,"查询所有失败",null);
        }
    }

    @GetMapping("/exams/{page}/{size}")
    //SpringMVC如何接收restful风格url上的参数 : @PathVariable
    public ApiResult findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size){

        try{
            log.info("执行了分页查询....");
            Page<ExamManage> pageResult = examManageService.findPage(page,size);
            return new ApiResult(200,"查询所有成功",pageResult);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResult(400,"分页查询失败",null);
        }
    }

    /**
     * 根据主键ID查询考试信息
     */
    @GetMapping("/exam/{examCode}")
    public ApiResult findByExamCode(@PathVariable("examCode")Integer examCode){
        try{
            ExamManage examManage = examManageService.findByExamCode(examCode);
            return new ApiResult(200,"根据主键查询成功",examManage);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResult(400,"根据主键查询失败",null);
        }
    }

    /**
     * 新增考试信息
     */
    @PostMapping("/examCode")
    //接收页面传递过来的JSON数据，并要把数据封装给ExamManage对象，使用哪个注解: @RequestBody  @ReponseBody
    public ApiResult add(@RequestBody ExamManage examManage){
        try {
            log.info("新增考试信息");
            int result = examManageService.add(examManage); //result 如果新增成功则返回1，失败返回0
            return new ApiResult(200,"新增成功",result);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResult(400,"新增失败",null);
        }
    }

    /**
     * 修改考试信息
     */
    @PutMapping("/exam/{examCode}")
    public ApiResult update(@PathVariable("examCode")Integer examCode,@RequestBody ExamManage examManage){
        try {
            log.info("修改考试信息");
            int result = examManageService.update(examCode,examManage);
            return new ApiResult(200,"修改成功",result);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResult(400,"修改失败",null);
        }


    }

    /**
     * 根据传入的参数修改考试信息
     */
    @PutMapping("/update/{examCode}")
    public ApiResult edit(@PathVariable("examCode")Integer examCode,@RequestBody ExamManage examManage){
        try {
            log.info("根据传入的参数修改考试信息");
            int result = examManageService.edit(examCode,examManage);
            return new ApiResult(200,"修改成功",result);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResult(400,"修改失败",null);
        }


    }

    /**
     * 根据主键ID删除
     *
     */
    @DeleteMapping("/exam/{examCode}")
    public ApiResult deleteByExamCode(@PathVariable("examCode") Integer examCode){
        try {
            log.info("根据传入的ExamCode删除考试信息");
            int result = examManageService.deleteByExamCode(examCode);
            return new ApiResult(200,"删除成功",result);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResult(400,"删除失败",null);
        }
    }

}

