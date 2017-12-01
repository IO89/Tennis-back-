package hh.project.Tennis;

import hh.project.Tennis.domain.Player;
import hh.project.Tennis.domain.PlayerRepository;
import hh.project.Tennis.domain.User;
import hh.project.Tennis.domain.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TennisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TennisApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PlayerRepository repository, UserRepository userRepository) {
        return (args) -> {
            User user1 = new User("user", "$2a$06$1kpjLI1hyCZgurfQJjchV.fvwKCd4lpvAMxRA784YgG19dofbD.aC", "USER");
            User user2 = new User("admin", "$2a$06$prcCYpL64wteme13b8CApuS.LHha1rIuKLroXyvNMEXi636cNSPw.", "ADMIN");
            userRepository.save(user1);
            userRepository.save(user2);

            repository.save(new Player("Eduardo","Cortizo","Hard",68));
            repository.save(new Player("Pasha","Zabelin","Hard(i)",56));



            for (User user : userRepository.findAll()) {
                System.out.println(user.toString());
            }
        };
    }
}