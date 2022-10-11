package oit.is.z0553.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0553.kaizi.janken.controller.model.Janken;

import java.util.Random;
import java.util.ArrayList;

@Controller
public class JankenController {

  @PostMapping("/janken")
  public String janken(@RequestParam String name, ModelMap model) {
    String id = name;
    model.addAttribute("name", id);
    return "janken.html";
  }

  @GetMapping("/janken")
  public String janken() {
    return "janken.html";
  }

  @GetMapping("/jankengame")
  public String jankengame(@RequestParam String param1, ModelMap model) {
    Random rand = new Random();
    ArrayList<String> handlist = new ArrayList<>();
    handlist.add("gu");
    handlist.add("pa");
    handlist.add("choki");
    String myhand = param1;
    String comphand = handlist.get(rand.nextInt(3));
    Janken janken = new Janken(myhand, comphand);
    model.addAttribute("me", myhand);
    model.addAttribute("enemy", comphand);
    model.addAttribute("result", janken.getresult());
    return "janken.html";
  }
}
