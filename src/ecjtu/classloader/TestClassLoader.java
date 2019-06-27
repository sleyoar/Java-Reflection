package ecjtu.classloader;

public class TestClassLoader {
    public static void main(String[] args) {
        //获取默认系统加载器
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while(classLoader!=null){
            classLoader=classLoader.getParent();
            System.out.println("获取最顶层的加载器："+classLoader);
        }
        try {
            Class cls=Class.forName("java.lang.Object");
            System.out.println("System类的加载器："+cls.getClassLoader());
            //自定义类的加载器
            cls=Class.forName("com.ecjtu.classloader.Person");
            System.out.println("自定义类的加载器为："+cls.getClassLoader());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
