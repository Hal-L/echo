## 1. 创建表结构并完成下面各题

<font color='red' size='5'>以下题目重点在于练习SQL语句，如果需要外键关联，只需要建立外键字段，不用建立主外键关系</font>

数据库表结构如下：

```sql
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,	-- 入职时间
PRIMARY KEY (`emp_no`)
);
/* 数据不够时请自行添加 */
INSERT INTO `employees` VALUES (10001, '1970-09-22', 'san', 'zhang', 'M', '1986-06-26');
INSERT INTO `employees` VALUES (10002, '1975-07-26', 'si', 'li', 'M', '1996-08-03');
INSERT INTO `employees` VALUES (10003, '1976-11-03', 'wu', 'wang', 'M', '1996-08-03');
```



### 第一题

按照上述结构新建表结构并初始化数据



### 第二题

查找最晚入职员工的所有信息（要求使用子查询）。

为了减轻入门难度，目前所有的数据里员工入职的日期都不是同一天

#### 关键字

`子查询`

#### 效果

| emp_no | birth_date | first_name | last_name | gender | hire_date  |
| ------ | ---------- | ---------- | --------- | ------ | ---------- |
| 10005  | 1955-01-21 | san        | zhang     | M      | 1989-09-12 |
| ...    |            |            |           |        |            |
| ...    |            |            |           |        |            |

#### 答案

```sql
select 
	* 
from 
	employees 
where 
    hire_date = (
        select 
        	max(hire_date) 
        from 
        	employees
    );
```





------

配合上述第一张表，并结合下表结构创建并初始化数据

```sql
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,	-- 进入部门时间
`to_date` date NOT NULL,	-- 离开部门时间
PRIMARY KEY (`emp_no`,`dept_no`)
);

/* 数据不够时请自行添加 */
INSERT INTO dept_emp VALUES(10001,'d001','1986-06-26','9999-01-01');
INSERT INTO dept_emp VALUES(10002,'d001','1996-08-03','9999-01-01');
INSERT INTO dept_emp VALUES(10003,'d004','1995-12-03','9999-01-01');
INSERT INTO dept_emp VALUES(10004,'d004','1986-12-01','9999-01-01');
INSERT INTO dept_emp VALUES(10005,'d003','1989-09-12','9999-01-01');
INSERT INTO dept_emp VALUES(10006,'d002','1990-08-05','9999-01-01');
INSERT INTO dept_emp VALUES(10007,'d005','1989-02-10','9999-01-01');
INSERT INTO dept_emp VALUES(10008,'d005','1998-03-11','2000-07-31');
INSERT INTO dept_emp VALUES(10009,'d006','1985-02-18','9999-01-01');
INSERT INTO dept_emp VALUES(10010,'d005','1996-11-24','2000-06-26');
INSERT INTO dept_emp VALUES(10010,'d006','2000-06-26','9999-01-01');
```



### 第三题

#### 题目

> 查找所有已经分配部门的员工的last_name和first_name以及dept_no(请注意输出描述里各个列的前后顺序)

#### 关键字

`INNER JOIN`

#### 效果

| last_name | first_name | dept_no |
| :-------- | :--------- | :------ |
| Facello   | Georgi     | d001    |
| tigger    | tigger     | d001    |
| Piveteau  | Duangkaew  | d006    |



#### 答案

```sql
select 
	e.last_name,e.first_name,d.dept_no 
from 
	employees e
join 
	dept_emp d
on 
	e.emp_no=d.emp_no;
```



### 第四题

#### 题目

> 查找所有员工的last_name和first_name以及对应部门编号dept_no，也包括暂时没有分配具体部门的员工(请注意输出描述里各个列的前后顺序)

#### 关键字

`LEFT JOIN`

#### 效果

| last_name | first_name | dept_no |
| --------- | ---------- | ------- |
| Facello   | Georgi     | d001    |
| Sluis     | Mary       | NULL    |

#### 答案

```sql
select 
	e.last_name,e.first_name,d.dept_no 
from 
	employees e
left join 
	dept_emp d
on 
	e.emp_no=d.emp_no;
```







------

配合上述两张表，并结合下表结构创建并初始化数据

```sql
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,  -- 当前薪资开始时间
`to_date` date NOT NULL,	-- 当前薪资结束时间,如果值为"9999-01-01"表示现在的、当前的、现在有效的
PRIMARY KEY (`emp_no`,`from_date`)
);
/* 数据不够时请自行添加 */
INSERT INTO salaries VALUES(10001,90000,'1986-06-26','1987-06-26');
INSERT INTO salaries VALUES(10001,88958,'2002-06-22','9999-01-01');
INSERT INTO salaries VALUES(10002,72527,'1996-08-03','1997-08-03');
INSERT INTO salaries VALUES(10002,72527,'2000-08-02','2001-08-02');
INSERT INTO salaries VALUES(10002,72527,'2001-08-02','9999-01-01');
INSERT INTO salaries VALUES(10003,90000,'1996-08-03','1997-08-03');
```



### 第五题

#### 题目

> 查找所有员工入职时候的薪水情况，给出emp_no以及salary， 并按照emp_no进行逆序(请注意，一个员工可能有多次涨薪的情况)

#### 关键字

`LEFT JOIN`、`ORDER BY`、`DESC`

#### 效果

| emp_no | salary |
| ------ | ------ |
| 10003  | 90000  |
| 10002  | 72527  |
| 10001  | 90000  |

