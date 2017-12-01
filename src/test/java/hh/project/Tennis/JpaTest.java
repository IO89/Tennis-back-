package hh.project.Tennis;
import hh.project.Tennis.domain.Player;
import hh.project.Tennis.domain.User;
import hh.project.Tennis.domain.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaTest {

    @Autowired
    private PlayerRepository repository;


    @Test
    public void findByFirstNameShouldreturnPlayer() {
        List<Player> testPlayers = repository.findByFirstName("Pasha");
        assertThat(testPlayers).hasSize(1);
        assertThat(testPlayers.get(0).getFirstName()).isEqualTo("Pasha");
    }

    @Test
    public void createNewPlayer() {
        Player player = new Player("Arthur", "Eld","Clay",10);
        repository.save(player);
        assertThat(player.getId()).isNotNull();
    }
    @Test
    public void deletePlayer(){
        List<Player> testPlayer = repository.findByFirstName("Pasha");
        repository.delete(testPlayer.get(0));
        assertThat(repository.findByFirstName("Pasha")).hasSize(0);

    }
    @Test
    public void searchPlayer(){
        List<Player> testPlayer = repository.findByFirstName("Pasha");
        repository.findByFirstName("Pasha");
        assertThat(testPlayer).hasSize(1);
    }

}
