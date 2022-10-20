package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class AWSConnectionMaker implements ConnectionMaker{

    @Override
    public Connection makeConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Map<String, String> env = System.getenv(); // getevn는 환경변수를 가져와주는 메소드로서 key 값을 넣으면 value 값을 반환해준다
        String dbHost = env.get("DB_HOST");// 키 값을 넣어서 벨류값을 스트링에 저장한다
        String dbUser = env.get("DB_USER");
        String dbPassword = env. get("DB_PASSWORD");
        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);
        return conn;
    }
}
