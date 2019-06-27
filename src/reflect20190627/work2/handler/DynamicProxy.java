package reflect20190627.work2.handler;

import reflect20190627.work2.dao.IUser;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class DynamicProxy implements InvocationHandler {
    Object target;

    public Object getInstance(IUser target){
        this.target=target;
        ClassLoader loader=target.getClass().getClassLoader();
        Class cls=target.getClass();
        Object obj= Proxy.newProxyInstance(loader,cls.getInterfaces(),this);
        return obj;
    }
    public static  boolean getRight(){
        Scanner sc=new Scanner(System.in);
        System.out.println("输入执行权限（y/n）：");
        if(sc.next().equals("y")){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //　　在代理真实对象前我们可以添加一些自己的操作
        System.out.println("我是动态代理方法，增加，删除User");
        if (getRight()) {
            System.out.println("Method:"+method);
            //    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
            method.invoke(target,args);
            System.out.println("方法执行完毕！");
        }else {
            System.out.println("当前无权操作！！！");
        }
        return null;
    }
}
