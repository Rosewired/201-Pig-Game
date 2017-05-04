public class WatchOpponentPlayer extends PigPlayer {
  private int holdValue, reasonable, number;
  
  /* A 'number' value of 1 means that the difference between scores will always be
   * returned. Then, a 'reasonable' value of 1 results in a hold value that is always
   * 1 more than the difference between values. */
  
  // Default constructor.
  public WatchOpponentPlayer() {
    super("User");
    holdValue = 24;
    reasonable = 1;
    number = 1;
  }
  
//Constructor for the name of the player.  
  public WatchOpponentPlayer(String playerName) {
    super(playerName);
    holdValue = 24;
    reasonable = 1;
    number = 1;
  }
  
// Constructor for the name of the player and the hold number.  
  public WatchOpponentPlayer(String playerName, int holdNumber) {
    super(playerName);
    holdValue = holdNumber;
    reasonable = 1;
    number = 1;
  }
  
  public boolean isRolling(int turnTotal, int opponentScore) {
    int currentScore = super.getScore();
    if (currentScore >= opponentScore) {
      holdValue = 24;
    }
    else {
      if (opponentScore >= 85) {
        holdValue = 100;
      }
      else {
        holdValue = reasonable + ((opponentScore - currentScore)*1)/number;
      }
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