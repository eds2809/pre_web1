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

    public boolean addUser(String name) {
        return name != null && !name.isEmpty() && new UserJDBCDao(connection).addUser(name);
    }

    public boolean delUser(long id) {
        return new UserJDBCDao(connection).delUser(id);
    }

    public boolean updateUser(long id, String name) {
        User user = new User(id, name);
        return user.validate() && new UserJDBCDao(connection).update(user);
    }
}
