package reflect.entity.ShiZhan;

import reflect.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ShiZhan1 {
    public static void main(String[] args) {
        Class clz = Person.class;
        String fullName = clz.getName();
        String simpleName = clz.getSimpleName();
        System.out.println("以下是 " + fullName + " 类的基本信息");
//        System.out.println("------------------------");

        //获取 Person 类所在的包
        Package pkg = clz.getPackage();
        System.out.println(simpleName + " 定义在: " + pkg.getName() + " 包中");
//        System.out.println("------------------------");

        //获得 clz 所表示的实体 (类、接口、基本类型或 void)的超类的 Class
        //如果 clz 表示 Object 类、一个接口、一个基本类或 void ,则返回 null
        //如果 clz 表示一个数组类,则返回表示 Object 类的 CLass 实例
        Class superClass = clz.getSuperclass();
        System.out.println(simpleName + " 类的超类是: " + superClass.getName());
//        System.out.println("------------------------");

        //获得 clz 所表示的类实现的接口
        //如果 clz 表示一个不实现任何接口的类或接口,则次方法返回一个长度为 0 的数组
        //如果 clz 表示一个基本类型或 void ,则此方法返回一个长度为 0 的数组
        Class[] interfaces = clz.getInterfaces();
        System.out.println(simpleName + " 类所实现的接口: ");
        for (Class c : interfaces) {
            System.out.println("\t" + c.getName());
        }
//        System.out.println("------------------------");

        //每个修饰符对应一个 int 常量,返回的修饰符信息将类所拥有的修饰符以 “或” 运算组合
        //通过与 Modifier 类中的常量进行 “与” 运算即可判断该类型是否拥有某个修饰符
        int modifier = clz.getModifiers();
        System.out.println(simpleName + " 类的修饰符: ");
        //判断修饰符
        if ((modifier & Modifier.PUBLIC) == Modifier.PUBLIC){
            System.out.println("\t访问修饰符是: public");
        }else if ((modifier & Modifier.PRIVATE) == Modifier.PRIVATE){
            System.out.println("\t访问修饰符是: private");
        }else if ((modifier & Modifier.PROTECTED) == Modifier.PROTECTED){
            System.out.println("\t访问修饰符是: protected");
        }else{
            System.out.println("\t访问修饰符是: default(package)");
        }
        //
        if ((modifier & Modifier.FINAL) == Modifier.FINAL){
            System.out.println("\t这个类是 final 的");
        }
        if ((modifier & Modifier.ABSTRACT) == Modifier.ABSTRACT){
            System.out.println("\t这个类是抽象类");
        }
        if ((modifier & Modifier.INTERFACE) == Modifier.INTERFACE){
            System.out.println("\t这是一个接口");
        }

        //构造方法
        Constructor[] cons = Person.class.getDeclaredConstructors();

        //构造方法展示
        System.out.println("==============构造方法展示==============");
        for (Constructor con : cons) {
            // 获取构造方法的参数列表
            Class[] params = con.getParameterTypes();
            if (params.length == 0){
                System.out.println("该构造方法没有参数");
            }else{
                System.out.print("该构造方法的参数列表为: [");
                for (int i = 0; i < params.length; i++) {
                    if (i != 0){
                        System.out.print(",");
                    }
                    System.out.println(params[i].getName());
                }
                System.out.println("]");
            }
            System.out.println("----------------------------");
        }//构造方法遍历


        //属性
        //获取 reflect.entity.Person 类所有属性
        //包括公共、保护、默认(包)访问和私有属性,但不包括继承的属性
        //如果该类或接口不声明任何属性,或者此 Class 实例表示一个基本类型,
        //一个数组或 void,此方法返回一个长度为 0 的数组

        Field[] fields = Person.class.getDeclaredFields();
        //展示属性的一些信息
        System.out.println("==============属性展示==============");
        for (Field field : fields) {
            System.out.println("属性名: " + field.getName());
            System.out.println("类型: " + field.getType().getName());
        }

        //方法
        //获取 reflect.entity.Person 类所有方法
        //包括公共、保护、默认(包)访问和私有属性,但不包括继承的方法
        //如果该类或接口不声明任何属性,或者此 Class 实例表示一个基本类型,
        //一个数组或 void,此方法返回一个长度为 0 的数组

        Method[] methods = Person.class.getDeclaredMethods();

        //展示方法的一些信息
        System.out.println("==============方法展示==============");
        for (Method method : methods) {
            System.out.println("方法名: " + method.getName());
            System.out.println("返回值类型: " + method.getReturnType().getName());
        }
    }
}
