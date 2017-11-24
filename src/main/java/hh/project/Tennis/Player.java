package hh.project.Tennis;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Player {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String surface;
    private int points;


    /*
    Maybe more fields like court, or smth
    @Data helps with getter and setters, generates it automatically
    */

    private Player(){}

    public Player(String firstName, String lastName,String surface, int points) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surface = surface;
        this.points = points;
    }
}
