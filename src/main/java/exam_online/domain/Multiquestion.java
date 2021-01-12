package KnowledgePoints.myInterface.interFalse.exam_online.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Multiquestion implements Serializable {

    private Integer questionId;
    private String subject;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String right;
    private Integer score;
    private String section;
    private String level;
}
