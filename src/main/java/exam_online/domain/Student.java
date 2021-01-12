package KnowledgePoints.myInterface.interFalse.exam_online.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private Integer studentId;
    private String studentName;
    private String grade;
    private String major;
    private String clazz;
    private String institute;
    private String tel;
    private String email;
    private String pwd;
    private String cardId;
    private String sex;
    private String role;
}
