
public class Make 
{
	private Node root;
	private char[] charArray, tempArray;
	private int totalChars, check, printInterval, permutations;
	/**
	 * constructor to make a new build
	 * a tree suitable for all the permutations
	 */
	public Make(int permuta, char[] chars)
	{
		check = 0; printInterval = 50; permutations = permuta;
		charArray = chars;
		totalChars = charArray.length;
		root = new Node(totalChars);
		construct();
		fill();
		print();
	}
	/**
	 * method to construct a permutation tree
	 */
	private void construct()
	{
		for(int i = 0; i < totalChars; i++)
		{
			add(i);
		}
	}
	/**
	 * recursive method to add all the following nodes from a node
	 * @param an array number from the root its children array
	 */
	private void add(int number)
	{
		Node child;
		
		root.setChild(number, new Node(root, totalChars-1));
		child = root.getChild(number);
		
		while(child != root)
		{
			if(child.getTotalChildren() == 1)
			{
				child.setChild(child.getCount(), new Node(child));
				child.setCount(child.getCount()+1);
				while(child.getCount() == child.getTotalChildren())
				{
					child.setCount(0);
					child = child.getParent();
				}
			}
			else
			{
				child.setChild(child.getCount(), new Node(child, (child.getTotalChildren()-1)));
				child.setCount(child.getCount()+1);
				child = child.getChild(child.getCount()-1);
			}
		}
	}
	/**
	 * method to fill the complete tree with all the chars
	 * needed to form all permutations
	 */
	private void fill()
	{
		fillBase();
		for(int i = 0; i < root.getTotalChildren(); i++)
		{
			Node child = root.getChild(i);
			fillOther(child);
		}
	}
	/**
	 * method to fill the base row of the tree
	 * this makes it possible to calculate tempArray for every node its children
	 */
	private void fillBase()
	{
		tempArray = charArray;
		
		for(int i = 0; i < root.getTotalChildren(); i++)
		{
			Node child = root.getChild(i);
			child.setData(charArray[i]);
		}
	}
	/**
	 * recursive method to fill all nodes under a node
	 * @param a node
	 */
	private void fillOther(Node child)
	{	
		while(child != root)
		{
			if(child.getTotalChildren() == 2)
			{
				getCharArray(child);
				tail(child);
				child.setCount(child.getCount()+2);
				while(child.getCount() >= child.getTotalChildren())
				{
					child.setCount(0);
					child = child.getParent();
				}
				if(child != root)
				{
					child.setCount(child.getCount()+1);
					child = child.getChild(child.getCount()-1);
				}
			}
			else
			{
				getCharArray(child);
				for(int i = 0; i < child.getTotalChildren(); i++)
				{
					child.getChild(i).setData(tempArray[i]);
				}
				child.setCount(child.getCount()+1);
				child = child.getChild(child.getCount()-1);
			}
		}
	}
	/**
	 * method to calculate the charArray for a node its children
	 * @param a node
	 */
	private void getCharArray(Node child)
	{
		if(child.getParent() == root)
		{
			tempArray = charArray;
			deleteChar(child.getData());
		}
		else
		{
			getParentChildrenArray(child);
			deleteChar(child.getData());
		}		
	}
	/**
	 * method to make an array of the data from a node its children
	 * @param a node
	 */
	private void getParentChildrenArray(Node child)
	{
		tempArray = new char[child.getParent().getTotalChildren()];
		for(int i = 0; i < child.getParent().getTotalChildren(); i++)
		{
			tempArray[i] = child.getParent().getChild(i).getData();
		}
	}
	/**
	 * method to fill a tail from the tree
	 * @param a node
	 * @param a pair of chars
	 */
	private void tail(Node parent)
	{
		parent.getChild(0).setData(tempArray[0]);
		parent.getChild(0).getChild(0).setData(tempArray[1]);
		parent.getChild(1).setData(tempArray[1]);
		parent.getChild(1).getChild(0).setData(tempArray[0]);	
	}
	/**
	 * method to delete a char from an array
	 * @param the char to be deleted
	 */
	private void deleteChar(char cha)
	{
		char[] temporary = new char[tempArray.length-1];
		int tempo = 0;
		for(int i = 0; i < tempArray.length; i++)
		{
			if(tempArray[i] != cha) 
			{
				temporary[tempo] = tempArray[i];
				tempo++;
			}
		}
		tempArray = temporary;
	}
	
	/**
	 * method to print the whole tree
	 */
	private void print()
	{
		tempArray = new char[charArray.length];
		for(int i = 0; i < root.getTotalChildren(); i++)
		{
			Node child = root.getChild(i);
			System.out.print("The permutations for char '" + child.getData() + "' are : ");
			printOther(0, child);
			System.out.println();
		}
		System.out.println("The total of printed permutations vs calculated permutations = " + check + "/" + permutations);
	}
	/**
	 * recursive method to get all data ready to print
	 * and printed once a permutation is complete
	 * @param a child node from the root
	 */
	private void printOther(int interval, Node child)
	{	
		if(child != root)
		{
			if(child.getTotalChildren() == 2)
			{
				tempArray[totalChars-child.getParent().getTotalChildren()] = child.getData();
				tempArray[tempArray.length-2] = child.getChild(0).getData();
				tempArray[tempArray.length-1] = child.getChild(0).getChild(0).getData();
				printTempArray();
				System.out.print(" ");
				tempArray[tempArray.length-2] = child.getChild(1).getData();
				tempArray[tempArray.length-1] = child.getChild(1).getChild(0).getData();
				printTempArray();
				System.out.print(" ");
				child.setCount(child.getCount()+2);
				check = check +2; interval = interval +2;
				if(interval == printInterval)
				{
					interval = 0;
					System.out.println();
					System.out.print("                                    ");
				}
				while(child.getCount() == child.getTotalChildren())
				{
					child.setCount(0);
					child = child.getParent();
				}
				printOther(interval, child);
			}
			else
			{
				tempArray[totalChars-child.getParent().getTotalChildren()] = child.getData();
				child.setCount(child.getCount()+1);
				child = child.getChild(child.getCount()-1);
				printOther(interval, child);
			}
		}
	}
	/**
	 * method to print tempArray
	 */
	private void printTempArray()
	{
		for(int i = 0; i < tempArray.length; i++)
		{
			System.out.print(tempArray[i]);
		}		
	}
}
