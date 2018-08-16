package brauls.sandbox.springbootsandbox;

import brauls.sandbox.springbootsandbox.entity.User;
import brauls.sandbox.springbootsandbox.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    private final UserRepository userRepository;

    public App(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String []args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner demoData() {
        return (args -> {
            final User demoUser1 = new User();
            demoUser1.setName("Benedikt");
            demoUser1.setMailAddress("brauls101@gmail.com");
            this.userRepository.save(demoUser1);
        });
    }
}
