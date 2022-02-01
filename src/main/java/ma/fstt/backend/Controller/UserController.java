package ma.fstt.backend.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import ma.fstt.backend.Model.User;
import ma.fstt.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/clients/")
public class UserController {
    @Autowired private UserService userService;
    @Autowired
    private MongoOperations mongoOperations;

    @RequestMapping(value = "api/{id}",method = RequestMethod.GET)
    public User findbyid(@PathVariable("id")int id){
        User user = mongoOperations.findById(id,User.class);
       return user;

    }
    @RequestMapping(value = "api/delete/{id}", method = RequestMethod.GET)
    public void removeUser(@PathVariable("id") int id){
        User usr = mongoOperations.findById(id,User.class);
        mongoOperations.remove(usr);
    }
//    @GetMapping("/api/getAll")
//    public List<User> getAllUser(){
//        List<User> list = mongoOperations.findAll(User.class);
//        return list;
//    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User u = userService.getUser(id);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,String> info){
        List<User> allUsers = userService.getAllUsers();
        User u = null;
        String email ,pwd,usr_pwd;
        try {
            email = info.get("email");
            pwd = info.get("password");
            u = userService.getUserByEmail(email);
            if(u != null){
                usr_pwd = u.getPassword();
                if(pwd.equals(usr_pwd) && allUsers.contains(u)) {
                    return new ResponseEntity<>(info, HttpStatus.OK);
                }else{
                    return new ResponseEntity<>(info, HttpStatus.NOT_ACCEPTABLE);
                }
            }else
            return new ResponseEntity<>(info, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            throw (e);
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<User> addUser(@RequestBody User u) throws JsonMappingException, JsonProcessingException {
       try {
           User usr = userService.addUser(u);
           return new ResponseEntity<>(usr, HttpStatus.OK);

       }catch(Exception e){
           throw (e);
       }
       }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User u){
        User up_usr = userService.UpdateUser(u);
        return new ResponseEntity<>(up_usr, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
        userService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
