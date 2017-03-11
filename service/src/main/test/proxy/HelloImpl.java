package proxy;

/**
 * Created by liusifan on 2017/2/25.
 */
public class HelloImpl implements IHello {
    @Override
    public void sayHello() {
        System.out.println("Hello, world");
    }

}
