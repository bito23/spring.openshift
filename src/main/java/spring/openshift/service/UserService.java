package spring.openshift.service;

import spring.openshift.entity.User;
import spring.openshift.exceptions.NullUserException;
import spring.openshift.exceptions.UpdateUserException;
import spring.openshift.exceptions.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    public User findById(int id) throws UsernameNotFoundException;

    public User findByName(String name) throws UsernameNotFoundException;

    public void save(User user) throws NullUserException;

    public void deleteById(int id) throws UsernameNotFoundException;

    public User updateUserById(User user, int id) throws UpdateUserException;

    public List<User> findAll();

}
