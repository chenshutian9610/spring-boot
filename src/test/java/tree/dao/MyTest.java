package tree.dao;

import tree.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    private UserDao dao;
    @Test
    public void myTest(){
        User user=dao.getOne(1);
        System.out.println(user);
    }
}