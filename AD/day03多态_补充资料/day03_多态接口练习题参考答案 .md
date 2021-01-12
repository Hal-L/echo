## 练习题

### 第一题

+ 要求：

1. 定义明星类，有姓名和年龄的属性，且属性不写private修饰符

   提供无返回值的无参数的自我介绍的方法，方法内容为: "我是明星xxx，我今年xxx岁了"

2. 定义明星的子类，重写父类的自我介绍的方法，内容为: "我是明星子类，我的名字是xxx，我今年xxx岁了"

   提供一个无参数的无返回值的跳舞的方法，内容为:"我是明星的子类，我跳拉丁舞......"

3. 定义测试类，使用多态的形式创建明星的子类的对象

   使用该对象分别给姓名和年龄属性赋值，再调用自我介绍的方法，然后通过类型转换，调用子类跳舞的方法；

+ 参考代码

  ```java
  /*
   * 明星类：
   * 		属性：
   * 			姓名
   * 			年龄
   * 		方法：
   * 			自我介绍
   */
  publicclass MingXing {
  	//属性
  	String name;
  	intage;
  	//自我介绍的方法
  	publicvoid ziWoJieShao(){
  		System.out.println("我是明星"+name+"，我今年"+age+"岁了;");
  	}
  }
  /*
   * 明星子类：
   * 		方法：
   * 			自我介绍
   * 			跳舞
   */
  publicclass MingXingZi extends MingXing {
  	//重写父类的自我介绍的方法
  	publicvoid ziWoJieShao(){
  		System.out.println("我是明星子类，我的名字是"+super.name+"，我今年"+super.age+"岁了;");
  	}
  	//跳舞的方法
  	publicvoid tiaoWu(){
  		System.out.println("我是明星的子类，我跳拉丁舞......");
  	}
  }
  /*
   * 测试类
   */
  publicclass Test22 {
  	publicstaticvoid main(String[] args) {
  		//1、使用多态的形式创建明星的子类的对象
  		MingXing mx = new MingXingZi();
  		//2、赋值
  		mx.name = "德华";
  		mx.age  = 40;
  		//3、调用自我介绍的方法
  		mx.ziWoJieShao();
  		//4、向下转型
  		MingXingZi mxz = (MingXingZi)mx;
  		//5、调用跳舞的方法
  		mxz.tiaoWu();
  	}
  }
  ```

### 第二题

+ 要求：

1. 定义动物类，动物类有抽象的无返回值的无参数的“嚎叫”方法

2. 定义猫类，继承动物类，猫叫的声音为: “小猫喵喵叫...”

   提供无返回值的无参数的抓老鼠的方法,内容为：”小猫抓老鼠...”

3. 定义狗类，继承动物类，狗叫的声音为: “小狗汪汪叫...”

4. 定义人类，提供无返回值的带1个动物类型参数的逗动物玩的方法

   在方法内部让动物嚎叫，且如果该动物是小猫，就让小猫抓老鼠

5. 定义测试类，分别创建猫的对象，狗的对象，人的对象

   用人的对象调用逗动物玩的方法，分别测试小猫对象和小狗对象

+ 参考代码

  ```java
  /*
   * 抽象的动物类：
   * 		方法：
   * 			抽象的嚎叫方法
   */
  publicabstractclass DongWu {
  	publicabstractvoid haoJiao();
  }
  /*
   * 猫类继承动物类：
   * 		方法：
   * 			嚎叫
   * 			抓老鼠
   */
  publicclass Mao extends DongWu{
  	//嚎叫的方法
  	publicvoid haoJiao() {
  		System.out.println("小猫喵喵叫...");
  	}
  	//抓老鼠的方法；
  	publicvoid zhuaLaoShu() {
  		System.out.println("小猫抓老鼠...");
  	}
  }
  /*
   * 狗类继承动物类
   */
  publicclass Gou extends DongWu{
  	//嚎叫的方法
  	publicvoid haoJiao() {
  		System.out.println("小狗汪汪叫...");
  	}
  }
  /*
   * 人类：
   * 		方法：
   * 			逗动物玩
   */
  publicclass Ren {
  	//逗动物玩
  	publicvoid douDongWuWan(DongWu d){
  		//1、让动物嚎叫
  		d.haoJiao();
  		//2、判断该动物是不是小猫
  		if(dinstanceof Mao){
  			//3、是猫就强转成猫类型，调用抓老鼠的方法
  			Mao m = (Mao)d;
  			m.zhuaLaoShu();
  		}
  	}
  }
  /*
   * 测试类
   */
  publicclass Test22 {
  	publicstaticvoid main(String[] args) {
  		//1、分别创建猫的对象，狗的对象，人的对象
  		Mao m = new Mao();
  		Gou g = new Gou();
  		Ren r = new Ren();
  		//2、用人的对象调用逗动物玩的方法，分别测试小猫对象和小狗对象
  		r.douDongWuWan(g);
  		r.douDongWuWan(m);
  	}
  }
  ```

