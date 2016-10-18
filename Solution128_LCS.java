import java.util.HashMap;
import java.util.Map;


public class Solution128_LCS {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> head = new HashMap<>(), tail = new HashMap<>();
        int newHead, newTail, max = 0;
        for(int element: nums) {
            if(head.containsKey(element+1) && tail.containsKey(element-1)) {
                newHead = tail.get(element-1);
                newTail = head.get(element+1);
                head.remove(element+1);
                tail.remove(element-1);
            }
            else if(head.containsKey(element+1) && !tail.containsKey(element-1)) {
                newHead = element;
                newTail = head.get(element+1);
                head.remove(element+1);
            }
            else if(!head.containsKey(element+1) && tail.containsKey(element-1)) {
                newHead = tail.get(element-1);
                newTail = element;
                tail.remove(element-1);
            }
            else {
                newHead = element;
                newTail = element;
            }
            head.put(newHead, newTail);
            tail.put(newTail, newHead);
            max = max>(newTail-newHead+1)? max: (newTail-newHead+1);
        }
        return max;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = {-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7};
		new Solution128_LCS().longestConsecutive(input);
	}

}
