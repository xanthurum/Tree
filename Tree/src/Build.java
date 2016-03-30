

public class Build 
{

	private Node root;
	private int totalChars, permutations = 1;
	private char[] chars;
	
	public Build(int totalChar, char[] chrs)
	{
		chars = chrs;
		totalChars = totalChar;
		root = new Node(totalChars);
		permutations = permutations(totalChars);
		printPermutations();
		build();
	}
	
	
	/**
	 * calculate the number of permutations
	 * @param total
	 * @return #permutations
	 */
	private int permutations(int total)
	{
		if(total == 1) return permutations * 1;
		else
		{
			return (total * permutations(total -1));
		}
	}
	/**
	 * method who actually builds a new tree made of nodes
	 */
	private void build()
	{
		for(int i = 0; i < totalChars; i++)
		{
			root.setChild(i,new Node(root, (permutations/totalChars), chars[i]));
		}
		
	}
	/**
	 * prints out the number of permutations
	 */
	private void printPermutations()
	{
		System.out.println("The total number of permutations are " + permutations);
	}
}
     