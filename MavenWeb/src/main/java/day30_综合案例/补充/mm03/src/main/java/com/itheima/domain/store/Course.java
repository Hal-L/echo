package com.itheima.domain.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private String id;
    private String name;
    private String remark;
    private String state;
    private String deptId;
    private Date createTime;


}
