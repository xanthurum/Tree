

public class Build 
{

	private Node root;
	private int totalChars, permutations = 1;
	private char[] chars;
	
	public Build(int totalChar, char[] chrs)
	{
		root = new Node(totalChars);
		permutations = permutations(totalChars);
		printPermutations();
		
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
			return (permutations * permutations(total -1));
		}
	}
	/**
	 * prints out the number of permutations
	 */
	private void printPermutations()
	{
		System.out.println("the total number of permutations = " + permutations);
	}
}
     