package ecjtu.handler;
import ecjtu.dao.IFindHouse;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LinkHome implements InvocationHandler {

    Object target;

    public Object getInstance(IFindHouse target){
       this.target=target;
       ClassLoader loader=target.getClass().getClassLoader();
       Class cls=target.getClass();
      Object obj =Proxy.newProxyInstance(loader,cls.getInterfaces(),this);
     return  obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是链家，我帮别人找房子..");
        //第一个参数是target,也就是被代理类的对象；第二个参数是方法中的参数
        Object result=method.invoke(target,args);
        System.out.println("我是链家，已经找完了..");
        return result;
    }
}
