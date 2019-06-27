package ecjtu.test;

import ecjtu.dao.Hello;
import ecjtu.handler.CGlibProxy;


public class TestCglib {
    public static void main(String[] args) {
       Hello helloproxy = CGlibProxy.getInstance().createProxy(new Hello());
       helloproxy.say("jack");
    }
}
