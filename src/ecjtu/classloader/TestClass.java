package ecjtu.classloader;

public class TestClass {
    public static void main(String[] args) {
        //有三种方式获取class
       Person person=new Person();
       System.out.println(person.getClass());

        System.out.println("通过字节码文件："+Person.class);

        try {
            Class cls=Class.forName("com.ecjtu.classloader.Person");
            System.out.println(cls);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //基本类型的class
        System.out.println(Integer.TYPE);


    }
}
