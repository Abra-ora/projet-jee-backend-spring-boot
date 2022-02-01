package ma.fstt.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("admins")
public class Admin {
    @Transient
    public static final String SEQUENCE_NAME = "admin_sequence";
    @Id
    private Integer id;
    private String username;
    private String email;
    private String password;

    public Admin(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        }
}
