package KnowledgePoints.myInterface.interFalse.exam_online.service.impl;

import KnowledgePoints.myInterface.interFalse.exam_online.dao.AdminMapper;
import KnowledgePoints.myInterface.interFalse.exam_online.dao.StudentMapper;
import KnowledgePoints.myInterface.interFalse.exam_online.dao.TeacherMapper;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Admin;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Student;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Teacher;
import KnowledgePoints.myInterface.interFalse.exam_online.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Admin adminLogin(Integer username, String password) {
        return adminMapper.queryByUsernameAndPwd(username,password);
    }

    @Override
    public Teacher teacherLogin(Integer username, String password) {
        return teacherMapper.queryByUsernameAndPwd(username,password);
    }

    @Override
    public Student studentLogin(Integer username, String password) {
        return studentMapper.queryByUsernameAndPwd(username,password);
    }
}
