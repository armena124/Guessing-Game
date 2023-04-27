import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class third extends JFrame
{
    public static void main(String[] args)
    {
        Themain();
    }

    public static void Themain()
    {
        JFrame screen = new JFrame("Menu");
        screen.setSize(600, 500);
        screen.setBackground(new Color(128, 128, 255));
       
        JLabel prompt = new JLabel("Welcome to the guessing game! Click instructions to learn how to play.");
        prompt.setBounds(110, 50, 400, 50);
        screen.add(prompt);

        JButton play_game = new JButton("Play game");
        play_game.setBounds(190, 100, 250, 30);
        screen.add(play_game);
        play_game.addActionListener(new ActionListener()

        {
            public void actionPerformed(ActionEvent e)
            {
                screen.dispose();
                gameScreen();
            }
        });

        JButton Exit = new JButton("Exit");
        Exit.setBounds(190, 200, 250, 30);
        screen.add(Exit);

        Exit.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                screen.dispose();
            }
        });

        screen.setLayout(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setVisible(true);

        JButton instructions = new JButton("Instructions");
        instructions.setBounds(190, 150, 250, 30);
        screen.add(instructions);

        instructions.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                screen.dispose();
                instruction_screen();
            }
        });
    }
    
    public static void instruction_screen()
    {
        JFrame instr = new JFrame("Instructions");
        instr.setSize(400,400);

        JButton goBack = new JButton("Go back");
        goBack.setBounds(120,150,150,20);
        instr.add(goBack);
        goBack.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                instr.dispose();
                Themain();
            }
        });

        JLabel instructions = new JLabel("Guess the number i'm thinking of (1-100)");
        instructions.setBounds(75, 100, 300, 50);
        instr.add(instructions);

         

        instr.setLayout(null);
        instr.setResizable(false);
        instr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instr.setVisible(true);

    
    }
    public static void gameScreen()
    {
        JFrame game = new JFrame("Playing");
        game.setSize(400,400);
        JLabel range = new JLabel("Invalid or out of range");
        range.setBounds(450, 250, 100, 25);
        
                
        game.add(range);
        range.setVisible(false);

        JLabel correct = new JLabel("Correct");
        correct.setBounds(180, 180, 70, 25);
                
        game.add(correct);
        correct.setVisible(false);

        JLabel too_high = new JLabel("too high");
        too_high.setBounds(180, 180, 70, 25);

        
        game.add(too_high);
        too_high.setVisible(false);

        JLabel too_low = new JLabel("too low");
        too_low.setBounds (180, 180, 70, 25);
        
        game.add(too_low);
        too_low.setVisible(false);

        JLabel notInt = new JLabel("Not an integer");
        notInt.setBounds(165, 180, 100, 25);

        game.add(notInt);
        notInt.setVisible(false);
        JButton goBack = new JButton("Return to Main Menu");
        goBack.setBounds(125,220,150,20);
        goBack.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                game.dispose();
                Themain();
            }
        });

        JLabel prompt = new JLabel("Guess my number :)");
        prompt.setBounds(150, 50, 300, 50);
        game.add(prompt);

        JTextField input = new JTextField();
        input.setBounds(100, 100, 200, 25);
        game.add(input);
        
        JButton verify = new JButton("Enter");
        verify.setBounds(170, 135, 70, 25);
        verify.addActionListener(new ActionListener()

        
        {
        public void actionPerformed(ActionEvent e)
            {

                String guess = input.getText();
                try
                { 
    
                    int finalGuess = Integer.parseInt(guess);
                    if(finalGuess < 1 || finalGuess > 100)
                    {
                        range.setVisible(true);
                        correct.setVisible(false);
                        too_high.setVisible(false);
                        too_low.setVisible(false);
                        notInt.setVisible(false);
                    }

                    else if(finalGuess == 55)

                    {
                        range.setVisible(false);
                        correct.setVisible(true);
                        too_high.setVisible(false);
                        too_low.setVisible(false);
                        notInt.setVisible(false);
                    }

                    else if(finalGuess > 55){
                        range.setVisible(false);
                        correct.setVisible(false);
                        too_high.setVisible(true);
                        too_low.setVisible(false);
                        notInt.setVisible(false);
                    }

                    else

                    {
                       range.setVisible(false);
                       correct.setVisible(false);
                       too_high.setVisible(false);
                       too_low.setVisible(true);
                       notInt.setVisible(false);
                    }

                }

                catch(NumberFormatException err){
                    range.setVisible(false);
                    too_high.setVisible(false);
                    too_low.setVisible(false);
                    notInt.setVisible(true);
                }

                finally{
                    game.revalidate();
                    game.repaint();
                }
            }
        });



        game.add(verify);

        game.add(goBack);
        game.setLayout(null);
        game.setResizable(false);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
    
}
