package reflect20190627.work1.entity;

public class Student {
    private String name;
    private int age;
    private String sex;
    //默认构造
    public Student() {
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }
    //全属性赋值构造
    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    //姓名。性别。年龄默认20构造
    public Student(String name, String sex) {
        this.age=20;
        this.name = name;
        this.sex = sex;
    }
    //show（）显示信息
    public void show(){
        System.out.println("Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
