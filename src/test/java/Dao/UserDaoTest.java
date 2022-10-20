package Dao;
import domein.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class) // application context 로드
@ContextConfiguration(classes = UserDaoFactory.class) // application context 정보 가져오는것
class UserDaoTest {

    @Autowired
    ApplicationContext context;

    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {

        //UserDaoFactory userDaoFactory = new UserDaoFactory();
        //UserDao userDao = userDaoFactory.awsUserDao(); // userdao 에 aws 인터페이스를 주입한 상태인 채로 사용가능함
        //User user = new User("3","jin", "1234");
        //userDaoFactory.awsUserDao().add(user);  //     userDao.add(user); 이거와 같은 값
        //String id = "3";
        //userDaoFactory.awsUserDao().get(id);
        //Assertions.assertEquals("jin" , user.getName());
         UserDao userDao = context.getBean("awsUserDao", UserDao.class); // 빈의 이름, 빈의 타입
        String id ="7";
        userDao.add(new User(id,"kangsubin","1234"));


    }
}
