package oit.is.z0553.kaizi.janken.controller.model;

import java.util.ArrayList;

public class Janken {
  String result;

  public Janken(String me, String comp) {
    String result;
    if (me.equals("gu") && comp.equals("gu") || me.equals("pa") && comp.equals("pa") || me.equals("choki") && comp
        .equals("choki")) {
      this.result = "Tie";
      result = this.result;
    } else if (me.equals("gu") && comp.equals("pa") || me.equals("pa") && comp.equals("choki")
        || me.equals("choki") && comp
            .equals("gu")) {
      this.result = "You Lose!";
      result = this.result;
    } else if ((me.equals("gu") && comp.equals("choki") || me.equals("pa") && comp.equals("gu")
        || me.equals("choki") && comp
            .equals("pa"))) {
      this.result = "You Win!";
      result = this.result;
    }
  }

  public String getresult() {
    return result;
  }

  public void setresult(String result) {
    this.result = result;
  }
}
