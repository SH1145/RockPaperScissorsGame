import java.util.Random;

public class RockPaperScissor {
    //computer choices
    private static final String[] computerChoices = {"Rock", "Paper", "Scissors"};

    //store computer choices
    private String computerChoice;

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    //stores the scores
    private int computerScore, playerScore;

    //random number generator
    private Random random;

    //constructor
    public RockPaperScissor() {
        random = new Random();
    }

    public String playRockPaperScissor(String playerChoice) {
        //generate computer choices
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        //returning message of results
        String result;

        //evaluate the winner
        if(computerChoice.equals("Rock")) {
            if(playerChoice.equals("Paper")) {
                result = "Player wins!";
                playerScore++;
            }else if(playerChoice.equals("Scissors")) {
                result = "Computer wins!";
                computerScore++;
            }else {
                result = "Draw";
            }
        }else if(computerChoice.equals("paper")) {
            if(playerChoice.equals("Scissors")) {
                result = "Player wins!";
                playerScore++;
            }else if(playerChoice.equals("Rock")) {
                result = "Computer wins!";
                computerScore++;
            }else {
                result = "Draw";
            }
        }else{
            //computer chooses scissors
            if(playerChoice.equals("Rock")) {
                result = "Player wins!";
                playerScore++;
            }else if(playerChoice.equals("Paper")) {
                result = "Computer wins!";
                computerScore++;
            }else {
                result = "Draw";
            }
        }

        return result;
    }
}
