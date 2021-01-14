package com.itheima.domain.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    private String id;
    private String parentId;
    private String name;
    private Long ctype;
    private Long state;
    // 记录的是当前模块对应的url（操作该模块需要在浏览器发送的请求地址）
    // 之后会根据这个url的值进行具体的权限校验
    private String curl;
    private String remark;

    private Module module;


}
