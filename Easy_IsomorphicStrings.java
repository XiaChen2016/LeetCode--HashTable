/* Source of the question:
 * https://leetcode.com/problems/isomorphic-strings/
 * */
import java.util.HashMap;

public class Easy_IsomorphicStrings {
	
	public static void main( String []args ) {
		String s = "ab";
		String t = "ca";
		Easy_IsomorphicStrings  e = new Easy_IsomorphicStrings();
		System.out.println( e.isIsomorphic(s, t) );
	}
	
    public boolean isIsomorphic(String s, String t) {
    	int i;
    	HashMap<Character,Character> map = new HashMap<>();
    	for( i=0; i<s.length(); i++ ) {
    		if( map.containsKey(s.charAt(i))  ) {
    			if( map.get( s.charAt(i) ).equals( t.charAt(i) ) )
    					continue;
    			else return false;
    		} else if( map.containsValue( t.charAt(i)))
    			return false;
    		else
    			map.put(s.charAt(i), t.charAt(i));
    	}
    	return true;
    }
}
