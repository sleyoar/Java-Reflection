package ecjtu.reflect;

import ecjtu.classloader.Person;
import org.junit.Test;

import java.lang.reflect.Field;

public class TestField {

    @Test
    public void getallFields() {
        Field[] fields = Person.class.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName() + "," + f.getModifiers());
        }

    }

    @Test
    public void getSingleField() {
        try {
            Person person=(Person)Person.class.newInstance();
            Class cls=Person.class;
            Field f=cls.getDeclaredField("age");
            f.setAccessible(true);
            f.setInt(person,24);
            System.out.println(f.getInt(person));
            f=cls.getDeclaredField("name");
            f.setAccessible(true);
            f.set(person,"李四");
            System.out.println(f.get(person));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}