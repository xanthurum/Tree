

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
		//build();
		tree = new Make(totalChars, permutations, chars);
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
	 * and meanwhile prints out the permutations for every root child
	 */
	/*private void build()
	{
		for(int i = 0; i < totalChars; i++) //makes the children for the root
		{
			root.setChild(i,new Node(root, (permutations/totalChars), chars[i]));
			Node temp = root.getChild(i);
			System.out.print("The permutations from rootChild["+i+"] are : ");
			for(int j = 0; j < (permutations/totalChars); j++) //makes the children for the root its children
			{
				String fromChars = make(i);
				Permutations permutation = new Permutations(fromChars);
				System.out.print(chars[i] + permutation.getPermutation(j) + "   ");
				temp.setChild(j, new Node(temp, 1, permutation.getPermutation(j).charAt(0)));
				//System.out.println("The char from the permutation is " + permutation.getPermutation(j).charAt(0));
				Node parent = temp.getChild(j);
				
				for(int k = 1; k < (totalChars -1); k++) //makes a branch of children to fit one permutation
					{
						if(k != (totalChars -2)) 
						{
							parent.setChild(0, new Node(parent, 1, permutation.getPermutation(j).charAt(k)));	
						}
						else 
							{
							parent.setChild(0, new Node(null, 1, permutation.getPermutation(j).charAt(k)));
							}
						parent = parent.getChild(0);	
					}
				}
			System.out.println();
			}
		}*/
	
	/**
	 * 	method to make a correct string out of all the chars minus the one at place num
	 * @param num
	 * @return a new string
	 */
	private String make(int num)
	{
		String temp = new String();
		for(int i = 0; i < totalChars; i++)
		{
			if(i != num) temp += (chars[i]);
		}
		return temp;
	}
	
	
	/**
	 * prints out the number of permutations
	 */
	private void printPermutations()
	{
		System.out.println("The total number of permutations are " + permutations);
	}
}
     