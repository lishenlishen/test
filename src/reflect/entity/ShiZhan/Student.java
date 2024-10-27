package reflect.entity.ShiZhan;

public class Student {
    private String name;

    public static int getAge() {
        return age;
    }

    static final int age = 0;

    public Student() {
        System.out.println("无参构造器执行");
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
