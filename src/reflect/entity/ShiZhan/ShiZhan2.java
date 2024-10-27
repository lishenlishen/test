package reflect.entity.ShiZhan;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ShiZhan2 {
    public static void main2(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //a.获取类对象
        Class c = Student.class;
        //b.定位单个构造器对象(按照参数定位无参构造器)
        Constructor cons = c.getDeclaredConstructor();
        System.out.println(cons.getName() + "===>" + cons.getParameterCount());

        //如果遇到了私有的构造器,可以暴力反射
        cons.setAccessible(true);//权限被打开

        Student student = (Student) cons.newInstance();
        System.out.println(student);


        //定位某个有参构造器
        Constructor cons2 = c.getDeclaredConstructor(String.class,int.class);
        System.out.println(cons2.getName() + "===>" + cons2.getParameterCount());



    }

    public static void main(String[] args) throws Exception {

        Class clz = Class.forName("reflect.entity.ShiZhan.Student");    //加载 Student 类

        // 获取 Student 的单参构造 private Student
        Constructor c2 = clz.getDeclaredConstructor();
        //这个构造器修饰符为 private ,要加Declared
        Object object = c2.newInstance();
        System.out.println(object);

        // 获取 Student 两个参数构造器
        Constructor c1 = clz.getDeclaredConstructor(String.class);
        c1.setAccessible(true);
        //这个构造器修饰符为 public ,可以不加 Declared
        object = c1.newInstance("小明");
        System.out.println(object);



    }
}
