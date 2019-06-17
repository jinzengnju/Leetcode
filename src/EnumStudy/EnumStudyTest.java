package EnumStudy;


import java.awt.*;

public class EnumStudyTest {
    public void testSwitch() {
        for (EnumTest e : EnumTest.values()) {
            System.out.println(e.toString());
        }
        System.out.println("----------------我是分隔线------------------");
        EnumTest test = EnumTest.TUE;
        switch (test) {
            case MON:
                System.out.println("今天是星期一");
                break;
            case TUE:
                System.out.println("今天是星期二");
                break;
            // ... ...
            default:
                System.out.println(test);
                break;
        }
    }

    //向枚举中添加新方法
    public void testColorEnum(){
        String color=ColorEnum.getName(1);
        System.out.println("index 1:"+color);
        String name=ColorEnum.RED.getName();
        System.out.println("RED name is:"+name);//获得括号里的名字

        System.out.println("========================");
        System.out.println(ColorEnum.RED.name());
        System.out.println(ColorEnum.RED.toString());

    }

    //给 enum 自定义属性和方法
    public void testEnumTest2(){
        System.out.println(EnumTest2.FRI.getValue());
    }






}
