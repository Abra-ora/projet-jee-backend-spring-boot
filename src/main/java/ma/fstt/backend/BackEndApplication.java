package ma.fstt.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "ma.fstt.Repository")
@EntityScan("ma.fstt.backend.Model")
@ComponentScan(basePackages ="ma.fstt.backend.Service")
@ComponentScan(basePackages = "ma.fstt.backend.Controller")
@EnableMongoRepositories("ma.fstt.backend.Repository")
public class BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }

}
