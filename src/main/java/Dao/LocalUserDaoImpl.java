package Dao;

import domein.User;

import java.sql.*;
import java.util.Map;

public class LocalUserDaoImpl extends UserDaoAbstract{
//로컬 서버와 연결되어 있는 클래스
    @Override
    public Connection makeConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Map<String, String> env = System.getenv(); // getevn는 환경변수를 가져와주는 메소드로서 key 값을 넣으면 value 값을 반환해준다
        String dbHost = env.get("DB_HOST");// 키 값을 넣어서 벨류값을 스트링에 저장한다
        String dbUser = env.get("DB_USER");
        String dbPassword = env. get("DB_PASSWORD");
        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword); // mysql과 연동이 된다
        // 추상 클래스를 만든 이유는 상속을 통해서 conn의 객체의 값을 다르게 저장하기 위해서임
        // 로컬값이랑 AWS 서버의 conn 값은 다르니까..
        return conn;
    }
    public void add(User user) throws ClassNotFoundException, SQLException {
        LocalUserDaoImpl localUserDao = new LocalUserDaoImpl();
        Connection conn = localUserDao.makeConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES(?, ?, ?)");
        ps.setString(1,user.getId()); // 각 물음표에 값을 넣은것
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassword());

        ps.executeUpdate(); // 각 값을 저장함
        ps.close();// 저장한 후 쿼리문 작성 닫기
        conn.close();// 연결닫기


    }

    public User get (String id) throws SQLException, ClassNotFoundException {
        LocalUserDaoImpl localUserDao = new LocalUserDaoImpl();
            Connection conn = localUserDao.makeConnection();
    PreparedStatement ps = conn.prepareStatement("SELECT id, name, password From users where id = ?"); // id가 ? 인 값을 뽑아옴
    ps.setString(1,  id); //  id 값을 1로 했기 때문에 id 값이 1인 애를 뽑아서 rs에 저장함
    ResultSet rs = ps.executeQuery(); // 셀렉한 값을 Resultset 객체에 반환해주는 메소드
    rs.next();
    User user = new User(rs.getString("id"),
            rs.getString("name"), rs.getString("password"));
    rs.close();
    ps.close();
    conn.close();
    return user; // user을 리턴해서 rs 안의 값을 출력해볼 수 있음
}

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        //     userDao.add();

        User user = userDao.get("2"); //

        System.out.println(user.getName()); //성공함...


}
}
