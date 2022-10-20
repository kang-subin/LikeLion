package Dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    Connection makeConnection () throws SQLException, ClassNotFoundException;
    // Connection 객체를 만들어서 리턴해주기 위해 생성된 메소드

}
