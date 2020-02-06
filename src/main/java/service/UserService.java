package service;

import dao.UserJDBCDao;
import model.User;
import util.DBHelper;

import java.sql.Connection;
import java.util.List;

public class UserService {

    public static UserService instance = new UserService();
    private final Connection connection;

    private UserService() {
        this.connection = DBHelper.getMysqlConnection();
    }

    public List<User> getAllUsers() {
        return new UserJDBCDao(connection).getAllUsers();
    }

    public boolean addUser(String name, String pass, long age) {
        return name != null &&
                pass != null &&
                !name.isEmpty() &&
                !pass.isEmpty() &&
                age > 0 &&
                new UserJDBCDao(connection).addUser(
                        new User(name, pass, age)
                );
    }

    public boolean delUser(long id) {
        return new UserJDBCDao(connection).delUser(new User(id));
    }

    public boolean updateUser(long id, String name, String pass, long age) {
        User user = new User(id, name, pass, age);
        return user.validate() && new UserJDBCDao(connection).update(user);
    }
}
