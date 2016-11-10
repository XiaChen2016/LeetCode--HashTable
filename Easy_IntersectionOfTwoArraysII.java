/* Source of this quetion:
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * */
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Iterator;
public class Easy_IntersectionOfTwoArraysII {

	public static void main( String args[] ) {
		Easy_IntersectionOfTwoArraysII i = new Easy_IntersectionOfTwoArraysII();
		int[] array = i.intersection( new int[]{ 1,2,2,1 }, new int[] {2,2});
	}
	
	
  public int[] intersection( int[] nums1, int[] nums2 ) {
    	if( nums1.length ==0 || nums2.length==0)
    		return new int[]{};
    	
    	int i;
    	int[] result;
    	// Store the array with longer length into a hash map 
    	HashMap<Integer,Integer> map = new HashMap<>();
    	HashMap<Integer,Integer> dest = new HashMap<>();
    	for( i = 0; i<nums1.length; i++ ) {
    		if( map.containsKey( nums1[i])){
    			int value = map.get(nums1 [i]);
    			map.remove( nums1[i], value);
    			map.put( nums1[i], ++value);
    		} else
    			map.put(nums1[i], 1);
    	}
    		
    	for( i = 0; i < nums2.length; i++ ) {
    		if( map.containsKey(nums2[i]) ){
    			int value = map.get( nums2[i] );
    			if( value ==1 ){
    				map.remove( nums2[i], value);
    			} else{
    				map.remove( nums2[i], value);
    				map.put( nums2[i], --value);
    				
    			}
    			dest.put( i,nums2[i] );
    		}
    	}
        
        i=0;
        Iterator<Entry<Integer, Integer>> iter = dest.entrySet().iterator();
        result = new int[ dest.size() ];
        
		while( iter.hasNext() ) {
			HashMap.Entry entry = (HashMap.Entry) iter.next();
			result[i++] = (int) entry.getValue();
			
		}        
		return result;
  }
}