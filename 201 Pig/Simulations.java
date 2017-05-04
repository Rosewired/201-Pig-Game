public class Simulations {
  
  private static double gamesWon1, gamesWon2, gamesWon1Total, gamesWon2Total;
  
  public Simulations() {
    gamesWon1 = 0;
    gamesWon2 = 0;
    gamesWon1Total = 0;
    gamesWon2Total = 0;
  }
  
  public static void firstAdvantage(long simulations) {
    PigPlayer player1 = new SimpleHoldPlayer();
    PigPlayer player2 = new SimpleHoldPlayer();
    PigGame game = new PigGame(player1,player2);
    game.setVerbose(false);
    for(int games = 0; games < simulations; games++) {
      game.playGame();
      if (player1.getScore() >= 100) {
        gamesWon1 = gamesWon1 + 1;
      }
      if (player2.getScore() >= 100) {
        gamesWon2 = gamesWon2 + 1;
      }
      game.reset();
      /* Advantage: from 100,000 tests, Player1 wins approximately 55% of the games, 
       * and Player2 wins 45% of the games. Therefore, whoever has the first turn
       * (with a hold value of 20) appears to have the advantage. */
    }
  }
  
  public static double comparePlayers(long simulations, PigPlayer first, PigPlayer second) {
    PigPlayer player1 = first;
    PigPlayer player2 = second;
    PigGame game = new PigGame(player1,player2);
    game.setVerbose(false);
    for(int games = 0; games < (simulations/2); games++) {
      first = player1;
      second = player2;
      game.playGame();
      if (first.getScore() >= 100) {
        gamesWon1 = gamesWon1 + 1;
      }
      if (second.getScore() >= 100) {
        gamesWon2 = gamesWon2 + 1;
      }
      gamesWon1Total = gamesWon1;
      gamesWon2Total = gamesWon2;
      game.reset();
    }
    for(int games = 0; games < simulations-(simulations/2); games++) {
      first = player2;
      second = player1;
      game.playGame();
      if (first.getScore() >= 100) {
        gamesWon1 = gamesWon1 + 1;
      }
      if (second.getScore() >= 100) {
        gamesWon2 = gamesWon2 + 1;
      }
      gamesWon1Total = gamesWon1Total + gamesWon1;
      gamesWon2Total = gamesWon2Total + gamesWon2;
      game.reset();
    }
    return gamesWon1Total;
    /* 20 vs. 15 = In favor of 20 (slight).
     20 vs. 25 = In favor of 20 (slight).
     20 vs. 21 = In favor of 21.
     21 vs. 22 = In favor of 22.
     22 vs. 23 = In favor of 23.
     23 vs. 24 = In favor of 24.
     24 vs. 25 = In favor of 24.
     Best hold value = 24.
     */
  }
  
  public static void main(String[] args) {
    Simulations sim1 = new Simulations();
    
    // First advantage simulation.
    /*sim1.firstAdvantage(1);
     double gamesTotal = gamesWon1 + gamesWon2;
     double player1Percent = (gamesWon1/gamesTotal)*100;
     double player2Percent = (gamesWon2/gamesTotal)*100;
     System.out.println("Player1 = " + player1Percent + "%");
     System.out.println("Player2 = " + player2Percent + "%"); */
    
    // Simulation to test ideal hold value.
    /*PigPlayer first = new SimpleHoldPlayer("comp1",23);
     PigPlayer second = new SimpleHoldPlayer("comp2",24);
     sim1.comparePlayers(10, first, second);
     double gamesTotal = gamesWon1 + gamesWon2;
     System.out.println(gamesWon1/gamesTotal); */
    
    // Simulation that tests SimpleHoldPlayer against FourTurnsPlayer.
    /*PigPlayer first = new SimpleHoldPlayer("comp1",24);
     PigPlayer second = new FourTurnsPlayer("comp2");
     sim1.comparePlayers(10000,first,second);
     System.out.println(gamesWon1);
     System.out.println(gamesWon2); */
    
    // Simulation that tests SimpleHoldPlayer against WatchOpponentPlayer.
    /*PigPlayer first = new SimpleHoldPlayer("comp1",24);
     PigPlayer second = new WatchOpponentPlayer("comp2");
     sim1.comparePlayers(10000,first,second);
     System.out.println(gamesWon1);
     System.out.println(gamesWon2);*/
    
    // Simulation that tests SimpleHoldPlayer against StrategicPlayer.
    /*PigPlayer first = new SimpleHoldPlayer("comp1",24);
    PigPlayer second = new StrategicPlayer("comp2");
    sim1.comparePlayers(10000,first,second);
    System.out.println(gamesWon1);
    System.out.println(gamesWon2);*/
    
    // Simulation that tests StrategicPlayer against WatchOpponentPlayer.
    /*PigPlayer first = new StrategicPlayer("comp1");
    PigPlayer second = new WatchOpponentPlayer("comp2");
    sim1.comparePlayers(10000,first,second);
    System.out.println(gamesWon1);
    System.out.println(gamesWon2);*/
    
        // Simulation that tests StrategicPlayer against FourTurnsPlayer.
    /*PigPlayer first = new StrategicPlayer("comp1");
    PigPlayer second = new FourTurnsPlayer("comp2");
    sim1.comparePlayers(10000,first,second);
    System.out.println(gamesWon1);
    System.out.println(gamesWon2); */
    
    FourTurnsPlayer four = new FourTurnsPlayer("watcher");
    SimpleHoldPlayer holder = new SimpleHoldPlayer("best hold", 18);
    sim1.comparePlayers(2, four, holder);
  }
  } 