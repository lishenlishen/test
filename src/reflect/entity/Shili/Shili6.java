package reflect.entity.Shili;

public class Shili6 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class clz = Class.forName("reflect.entity.Person");//加载 Person 类
        Object obj = clz.newInstance();//调用 person 类的无参构造创建 Person 类实例
        System.out.println(obj);    //调用 Person 实例的 toString() 方法,属性均为默认值
    }
}
