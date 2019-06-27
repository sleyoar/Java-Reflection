package ecjtu.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TicketInvocationHandler  implements InvocationHandler {
    Object target;//被代理对象
    public TicketInvocationHandler(Object target){
        this.target=target;
    }

   /* public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }*/

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start=System.currentTimeMillis();
        System.out.println("买火车票之前的时间："+start);
        //反射原理调用方法
        Object obj=method.invoke(target, args);
        long end=System.currentTimeMillis();
        System.out.println("*********"+end);
        System.out.println("总共花费多少时间："+(end-start));
        return obj;
    }
}
