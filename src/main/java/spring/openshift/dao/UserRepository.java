package spring.openshift.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.openshift.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);
}
