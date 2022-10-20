package Dao;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class UserDaoFactory { // userdao(모터) aws,local(선풍기날개) 중 어떤것을 선택할 것인가? 조합해놓는 곳
    @Bean // 빈이 스프링에 의해서 관리되어 지고 있는 자바 객체를 의미  여기선 userdao (aws서버에 연결된)
    public UserDao awsUserDao () throws SQLException, ClassNotFoundException {
        AWSConnectionMaker awsConnectionMaker = new AWSConnectionMaker();
      UserDao userDao = new UserDao(new AWSConnectionMaker()); // 제어의 역전 (원래는 userdao에서 인터페이스를 넣어서 구현했는데, 지금 경우는
        // 먼저 userdao 에 aws를 주입한 객체를 반환해서 이 팩토리 메소드를 사용하면 aws에 연결된 userdao를 쓸 수 있도록 함
      return userDao;

    }
    @Bean
    public UserDao localUserDao ( ){
        LocalUserDaoImpl localUserDao = new LocalUserDaoImpl();
        UserDao userDao = new UserDao(new LocalConnectionMaker());
        return userDao;
    }
}

