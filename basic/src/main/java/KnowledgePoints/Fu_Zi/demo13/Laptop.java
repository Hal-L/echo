package KnowledgePoints.Fu_Zi.demo13;

public class Laptop {

    public void run(){
        System.out.println("开启笔记本");
    }

    public void shutDown(){
        System.out.println("关闭笔记本");
    }

    // 使用usb
    public void useUsb(USB usb){// USB usb = new Mouse();
        usb.open();// usb设备需要打开
        // 判断usb指向的对象是Mouse类型,那么就向下转型
        if(usb instanceof Mouse){
            Mouse mouse = (Mouse) usb;
            mouse.click();//点击鼠标
        }

        // 判断usb指向的对象是Keyboard类型,向下转型
        if(usb instanceof Keyboard){
            Keyboard kb = (Keyboard)usb;
            kb.type();// 敲击键盘
        }

        usb.close();// usb设备关闭
    }

}
