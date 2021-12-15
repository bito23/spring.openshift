package spring.openshift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.openshift.entity.User;
import spring.openshift.exceptions.NullUserException;
import spring.openshift.exceptions.UpdateUserException;
import spring.openshift.exceptions.UsernameNotFoundException;
import spring.openshift.dao.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public User findById(int id) throws UsernameNotFoundException {
        User searchedUser;
        if(userRepository.findById(id).isEmpty()){
            throw new UsernameNotFoundException(id);
        }
        searchedUser = userRepository.findById(id)
                                            .stream()
                                            .findAny()
                                            .get();
        return searchedUser;
    }

    @Override
    public User findByName(String name) throws UsernameNotFoundException {
        User searchedUser = userRepository.findByName(name);

        if(searchedUser == null){
            throw new UsernameNotFoundException(name);
        }
        return searchedUser;
    }

    @Override
    @Transactional
    public void save(User user) throws NullUserException {
        if(user.getName() == null || user.getAge() < 18 || user.getEmail() == null){
            throw new NullUserException();
        }
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) throws UsernameNotFoundException {
        if(userRepository.findById(id).isEmpty()){
            throw new UsernameNotFoundException(id);
        }

        userRepository.deleteById(id);
    }

    @Override
    public User updateUserById(User updatedUser, int id) throws UpdateUserException {

        if(updatedUser.getName() == null || updatedUser.getAge() < 18 || updatedUser.getEmail() == null){
            throw new UpdateUserException();
        }

        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    user.setAge(updatedUser.getAge());
                    return userRepository.save(user);
                }).orElseGet(() -> {
                    updatedUser.setId(id);
                    return userRepository.save(updatedUser);
                });
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
