package com.itheima.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude = "")
public class User {

    private Integer id;
    private String username;
    private String password;
    private Date birthday;

    private List<Order> orderList;



}
