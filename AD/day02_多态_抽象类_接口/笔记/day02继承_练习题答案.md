## 练习题

### 第一题 

+ 要求：

  编写代码，实现如下功能：

  1. 定义一个门类，包含3个属性：宽度width 和 高度height ，颜色color

     包含2个方法：开门和关门

     开门方法: 输出“门已经打开，请进！”

     关门方法: 输出“门已经关闭，禁止进入！”

  2. 定义一个木头门WOOD，继承Door 

     重写父类开门方法: 输出门的高度  宽度  颜色  +“门已经打开，请进！”

     重写父类关门方法: 输出门的高度  宽度  颜色  +“门已经关闭，禁止进入！”

  3. 定义一个测试类，测试类定义一个main方法

     分别创建 门对象  和 木头门对象， 为创建的木头门对象属性赋值, 调用开门和关门两个方法。

+ 参考代码

  ```java
  publicclass Demo03_jiCheng {
  	publicstaticvoid main(String[] args) {
  		//创建门对象
  		Door02 door = new Door02();
  		// 调用方法
  		door.openDoor();
  		door.closeDoor();
  		
  //		创建木头门对象
  		WoodDoor woodDoor = new WoodDoor();
  		//调用set方法对属性赋值
  		woodDoor.setWidth(1.8);
  		woodDoor.setHight(2.5);
  		woodDoor.setColor("红色");
  //		调用方法
  		woodDoor.openDoor();
  		woodDoor.closeDoor();
  	}
  }

  class Door02 {
  	//	定义属性
  	privatedoublewidth;
  	privatedoublehight;
  	private String color;
  	
  	publicdouble getWidth() {
  		returnwidth;
  	}
  	publicvoid setWidth(doublewidth) {
  		this.width = width;
  	}
  	publicdouble getHight() {
  		returnhight;
  	}
  	publicvoid setHight(doublehight) {
  		this.hight = hight;
  	}
  	public String getColor() {
  		returncolor;
  	}
  	publicvoid setColor(String color) {
  		this.color = color;
  	}
  	
  	//开门方法
  	publicvoid openDoor(){
  		System.out.println("门已经打开，请进！");
  	}
  	//关门方法
  	publicvoid closeDoor(){
  		System.out.println("门已经关闭，禁止进入！");
  	}
  }

  class WoodDoor extends Door02{

  	//重写开门方法
  	publicvoid openDoor(){
  		System.out.println("门的宽度为："+ getWidth() +"，高度为："+getHight()+"，颜色："+getColor()+"，门已经打开，请进！");
  	}
  	
  	//关门方法
  	publicvoid closeDoor(){
  		System.out.println("门的宽度为："+ getWidth() +"，高度为："+getHight()+"，颜色："+getColor()+"，门已经关闭，禁止进入！");
  	}
  }

  ```


### 第二题 

+ 要求：

1. 定义老手机类，有品牌属性，且属性私有化

   提供相应的getXxx与setXxx方法

   提供无返回值的带一个String类型参数的打电话的方法，内容为：“正在给xxx打电话...”

2. 定义新手机类，继承老手机类，重写父类的打电话的方法

   内容为2句话：“语音拨号中...”、“正在给xxx打电话...”

   要求打印“正在给xxx打电话...”这一句调用父类的方法实现，不能在子类的方法中直接打印；

   提供无返回值的无参数的手机介绍的方法，内容为：“品牌为：xxx的手机很好用...”

3. 定义测试类，创建新手机对象，并使用该对象，对父类中的品牌属性赋值；

4. 使用新手机对象调用手机介绍的方法；

5. 使用新手机对象调用打电话的方法；


