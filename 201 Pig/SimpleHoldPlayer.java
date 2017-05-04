public class SimpleHoldPlayer extends PigPlayer {
  private int holdValue;
  
// Default constructor.
  public SimpleHoldPlayer() {
    super("User");
    holdValue = 20;
  }
  
//Constructor for the name of the player.  
  public SimpleHoldPlayer(String playerName) {
    super(playerName);
    holdValue = 20;
  }
  
// Constructor for the name of the player and the hold number.  
  public SimpleHoldPlayer(String playerName, int holdNumber) {
    super(playerName);
    holdValue = holdNumber;
  }
  
// Checks to see if the die should be rolled by checking whether or not
// the game is won, and whether or not the turnTotal is less than 20.
  public boolean isRolling(int turnTotal, int opponentScore) {
    int currentScore = super.getScore();
    if (currentScore != PigGame.GOAL && opponentScore != PigGame.GOAL && turnTotal < holdValue
       && (currentScore + turnTotal) < PigGame.GOAL) {
      return true;
    }
    else {
      return false;
    }
  }
  
// Main method.  
  public static void main(String[] args) {
    SimpleHoldPlayer holdPlayer = new SimpleHoldPlayer();
    System.out.println(holdPlayer.isRolling(10,100));
    System.out.println(holdPlayer.isRolling(10,10));
    System.out.println(holdPlayer.isRolling(20,10));
  }
}