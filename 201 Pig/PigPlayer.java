public abstract class PigPlayer{
  private String name;
  private int currentScore, winningGames;
  
// Default constructor for name String.
  public PigPlayer() {
    this.setName("Name");
    currentScore = 0;
    winningGames = 0;
  }
  
  // Constructor that takes a String.
  public PigPlayer(String playerName) {
   name = playerName;
    currentScore = 0;
    winningGames = 0;
  }
  
// Sets the name as a String.
  public void setName(String playerName) {
    name = playerName;
  }
  
// Gets the name as a String.  
  public String getName() {
    return name;
  }
  
// Resets the game, setting the score to 0.
  public void reset() {
    currentScore = 0;
  }
  
// Adds the turn total to the player's score. If the score reaches the goal, 
// it adds 1 to the winning games total. 
  public void addPoints(int turnTotal) {
    currentScore = currentScore + turnTotal;
      if (this.getScore() >= PigGame.GOAL) {
    winningGames = winningGames + 1;
  }
  }
  
// Returns true if the player has reached 'goal'.  
  public boolean won() {
  if (this.getScore() >= PigGame.GOAL) {
    return true;
  }
  else {
    return false;
  }
}
  
// Gets the player's current score.  
  public int getScore() {
    return currentScore;
  }
 
// Gets the number of games the player has currently won.  
  public int getWinRecord() {
    return winningGames;
  }
  
// Converts the player's name and score to a String.
  public String toString() {
    return "Name: " + name + ", Score: " + currentScore;
}
  
// Abstract isRolling method.
  public abstract boolean isRolling(int turnTotal, int opponentScore);
  
// Main method.  
 public static void main(String[] args) {
    /*PigPlayer player = new PigPlayer();
    System.out.println(player.getName());
    player.setName("Bob");
    System.out.println(player.getName());
    player.addPoints(50);
    System.out.println(player.getScore());
    System.out.println(player.won());
    System.out.println(player.getWinRecord());
    System.out.println(player);
  } */
  
      UserPigPlayer person = new UserPigPlayer("user");
    person.addPoints(20);
    System.out.println(person.getWinRecord());
    person.addPoints(102);
    System.out.println(person.getWinRecord());
    person.reset();
    System.out.println(person.getWinRecord());
    person.addPoints(85);
    person.addPoints(35);
    System.out.println(person.getWinRecord());
}
}