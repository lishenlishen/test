package reflect.entity.Shili;

import reflect.entity.Person;

import java.lang.reflect.Modifier;

public class Shili2 {
    public static void main(String[] args) {
        Class clz = Person.class;
        String fullName = clz.getName();
        String simpleName = clz.getSimpleName();
        System.out.println("以下是"+fullName+"类的基本信息");
        System.out.println("-----------------");

        //获取 reflect.entity.Person 类所在的包
        Package pkg = clz.getPackage();
        System.out.println(simpleName+"定义在:"+pkg.getName()+"包中");
        System.out.println("-----------------");

        //获得 clz 所表示的实体 (类、接口、基本类型或 void)的超类的 Class
        //如果 clz 表示 Object 类、一个接口、一个基本类或 void ,则返回 null
        //如果 clz 表示一个数组类,则返回表示 Object 类的 CLass 实例
        Class superClass = clz.getSuperclass();
        System.out.println(simpleName+" 类的超类是: "+superClass.getName());
        System.out.println("-----------------");

        //获得 clz 所表示的类实现的接口
        //如果 clz 表示一个不实现任何接口的类或接口,则次方法返回一个长度为 0 的数组
        //如果 clz 表示一个基本类型或 void ,则此方法返回一个长度为 0 的数组
        Class[] interfaces = clz.getInterfaces();
        System.out.println(simpleName + " 类所实现的接口:");
        for (Class c : interfaces){
            System.out.println("\t" + c.getName());
            System.out.println("-----------------");
        }

        //每个修饰符对应一个 int 常量,返回的修饰符信息将类所拥有的修饰符以 “或” 运算组合
        //通过与 Modifier 类中的常量进行 “与” 运算即可判断该类型是否拥有某个修饰符
        int modifier = clz.getModifiers();
        System.out.println(simpleName + "类的修饰符:");
        if ((modifier & Modifier.PUBLIC) == Modifier.PUBLIC){
            System.out.println("\t访问修饰符是:public");
        }else{
            System.out.println("\t访问修饰符是:default(package)");
        }
        if ((modifier & Modifier.FINAL) == Modifier.FINAL){
            System.out.println("\t这个类是final的");
        }
        if ((modifier & Modifier.ABSTRACT) == Modifier.ABSTRACT){
            System.out.println("\t这个是一个抽象类");
        }
        if ((modifier & Modifier.INTERFACE) == Modifier.INTERFACE){
            System.out.println("\t这是一个接口");
        }
        System.out.println("-----------------");
    }
}
