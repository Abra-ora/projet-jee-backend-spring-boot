package ma.fstt.backend.security.services;


import ma.fstt.backend.Model.Admin;
import ma.fstt.backend.Repository.AdminRepository;
import ma.fstt.backend.Service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AdminDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private SequenceServiceForAdmin sequenceService;

    public Admin addAdmin(Admin admin){
        admin.setId(sequenceService.getSequenceNumber(Admin.SEQUENCE_NAME));
        return adminRepository.save(admin);
    }

    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return AdminDetailsImpl.build(user);
    }
}
