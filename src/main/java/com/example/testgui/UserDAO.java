package com.example.testgui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends Const {
        private static final String FIND_ALL_SQL = "SELECT * FROM Client";


        public List<User> findAll() {
            try (var connection = DBConnection.getInstance().getConnection();
                 var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
                var resultSet = preparedStatement.executeQuery();
                List<User> users = new ArrayList<>();
                while (resultSet.next()) {
                    users.add(buildUser(resultSet));
                }
                return users;
            } catch (SQLException throwable) {
                throwable.printStackTrace();
                throw new DaoException(throwable);
            }
        }

    private static final UserDAO INSTANCE = new UserDAO();
        public static UserDAO getInstance() {
            return INSTANCE;
        }
        private User buildUser(ResultSet resultSet) throws SQLException {
            return new User(
                    resultSet.getString("number_phone"),
                    resultSet.getString("name"),
                    resultSet.getString("type_service")
            );
        }
}

