
import java.util.HashSet;
import java.util.Set;
	 
public class Permutations 
{
	private String[] permutations;
	/**
	 * constructor for Permutations
	 * @param string
	 */
	public Permutations(String string)
	{
		permutation(string);
	}
	
	/**
	 * method to make the permutations
	 * @author idea from Crunchify.com 
	 * @param string
	 * @return the whole set of permutations
	 */
	private Set<String> permutation(String string)
	{
		Set<String> result = new HashSet<String>();
		if (string == null) {
			return null;
		} else if (string.length() == 0) {
			result.add("");
			return result;
		}
		
		char firstChar = string.charAt(0);
		String rest = string.substring(1);
		Set<String> word = permutation(rest);
		
		for(String newString : word)
		{
			for(int i = 0; i <= newString.length(); i++)
			{
				result.add(addChar(newString, firstChar, i));
			}
		}
		permutations = result.toArray(new String[result.size()]);
		return result;
	}
	/**
	 * method to construct a permutation
	 * @author idea from Crunchify.com
	 * @param str
	 * @param c
	 * @param j
	 * @return a permutation
	 */
	private String addChar(String str, char c, int j)
	{
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}
	/**
	 * method to get a specific permutation
	 * @param i
	 * @return the permutation with number i in the array
	 */
	public String getPermutation(int i)
	{
		return permutations[i];
	}
}
	