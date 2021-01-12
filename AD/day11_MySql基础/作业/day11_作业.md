## 1. 完成课堂各案例并自学分组、分页查询





## 2. 创建表结构并完成下面各题



数据库表结构如下：

```sql
CREATE TABLE `employees` (
`emp_no` int(11),
`birth_date` date,
`username` varchar(14),
`salary` double ,
`gender` varchar(2) ,
`hire_date` date ,
PRIMARY KEY (`emp_no`));
}
```



| emp_no | birth_date | username | salary | gender | hire_date  | dept_no |
| ------ | ---------- | -------- | ------ | ------ | ---------- | ------- |
| 10005  | 1955-01-21 | 张三     | 3000   | 男     | 1989-09-12 | 1001    |
| ...    |            |          |        |        |            |         |
| ...    |            |          |        |        |            |         |



### 第一题

按照上述结构新建表结构并初始化数据



### 第二题

查找所有员的薪水情况，给出员工编号(emp_no)、薪资(salary)， 并按照salary进行逆序排序



### 第三题

查询薪水(salary)介于4000~5000的员工数量



### 第四题

查询出所有部门编号(dept_no)，要求改部门下至少有一个员工信息高于4000



### 第五题

查找入职员工时间排名倒数第三的员工所有信息

（为了降低难度，目前所有的数据里员工入职的日期都不是同一天）

提示：使用的关键字 order by   limit





