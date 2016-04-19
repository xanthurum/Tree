

public class Build 
{
	private int totalChars, permutations = 1;
	private int[] combinations;
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
		permutations = factorial(totalChars);
		printPermutations();
		combinations();
		Make tree = new Make(permutations, combinations, chars);
	}
	
	
	/**
	 * calculate the number of permutations
	 * @param total
	 * @return #permutations
	 */
	private int factorial(int total)
	{
		if(total == 1) return 1;
		else
		{
			return (total * factorial(total -1));
		}
	}
	private void combinations()
	{
		combinations = new int[totalChars-2];
		int temp = totalChars-2;
		for(int i = 2; i < totalChars; i++)
		{
			combinations[i-2] = (factorial(totalChars)/factorial(temp));
			temp--;
			System.out.println("combinations for : " + i + " chars are : " + combinations[i-2]);
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
     