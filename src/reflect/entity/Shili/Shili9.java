package reflect.entity.Shili;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Shili9 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //...
        //通过反射加载 Person 类
        Class clz = Class.forName("reflect.entity.Person");

        //根据方法名和参数列表获取 static final int getAge() 方法,
        //没有参数可以不写或用 null 表示
        Method getAge = clz.getDeclaredMethod("getAge",null);
        // getAge 方法为 default (package), 这里已超出其访问范围,不能直接访问
        // 通过 setAccessable 方法,设定为可以访问

        getAge.setAccessible(true);
        // 调用 getAge 方法并传参,没有参数可以不写或用 null 表示
        // getAge 方法为静态方法,调用时可以不指定具体 Person 实例
        Object returnAge = getAge.invoke(null,null);//抛出异常
        System.out.println("年龄是:" + returnAge);

        Object person = clz.newInstance();//创建 Preson 实例

        //根据方法名和参数列表获取 private void silentMethod() 方法,
        //没有参数可以不写或用 null 表示
        Method silentMethod = clz.getDeclaredMethod("silentMethod",null);
        // silentMethod 方法为 private,这里已超出其访问范围,不能直接访问
        // 通过 setAccessable 方法,设定为可以访问

        silentMethod.setAccessible(true);
        //调用 silentMethod 方法并传参,没有参数可以不写或用null表示
        silentMethod.invoke(person,null);

        //根据方法名和参数列表获取 public void setName(String)方法
        Method setName = clz.getDeclaredMethod("setName", String.class);
        // setName 方法为 public, 这里可以直接访问
        // 调用 setName 方法并传参
        setName.invoke(person,"New Person");
        //验证一下结果,调用 public String getName() 方法得到 name 的值
        Object returnName = clz.getDeclaredMethod("getName").invoke(person);
        System.out.println("刚才设定的name是:"+ returnName);
    }
}
