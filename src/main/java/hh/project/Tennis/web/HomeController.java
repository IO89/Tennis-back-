package hh.project.Tennis.web;

import hh.project.Tennis.domain.Player;
import hh.project.Tennis.domain.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Controller

public class HomeController {

    @Autowired
    PlayerRepository repository;

    public void doSomething() {
    }

    //List all players
    @RequestMapping(value = "/playerslist")
    public String index(Model model) {
        List<Player> playerList = new ArrayList<>();
        model.addAttribute("playerlist", repository.OrderByPointsDesc());
        return "playerslist";
    }

    //Add player(reuquire role admin)
    @RequestMapping(value = "/addplayer")
    public String addPlayer(Model model) {
        model.addAttribute("player", new Player());
        return "addplayer";
    }

    //Save inputted data
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePlayer(Player player) {
        repository.save(player);
        return "redirect:playerslist";
    }

    //delete player needs admin role for this action(Check naming of Id)
    @RequestMapping(value = "/delete/{Id}", method = RequestMethod.GET)
    public String deletePlayer(@PathVariable("Id") Long Id, Model model) {
        repository.delete(Id);
        System.out.println("delete " + Id);
        return "redirect:../playerslist";
    }

    //Edit info for players think about what roles are able to do it
    @RequestMapping(value = "/edit/{Id}", method = RequestMethod.GET)
    public String editPlayer(@PathVariable("Id") Long Id, Model model) {
        model.addAttribute("player", repository.findOne(Id));
        return "editplayer";
    }
/*    //Select random opponent
    @RequestMapping (value ="/randomplayer/{Id}",method = RequestMethod.GET)
    public String randomPlayer(@PathVariable Long Id,Model model){
        int size = (int) repository.count();
        Long randomValue=ThreadLocalRandom.current().nextLong(size);
        model.addAttribute("player",repository.findOne(randomValue));
        return "randomplayer";
    }*/

    //Restful service?
    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public @ResponseBody
    List<Player> playerListREST() {
        return (List<Player>) repository.findAll();
    }

    @RequestMapping(value = "player/{Id}", method = RequestMethod.GET)
    public @ResponseBody
    Player findPlayerREST(@PathVariable("Id") Long Id) {
        return repository.findOne(Id);
    }

    //Adiing Login to Controller
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

}
