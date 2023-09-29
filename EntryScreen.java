//import javax.print.attribute.standard.JobKOctetsSupported;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryScreen implements ActionListener
{
    DatabaseConnector database;
    JFrame frame;
    JPanel panel;
    JLabel label;
    JTextField iDText;
    JButton button;
    boolean startGame;
    int gameState;
    int iD;
    int equipID;
    String codeName;


    EntryScreen()
    {
        gameState = 0;
        startGame = false;
        database = new DatabaseConnector();
        frame = new JFrame();
        panel = new JPanel();
        // frame.setSize(500, 500);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setVisible(true);
        // frame.add(panel);
        label = new JLabel("ID");
        // label.setBounds(10,20,80,25);
        // panel.add(label);
        iDText = new JTextField();
        // iDText.setBounds(100, 20, 165, 25);
        // panel.add(iDText);
        button = new JButton("Submit");
        // button.setBounds(10,80,80,25);
        // panel.add(button);
        this.frame.setSize(350, 200);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.add(this.panel);

        this.panel.add(this.label);

        this.panel.add(this.iDText);

        this.button.setBounds(10,80,80,25);
        this.button.addActionListener(this);
        this.panel.add(this.button);
        
        this.panel.setLayout(null);

        this.enterID();
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Button Pressed");
        // Player player = new Player(Integer.parseInt(iDText.getText()), "test", "test", null);
        // database.connect();
        // if(database.willConflict(player))
        // {
        //     System.out.println("Player has been added to the game");
        // }
        // else
        // {
            this.gameState++;
            System.out.println(gameState);
            if(this.gameState == 0)
            {
                this.enterID();
            }
            else if(this.gameState == 1)
            {
                try
                {
                    iD = Integer.parseInt(this.iDText.getText());
                    this.enterCodeName();

                }
                catch(NumberFormatException exc)
                {
                    System.out.println("Enter an integer");
                    this.gameState = 0;
                }
            }
            else if(this.gameState == 2)
            {
                try
                {
                    codeName = this.iDText.getText();
                    this.enterEquipID();
                }
                catch(NumberFormatException exc)
                {
                    System.out.println("Enter a string");
                    this.gameState = 1;
                }
                
            }
            else if(this.gameState == 3)
            {
                try
                {
                    equipID = Integer.parseInt(this.iDText.getText());
                    this.enterID();
                    gameState = 0;
                }
                catch(NumberFormatException exc)
                {
                    System.out.println("Enter an integer");
                    this.gameState = 2;
                }
                
            }

        // }
        // database.disconnect();
    }

    public void enterID()
    {
        this.label.setText("ID");
        this.label.setBounds(10,20,80,25);
        // this.panel.add(this.label);

        this.iDText.setText("");
        this.iDText.setBounds(100, 20, 165, 25);
        // this.panel.add(this.iDText);

        // this.button.setBounds(10,80,80,25);
        // this.button.addActionListener(this);
        // this.panel.add(this.button);

        // while(entryScreen.gameState == 0)
        // {
            
        // }
    }
    
    public void enterCodeName()
    {   
        this.label.setText("CodeName");
        this.label.setBounds(10,20,80,25);
        //this.panel.add(this.label);

        this.iDText.setText("");
        this.iDText.setBounds(100, 20, 165, 25);
        //this.panel.add(this.iDText);

        //this.button.setBounds(10,80,80,25);
        //this.button.addActionListener(this);
        //this.panel.add(this.button);
    }

    public void enterEquipID()
    {   
        this.label.setText("Equipment ID");
        this.label.setBounds(10,20,80,25);
        this.panel.add(this.label);

        this.iDText.setText("");
        this.iDText.setBounds(100, 20, 165, 25);
        this.panel.add(this.iDText);

        // this.button.setBounds(10,80,80,25);
        // this.button.addActionListener(this);
        // this.panel.add(this.button);
    }

    public void repaint()
    {
        //if
    }

    public static void main(String[] args)
    {
        EntryScreen entryScreen = new EntryScreen();
    }
}
