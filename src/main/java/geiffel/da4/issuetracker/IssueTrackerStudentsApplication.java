package geiffel.da4.issuetracker;

import geiffel.da4.issuetracker.user.Fonction;
import geiffel.da4.issuetracker.user.User;
import geiffel.da4.issuetracker.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class IssueTrackerStudentsApplication {

    private final UserRepository userRepository;

    @Autowired
    public IssueTrackerStudentsApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(IssueTrackerStudentsApplication.class, args);
    }

    @Bean
    public CommandLineRunner setUpBDD() {
        return args -> {
            List<User> = new ArrayList<>(){{
                users.add(new User(1L, "Machin", Fonction.USER));
                users.add(new User(2L, "Chose", Fonction.USER));
                users.add(new User(3L, "Truc", Fonction.DEVELOPPER));
            }};
            userRepository.saveAll(users);
        };
    }

}
