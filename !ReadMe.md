### 系统版本

CentOS 7 x64 ，含GNOME桌面。

参数配置：1核/1G/20G/1网卡

账密：root/root；itcast/itheima888

默认IP：`192.168.115.130`

### 已安装软件

| 软件          | 安装路径                       | 备注                                 |
| ------------- | ------------------------------ | ------------------------------------ |
| `nginx`       | `/usr/local/nginx`             | 已配置path                           |
| `Tomcat`      | `/usr/local/tomcat`            | 已配置path                           |
| `JDK8`        | `/usr/local/JDK8`              | 替换OpenJDK，并已配置JAVA_HOME和path |
| `MysSQL5.7`   | 系统缺省位置                   | 已修改编码UTF-8，账密root/root       |
| `redis-5.0.5` | `/usr/local/redis/redis-5.0.5` | 已配置path                           |
| `防火墙`      |                                | 已关闭并禁止开机启动                 |



### 注意

1. 所有软件都是root账户安装的，操作的时候请使用root用户
2. 本虚拟机默认IP地址是：`192.168.115.130`。需要将IP修改为`192.168.你的VMNet8网段.130`才能正常通讯，修改步骤如下：



### 修改IP步骤

0. 确认VMNet8网卡网段

   > 打开VMWare，点`编辑`菜单下的`虚拟网络编辑器`，在弹出的窗口中选择`VMNet8`，查询窗口左下角的`子网IP`中第三段，即为我们需要的网卡网段

   获取root权限

   ```shell
   su root
   # 输入root密码，输入的时候没有任何提示，输入完回车就可以了。
   ```

   

1. 修改网卡配置文件

   ```shell
   vi /etc/sysconfig/network-scripts/ifcfg-ens33
   ```

   

2. 修改文件内容

   快捷键dd可以删一行，多次按键删除所有内容；

   按i<小写>进入插入模式，把下面的内容粘贴

   **注意：**网段改成你自己VMNet8的，改两个地方

   ```shell
   TYPE=Ethernet
   PROXY_METHOD=none
   BROWSER_ONLY=no
   BOOTPROTO=static
   IPADDR=192.168.23.129
   NETMASK=255.255.255.0
   GATEWAY=192.168.23.2
   DEFROUTE=yes
   IPV4_FAILURE_FATAL=no
   IPV6INIT=yes
   IPV6_AUTOCONF=yes
   IPV6_DEFROUTE=yes
   IPV6_FAILURE_FATAL=no
   IPV6_ADDR_GEN_MODE=stable-privacy
   NAME=ens33
   UUID=2c2371f1-ef29-4514-a568-c4904bd11c82
   DEVICE=ens33
   ONBOOT=true
   
   ```
   
改完后，按Esc ，再shift+分号，再输入wq保存退出<分号要是英文状态下的，中文无效>
   
3. 重启网络服务

   ```shell
   systemctl restart network
   ```

4. 查看IP是否修改成功

   ```shell
   ifconfig
   ```

5. ping宿主机网络网关/网卡地址（百度），验证网络是否联通

   ```shell
   ping 192.168.你的宿主机网段.1
   ping 你的宿主机IP
   ```

   