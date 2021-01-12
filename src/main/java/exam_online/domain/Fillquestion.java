package KnowledgePoints.myInterface.interFalse.exam_online.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fillquestion implements Serializable {

    private String subject;
    private Integer questionId;
    private String question;
    private String answer;
    private Integer score;
    private String level;
    private String section;
}
