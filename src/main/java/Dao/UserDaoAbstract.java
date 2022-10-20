package Dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class UserDaoAbstract {// 추상클래스를 통해서 꼭 필요한 메서드를 상속받은 애들이 쓰도록 함
    public abstract Connection makeConnection() throws SQLException, ClassNotFoundException;
}

    // connction을 리턴하는 메소드로 이 클래스를 상속
    //받은 경우 꼭 이 메소드를 오버라이딩? 해야
    //추상 클래스는 다중상속을 못하기 때문에 다른 목적으로 상속을 받을 수가 없어서 문제점이 발생함
    //따라서 인터페이스를 사용하는 것임
    //Connection connection = awsConnectionMaker.makeConnection(); aws클래스로 분리하면 이런식으로 사용 가능함
    //클래스랑 연결되면 Userdao랑 강하게 결합되서 객체지향적이지 못하다?
