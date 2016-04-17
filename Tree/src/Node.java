
public class Node 
{

	private Node parent;
	private Node[] children;
	private int totalOfChildren, count = 0;
	private char data;
	/**
	 * constructor for a Node 
	 * @param parent
	 * @param totalChildren (number of children)
	 * @param data
	 */
	public Node(Node par, int totalChildren)
	{
		totalOfChildren = totalChildren;
		parent = par;
		children = new Node[totalChildren];
	}
	/**
	 * constructor for a root Node
	 * @param totalChildren  (number of children)
	 */
	public Node(int totalChildren)
	{
		totalOfChildren = totalChildren;
		parent = null;
		children = new Node[totalChildren];
	}
	/**
	 * constructor for an end Node
	 * @param parent
	 */
	public Node(Node par)
	{
		parent = par;
		children = null;
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
	 * @param placenumber of node in a children array
	 * @return that specific child node 
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
	 * method to get the count
	 *  a helping number while filling or printing the tree
	 * @return count
	 */
	public int getCount()
	{
		return count;
	}
	/**
	 * method to get the total of children of a Node
	 * @return totalOfChildren
	 */
	public int getTotalChildren()
	{
		return totalOfChildren;
	}
	/**
	 * method to get the children
	 * @return children
	 */
	public Node[] getChildren()
	{
		return children;
	}
	/**
	 * method to set the data of a Node
	 * @param char data
	 */
	public void setData(char dat)
	{
		data = dat;
	}
	/**
	 * method to set the count
	 * count a helping number while filling or printing the tree
	 * @param number
	 */
	public void setCount(int number)
	{
		count = number;
	}
	/**
	 * method to set a child of a Node
	 * @param num
	 * @param child
	 */
	public void setChild(int num, Node child)
	{
		children[num] = child;
	}
}
