package reflect20190627.work1.testreflect;

import reflect20190627.work1.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ChangeAge {
    public static void main(String[] args) throws Exception{
        Class clazz=Class.forName("reflect20190627.work1.entity.Student");
        Constructor constructor=clazz.getConstructor(new Class[]{String.class,int.class,String.class});
        Student st2=(Student)constructor.newInstance("bob",23,"男");
        st2.show();
        //调用getDeclaredField（”age“）获得age属性对象的Field对象
        Field f=clazz.getDeclaredField("age");
        //取消属性的访问权限控制，即使private属性也可以进行访问。
        f.setAccessible(true);
        //调用get()方法取得对应属性值。
        System.out.println("修改前的Age："+f.get(st2));
        // 调用set()方法给对应属性赋值。
        f.set(st2,36);
        // 调用get()方法取得对应属性修改后的值。
        System.out.println("修改后的Age："+f.get(st2));
        st2.show();
    }

}
