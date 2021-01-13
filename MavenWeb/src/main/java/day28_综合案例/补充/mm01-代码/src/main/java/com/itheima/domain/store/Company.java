package com.itheima.domain.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/*
    lombok
        1. 安装一个插件 lombok
        2. 导入一个依赖 lombok
        3. 添加一个注解  @Data

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {


    private String id;
    private String name;
    private Date expirationDate;
    private String address;
    private String licenseId;
    private String representative;
    private String phone;
    private String companySize;
    private String industry;
    private String remarks;
    private Integer state;
    private String city;

}
