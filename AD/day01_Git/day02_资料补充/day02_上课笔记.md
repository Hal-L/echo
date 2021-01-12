#### 昨日反馈

```
老师十分敬业负责，非常棒。
后面的视频时间比较长 希望能尽量1.2倍播放 听起来没区别 但是能省些时间
```

#### 昨日回顾

```
用户相关
	useradd 用户名
	passwd 用户名
	
	groupadd 组名
	gpasswd -a 用户名 组名
	grep '组名' /etc/group
	
	userdel -r -f 用户名
	groupdel 组名
系统管理
	su
	sudo
	timedatectl set-ntp true
	who
	clear
进程相关
	top
	ps -ef
	kill 进程id
	kill -9 进程id
```

#### 目录管理命令

```
ls 列出目录下的文件(不包含隐藏文件)  
ll 列出目录下文件的详细信息 

pwd 显示当前所在的目录
cd 切换目录(change directory)

mkdir 目录名 创建新的目录
touch 文件名 创建新的文件
rm -rf 删除文件(不带提示) r:递归处理  f:强制删除
rm -rf /* 删库跑路

cp 文件名 目录名  复制文件到指定目录
mv 文件名 目录名  移动文件到指定目录
```

#### 文件管理命令

```
chown 属主名:属组名 文件名  更改文件的属主和属组属性
chmod -R 777 文件名/目录   更改文件/目录的属性为可读可写可执行
```

#### vim相关命令

```
打开文件
	vim 文件名  文件已存在就会直接打开,不存在,退出之后就会新建一个文件

编辑模式
	i  在当前字符前插入文本
	esc 退出编辑默认

末行模式
	:q! 不保存退出
	:wq! 保存退出
```



#### 文件查看命令

```
cat a.txt 查看a.txt的内容(小文件)
less a.txt 查看a.txt的内容(大文件)
tail -f 文件名 动态的显示文件后面10行内容


grep 关键字 文件名 把包含关键字的行展示出来
```



#### 压缩解压命令

```
tar -zcvf 压缩文件名 文件名/文件夹   压缩并指定压缩文件
tar -zxvf 压缩文件名  解压到当前目录
tar -zxvf 压缩文件名 -C 目录名  解压到指定目录

安装tomcat
	1,在跟目录下创建一个tomcat文件夹,将压缩包拖进去
	2,解压:tar -zxvf apache-tomcat-9.0.29.tar.gz
	3,bin目录中: ./startup.sh  开启服务
	4,systemctl stop firewalld 关闭Linux的防火墙
	
	在window浏览器中输入http://192.168.23.129:8080/
```

#### 网络管理相关

```
ifconfig 查看网址

ping 网址 是否连通

查看防火墙状态
	systemctl status firewalld.service 
禁用防火墙
	systemctl disable firewalld.service  用enable可以再次开启
关闭防火墙
	systemctl stop firewalld.service 
```



#### yum工具使用

```
yum -y install 软件名称 安装软件
yum remove 软件名称 移除软件
```



#### 其他常用命令

```
管道命令 |  
	将一个命令的输出作为另外一个命令的输入
	
rpm:红帽的包管理工具,可以安装,卸载,升级,管理软件
 -e 卸载程序
 -q 查询已经安装的软件的信息
 -i 安装rpm包(程序)
 -vh 显示安装的进度
 -qa 列出所有被安装的软件
 
 rpm -qa | grep java 查找系统中安装的java软件
 
 
重定向命令 >
	将正常输出的数据重新改变一个方法
	cat anaconda-ks.cfg > a.txt 默认是输出控制台,现在流入文件
```



