package reflect.entity.Shili;

import reflect.entity.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Shili5 {
    public static void main(String[] args) {
        //获取 reflect.entity.Person 类所有方法
        //包括公共、保护、默认(包)访问和私有属性,但不包括继承的方法
        //如果该类或接口不声明任何属性,或者此 Class 实例表示一个基本类型,
        //一个数组或 void,此方法返回一个长度为 0 的数组


        Method[] methods = Person.class.getDeclaredMethods();

        //展示方法的一些信息
        System.out.println("============方法展示============");
        for (Method method : methods) {
            System.out.println("方法名:" + method.getName());
            System.out.println("返回值类型:" + method.getReturnType().getName());

            //获取方法的参数列表
            Class[] params = method.getParameterTypes();

            if (params.length == 0){
                System.out.println("该方法没有参数");
            }else{
                System.out.print("该方法的参数列表为: [");
                for (int i = 0; i < params.length; i++) {
                    if (i != 0){
                        System.out.print(",");
                    }
                    System.out.println(params[i].getName());
                }
                System.out.println("]");
            }

            System.out.print("访问修饰符: ");
            int modifier = method.getModifiers();
            //判断该方法的访问修饰符
            if ((modifier & Modifier.PUBLIC) == Modifier.PUBLIC){
                System.out.println("public");
            }
            if ((modifier & Modifier.PRIVATE) == Modifier.PRIVATE){
                System.out.println("private");
            }
            if ((modifier & Modifier.PROTECTED) == Modifier.PROTECTED){
                System.out.println("protected");
            }

            //判断该方法是否有 static 修饰符
            if ((modifier & Modifier.STATIC) == Modifier.STATIC){
                System.out.println("这是一个静态方法");
            }
            //判断该方法是否有 final 修饰符
            if ((modifier & Modifier.FINAL) == Modifier.FINAL){
                System.out.println("这是一个 final 方法");
            }
            //判断该方法是否有 abstract 修饰符
            if ((modifier & Modifier.ABSTRACT) == Modifier.ABSTRACT){
                System.out.println("这是一个抽象方法");
            }
            //判断该方法是否有 synchronized 修饰符
            if ((modifier & Modifier.SYNCHRONIZED) == Modifier.SYNCHRONIZED){
                System.out.println("这是一个同步方法");
            }

            //获取方法所属的类或接口的 Class 实例
            Class declaringClass = method.getDeclaringClass();
            System.out.println("方法声明在: " + declaringClass.getName() + " 中");

            //获取方法抛出的异常类型,即 throws 字句中声明的异常
            Class[] exception = method.getExceptionTypes();
            if (exception.length > 0){
                System.out.print("该方法抛出的异常有: [");
                for (int i = 0; i < exception.length; i++) {
                    if (i != 0){
                        System.out.print(",");
                    }
                    System.out.println(exception[i].getName());
                }
                System.out.println("]");
            }
            System.out.println("-------------------------------------");
        }//遍历方法
    }
}
