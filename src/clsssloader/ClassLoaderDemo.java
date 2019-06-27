package clsssloader;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader classLoader;
        classLoader=ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (classLoader!=null){
            classLoader=classLoader.getParent();
            System.out.println(classLoader);
        }
        try {
            Class cl=Class.forName("java.lang.Object");
            classLoader=cl.getClassLoader();
            System.out.println("java.long.Object's loader is "+classLoader);
            cl=Class.forName("test.exp.Student");
            classLoader=cl.getClassLoader();
            System.out.println("ClassLoaderDemo's Loader is "+classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/*
执行结果如下：
//表示系统类装载器实例化自类sun.misc.Launcher$AppClassLoader
sun.misc.Launcher$AppClassLoader@19821f
//表示系统类装载器的parent实例化自类sun.misc.Launcher$ExtClassLoader
sun.misc.Launcher$ExtClassLoader@addbf1
//表示系统类装载器parent的parent为bootstrap，无法直接获取
null
//表示类Object是由bootstrap装载的
java.lang.Object's loader is  null
//表示用户类是由系统类装载器装载的
ClassLoaderDemo's loader is  sun.misc.Launcher$AppClassLoader@19821f

 */