import java.util.ArrayList;

public class Node 
{

	private Node parent;
	private Node[] children;
	private char data;
	
	public Node(Node par, int child, char dat)
	{
		parent = par;
		children = new Node[child];
		data = dat;
	}
	/**
	 * constructor for a Node
	 * @param totalChildren
	 */
	public Node(int totalChildren)
	{
		parent = null;
		children = new Node[totalChildren];
		data = '0';
	}
	/**
	 * method to get the parent of a Node
	 * @return the parent of the Node
	 */
	public Node getParent()
	{
		return parent;
	}
	/**
	 * method to get the particular child of a Node
	 * @param number of child
	 * @return Node child
	 */
	public Node getChild(int number)
	{
		return children[number];
	}
	/**
	 *method to get the data of a Node
	 * @return the data of the Node
	 */
	public char getData()
	{
		return data;
	}
	/**
	 * method to set the data of a Node
	 * @param char data
	 */
	public void setData(char dat)
	{
		data = dat;
	}
}
