package com.itheima.domain.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String id;
    private String name;
    private String remark;
    private Date createTime;

}
