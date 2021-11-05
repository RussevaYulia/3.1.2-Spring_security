package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public List<Role> getAllRoles();

    public void saveUser(User user);

    public void editUser(User user);

    public User getUser(int id);

    public User getUserByName(String username);

    public void deleteUser(int id);
}
