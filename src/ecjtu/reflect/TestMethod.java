package ecjtu.reflect;

import ecjtu.classloader.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethod {
    public static void main(String[] args){
        //获取add方法
        Class cls= Person.class;
        try {
            Person person=(Person)cls.newInstance();
            Method m=cls.getDeclaredMethod("add",new Class[]{int.class,int.class});
            Object result= m.invoke(person,3,4);
            m=cls.getDeclaredMethod("setAge",new Class[]{int.class});
            m=cls.getDeclaredMethod("getAge",new Class[]{});
            System.out.println(m.invoke(person,null));
            //System.out.println(result);
        } catch (InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
