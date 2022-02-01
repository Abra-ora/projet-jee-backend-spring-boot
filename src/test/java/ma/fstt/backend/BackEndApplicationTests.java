package ma.fstt.backend;

import ma.fstt.backend.Model.Admin;
import ma.fstt.backend.Model.User;
import ma.fstt.backend.Repository.AdminRepository;
import ma.fstt.backend.Repository.UserRepository;
import ma.fstt.backend.Service.SequenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest


class BackEndApplicationTests {
    @Autowired
    private UserRepository u;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private AdminRepository adminRepository;
    @Test
    void contextLoads() {
//        for(int i = 0; i< 10 ;i++ ) {
//            User usr = new User("abdessamad5", "test@gmail.com", "password");
//            usr.setId(sequenceService.getSequenceNumber(usr.SEQUENCE_NAME));
//            u.save(usr);
//        }

//        User usr = new User("abdessamad5", "test@gmail.com", "password");
//        u.save(usr);
        Admin a = new Admin("admin", "admin@admin.com", "password");
//        User user=new User("anas", "anas@anas", "123456");
            adminRepository.save(a);

    }

}
