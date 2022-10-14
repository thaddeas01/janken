package oit.is.z0553.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0553.kaizi.janken.model.Janken;
import oit.is.z0553.kaizi.janken.model.Entry;

import java.util.Random;
import java.util.ArrayList;

@Controller
public class JankenController {
  @Autowired
  private Entry entry;

  @GetMapping("/janken")
  public String janken(ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    this.entry.addUser(loginUser);
    model.addAttribute("entry", this.entry);
    model.addAttribute("login_user", loginUser);
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
    model.addAttribute("me", param1);
    model.addAttribute("enemy", comphand);
    model.addAttribute("result", janken.getresult());
    return "janken.html";
  }
}
