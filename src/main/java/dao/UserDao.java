package dao;

import model.User;

public interface UserDao {
    public void add(User user);

    public void delete(User user);

    public void edit(User user);

    public User findById(int id);
}
