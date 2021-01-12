package KnowledgePoints.myInterface.interFalse.exam_online.service;

import KnowledgePoints.myInterface.interFalse.exam_online.domain.Admin;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Student;
import KnowledgePoints.myInterface.interFalse.exam_online.domain.Teacher;

public interface LoginService {

    public Admin adminLogin(Integer username, String password);

    public Teacher teacherLogin(Integer username, String password);

    public Student studentLogin(Integer username, String password);
}
