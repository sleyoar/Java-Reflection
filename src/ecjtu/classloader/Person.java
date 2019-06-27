package ecjtu.classloader;

public class Person {
    private String name;
    private int age;
    private String sex;
   public Person() {
        System.out.println("默认构造方法");
        sex="男";
    }
    public Person(String n, int a, String s) {
        name=n;
        age=a;
        sex=s;
        System.out.println("带参的构造方法");
    }

    public Person(String n,int a) {
        //this();默认构造方法
        name=n;
        age=a;
        System.out.println("两个参数的构造方法");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public int add(int a,int b) {
        return a+b;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
