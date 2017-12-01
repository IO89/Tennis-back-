package hh.project.Tennis.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class DataBaseLoader implements CommandLineRunner {

    private final PlayerRepository repository;
    @Autowired
    public DataBaseLoader(PlayerRepository repository){
        this.repository=repository;
    }
    @Override
    public void run(String... strings) throws Exception{

        this.repository.save(new Player("Anna","Bibilashvili","Clay",45));
        this.repository.save(new Player("Maria","Loktionova","Hard",34));
        this.repository.save(new Player("Ivan","Osipov","Hard(i)",7));
        this.repository.save(new Player("Pablo","Barquero","Clay",17));
    }


}
