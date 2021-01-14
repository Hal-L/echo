package com.itheima.domain.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionItem {
    private String id;          	//ID
    private String questionId;  //题目ID
    private String content;     //选项内容
    private String picture;      //选项图片
    private String isRight;    //是否正确答案

}