​	
​	

#### 答案

```sql
select 
	e.emp_no,s.salary 
from 
	employees e
left join 
	salaries s
on 
	e.emp_no=s.emp_no 
where 
	e.hire_date = s.from_date 
order by 
	e.emp_no 
desc;
```



### 第六题

#### 题目

> 查找薪水变动超过3次的员工号emp_no以及其对应的变动次数

#### 关键字

`GROUP BY`、`HAVING`

#### 效果

| emp_no | times |
| ------ | ----- |
| 10001  | 17    |
| 10004  | 16    |
| 10009  | 18    |



#### 答案

```sql
select 
	emp_no ,
	count(emp_no)  times 
from 
	salaries 
group by 
	emp_no 
having 
	times>3;
```



------

配合上述三张表，并结合下表结构创建并初始化数据

```sql
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`)
);

/* 数据不够时请自行添加 */
INSERT INTO dept_manager VALUES('d001',10002,'1996-08-03','9999-01-01');
INSERT INTO dept_manager VALUES('d002',10006,'1990-08-05','9999-01-01');
INSERT INTO dept_manager VALUES('d003',10005,'1989-09-12','9999-01-01');
INSERT INTO dept_manager VALUES('d004',10004,'1986-12-01','9999-01-01');
INSERT INTO dept_manager VALUES('d005',10010,'1996-11-24','2000-06-26');
INSERT INTO dept_manager VALUES('d006',10010,'2000-06-26','9999-01-01');
```







### 第七题

#### 题目

> 找出所有员工现在的具体的薪水salary情况，对于相同的薪水只显示一次,并按照逆序显示。
>
> （判断当前的条件为：to_date='9999-01-01'）

#### 关键字

`GROUP BY`、`ORDER BY`

#### 效果

| salary |
| ------ |
| 94692  |
| 94409  |
| 88958  |
| 88070  |
| 74057  |
| 72527  |
| 59755  |

#### 答案

```sql
select 
	salary 
from 
	salaries
where 
	to_date='9999-01-01' 
group by 
	salary 
order by 
	salary 
desc;
```



### 第八题

#### 题目

> 获取所有部门现在(dept_manager.to_date='9999-01-01')manager的现在(salaries.to_date='9999-01-01')薪水情况，给出dept_no, emp_no以及salary
>
> (请注意，同一个人可能有多条薪水情况记录)

#### 关键字

`内连接`

#### 效果

| dept_no | emp_no | salary |
| ------- | ------ | ------ |
| d001    | 10002  | 72527  |
| d004    | 10004  | 74057  |
| d003    | 10005  | 94692  |
| d002    | 10006  | 43311  |
| d006    | 10010  | 94409  |



#### 答案

```sql
select 
    d.dept_no, 
    s.emp_no, 
    s.salary 
from 
	dept_manager d, salaries s
where 
	d.to_date='9999-01-01'
and 
	s.to_date='9999-01-01'
and 
	d.emp_no = s.emp_no;
```



### 第九题

#### 题目

> 查找所有员工的last_name和first_name以及对应部门编号dept_no，也包括暂时没有分配具体部门的员工(请注意输出描述里各个列的前后顺序)

#### 关键字

`NOT IN`、`子查询`

#### 效果

| dept_no |
| ------- |
| 10001   |
| 10003   |
| 10007   |
| 10008   |
| 10009   |
| 10011   |



#### 答案

```sql
select 
	emp_no
from 
	employees 
where 
	emp_no 
not in 
	(select 
     	emp_no 
     from 
     	dept_manager
    );
```





### 第十题

#### 题目

> 获取所有员工当前的(dept_manager.to_date='9999-01-01')manager，如果员工是manager的话不显示(也就是如果当前的manager是自己的话结果不显示)。输出结果第一列给出当前员工的emp_no,第二列给出其manager对应的emp_no。

#### 关键字

`INNER JOIN`、`多条件`、`<>`

#### 效果

| emp_no | manager_no |
| ------ | ---------- |
| 10001  | 10002      |
| 10003  | 10004      |
| 10009  | 10010      |

#### 答案

```sql
SELECT 
	de.emp_no, 
	dm.emp_no AS manager_no 
FROM 
	dept_emp AS de 
INNER JOIN 
	dept_manager AS dm
ON 
	de.dept_no = dm.dept_no 
WHERE 
	dm.to_date = '9999-01-01' 
AND 
	de.to_date = '9999-01-01' 
AND 
	de.emp_no <> dm.emp_no;
```





### 第十一题

#### 题目

> 获取所有部门中当前(dept_emp.to_date = '9999-01-01')员工当前(salaries.to_date='9999-01-01')薪水最高的相关信息，给出dept_no以及其对应的salary，按照部门升序排列。

#### 关键字

`INNER JOIN`、`GROUP BY`、`ORDER BY`、`MAX`

#### 效果

| dept_no | salary |
| ------- | ------ |
| d001    | 88958  |
| d002    | 95623  |

#### 答案

```sql
select 
	e.dept_no,
	MAX(s.salary) salary
from 
	dept_emp e 
inner join 
	salaries s
on 
	e.emp_no = s.emp_no 
where 
	s.to_date='9999-01-01' 
and 
	e.to_date = '9999-01-01'
GROUP BY 
	e.dept_no
ORDER BY
	dept_no;
```

