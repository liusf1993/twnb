package proxy;

/**
 * Created by liusifan on 2017/2/25.
 */
public class IHelloProxy implements IHello {
    private  IHello hello;
    @Override
    public void sayHello() {
        hello=new HelloImpl();
        System.out.println("good");
        hello.sayHello();
        System.out.print("人生真是寂寞如雪");
    }
}
