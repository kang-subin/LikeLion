package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatmentStrategy {
    PreparedStatement makePreparedStatement (Connection connection) throws SQLException;

}
