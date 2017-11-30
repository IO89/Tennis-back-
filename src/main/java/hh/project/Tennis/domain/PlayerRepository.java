package hh.project.Tennis.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    public List<Player>OrderByPointsDesc();
    Player findPlayerByFirstName(String firstName);

}
