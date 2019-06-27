package ecjtu.handler;

import ecjtu.dao.Hello;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxy  implements MethodInterceptor {
    private static CGlibProxy instance = new CGlibProxy();
    /**
     * 内部持有委托类对象的引用
     */
    private Object target;
    private CGlibProxy(){

    }

    public static CGlibProxy getInstance(){
        return instance;
    }

    //获取代理对象
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    /**
     * 创建代理类对象
     */
    public Hello createProxy(Hello object){
        target = object;
        //创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        //设置要代理的目标类，以扩展功能
        enhancer.setSuperclass(this.target.getClass());
        //设置单一回调对象，在回调中拦截对目标方法的调用
        enhancer.setCallback(this);
        //设置类加载器
        enhancer.setClassLoader(object.getClass().getClassLoader());
        //创建代理对象
        return (Hello)enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();//做些权限控制
        Object result = methodProxy.invokeSuper(obj,args);
        after();//日志输出
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");

    }
}
