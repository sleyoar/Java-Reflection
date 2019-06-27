package reflect20190627.work2.test;

import reflect20190627.work2.dao.IUser;
import reflect20190627.work2.dao.User;
import reflect20190627.work2.dao.impl.UserReal;
import reflect20190627.work2.handler.DynamicProxy;

public class UserTest {
    public static void main(String[] args) {
        //    我们要代理的真实对象
        IUser userReal=new UserReal();
        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        IUser user= (IUser) new DynamicProxy().getInstance(userReal);
        user.add(new User(1,"bob"));
        user.delete(1);
    }
}
