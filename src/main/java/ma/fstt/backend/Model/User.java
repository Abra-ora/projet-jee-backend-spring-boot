package ma.fstt.backend.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    private int id;
    private String username;
    private String email;
    private String password;
//    private String imageUrl;

    public User(String full_name, String email, String password) {
        //this.id = id;
        this.username = full_name;
        this.email = email;
        this.password = password;
    }

    public User(){}
}
