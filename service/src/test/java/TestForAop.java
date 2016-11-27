import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by liusf13201 on 2015/11/13.
 */
@Component
@Aspect
public class TestForAop
{
    @Pointcut("execution (* com.lsf.twnb.service.impl.UserServiceImpl.insert(..))")
    public void performance()
    {

    }
    @Before("performance()")
    public void before(JoinPoint jp)
    {
        try
        {

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("start");
    }
    @AfterReturning("performance()")
    public void afterSucc(JoinPoint jp)
    {

        jp.getTarget().getClass().getName();
        jp.getArgs();
        System.out.println("succ");
    }


}
