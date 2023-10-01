//import javax.print.attribute.standard.JobKOctetsSupported;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class EntryScreen extends JFrame implements ActionListener, KeyListener
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
    Action exit;
    Action submit;
    static ArrayList<Integer> info = new ArrayList<Integer>();


    EntryScreen()
    {
        exit = new Exit();
        submit = new Submit();
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
        this.addKeyListener(this);
        this.frame.setVisible(true);
        this.frame.add(this.panel);

        InputMap iMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        iMap.put(KeyStroke.getKeyStroke("F3"), "exit");
        panel.getActionMap().put("exit", exit);
        iMap.put(KeyStroke.getKeyStroke("\t"), "submit");
        panel.getActionMap().put("submit", submit);
        


        this.panel.add(this.label);

        this.panel.add(this.iDText);

        this.button.setBounds(10,80,80,25);
        this.button.addActionListener(this);
        this.panel.add(this.button);
        
        this.panel.setLayout(null);

        this.enterID();
    }

    public class Exit extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("f3");
            gameState = 5;
            update();
        }

    }

    public class Submit extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("tab");
            update();
        }

    }

    

    public void keyTyped(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e)
    {

    }

    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_F3)
        {
            System.out.println("f3 pressed");
            this.gameState = 5;
            update();
        }
        else if(e.getKeyCode() == KeyEvent.VK_TAB)
        {
            System.out.println("tab pressed");
            update();
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        update();
    }

    public void update()
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
                    info.add(equipID);
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
                        System.out.println("Enter red or green" + this.team.toLowerCase());
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
                    System.out.println("Enter red or green exception");
                    this.iDText.setText("");
                    this.gameState = 3;
                }
            }

        //}
        database.disconnect();

        try
        {
            baseClient();
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }
        System.out.println(this.gameState);

        if(this.gameState == 6)
        {
            System.exit(0);
        }
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

    public static void baseClient() throws IOException
	{
		// Step 1:Create the socket object for
		// carrying the data.
		DatagramSocket ds = new DatagramSocket();

		InetAddress ip = InetAddress.getLocalHost();
		byte buf[] = null;

		// loop while user not enters "bye"
		//for loop to iterate through all elements in the arrayList
		for (int i = 0; i < info.size(); i++)
		{
            System.out.println("loop");
			//loops over all elements in the arrayList
			//System.out.println(info.get(i));
			
			//String will take the input of whatever is in the arrayList at i
			int inp = info.get(i);
			//System.out.println("This is inp: " + inp);
			// convert the String input into the byte array.
			buf = ByteBuffer.allocate(Integer.BYTES).putInt(inp).array();
			// Step 2 : Create the datagramPacket for sending
			// the data.
			//System.out.println("This is buf: " + buf);
			DatagramPacket DpSend =
				new DatagramPacket(buf, buf.length, ip, 7500);

			// Step 3 : invoke the send call to actually send
			// the data.
			ds.send(DpSend);
		}
		

		// break the loop if user enters "bye"
		//if (inp.equals("bye"))
		
	}

    // public static void main(String[] args)
    // {
    //     EntryScreen entryScreen = new EntryScreen();
    // }
}
