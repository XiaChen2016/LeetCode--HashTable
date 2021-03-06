/* Source of the question:
 * https://leetcode.com/problems/single-number-ii/
 * */
import java.util.HashMap;

public class Medium_SingleNumberII {

	public static void main(String []args) {
		int[] nums = {1,2,1,1,3,3,3};
		Medium_SingleNumberII m = new Medium_SingleNumberII();
		System.out.println( m.singleNumber(nums) );
	}
	
    public int singleNumber(int[] nums) {
    	
    	//  runtime beats 64.72% of java submissions.
        int ones = 0, twos = 0;
		for(int i = 0; i < nums.length; i++){
		    ones = (ones ^ nums[i]) & ~twos;
		    twos = (twos ^ nums[i]) & ~ones;
		}
		return ones;
		
		 //  runtime beats 14.78% of java submissions.
//    	int i,j;
//        if( nums.length<2 )
//        	return nums[0];
//        HashMap<Integer,Integer> map = new HashMap<>();
//		for( i=0; i<nums.length; i++ ) {
//			// If find element with value "2", delete it
//			if( map.containsKey(nums[i]) ){
//				if( map.get(nums[i]).intValue() == 2){
//					map.remove(nums[i]);
//				}
//			// If the element has only appeared once, replace the value with 2
//				else{
//					map.remove(nums[i]);
//					map.put(nums[i], 2);
//				}
//			}
//
//			else
//				map.put(nums[i],1);
//		}
//    	return map.keySet().iterator().next();
    }
}
