package ma.fstt.backend.Service;

import ma.fstt.backend.Model.User;
import ma.fstt.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SequenceService sequenceService;


    public User addUser(User u){
        u.setId(sequenceService.getSequenceNumber(u.SEQUENCE_NAME));
        return userRepository.save(u);
    }
    public User getUser(int id){
        return userRepository.findUserById(id).orElseThrow(()-> new NoSuchElementException("User with the id => "+id+" not found!!"));
    }
    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User UpdateUser(User u){
        return userRepository.save(u);
    }

    public void removeUser(int id){
        //Optional<User> u = userRepository.findById(id);
        userRepository.deleteUserById(id);
    }
}
