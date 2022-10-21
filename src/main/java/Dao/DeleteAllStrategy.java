package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllStrategy  implements StatmentStrategy{

    @Override
    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {

        return connection.prepareStatement("DELETE  from users"); // del
    }

}
