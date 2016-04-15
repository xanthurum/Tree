
public class Node 
{

	private Node parent;
	private Node[] children;
	private int totalOfChildren, count = 0;
	private int data;
	/**
	 * constructor for a Node 
	 * @param parent
	 * @param totalChildren (number of children)
	 * @param data
	 */
	public Node(Node par, int totalChildren, int dat)
	{
		totalOfChildren = totalChildren;
		parent = par;
		children = new Node[totalChildren];
		data = dat;
	}
	/**
	 * constructor for a root Node
	 * @param totalChildren  (number of children)
	 */
	public Node(int totalChildren, int dat)
	{
		totalOfChildren = totalChildren;
		parent = null;
		children = new Node[totalChildren];
		data = dat;
	}
	/**
	 * constructor for a end Node
	 * @param parent
	 */
	public Node(Node par, int dat)
	{
		parent = par;
		children = null;
		data = dat;
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
	public int getData()
	{
		return data;
	}
	/**
	 * method to get the count
	 *  a help number while filling or printing the tree
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
	public void setData(int dat)
	{
		data = dat;
	}
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
