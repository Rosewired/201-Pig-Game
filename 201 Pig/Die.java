public class Die {
  private int sides;
  
// Default constructor for the number of sides.  
  public Die() {
    this.setSides(6);
  }
  
// Sets the sides of the die. 
  public void setSides (int numberofSides) {
    if (numberofSides > 0) {
   sides = numberofSides; 
    }
  } 

// Gets the sides of the die.
  public int getSides() {
    return sides;
  }
  
// Static roll method: produces a number between 1 and 6.  
  public static int roll() {
    double roll = Math.random()*(6) + 1;
    return (int)roll;
  }

// Non-static roll method: works for more sides than 6.  
  public int rollDie() {
    double roll = Math.random()*(sides) + 1;
    return (int)roll;
  }
  
// Main method.
  public static void main(String[] args) {
    Die die = new Die();
    die.setSides(8);
    System.out.println(die.rollDie());
  }
}
  