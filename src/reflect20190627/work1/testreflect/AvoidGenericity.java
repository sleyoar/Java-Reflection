package reflect20190627.work1.testreflect;
import reflect20190627.work1.entity.Student;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
public class AvoidGenericity {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Student> stuList=new ArrayList<Student>();
        stuList.add(new Student("Bob",23,"男"));
        stuList.add(new Student("Lucy",24,"女"));
        stuList.add(new Student("King",25,"男"));
        //获取ArrayList的Class对象，反向的调用add()方法，添加数据
        Class listClass=stuList.getClass();
        //获取add()方法
        Method m=listClass.getMethod("add", Object.class);
        //调用add()方法
        m.invoke(stuList,100);
        //遍历集合
        for(Object obj : stuList){
            System.out.println(obj);
        }
    }
}