+ 参考代码

  ```java
  /*
   * 老手机类：
   * 		属性：
   * 			品牌
   * 		方法：
   * 			getXxx与setXxx
   * 			打电话
   */
  publicclass LaoShouJi {
  	//属性
  	private String name;
  	//getXxx与setXxx
  	public String getName() {
  		returnname;
  	}
  	publicvoid setName(String name) {
  		this.name = name;
  	}
  	//打电话
  	publicvoid daDianHua(String ren){
  		System.out.println("正在给"+ren+"打电话...");
  	}
  }
  /*
   * 新手机类：
   * 		方法：
   * 		重写父类的打电话的方法
   * 		手机介绍的方法
   */
  publicclass XinShouJi extends LaoShouJi{
  	//按要求重写父类中的方法
  	publicvoid daDianHua(String ren) {
  		System.out.println("语音拨号中...");
  		//使用super关键字调用父类的daDianHua的方法
  		super.daDianHua(ren);
  	}
  	//手机介绍的方法
  	publicvoid jieShao(){
  		System.out.println("品牌为："+super.getName()+"的手机很好用...");
  	}
  }
  /*
   * 测试类
   */
  publicclass Test22 {
  	publicstaticvoid main(String[] args) {
  		//1、创建新手机对象
  		XinShouJi xin = new XinShouJi();
  		//2、对父类中的品牌属性赋值
  		xin.setName("诺基亚");
  		//3、调用手机介绍和打电话的方法
  		xin.jieShao();
  		xin.daDianHua("小丽");
  	}
  }
  ```


### 第三题

+ 要求：

1. 定义动物类，有名称和年龄两个属性，且属性私有化，提供相应的getXxx与setXxx方法，提供无参数的无返回值的吃饭方法，内容为：“吃饭...”；
2. 定义猫类，继承动物类，重写父类中的吃饭方法，内容为：“猫吃鱼...”
3. 定义狗类，继承动物类，重写父类中的吃饭方法，内容为：“狗吃骨头...”
4. 定义测试类，分别创建猫对象和狗对象，并分别给父类对象中的名称和年龄属性赋值；
5. 分别使用猫对象和狗对象获取名称和年龄的属性值并打印在控制台上；
6. 分别使用猫对象和狗对象调用吃饭方法；


+ 参考代码

  ```java
  /*
   * 动物类：
   * 		属性：
   * 			名称
   * 			年龄
   * 		方法：
   * 			吃饭方法
   * 			getXxx与setXxx
   */
  publicclass DongWu {
  	//属性
  	private String name;
  	privateintage;
  	//getXxx与setXxx
  	public String getName() {
  		returnname;
  	}
  	publicvoid setName(String name) {
  		this.name = name;
  	}
  	publicint getAge() {
  		returnage;
  	}
  	publicvoid setAge(intage) {
  		this.age = age;
  	}
  	//吃饭方法
  	publicvoid chiFan(){
  		System.out.println("吃饭...");
  	}
  }
  /*
   * 狗类继承动物类
   */
  publicclass Gou extends DongWu{
  	publicvoid chiFan() {
  		System.out.println("狗吃骨头...");
  	}
  }
  /*
   * 猫类继承动物类：
   */
  publicclass Mao extends DongWu{
  	//重写吃饭的方法；
  	publicvoid chiFan() {
  		System.out.println("猫吃鱼...");
  	}
  }
  /*
   * 测试类
   */
  publicclass Test22 {
  	publicstaticvoid main(String[] args) {
  		//1、分别创建猫对象和狗对象，并分别给父类对象中的名称和年龄属性赋值
  		Mao m = new Mao();
  		m.setName("波斯猫");
  		m.setAge(3);
  		Gou g = new Gou();
  		g.setName("哈巴狗");
  		g.setAge(2);
  		//2、分别使用猫对象和狗对象获取名称和年龄的属性值并打印在控制台上；
  		String name = m.getName();
  		intage = m.getAge();
  		String name2 = g.getName();
  		intage2 = g.getAge();
  		System.out.println("猫的名字为："+name+";年龄为："+age);
  		System.out.println("狗的名字为："+name2+";年龄为："+age2);
  		//3、分别使用猫对象和狗对象调用吃饭方法
  		m.chiFan();
  		g.chiFan();
  	}
  }
  ```

  ​