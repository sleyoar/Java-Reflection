package reflect20190627.work1.testreflect;
import reflect20190627.work1.entity.Student;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class ShowMethod {
    public static void main(String[] args) throws IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz= Student.class;
        Constructor constructor=clazz.getConstructor(new Class[]{String.class,int.class,String.class});
        Student st2=(Student)constructor.newInstance("bob",23,"男");
        Method smethod=clazz.getMethod("show");
        Object result=smethod.invoke(st2);
    }
}
