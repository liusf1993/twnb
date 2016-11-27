import com.lsf.twnb.entity.User;
import com.lsf.twnb.service.interfaces.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.BaseTest;

/**
 * Created by liusf on 8/8/16.
 */
public class UserTest extends BaseTest {
    @Autowired
    private IUserService userService;
    @Test
    public void insert() throws Exception {
        User user =new User();
        user.setUsername("liusf19934");
        user.setPassword("1");
        user.setCompany("hundsun");
        user.setPhone("18258441182");
        user.setEmail("liusf1993@sina.cn");
        userService.insert(user);

    }

    @Test
    public void updateById() throws Exception {

    }
}
