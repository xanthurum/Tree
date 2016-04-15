
public class Make 
{
	private Node root, temp;
	private char[] charArray;
	private int totalChars, permutations, check, base, num, index;
	private StringBuilder string;
	/*
	 * constructor to make a new build
	 * a tree suitable for all the permutations
	 */
	public Make(int totalCh, int permu, char[] chars)
	{
		num = 0; base = 0; index = 0;
		root = new Node(totalCh, num);
		totalChars = totalCh;
		check = totalChars;
		permutations = permu;
		string = new StringBuilder(totalChars);
		construct();
		//print();
	}
	
	private void construct()
	{
		for(int i = 0; i < totalChars; i++)
		{
			System.out.println("first node " + i );
			root.setChild(i, add(root, root.getChild(i)));
			System.out.println("construct, data = " + root.getChild(i).getData());
		}
	}
	/**
	 * method to add a the number of nodes untill a Node has no children anymore
	 * @param parent
	 * @return a new Node
	 */
	private Node add(Node parent, Node child)
	{
		if(child != null) System.out.println("last child passed data = " + child.getData());
		
		while(child != root)
		{
			if(child == null && parent == root)
			{
				temp = new Node(root, totalChars-1, ++num);
				temp.setChild(temp.getCount(), new Node(temp, temp.getTotalChildren()-1, ++num));
				temp.setCount(temp.getCount()+1);
				System.out.println("node temp, totalChildren = " + temp.getTotalChildren() + " count = " + temp.getCount() + " data = " + temp.getData() + " data child = " + temp.getChild(temp.getCount()-1).getData());
				add(temp, temp.getChild(temp.getCount()-1));
			}
			else
			{
				if (parent.getTotalChildren() == 1) 
				{
					child.setChild(0, new Node(child, ++num));
					System.out.println("node null and child null, count = " + child.getCount() + " data = " + child.getData());
				
					System.out.println("temporaryParent count = " + parent.getCount() + " temporaryParent data = " + parent.getData());
					parent.setCount(parent.getCount()+1);
					System.out.println("temporaryParent new count = " + parent.getCount() + " temporaryParent data = " + parent.getData() + " base = " + base);
					testReset(child);
					
					if (base <= 0) 
						{
						 	add(null,child);
						 	return temp;
						}
					
					for(int i = 0; i < base; i++)
							{
								child = child.getParent();
							}
					base = 0;
					System.out.println("new child data = " + child.getData() + " count = " + child.getCount());
					add(child.getParent(), child);
					
				}			 
				else
				{
					System.out.println("child totalChildren = " + child.getTotalChildren() + " child data = " + child.getData());
					if(child.getTotalChildren() > 1)
					{
						child.setChild(child.getCount(), new Node(child, child.getTotalChildren()-1, ++num));
						child.setCount(child.getCount()+1);
						System.out.println("node null, totalChildren = " + child.getTotalChildren() + " new count = " + child.getCount() + " data = " + child.getData());
						if(child.getTotalChildren() <= 2) add(child, child.getChild(child.getCount()-1));
						else add(child, child.getChild(child.getCount()-1));
					}
					else
					{
						child.setChild(child.getCount(), new Node(child, child.getTotalChildren(), ++num));
						System.out.println("node null, totalChildren = " + child.getTotalChildren() + " count = " + child.getCount() + " data = " + child.getData());
						add(child, child.getChild(child.getCount()));
					}
				}
			}
		}
		return temp;		
	}
	
	private int testReset(Node parent)
	{
		if(parent == root)
		{
			return -1;
		}
		else
		if(parent.getTotalChildren() == 1 || parent.getCount() >= parent.getTotalChildren())
		{
			parent.setCount(0);
			base++;
			System.out.println("testReset() parent.getData.If = " + parent.getData() + " base = " + base);
			testReset(parent.getParent());
		}
		else
			System.out.println("testReset() parent.getData = " + parent.getData() + " base = " + base);
			//parent.setCount(parent.getCount()+1);
			return base;
	}
	/**
	 * method to print the tree
	 */
	private void print()
	{
		for(int i = 0; i < totalChars; i++)
		{
			System.out.print("The permutations from rootChild["+i+"] are : ");
			string.append(root.getChild(i).getData());	
			getString(root.getChild(i));
			string.delete(0,totalChars-1);
		}
	}
	
	private void getString(Node parent)
	{
		if(parent.getCount() == parent.getTotalChildren() && parent.getParent() == root)
		{
			parent.setCount(-1);
		}
		else
			if(parent.getCount() == parent.getTotalChildren())
			{
				parent.setCount(-1);
				getString(parent.getParent().getChild(parent.getParent().getCount()));
			}
		else
			if(parent.getTotalChildren() > 1)
			{
				temp = parent;
				string.append(parent.getData());
				index ++;
				temp.setCount(parent.getCount()+1);
				if(parent.getParent() == root) base ++;
				getString(parent.getChild(parent.getCount()-1));
			}
		else
			if(parent.getTotalChildren() == 1)
			{
				string.append(parent.getData());
				index++;
				getString(parent.getChild(0));
			}
		else
			if(parent.getChildren() == null)
			{
				string.append(parent.getData());
				index++;
				System.out.print(string + " ");
				string.delete(index-2, index);
				index = index-2;
				getString(parent.getParent().getParent().getChild(parent.getParent().getParent().getCount()));
			}
				
	}
}