### 第三题

+ 要求：

1. 定义主持人接口，提供一个无参数无返回值的主持的方法
2. 定义学生类，提供一个无参数的无返回值的抽象的吃方法
3. 定义男同学类，继承学生类，吃的方法内容为：”我是男同学，我嗑瓜子，喝啤酒...”
4. 定义女同学类，继承学生类，同时实现主持人接口，主持方法的内容为：”女士们，先生们，大家好，我是主持人......”，吃的方法内容为：”我是女同学，我嗑瓜子，吃水果...”
5. 定义班级类，提供一个无返回值的，带两个参数的开晚会的方法，其中第1个参数为主持人接口类型，第二个参数为学生类型，方法内容中要求先调用主持人的主持方法，再打印一句话”晚会正式开始.....”,然后调用学生的吃的方法
6. 定义测试类，使用多态的形式分别创建学生类型的对象,主持人类型的对象，班级类型的对象（这个对象非多态），使用班级对象调用开晚会的方法

+ 参考代码

  ```java
  /*
   * 主持人接口：
   * 		方法：
   * 			主持
   */
  publicinterface ZhuChiRen {
  	publicabstractvoid zhuChi();
  }
  /*
   * 学生类：
   * 		方法：
   */
  publicabstractclass XueSheng {
  	publicabstractvoid chi();
  }
  /*
   * 男同学类，继承学生类
   */
  publicclass NanTongXue extends XueSheng{
  	publicvoid chi(){
  		System.out.println("我是男同学，我嗑瓜子，喝啤酒...");
  	}
  }
  /*
   * 女同学类，继承学生类，同时实现主持人接口
   */
  publicclass NvTongXue extends XueSheng implements ZhuChiRen{
  	//重写学生类中的抽象的吃的方法
  	publicvoid chi(){
  		System.out.println("我是女同学，我嗑瓜子，吃水果...");
  	}
  	//实现主持人接口的主持的方法
  	publicvoid zhuChi() {
  		System.out.println("女士们，先生们，大家好，我是主持人......");
  	}
  }
  /*
   * 班级类
   * 	方法：
   * 		开班会
   */
  publicclass BanJi {
  	//无返回值的，带两个参数的开晚会的方法，其中第1个参数为主持人接口类型，第二个参数为学生类型
  	publicvoid kaiBanHui(ZhuChiRen z,XueSheng x){
  		//1、先调用主持人的主持方法
  		z.zhuChi();
  		//2、打印一句话”晚会正式开始.....”
  		System.out.println("晚会正式开始.....");
  		//3、然后调用学生的吃的方法
  		x.chi();
  	}
  }
  /*
   * 测试类
   */
  publicclass Test22 {
  	publicstaticvoid main(String[] args) {
  		//1、使用多态的形式分别创建学生类型的对象,主持人类型的对象，
  		XueSheng x = new NanTongXue();
  		ZhuChiRen z = new NvTongXue();
  		//2、创建班级类型的对象（这个对象非多态），
  		BanJi b = new BanJi();
  		//3、使用班级对象调用开晚会的方法
  		b.kaiBanHui(z, x);
  	}
  }
  ```

  ​

