package reflect20190627.work1.testreflect;

import reflect20190627.work1.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorTest {
    public static void main(String[] args) {
        Class cls= Student.class;
        try {
            //调用默认的构造函数
            Student st1=(Student) cls.newInstance();
            st1.show();
            //调用全属性赋值构造函数
            Constructor constructor=cls.getConstructor(new Class[]{String.class,int.class,String.class});
           Student st2=(Student)constructor.newInstance("bob",23,"男");
           st2.show();
           //调用姓名。性别。年龄默认20构造函数
            Constructor constructor1=cls.getConstructor(new Class[]{String.class,String.class});
            Student st3=(Student)constructor1.newInstance("Lucy","女");
            st3.show();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
