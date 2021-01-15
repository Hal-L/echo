package com.itheima.domain.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private String id;
    private String deptName;
    private String parentId;
    private Integer state;

    private Dept parent;
}
