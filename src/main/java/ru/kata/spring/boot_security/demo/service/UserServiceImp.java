package ru.kata.spring.boot_security.demo.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(int Id, String name, String lastName, String country, int age) {
        userDao.updateUser(Id, name, lastName, country, age);
    }


    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }



}
