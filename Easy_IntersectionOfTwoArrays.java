/* Source of the question:
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * */
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Iterator;

public class Easy_IntersectionOfTwoArrays {

	public static void main( String args[] ) {
		int[] nums1 = {3,1,2};
		int[] nums2 = {1,1};
		Easy_IntersectionOfTwoArrays e = new Easy_IntersectionOfTwoArrays();
		// Store the result in nums3
		int[] nums3 = e.intersection(nums1, nums2);
		
	}
    public int[] intersection(int[] nums1, int[] nums2) {
    	if( nums1.length ==0 || nums2.length==0)
    		return new int[]{};
    	
    	int i,j,length;
    	int[] result;
    	// Store the array with longer length into a hash map 
    	HashMap<Integer,Integer> map = new HashMap<>();
        if( nums1.length > nums2.length ) {
        	for( i = 0; i<nums1.length; i++ )
        		map.put(nums1[i], i);
        } else {
        	for( i = 0; i<nums2.length; i++ )
        		map.put(nums2[i], i);
        }

    	i=0;
        if( nums1.length > nums2.length ) {
        	j = nums2.length-1;
        	// Leave the intersection of two arrays at the front of nums2
        	while(i<=j) {
        		if( map.containsKey(nums2[i])){
        			i++;
        		} else{
        			nums2[i] = nums2[j];
        			j--;
        		}
        	}
        	map.clear();
        	length = i;
        	// Store the intersection into map
        	for( i=0; i<length; i++) {
        			map.put(nums2[i],i);
        	}
        } else {
        	j = nums1.length-1;
        	// Leave the intersection of two arrays at the front of nums1
        	while(i<=j) {
        		if( map.containsKey(nums1[i])){
        			i++;
        		} else{
        			nums1[i] = nums1[j];
        			j--;
        		}
        	}

        	map.clear();
        	length = i;
        	/* Store the intersection into map
        	 * Duplicate elements can be avoided when they are stored into map */
        	for( i=0; i<length; i++) {
        			map.put(nums1[i],i);
        	}
        }
        
        j = length;
        Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
        result = new int[map.size()];
        i=0;
		while( iter.hasNext() ) {
			HashMap.Entry entry = (HashMap.Entry) iter.next();
			result[i++] = (int) entry.getKey();
			
		}        
		return result;
    	
    }
}
