import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame  implements ActionListener {
    //player buttons
    JButton rockButton, paperButton, scissorButton;

    JLabel computerChoice;

    JLabel computerScoreLabel, playerScoreLabel;

    RockPaperScissor rockPaperScissor;

    public GameGUI() {
        //title to the GUI
        super("Rock Paper Scissors");

        //size of the GUI
        setSize(500, 580);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //centers the GUI when loaded
        setLocationRelativeTo(null);

        rockPaperScissor = new RockPaperScissor();

        //adds GUI components
        addGuiComponents();
    }

    private void addGuiComponents() {
        //AI score card
        computerScoreLabel = new JLabel("Computer: 0");

        computerScoreLabel.setBounds(0, 43, 450, 30);

        //place the text in the center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add to GUI
        add(computerScoreLabel);

        //shows computers choice
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 118, 98, 81);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 10));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //black border
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        //player scorecard
        playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0, 317, 450, 30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //player buttons

        //rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener(this);
        add(rockButton);

        //paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165, 387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        paperButton.addActionListener(this);
        add(paperButton);

        //scissors button
        scissorButton = new JButton("Scissors");
        scissorButton.setBounds(290, 387, 105, 81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        scissorButton.addActionListener(this);
        add(scissorButton);


    }

    private void  showDialog(String message){
        JDialog resultDialog = new JDialog(this, "Result", true);
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        //message lable
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel,BorderLayout.CENTER);

        //try again button
        JButton tryAgainButton = new JButton("Try Again");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reset computer choice
                computerChoice.setText("?");

                resultDialog.dispose();

            }
        });
        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //get players choice
        String playerChoice = e.getActionCommand().toString();

        String result = rockPaperScissor.playRockPaperScissor(playerChoice);

        computerChoice.setText(rockPaperScissor.getComputerChoice());

        computerScoreLabel.setText("Computer:" + rockPaperScissor.getComputerChoice());
        playerScoreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());

        showDialog(result);


    }
}
