import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tree extends JFrame implements KeyListener
{
	private char[] chars;
	private int total = 1,keys = 0;
	private volatile boolean event = false;
	private JTextField area;
	private JPanel panel;

	/**
	 * constructor for the Tree class
	 */
	public Tree() 
	{
		panel = new JPanel();
		area = new JTextField(5);
		setVisible(true);
		setSize(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.add(area);
		add(panel);
		area.addKeyListener(this);	
		
		System.out.println("Typ (int) the total amount of chars you wish to add");
		build();
	}

	public static void main(String[] args) 
	{
		
		Tree tree = new Tree();
	}
	/**
	 * KeyEvent method to get all necessary parameters to make a new build
	 */
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		if(total == 1) 
		{
			total = Character.getNumericValue(e.getKeyChar());
			System.out.println("The total amount of chars will be : " + total);
			System.out.println("Typ in your first caracter");
			chars = new char[total];
		}
		else if(keys != total)
		{
			chars[keys] = e.getKeyChar();
			keys++;
			if(keys != total) System.out.println("Typ in caracter number " + (keys + 1));
			if(keys == total)
			{
				event = true;
				printChars();
			}
		}
		
	}
	/**
	 * The build method waits until all chars are been set to make a new build
	 */
	private void build()
	{
		while(!event){}
			
		if(event)
		{
			Build build = new Build(total, chars);
		}
	}
	/**
	 * print method to print the chosen chars
	 */
	private void printChars()
	{
		System.out.print("Your chosen chars are : ");
		for(int i = 0; i < chars.length; i++)
		{
			System.out.print(chars[i] + " ");
		}
		System.out.println();
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
