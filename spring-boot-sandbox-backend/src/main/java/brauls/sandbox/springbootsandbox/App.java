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
            final User demoUser2 = new User();
            demoUser2.setName("Martin");
            demoUser2.setMailAddress("lux@gmail.com");
            this.userRepository.save(demoUser2);
            final User demoUser3 = new User();
            demoUser3.setName("Manuel");
            demoUser3.setMailAddress("fuchs@gmail.com");
            this.userRepository.save(demoUser3);
            final User demoUser4 = new User();
            demoUser4.setName("Jens");
            demoUser4.setMailAddress("wambach@gmail.com");
            this.userRepository.save(demoUser4);
            final User demoUser5 = new User();
            demoUser5.setName("Tim");
            demoUser5.setMailAddress("woerner@gmail.com");
            this.userRepository.save(demoUser5);
        });
    }
}
