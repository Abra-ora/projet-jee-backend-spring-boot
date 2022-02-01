package ma.fstt.backend.Repository;

import ma.fstt.backend.Model.Admin;
import ma.fstt.backend.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
     void deleteUserById(Integer id);
    Optional<User> findUserById(Integer id);
    User findUserByEmail(String email);

}
