package web.service;


import dao.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;


    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public User findById(int id) {
        return null;
    }


}
