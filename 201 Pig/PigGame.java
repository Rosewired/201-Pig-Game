import java.util.Scanner;
public class PigGame{
  
  public static final int GOAL = 100;
  private PigPlayer player1, player2;
  public static boolean verbose;
  
  // Constructor that creates two UserPigPlayers.
  public PigGame() {
    player1 = new UserPigPlayer();
    player2 = new UserPigPlayer();
  }
  
  // Constructor that creates two UserPigPlayers and names them using parameters.
  public PigGame(String player1Name, String player2Name) {
    this();
    player1.setName(player1Name);
    player2.setName(player2Name);
  }
  
// Constructor that takes two PigPlayers.
  public PigGame(PigPlayer playerOne, PigPlayer playerTwo) {
    this();
    player1 = playerOne;
    player2 = playerTwo;
    player1.setName(player1.getName());
    player2.setName(player2.getName());
  }
  
  // Resets the two UserPigPlayers.
  public void reset() {
    player1.reset();
    player2.reset();
  }
  
  // Sets verbose.
  public void setVerbose(boolean text) {
    verbose = text;
  }
  
  // Method for playing a turn.
  public int playTurn(PigPlayer player, PigPlayer opponent) {
    int turnTotal = 0;
    Die die = new Die();
    String playerName = player.getName();
    String opponentName = opponent.getName();
    do {
      if (verbose) {
        System.out.println(playerName + "'s turn.");
      }
      int roll = die.rollDie();
      
      if (roll > 1) {
        if (verbose) {
          System.out.println(playerName + "'s Score = " + player.getScore());
          System.out.println(opponentName + "'s Score = " + opponent.getScore());
          System.out.println("You rolled " + roll + ".");
          System.out.println("The current turn total for " + playerName + " is: " + turnTotal + ". Would you like to roll again? (enter for yes, anything else for no)");
        }
        turnTotal = turnTotal + roll;
      }
      else {
        if (verbose) {
          System.out.println("You rolled " + roll + ". Turn over! " + "Next turn!");
          System.out.println();
        }
        turnTotal = 0;
        break;
      }
    }
    while (player.isRolling(turnTotal,opponent.getScore()) == true && turnTotal != 0);
    return turnTotal;
  }
  
  // Method for playing a game, using playTurn.
  public void playGame() {
    int turnValue = 0;
    String player1Name = player1.getName();
    String player2Name = player2.getName();
    while (player1.won() == false && player2.won() == false) {
      turnValue = this.playTurn(player1,player2);
      player1.addPoints(turnValue);
      turnValue = 0;
      if (player1.won() == true) {
        break;
      }
      else {
      turnValue = this.playTurn(player2,player1);
      player2.addPoints(turnValue);
      turnValue = 0;
      }
    }
    
    if (player1.getScore() >= GOAL) {
      if (verbose) {
        System.out.println(" ");
        System.out.println(player1Name + " wins!");
        System.out.println(player1Name + "'s score = " + player1.getScore() + ".");
        System.out.println(player2Name + "'s score = " + player2.getScore() + ".");
      }
    }
    if (player2.getScore() >= GOAL) {
      if (verbose) {
        System.out.println(" ");
        System.out.println(player2Name + " wins!");
        System.out.println(player1Name + "'s score = " + player1.getScore() + ".");
        System.out.println(player2Name + "'s score = " + player2.getScore() + ".");
      }
    }
  }
  
// Method for initializing a game between two humans, using playGame.
  public void userVsUser() {
    PigPlayer firstPlayer = new UserPigPlayer(); 
    PigPlayer secondPlayer = new UserPigPlayer();
    System.out.println("The goal of Pig is to roll a six-sided die, adding points equal to the number you roll until you reach 100.");
    System.out.println("But beware...if you roll a 1, your turn total becomes 0 and it is the next player's turn!");
    System.out.println("You can choose to end your turn early, preserving your points and adding them to your overall score.  It is then the other player's turn.");
    System.out.println("First player to 100 points wins! When you reach a turn total that would win you the game, make sure to stop rolling in order to add these points to your overall score and register your win.");
    Scanner keyboard = new Scanner(System.in);
    System.out.println("What is the first player's name?");
    firstPlayer.setName(keyboard.nextLine()); 
    System.out.println("What is the second player's name?");
    secondPlayer.setName(keyboard.nextLine());
    double firstPlayerRoll = Math.random();
    double secondPlayerRoll = Math.random();
    if (firstPlayerRoll >= secondPlayerRoll) {
      player1 = firstPlayer; 
      player2 = secondPlayer;
    }
    else {
      player1 = secondPlayer;
      player2 = firstPlayer;
    }
    String player1Name = player1.getName();
    String player2Name = player2.getName();
    System.out.println(player1Name + " will go first.");
    PigGame game = new PigGame(player1, player2);
    game.setVerbose(true);
    game.playGame();
  }
  
// Method for initializing a game between a human and a computer, 
// using playGame.
  public void userVsComputer() {
    PigPlayer firstPlayer = new UserPigPlayer(); 
    PigPlayer secondPlayer = new WatchOpponentPlayer();
    System.out.println("The goal of Pig is to roll a six-sided die, adding points equal to the number you roll until you reach 100.");
    System.out.println("But beware...if you roll a 1, your turn total becomes 0 and it is the next player's turn!");
    System.out.println("You can choose to end your turn early, preserving your points and adding them to your overall score.  It is then the other player's turn.");
    System.out.println("First player to 100 points wins! When you reach a turn total that would win you the game, make sure to stop rolling in order to add these points to your overall score and register your win.");
    Scanner keyboard = new Scanner(System.in);
    System.out.println("What is the first player's name?");
    firstPlayer.setName(keyboard.nextLine());
    System.out.println("What is the second player's name?");
    secondPlayer.setName("Computer");
    System.out.println(secondPlayer.getName());
    double firstPlayerRoll = Math.random();
    double secondPlayerRoll = Math.random();
    if (firstPlayerRoll >= secondPlayerRoll) {
      player1 = firstPlayer;
      player2 = secondPlayer;
    }
    else {
      player1 = secondPlayer;
      player2 = firstPlayer;
    }
    String player1Name = player1.getName();
    String player2Name = player2.getName();
    System.out.println(player1Name + " will go first.");
    PigGame game = new PigGame(player1,player2);
    game.setVerbose(true);
    game.playGame();
  }
  
// Method for initializing a game between two computers, using playGame.
  public void computerVsComputer() {
    PigPlayer firstPlayer = new SimpleHoldPlayer(); 
    PigPlayer secondPlayer = new StrategicPlayer();
    firstPlayer.setName("Player 1");
    secondPlayer.setName("Player 2");
    double firstPlayerRoll = Math.random();
    double secondPlayerRoll = Math.random();
    if (firstPlayerRoll >= secondPlayerRoll) {
      player1 = firstPlayer;
      player2 = secondPlayer;
    }
    else {
      player1 = secondPlayer;
      player2 = firstPlayer;
    }
    String player1Name = player1.getName();
    String player2Name = player2.getName();
    PigGame game = new PigGame(player1, player2);
    game.setVerbose(true);
    game.playGame();
  }
  
// Main method.
  public static void main(String[] args) {
    //PigGame game = new PigGame();
    //game.computerVsComputer();
    
        PigGame game = new PigGame();
        int simulations = 1;
    SimpleHoldPlayer player = new SimpleHoldPlayer("player", 20);
    SimpleHoldPlayer other = new SimpleHoldPlayer("other", 10);
    for (int i=0; i<simulations; i++) {
      int total = game.playTurn(player, other);
    }
  }
}