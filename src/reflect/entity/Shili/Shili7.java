package reflect.entity.Shili;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Shili7 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//...
        Class clz = Class.forName("reflect.entity.Person");

        //获取 Person 的无参构造: public Person()

        Constructor c1 = clz.getDeclaredConstructor();
        // Person 的无参构造为 public, 这里可以直接访问
        Object obj = c1.newInstance();
        System.out.println(obj);

        //获取 Person 的单参构造: private Person (String)
        Constructor c2 = clz.getDeclaredConstructor(String.class);
        // Person 的单参构造为 private, 这里已超出其访问范围,不能直接访问
        // 通过 setAccessable 方法,设定为可以访问

        c2.setAccessible(true);
        obj = c2.newInstance("New Person");
        System.out.println(obj);

        //获取 Person 的三参构造: protected Person (String, String, String)
        Constructor c3 = clz.getDeclaredConstructor(String.class,String.class,String.class);
        // Person 的三参构造为 protected, 这里已超出其访问范围,不能直接访问
        // 通过 setAccessable 方法,设定为可以访问
        c3.setAccessible(true);
        obj = c3.newInstance("New Person","beijing","Hello!");
        System.out.println(obj);
        //...
    }
}
