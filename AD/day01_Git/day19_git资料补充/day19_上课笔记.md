#### 昨日反馈

```
栋哥 以后晚上晚自习的时候可以将一会会第二天要学的知识吗?
```

#### 昨日回顾

```
目录管理
	ls ll mkdir  rm  cp mv
文件管理
	touch 
	chmod -R 777 文件名
vim
	i
	esc
	:wq!
	:q!
文件查看
	cat
	tail
压缩解压
	tar -zcvf
	tar -zxvf
网络管理
	ifconfig
	ping
yum
	yum -y install 软件名
	yum remove 软件名
```

#### 简介

##### 1. 版本控制系统

```
分类
	Git(分布式)  SVN(集中式)
作用
	代码备份
	版本控制
	协同工作
	责任追溯
```

##### 2. Git

```
概念
	分布式的版本控制系统(没有中央服务器,每个人的电脑都是一个完整的版本库)
优势
	速度快
	简单的设计
	完全分布式
	对非线性开发模式的强力执行(允许上千个并行开发的分支)
```

#### 基本使用

##### 1. 工作流程

```
1,从远程仓库克隆git资源库作为本地仓库
2,从本地仓库checkout到本地工作区,然后进行代码的修改
3,在提交之前先将代码添加到暂存区(add命令)
4,提交修改,提交到本地仓库,本地仓库中保存的就是修改的各个版本的历史记录(commit)
5,需要和其他同事共享代码的时候,push到远程仓库
6,其他同事就可以pull(拉取)到自己的工作区
```

##### 2. 常用命令

```
git init 初始化 创建git仓库
git status 查看git状态
git add    将本地文件添加到暂存区
git commit  提交,将暂存区的文件提交到历史仓库
git log 	查看日志(历史提交记录)
```

##### 3. 版本切换

```
git reflog 可以查看所有分支的所有操作(更加精简的展示日志)
git reset --hard 版本唯一索引值 切换版本
```

#### 分支管理

##### 1. 好处

```
可以从开发主线上分离出来,在不影响主线的情况下,继续工作,一般用于周期较长的模块开发或者尝试性的模块开发
```

##### 2. 操作

```
创建分支
	git branch 分支名
切换分支
	git checkout 分支名
合并分支
    git merge 分支名
删除分支
    git branch -d 分支名
查看分支列表
	git branch
```

#### 远程仓库

##### 1. 本地推送到远程

```
创建远程仓库
	1,设置Git账号(自己注册)
	2,生成SSH公钥
		cd ~/.ssh（查看是否生成过SSH公钥）
		git config user.name（查看git账户）
		git config user.email（查看git邮箱）
		git config --global user.name “账户名”（设置全局账户名和邮箱）
		git config --global user.email “邮箱”
		ssh-keygen –t rsa –C “邮箱” (生成SSH公钥)
		cat ~/.ssh/id_rsa.pub  (查看生成的公钥)
	3,设置账户公钥(登录码云设置)
	4,公钥测试
		ssh -T git@gitee.com
		
推送到远程仓库
	1,为远程仓库地址起一个别名
		git remote add 远程名称 远程仓库地址
	2,推送
		git push -u 仓库名称 分支名
```

##### 2. 远程拉取到本地

```
1,如果是第一次,需要克隆到本地
	git clone 仓库地址
2,创建一个新的文件想推送远程仓库
	先git add 再git commit 最后 git push
3,另外一个同事想拉取你刚才推送的
	git pull 远程仓库名 分支名
```

##### 3. 代码冲突的解决

```
确保每次push之前做一次pull拉取的操作,如果有冲突,处理完冲突之后再push
```

#### idea中使用

##### 1. 配置Git

##### 2. 版本切换

```
reset  强行切换,并不会保存之前的记录
revert 可以保存之前的记录,需要你处理冲突,并且将这次切换也记录下来
```

##### 3. 分支管理

##### 4. 远程仓库

