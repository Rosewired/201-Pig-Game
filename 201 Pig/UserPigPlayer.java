import java.util.Scanner;
public class UserPigPlayer extends PigPlayer {
  
  
// Default constructor for the name String.
  public UserPigPlayer() {
    super("User");
  }
  
  public UserPigPlayer(String playerName) {
    super(playerName);
  }
  
// Prints out the turn and prompts the user if they want to roll or hold.
  public boolean isRolling(int turnTotal, int opponentScore) {
    Scanner keyboard = new Scanner(System.in);
    String response = keyboard.nextLine();
    if (response.equals("")) {
      return true;
    }
    else {
      return false;
    }
  }
  
  // Main method
  public static void main(String[] args) {
    UserPigPlayer player1 = new UserPigPlayer();
    System.out.println(player1.isRolling(0,0));
  }
}