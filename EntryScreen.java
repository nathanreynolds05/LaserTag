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
    String team;
    boolean exists;


    EntryScreen()
    {
        gameState = 0;
        startGame = false;
        exists = false;
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
        
        // if(this.gameState == 0)
        // {
        //     Player player = new Player(Integer.parseInt(iDText.getText()), null);

        //     if(database.willConflict(player))
        //     {
        //         System.out.println("Player has been added to the game");
        //         gameState = 
        //     }
        // }
        this.database.connect();
        System.out.println("test");
        // if(database.willConflict(player))
        // {
        //     System.out.println("Player has been added to the game");
        // }
        // else
        // {
            this.gameState++;
            System.out.println(this.gameState);
            if(this.gameState == 0)
            {
                this.enterID();
            }
            else if(this.gameState == 1)
            {
                try
                {
                    this.iD = Integer.parseInt(this.iDText.getText());
                    if(this.database.searchByID(this.iD) == null)
                    {
                        this.iD = this.database.getNewPlayerID();
                        
                        System.out.println("Player not found. New ID given: " + this.iD);
                        this.enterCodeName();
                    }
                    else
                    {
                        this.codeName = this.database.searchByID(this.iD).getCodename();
                        this.exists = true;
                        System.out.println("Player has been found. Your codename is " + this.codeName);
                        gameState++;
                        this.enterEquipID();
                    }
                    

                }
                catch(NumberFormatException exc)
                {
                    System.out.println("Enter an integer");
                    this.iDText.setText("");
                    this.gameState = 0;
                }
            }
            else if(this.gameState == 2)
            {
                try
                {
                    if(exists)
                    {
                        
                    }
                    else
                    {
                        this.codeName = this.iDText.getText();
                    }

                    this.enterEquipID();
                }
                catch(NumberFormatException exc)
                {
                    System.out.println("Enter a string");
                    this.iDText.setText("");
                    this.gameState = 1;
                }
                
            }
            else if(this.gameState == 3)
            {
                try
                {
                    this.equipID = Integer.parseInt(this.iDText.getText());
                    this.enterTeam();
                    //this.gameState = 0;
                }
                catch(NumberFormatException exc)
                {
                    System.out.println("Enter an integer");
                    this.iDText.setText("");
                    this.gameState = 2;
                }
            }
            else if(this.gameState == 4)
            {
                try
                {
                    this.team = this.iDText.getText();

                    if(!(this.team.toLowerCase().equals("red")) && !(this.team.toLowerCase().equals("green")))
                    {
                        System.out.println("Enter red or green");
                        this.gameState = 3;
                    }
                    else
                    {
                        this.gameState = 0;
                        if(exists)
                        {
                            exists = false;
                        }
                        else
                        {
                            Player newPlayer = new Player(this.iD, this.codeName);
                            this.database.addPlayer(newPlayer);
                        }
                        
                        this.enterID();
                    }
                }
                catch(NumberFormatException exc)
                {
                    System.out.println("Enter red or green");
                    this.iDText.setText("");
                    this.gameState = 3;
                }
            }

        //}
        database.disconnect();
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
        //this.panel.add(this.label);

        this.iDText.setText("");
        this.iDText.setBounds(100, 20, 165, 25);
        //this.panel.add(this.iDText);

        // this.button.setBounds(10,80,80,25);
        // this.button.addActionListener(this);
        // this.panel.add(this.button);
    }

    public void enterTeam()
    {
        this.label.setText("Team");
        this.label.setBounds(10,20,80,25);
        //this.panel.add(this.label);

        this.iDText.setText("");
        this.iDText.setBounds(100, 20, 165, 25);
        //this.panel.add(this.iDText);
    }

    public static void main(String[] args)
    {
        EntryScreen entryScreen = new EntryScreen();
    }
}
