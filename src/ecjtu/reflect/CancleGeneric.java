package ecjtu.reflect;


import ecjtu.classloader.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//取消泛型检查
public class CancleGeneric {

    public static void main(String[] args) {
        Person person=new Person("张三",22,"男");
        Person person1=new Person("李四",24,"男");
        Person person2=new Person("王五",23,"男");
        List<String> names=new ArrayList<String>();
        names.add(person.getName());
        names.add(person1.getName());
        //取消泛型，希望list存储整个学生
       // names.add(person);
        Class cls=names.getClass();
        try {
            Method m =cls.getDeclaredMethod("add",new Class[]{Object.class});
            m.setAccessible(true);
            m.invoke(names,person);
            m.invoke(names,1);
            System.out.println(names);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
