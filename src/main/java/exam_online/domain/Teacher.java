package KnowledgePoints.myInterface.interFalse.exam_online.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {

    private Integer teacherId;
    private String teacherName;
    private String institute;
    private String sex;
    private String tel;
    private String email;
    private String pwd;
    private String cardId;
    private String type;
    private String role;
}
