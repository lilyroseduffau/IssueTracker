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

            User user1 = new User(1L, "Machin", Fonction.USER);
            User user2 = new User(2L, "Chose", Fonction.DEVELOPPER);
            User user3 = new User(3L, "Truc", Fonction.USER);

            new ArrayList<>() {
                {
                    add(user1);
                    add(user2);
                    add(user3);

                }
            };
        };
    }
}




