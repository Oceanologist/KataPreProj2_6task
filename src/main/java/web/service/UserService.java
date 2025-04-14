package web.service;

import model.User;

public interface UserService {
    public void add(User user);

    public void delete(User user);

    public void edit(User user);

    public User findById(int id);
}
