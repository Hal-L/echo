package com.itheima.domain.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog {
    private String id;
    private String name;
    private String remark;
    private String state;
    private Date createTime;
    private String courseId;

    private Course course;

}
