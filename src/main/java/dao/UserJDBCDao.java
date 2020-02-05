package dao;

import executor.Executor;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJDBCDao {
    private Executor executor;

    public UserJDBCDao(Connection connection) {
        executor = new Executor(connection);
    }


    public List<User> getAllUsers() {
        try {
            return executor.execQuery("SELECT * FROM users", result -> {
                List<User> users = new ArrayList<>();
                while (result.next()) {
                    users.add(new User(result.getLong("id"), result.getString("name")));
                }
                return users;
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public boolean addUser(String name) {
        try {
            return executor.execUpdate(String.format("INSERT INTO users (name) VALUES (\"%s\")", name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delUser(long id) {
        try {
            return executor.execUpdate(String.format("DELETE FROM users WHERE id = %d ", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(User user) {
        try {
            return executor.execUpdate(
                    String.format("UPDATE users SET name = \"%s\" WHERE id = %d",
                            user.getName(),
                            user.getId()
                    )
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
