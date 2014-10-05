// A game of rock, paper, scissors
// CIS163AA 27873
// Author: Matthew Self
// Sept. 25, 2014
// Unsolicited commentary: This was MUCH, MUCH, MUCH more difficult than I ever
// anticipated!


// Imported the swing.JOptionPane class to provide for dialog boxes, rather than require
// the user to interact in the terminal. Also called up the Random class to generate the
// pseudorandom options for the computer opponent.

import javax.swing.JOptionPane;
import java.util.Random;

public class RockPaperScissors 
{
    public static void main(String[] args)


// This section creates the initial dialog boxes to begin interaction with the user. 
// It also sets up the initial dialog from the computer opponent.

    {
        String computerSide,
               userSide;

        JOptionPane.showMessageDialog(null, "Want to play a game of \"Rock, Paper, Scissors?\"");
        
        computerSide = ComputerChoice();
        userSide = UserChoice();
        
        if (userSide != null)
        {
            JOptionPane.showMessageDialog(null, "Your opponent chooses " + computerSide + ".");
            
            Winner(computerSide, userSide);
        }
        
        else
            JOptionPane.showMessageDialog(null, "Oops! I didn't understand your entry. Please enter " + 
                                        " 'rock', 'paper', or 'scissors'.");
    }
    
// This array assigns the computer options for output based in the generated choices.
// Chose to use the 'switch' statement with 'byte' data tap rather than a longer series
// of 'if-then' statements. Earlier version attempted to use 'boolean' class, but realized
// it was bad logic, since there are three choices isn't a true-or-false question.

    public static String ComputerChoice()
    {
        byte computerChoice;
        
        String computerChoiceString = "";
        
        Random choiceGenerator = new Random();
        
        computerChoice = (byte)(choiceGenerator.nextInt(3) + 1);
        
        switch (computerChoice)
        {
        
            case 1:
            {
                computerChoiceString = "rock";
                break;
            }
        
            case 2:
            {
                computerChoiceString = "paper";
                break;
            }
        
            case 3:
            {
                computerChoiceString = "scissors";
                break;
            }
        
        }
        
        return computerChoiceString;
    }
    
 // This section transitions the game to the user, giving the user the three options from
 // which to choose.
 
    public static String UserChoice()
    {
        String userChoice,
               userChoiceLowerCase;
        
        userChoice =
                JOptionPane.showInputDialog("Rock, paper, or scissors? What is your choice?");
        
        if (userChoice.equalsIgnoreCase("rock") || userChoice.equalsIgnoreCase("paper")
                || userChoice.equalsIgnoreCase("scissors"))
        {
            userChoiceLowerCase = userChoice.toLowerCase();
        }
        
        else
            userChoiceLowerCase = null;
        
        return userChoiceLowerCase;
    }
    
// This section computes the results of the game and presents them to the user in dialog
// boxes.

    public static void Winner(String computerSide, String userSide)
    {
        
        if (computerSide.equals(userSide))
            JOptionPane.showMessageDialog(null, "Kiss your sister, it's a tie! We need to play again.");
        
        else if (computerSide.equalsIgnoreCase("rock") && userSide.equalsIgnoreCase("paper"))
            JOptionPane.showMessageDialog(null, "Paper covers rock. You win!");
        
        else if (computerSide.equalsIgnoreCase("rock") && userSide.equalsIgnoreCase("scissors"))
            JOptionPane.showMessageDialog(null, "Rock crushes scissors. You lose!");
        
        else if (computerSide.equalsIgnoreCase("paper") && userSide.equalsIgnoreCase("rock"))
            JOptionPane.showMessageDialog(null, "Paper covers rock. You lose!");
        
        else if (computerSide.equalsIgnoreCase("paper") && userSide.equalsIgnoreCase("scissors"))
            JOptionPane.showMessageDialog(null, "Scissors cuts paper. You win!");
        
        else if (computerSide.equalsIgnoreCase("scissors") && userSide.equalsIgnoreCase("rock"))
            JOptionPane.showMessageDialog(null, "Rock crushes scissors. You win!");
        
        else
            JOptionPane.showMessageDialog(null, "You lose. Scissors cuts paper.");
    }
}
