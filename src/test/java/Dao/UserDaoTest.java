package Dao;
import domein.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class) // application context 로드
@ContextConfiguration(classes = UserDaoFactory.class) // application context 위치지정 (bean이 담겨있는 곳)
class UserDaoTest {
    @Autowired
    ApplicationContext context; //이곳에 bean 값이 ? 주입되서 이걸통해 bean 을 꺼내 쓸 수 있음
        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        User user1 = new User("1", "subin", "1234");
        User user2 = new User("2", "yi", "1234");
        User user3 = new User("3", "sa", "1234");

    @BeforeEach
        // @test가 매번 실행될 때 실행되는 코드를 공통화 함
    void setup() { // 보통 이 이름으로 함
        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
    }


    @Test
        // test
    void addAndSelect() throws SQLException, ClassNotFoundException {

        //UserDaoFactory userDaoFactory = new UserDaoFactory();
        //UserDao userDao = userDaoFactory.awsUserDao(); // userdao 에 aws 인터페이스를 주입한 상태인 채로 사용가능함
        //User user = new User("3","jin", "1234");
        //userDaoFactory.awsUserDao().add(user);  //     userDao.add(user); 이거와 같은 값
        //String id = "3";
        //userDaoFactory.awsUserDao().get(id);
        //Assertions.assertEquals("jin" , user.getName());
//         UserDao userDao = context.getBean("awsUserDao", UserDao.class); // 빈의 이름, 빈의 타입
//        String id ="7";
//        userDao.add(new User(id,"kangsubin","1234"));
    }

    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
       // UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        userDao.deleteAll();
        assertEquals(0, userDao.getCount());
        String id = "7";
        userDao.add(new User(id, "yel", "1234"));
        User user = userDao.get(id);
        assertEquals(1, userDao.getCount());
    }

    @Test
    void count() throws SQLException, ClassNotFoundException {

   UserDao userDao = context.getBean("awsUserDao", UserDao.class);
   userDao.add(user1);
//        User user1 = new User("1", "subin", "1234");
//        User user2 = new User("2", "yi", "1234");
//        User user3 = new User("3", "sa", "1234");
//
//        userDao.deleteAll();
//        assertEquals(0, userDao.getCount());
//        userDao.add(user1);
//        assertEquals(1, userDao.getCount());
//        userDao.add(user2);
//        assertEquals(2, userDao.getCount());
//        userDao.add(user3);
//        assertEquals(3, userDao.getCount());

    }
}


