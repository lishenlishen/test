package reflect.entity.Shili;

import java.lang.reflect.Field;

public class Shili8 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //...
        Class clz = Class.forName("reflect.entity.Person");
        Object person = clz.newInstance();

        //获取 private String name 属性
        Field name = clz.getDeclaredField("name");
        // name 属性为 private,这里已超出其访问范围,不能直接访问
        // 通过 setAccessable 方法,设定为可以访问
        name.setAccessible(true);

        // 先取值看一下
        System.out.println("赋值前的 name: " + name.get(person));
        // 为 name 属性赋值
        name.set(person,"New Person");
        //展示赋值效果
        System.out.println("赋值后的 name: " + name.get(person));
    }
}
