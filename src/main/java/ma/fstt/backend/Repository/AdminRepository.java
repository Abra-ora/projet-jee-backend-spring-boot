package ma.fstt.backend.Repository;

import ma.fstt.backend.Model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface AdminRepository extends MongoRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
