package Dao;
import domein.User;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.*;
import java.util.Map;

public class UserDao {
private ConnectionMaker connectionMaker; // 인터페이스가 userdao 멤버로 들어온것?
    UserDao(){
        this.connectionMaker = new AWSConnectionMaker(); // AWS 디폴트 설정, 다형성(구현한놈을 가리킬수 있다, 인터페이스 참조변수로 인터페이스를 참조한 애를 가리킬수 있다)
    }
    UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }


public void add(User user) throws ClassNotFoundException, SQLException {
    Connection conn = connectionMaker.makeConnection();  // 다형성때문에 참조변수가 aws... 이 아니라 connectionMaker로 될 수 있던 것임
    //인터페이스에 정의된 메소드를 사용하므로 클래스가 바뀐다해도 메소드 이름이 변경될 걱정이 없음
    PreparedStatement ps = new AddStrategy().makePreparedStatement(conn);
    // PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES(?, ?, ?)");
    // users 라는 테이블에 각 칼럼마다 값을 넣을것을 의미함
    ps.setString(1,user.getId()); // 각 물음표에 값을 넣은것
    ps.setString(2,user.getName());
    ps.setString(3,user.getPassword());

    ps.executeUpdate(); // 각 값을 저장함
    ps.close();// 저장한 후 쿼리문 작성 닫기
    conn.close();// 연결닫기
}
public User get (String id) throws SQLException, ClassNotFoundException {
    Connection conn = connectionMaker.makeConnection();
    PreparedStatement ps = conn.prepareStatement("SELECT id, name, password From users where id = ?"); // id가 ? 인 값을 뽑아옴
    ps.setString(1,  id); //  id 값을 1로 했기 때문에 id 값이 1인 애를 뽑아서 rs에 저장함
    ResultSet rs = ps.executeQuery(); // 셀렉한 값을 Resultset 객체에 반환해주는 메소드
    rs.next();
    User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
    rs.close();
    ps.close();
    conn.close();
    if(user == null) throw new EmptyResultDataAccessException(1); // 1 왜 넣는거죠?
    return user; // user을 리턴해서 rs 안의 값을 출력해볼 수 있음
}
public void jdbcContextWithStatementStrategy(StatmentStrategy stmt) throws SQLException, ClassNotFoundException {
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        conn = connectionMaker.makeConnection();
        pstmt = new DeleteAllStrategy().makePreparedStatement(conn); // delectall 쿼리를 가지고 있는 pstmt를 의미함
        pstmt.executeUpdate();

    } catch (SQLException | ClassNotFoundException e) {
         throw e;
    } finally { // error가 실행되도 무조건 실행되는 블럭
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
            }
        }
        if( conn != null) {
            try {
                conn.close();
            } catch (SQLException e){

            }

        }
    }



}



    public void deleteAll() throws SQLException, ClassNotFoundException {
        jdbcContextWithStatementStrategy(new DeleteAllStrategy());

    }

    public int getCount() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = connectionMaker.makeConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT count(*) from `users`");
            rs = pstmt.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            throw e;
       // } finally { if( )
        }
        rs.close();
        conn.close();
        return count;
    }



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            UserDao userDao = new UserDao(new AWSConnectionMaker());
             User user = new User("7","jj" , "1234" );
             userDao.add(user);
              //  userDao.add(user); // user 값 db에 추가
                user = userDao.get("7"); // id가 2인 값
                System.out.println(user.getName()); //id 2인 값 줄의 이름값을 출력
                 int count = userDao.getCount();
                 System.out.println(count);
        // userDao.deleteAll();


}

}
