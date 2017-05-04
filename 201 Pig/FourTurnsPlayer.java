public class FourTurnsPlayer extends PigPlayer {
  
  private int turnWithoutZero, holdValue;
  
  // Default constructor.
  public FourTurnsPlayer() {
    super("User");
    turnWithoutZero = 0;
    holdValue = PigGame.GOAL/4;
  }
  
//Constructor for the name of the player.  
  public FourTurnsPlayer(String playerName) {
    super(playerName);
    turnWithoutZero = 0;
    holdValue = PigGame.GOAL/4;
  }
  
// Constructor for the name of the player and the hold number.  
  public FourTurnsPlayer(String playerName, int holdNumber) {
    super(playerName);
    turnWithoutZero = 0;
    holdValue = holdNumber;
  }
  
  // Checks to see if the die should be rolled by checking whether or not
// the game is won, and whether or not the turnTotal is less than 20.
  public boolean isRolling(int turnTotal, int opponentScore) {
    int currentScore = super.getScore();
    if (turnWithoutZero == 4) {
      holdValue = 25;
    }
    else {
      holdValue = (PigGame.GOAL - currentScore) / (4-turnWithoutZero);
    }
    if (currentScore < PigGame.GOAL && turnTotal < holdValue
          && (currentScore + turnTotal) < PigGame.GOAL) {
      return true;
    }
    else {
      if (turnTotal > 0 ) {
        turnWithoutZero = turnWithoutZero + 1;
      }
      return false;
    }
  }
}