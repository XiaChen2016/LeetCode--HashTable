/* Source of the question:
 * https://leetcode.com/problems/single-number/
 * */
import java.util.HashMap;

public class Easy_SingleNumber {

	public static void main(String []args) {
		int[] nums = {1,2,1,3,4,4,6,3,2};
		Easy_SingleNumber e = new Easy_SingleNumber();
		System.out.println( e.singleNumber(nums) );
	}
	
    public int singleNumber(int[] nums) {
    	int i;
        if( nums.length<2 )
        	return nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();
		for( i=0; i<nums.length; i++ ) {
			// If find a duplicate element, remove it
			if( map.containsKey(nums[i]) )
				map.remove(nums[i]);
			else
				map.put(nums[i],i);
		}
    	return map.keySet().iterator().next();
    }
}
