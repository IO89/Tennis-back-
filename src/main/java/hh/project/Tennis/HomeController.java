package hh.project.Tennis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class HomeController {
    @Autowired
    PlayerRepository repository;

    //List all players
    @RequestMapping(value = "/")
    public String  index(Model model){
        List<Player> playerList = new ArrayList<>();
        model.addAttribute("playerlist",repository.findAll());
        return "index";
    }

}
