package KnowledgePoints.myInterface.interFalse.exam_online.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamManage implements Serializable {

    private Integer examCode;
    private String description;
    private String source;
    private Integer paperId;
    private Date examDate;
    private Integer totalTime;
    private String grade;
    private String term;
    private String major;
    private String institute;
    private Integer totalScore;
    private String type;
    private String tips;
}
