package ecjtu.reflect;

import ecjtu.classloader.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestConstructor {
    public static void main(String[] args) throws NoSuchMethodException {
     Class cls= Person.class;
        try {
            //调用默认的构造函数
            Object obj= cls.newInstance();
            //利用反射调用带参的构造函数

            Constructor constructor=cls.getDeclaredConstructor(new Class[]{String.class,int.class,String.class});
            constructor.setAccessible(true);//取消访问权限
            System.out.println(constructor.newInstance(new Object[]{"张三",22,"男"}));

            //System.out.println(obj);
        } catch (InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getAllconstructors(){
        Class cls= Person.class;
        Constructor[] constructors=cls.getDeclaredConstructors();
        for(Constructor constructor:constructors){
            System.out.println(constructor.getName());

        }
    }
}
