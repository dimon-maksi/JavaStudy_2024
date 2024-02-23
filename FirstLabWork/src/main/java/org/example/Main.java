package org.example;
public class Main {

    public static void main(String[] args) {
        Card myCard = new Card();
        Initialization init = new Initialization();
        init.InitProducts();
        UserInterface user = new UserInterface();
        user.Start();
  }
}

