package proxy;

import java.lang.reflect.Proxy;

/**
 * Created by liusifan on 2017/2/25.
 */
public class HelloTest {
    public static void main(String[] args) {
        DynamicProxy dp=new DynamicProxy(new HelloImpl());
        IHello hi= (IHello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),
                HelloImpl.class.getInterfaces(),dp);
        hi.sayHello();
    }
}
