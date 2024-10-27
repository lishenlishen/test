package reflect.entity.ShiZhan;

import java.lang.reflect.Method;

public class ShiZhan3 {
    public static void main(String[] args) throws Exception {
        // 通过反射加载 Student 类
        Class clz = Class.forName("reflect.entity.ShiZhan.Student");

        //根据方法名和参数列表获取 getAge() 方法
        //没有参数可以不写或用null表示

        Method getAge = clz.getDeclaredMethod("getAge",null);
        //getAge方法为 public
        //通过setAccessable方法,设定为可以访问
//        getAge.setAccessible(true);
        //调用 getAge 方法并传参,没有参数可以不写或用null表示
        Object returnAge = getAge.invoke(null,null);
        System.out.println("年龄是: " + returnAge);

        Object Student = clz.newInstance();//创建 Student 实例

        Method setAge = clz.getDeclaredMethod("setName", String.class);
        setAge.invoke(Student,"小明");
        Object object = clz.getDeclaredMethod("getName").invoke(Student);
        System.out.println(object);
    }
}
