
public class Make 
{
	private Node root;
	private char[] charArray, tempArray;
	private int[] combinations;
	private int totalChars, check, printInterval, permutations, level;
	/**
	 * constructor to make a new build
	 * a tree suitable for all the permutations
	 */
	public Make(int permuta, int[] combi, char[] chars)
	{
		level = 0; check = 0; printInterval = 50; permutations = permuta;
		charArray = chars;
		totalChars = charArray.length;
		combinations = combi;
		root = new Node(totalChars);
		construct();
		fill();
		printPermutations();
		printCombinations();
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
	 * method to print all the permutations for all chars
	 */
	private void printPermutations()
	{
		tempArray = new char[charArray.length];
		for(int i = 0; i < root.getTotalChildren(); i++)
		{
			Node child = root.getChild(i);
			System.out.print("The permutations for char '" + child.getData() + "' are : ");
			//printOther(0, child);
			level = 1;
			combinations(0, totalChars, child);
			System.out.println();
		}
		System.out.println("The total of printed permutations vs calculated permutations = " + check + "/" + permutations);
	}

	/**
	 * method to print all possible combinations
	 */
	private void printCombinations()
	{
		for(int i = 2; i < totalChars; i++)
		{
			check = 0;
			System.out.println("All combinations with " + i + " chars are : ");
			for(int j = 0; j < totalChars; j++)
			{
				tempArray = new char[i];
				Node child = root.getChild(j);
				System.out.print("The combinations for Char '" + child.getData() + "' are : ");
				level = 1;
				combinations(0, i, child);
				System.out.println();
			}
			System.out.println("The total of printed combinations for " + i + " chars vs the calculated combinations = " + check + "/" + combinations[i-2]);
		}
	}
	/**
	 * recursive method to get all data ready to print the combinations/permutations for each char
	 * once a combination is complete its been printed
	 * @param the of chars a combination is made of
	 * @param a child node from the root
	 */
	private void combinations(int interval, int numOfComb, Node child)
	{
		if(child != root)
		{
			if(level == numOfComb)
			{
				for(int i = 0; i < child.getParent().getTotalChildren(); i++)
				{
					tempArray[totalChars-child.getParent().getTotalChildren()] = child.getParent().getChild(i).getData();
					printTempArray();
					System.out.print(" ");
					interval++; check++;
					child.getParent().setCount(child.getParent().getCount()+1);
					if(interval == printInterval)
					{
						interval = 0;
						System.out.println();
						System.out.print("                                    ");
					}
				}
				child = child.getParent();
				level--;
				while(child.getCount() >= child.getTotalChildren())
				{
					child.setCount(0);
					child = child.getParent();
					level--;
				}
				combinations(interval, numOfComb, child);
			}
			else
			{
				tempArray[totalChars-child.getParent().getTotalChildren()] = child.getData();
				child.setCount(child.getCount()+1);
				child = child.getChild(child.getCount()-1);
				level++;
				combinations(interval, numOfComb, child);
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
