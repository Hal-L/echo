package KnowledgePoints.myInterface.interFalse.exam_online.controller;

import KnowledgePoints.myInterface.interFalse.exam_online.domain.Admin;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.ApiResult;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Student;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Teacher;
import KnowledgePoints.myInterface.interFalse.exam_online.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ApiResult login(@RequestBody Map map){

        try{
            //1.获取登录的角色类型 1管理员 2老师 3学生
            String type = (String)map.get("type");
            Integer username = Integer.parseInt(map.get("username").toString());
            String password = (String)map.get("password");
            if(type!=null && !"".equals(type)){
                if("1".equals(type)){
                    //查询管理员
                    Admin admin = loginService.adminLogin(username,password);
                    return new ApiResult(200,"登录成功",admin);
                }else if ("2".equals(type)){
                    //查询老师
                    Teacher teacher = loginService.teacherLogin(username,password);
                    return new ApiResult(200,"登录成功",teacher);
                }else if("3".equals(type)){
                    //查询学生
                    Student student = loginService.studentLogin(username,password);
                    return new ApiResult(200,"登录成功",student);
                }else{
                    return new ApiResult(300,"参数有误",null);
                }
            }else{
                return new ApiResult(300,"参数有误",null);
            }


        }catch (Exception e){
            e.printStackTrace();
            return new ApiResult(400,"登录失败",null);
        }

    }
}
