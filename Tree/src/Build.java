

public class Build 
{

	private Make tree;
	private int totalChars, permutations = 1;
	private char[] chars;
	/**
	 * the constructor of the Build class
	 * @param totalChar
	 * @param chrs
	 */
	public Build(int totalChar, char[] chrs)
	{
		chars = chrs;
		totalChars = totalChar; 
		permutations = permutations(totalChars);
		printPermutations();
		tree = new Make(permutations, chars);
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
	 * prints out the number of permutations
	 */
	private void printPermutations()
	{
		System.out.println("The total number of permutations are " + permutations);
	}
}
     