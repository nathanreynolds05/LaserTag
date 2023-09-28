//Dylan Baker
//3-31-2023
//Runs program using Model, Controller, and View

import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame
{
	View view;

	public Game()
	{
		view = new View();
		this.setTitle("A5 - Polymorphism");
		this.setSize(700, 500);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args)
	{
		Game g = new Game();
		g.run();
	}

	public void run()
	{
		while(true)
		{
			view.repaint(); // This will indirectly call View.paintComponent
			Toolkit.getDefaultToolkit().sync(); // Updates screen
			// Go to sleep for 40 milliseconds
			try
			{
				Thread.sleep(40);
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
