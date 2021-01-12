# 练习题

## 知识点

List

### 题目1（加强训练）

需求：创建一个ArrayList集合，添加一些整数，然后使用不同的方式遍历这些数据。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

### 题目2（加强训练）

需求：定义一个方法int listTest(ArrayList<Integer> al, Integer s)，要求返回s在al里面第一次出现的索引，如果s没出现过返回-1。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

### 题目3（加强训练）

需求：定义一个学生类Student，包含三个属性姓名、年龄、性别，私有成员变量,生成无参，有参构造方法，生成get/set方法并重写toString()方法。创建三个学生对象存入ArrayList集合中。

1. 遍历集合遍历输出。（输出格式如：姓名：张三, 年龄：23, 性别：男）

2. 求出年龄最大的学生，然后将该对象的姓名变为：小猪佩奇。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

### 题目4（加强训练）

需求：

1. 自定义人类:包含姓名,年龄,身高属性，私有成员变量,生成无参,有参构造方法,生成get/set方法；

2. 创建5个人放到ArrayList中；

3. 使用迭代器获取每个人的信息：找出最高的人,最矮的人，并输出最高人和最矮人的信息。

打印格式为：最高的人是张三,身高1.80；最矮的人是李四,身高1.60 。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

### 题目5（加强训练）

需求：

1. 有如下一个数据操作接口IDataOperation<E>和一个学生类Student，现需要提供一个IDataOperation接口的实现类，用来对学生信息进行操作；

2. 在IDataOperation接口实现类中，使用集合保存学生信息；

3. 注意：学生信息包括学号、姓名、年龄和地址；其中，学生的学号是唯一的，不能出现两个学号一样的学生。

   ```java
   //数据操作接口
   interface IDataOperation<E> {
   	// 添加数据
   	public boolean add(E t);
   	// 根据唯一标识删除一个数据
   	public <T> boolean delete(T t);
   	// 修改一个数据
   	public <T> boolean update(E e);
   	// 根据唯一表示查找一个数据
   	public <T> E get(T t);
   	// 查找所有数据
   	public Collection<E> getAll();
   }
   ```

   ```java
   // 标准学生类
   class D5.DemoTostring.Student {
   	private String id;// 学号
   	private String name;// 姓名
   	private String age;// 年龄
   	private String address;// 居住地
   	public D5.DemoTostring.Student() {}
   	public D5.DemoTostring.Student(String id, String name, String age, String address) {
   		this.id = id;
   		this.name = name;
   		this.age = age;
   		this.address = address;
   	}
   	public String getId() {
   		return id;
   	}
   	public void setId(String id) {
   		this.id = id;
   	}
   	public String getName() {
   		return name;
   	}
   	public void setName(String name) {
   		this.name = name;
   	}
   	public String getAge() {
   		return age;
   	}
   	public void setAge(String age) {
   		this.age = age;
   	}
   	public String getAddress() {
   		return address;
   	}
   	public void setAddress(String address) {
   		this.address = address;
   	}
   	@Override
   	public String toString() {
   		return "D5.DemoTostring.Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
   	}
   }
   ```

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

### 题目6（综合扩展）

需求：创建一个类，提供一个功能，向LinkedList集合中添加自定义的Person类对象；要求：

1. Person应该具有姓名、性别和年龄三个属性；

2. 添加对象时，如果容器中已存在该对象，就不添加；（要求：不能使用集合提供的contains方法）

3. 如果Person对象的姓名和性别相同，就认为是同一个人；

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

### 题目7（综合扩展）

需求：使用ArrayList集合，模拟实现一个栈；要求：

1. 提供入队、出队和获取队列长度的功能；

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

## 知识点

Set

### 题目1（加强训练）

需求：ArrayList有以下元素: "a","f","b","c","a","d"利用HashSet对ArrayList集合去重(最终结果: ArrayList中没有重复元素)。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

1. 创建ArrayList
2. 使用add方法往ArrayList添加元素
3. 创建HashSet.用于将ArrayList中重复的元素去除
4. 调用HashSet的addAll方法,将ArrayList中的元素添加到HashSet中
5. 清空list的所有元素
6. 将set集合中的元素再添加回ArrayList集合

#### 参考答案

### 题目2（加强训练）

需求：双色球规则，双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。红色球号码从1—33中选择，红球不可重复；蓝色球号码从1—16中选择。请随机生成一注双色球号码。

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

### 题目3（加强训练）

需求：使用HashSet集合，保存自定义的Person类对象；要求：

1. Person应该具有姓名、性别和年龄三个属性；
2. 如果Person对象的姓名和性别相同，就认为是同一个人；

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

### 题目4（加强训练）

需求:使用LinkedHashSet集合，保存自定义的Student类对象；要求：

1. Student应该具有姓名、性别、年龄和学号四个属性；
2. 如果Student对象的学号相同，就认为是同一个人；

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

 