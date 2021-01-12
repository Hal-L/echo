/*
import java.util.Arrays;1.分析以下需求，并用代码实现：
		(1)模拟Arrays.toString(int[] arr);方法，自己封装一个public static String toString(int[] arr);
		(2)如果int类型数组arr为null，toString方法返回字符串"null"
		(3)如果int类型数组arr长度为0，toString方法返回字符串"[]"
		(4)如果int类型数组arr的内容为{1,2,3,4,5},toString方法返回字符串"[1, 2, 3, 4, 5]"
		答：参考答案
		package com.heima.tests;
public class Test01 {
	public static void main(String[] args) {
		int[] arr1 = null;
		System.out.println(toString(arr1));
		int[] arr2 = new int[0];
		System.out.println(toString(arr2));
		int[] arr3 = {1,2,3,4,5};
		System.out.println(toString(arr3));
	}
	public static String toString(int[] arr) {
		//数组为空直接返回字符串"null"
		if (arr == null)
			return "null";
		int maxLen = arr.length - 1;
		//数组长度为0，返回字符串"[]"
		if (maxLen == -1)
			return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; ; i++) {
			sb.append(arr[i]);
			if (i == maxLen)
				return sb.append(']').toString();
			sb.append(", ");
		}
	}
}

2.分析以下需求，并用代码实现：
		(1)有一个数字字符串"25 11 -6 20 102 9",数字之间用空格间隔
		(2)对这串数字按照从小到大排序，生成一个数值有序的字符串"-6 9 11 20 25 102"
		(3)提示:用String类提供的split方法(用" "(空格)作为split方法的参数来切割)，然后生成对应的数字字符串数组
		答：参考答案
		package com.heima.tests;
public class Test02 {
	public static void main(String[] args) {
		String str = "25 11 -6 20 102 9";
		//1.将字符串数字变成字符串数组
		String[] arr = str.split(" ");
		//2.定义一个int数组,长度和arr相同
		int[] intArr = new int[arr.length];
		//3.将arr中的字符串类型的数字转成int类型并存入新数组intArr中
		for(int i =0;i<arr.length;i++) {
			intArr[i] = Integer.parseInt(arr[i]);
		}
		//4.调用sort方法对数组排序
		Arrasy.sort(intArr);
		//5.toString()方法将数组变成字符串
		System.out.println(Arrays.toString(intArr));
	}

3.定义一个方法实现如下功能:
	给定2个字符串，返回它们的连接，但是要去掉每个字符串的第一个字符。字符串将至少为1。
	public String nonStart(String s1,String s2){
		return s1.substring(1)+s2.substring(1);
	}

4.定义一个方法,方法名withoutX,实现如下功能:
	给定一个字符串，如果第一个或最后一个字符是'x'，则返回没有这些'x'字符串的字符串，
	否则返回字符串不变。
	public String withoutX(String str){

		if(str.length()>=2){
			if(str.charAt(0)=='x' && str.charAt(str.length()-1)=='x'){
				return str.substring(1, str.length()-1);
			}else if(str.charAt(0)=='x' && str.charAt(str.length()-1)!='x'){
				return str.substring(1);
			}else if(str.charAt(0)!='x' && str.charAt(str.length()-1)=='x'){
				return str.substring(0,str.length()-1);
			}else{
				return str;
			}
		}else if(str.length == 1){
			if(str.equals("x"){
				return "";
			}else{
				return str;
			}
		}

	}


5.给定两个字符串，将它们附加在一起（称为“并置”），并返回结果。
	但是，如果连接创建了一个双字符，则省略其中一个字符，因此“abc”和“cat”将生成“abcat”

	思路:
	前提:在获取这两个字符串的首位字符时,前提是字符串长度要大于0
1,获取参数1的最后一个字符
2,获取参数2 的第一个字符
3,比较获取的字符是否相等
4,拼接

	代码1:
	public class Itheima{
		public String conCat(String s1,String s2){
			if(s1.length()>0 && s2.length()>0){
				if(s1.charAt(s1.length()-1)==s2.charAt(0)){
					return s1+s2.substring(1);
				}
			}
			return s1+s2;
		}
	}

	代码2:
	public class Itheima{
		public String conCat(String s1,String s2){
			if(s1.length()>0 && s2.length()>0){
				if(s1.substring(s1.length()-1).equals(s2.substring(0,1))){
					return s1+s2.substring(1);
				}
			}
			return s1+s2;
		}
	}

6. 给定一个字符串，返回一个没有前2个字符的版本。 如果第一个字符是'a'，则保留第一个字符
	如果第二个字符是'b'。 则保留第二个字符，字符串可以是任意长度。

	思路:
			1,返回一个没有前2个字符的版本。那么也就是后所字符串长度至少要大于等于2
2,如果第一个字符是'a'，则保留第一个字符如果第二个字符是'b'。 则保留第二个字符
3,分了四种情况:
			1),前面有ab,返回:原串
	2),第一个字符是a,返回: 保留a,从第二个字符开始截取到最后
	3),第二个字符时b,返回: 丢掉第0个字符,从第一个字符开始截取到最后
	4),没有ab,返回:从第二个开始截取到最后

	代码1:
	public class Itheima{
		public String deFront(String str){

			if(str.length()>=2){
				if(str.substring(0,2).equals("ab")){
					return str;
				}else if(str.substring(0,1).equals("a")){
					return str.substring(0,1)+str.substring(2);
				}else if(str.substring(1,2).equals("b")){
					return str.substring(1);
				}else{
					return str.substring(2);
				}
			}
			return str;
		}
	}

	代码2:
	public class Itheima{
		public String deFront(String str){

			if(str.length()>=2){
				if(str.charAt(0)=='a'&&str.charAt(1)=='b'){
					return str;
				}else if(str.charAt(0)=='a'){
					return str.charAt(0)+str.substring(2);
				}else if(str.charAt(1)=='b'){
					return str.substring(1);
				}else{
					return str.substring(2);
				}
			}
			return str;
		}
	}

7.定义一个方法,方法名lastChars,实现以下功能:

	给定2个字符串，a和b，返回一个新的字符串，由a的第一个字符和b的最后一个字符，
	所以“you”和“java”产生“ya”。 如果任一个字符串的长度为0，则使用'@'作为其缺少的字符。

	思路:
			1,该题目分了四种情况
	1),两个字符串长度大于0 返回:获取第一个字符串的第一个字符,第二个字符串的最后一个字符
	2),一个等于0,第二个大于0 返回:"@"+第二个字符串的最后一个
	3),一个大于0,第二个等于0 返回:第一个字符串的第一个字符+"@"
			4)两个都等于0. 返回:"@@"
	public String lastChars(String s1,String s2){

		if(s1.length()>0 && s2.length()>0){
			return ""+s1.charAt(0)+s2.charAt(s2.length()-1);
		}else if(s1.length()>0 && s2.length()==0){
			return s1.charAt(0)+"@";
		}else if(s1.length()==0 && s2.length()>0){
			return "@"+s2.charAt(s2.length()-1);
		}else {
			return "@@";
		}
	}


8.练习今天课堂代码









	*/
