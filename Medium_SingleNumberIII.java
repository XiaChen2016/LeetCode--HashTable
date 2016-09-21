/* Source of the question:
 * https://leetcode.com/problems/single-number-iii/
 * */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Medium_SingleNumberIII {

	public static void main(String []args) {
		int[] nums = {1,2,1,3,4,4,6,3,2,5};
		int[] array = new int[2];
		Medium_SingleNumberIII m = new Medium_SingleNumberIII();
		array = m.singleNumber(nums);
	}
	
    public int[] singleNumber(int[] nums) {
    	int[] result = new int[2];
		int i;
	    HashMap<Integer,Integer> map = new HashMap<>();
		for( i=0; i<nums.length; i++ ) {
			// If find a duplicate element, remove it
			if( map.containsKey(nums[i]) )
				map.remove(nums[i]);
			else
				map.put(nums[i],i);
		}
		i = 0;
		Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
		while( iter.hasNext() ) {
			HashMap.Entry entry = (HashMap.Entry) iter.next();
			result[i++] = (int) entry.getKey();
			
		}
		return result;
	}
}
