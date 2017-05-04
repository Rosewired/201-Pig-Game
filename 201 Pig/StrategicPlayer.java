/* Strategic player starts strong, rolling until it reaches 25 to give itself a 
 * strong advantage. Then, once it has reached 50 points with said advantage,
 * it begins to play more carefully, instead holding at 10. */

public class StrategicPlayer extends PigPlayer {
  private int holdValue;
  
    // Default constructor.
  public StrategicPlayer() {
    super("User");
    holdValue = 24;
  }
  
//Constructor for the name of the player.  
  public StrategicPlayer(String playerName) {
    super(playerName);
    holdValue = 24;
  }
  
// Constructor for the name of the player and the hold number.  
  public StrategicPlayer(String playerName, int holdNumber) {
    super(playerName);
    holdValue = holdNumber;
  }
  
  // Checks to see if the die should be rolled by checking whether or not
// the game is won, and whether or not the turnTotal is less than 20.
  public boolean isRolling(int turnTotal, int opponentScore) {
    int currentScore = super.getScore();
    if (currentScore > 50) {
    holdValue = 25;
    }
    else {
      holdValue = 10;
    }
    if (currentScore < PigGame.GOAL && turnTotal < holdValue
          && (currentScore + turnTotal) < PigGame.GOAL) {
      return true;
    }
    else {
      return false;
    }
  }
}