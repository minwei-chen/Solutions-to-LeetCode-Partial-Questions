
public class Solution108_CSATBST {

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    
    private int[] nums;
    private int i;
    private TreeNode[] nodes;
    
    private TreeNode construct(int start, int end) {
        if(start>end) return null;
        int pos = (start+end)/2, cur = ++i;
        nodes[cur].val = nums[pos];
        nodes[cur].left = construct(start, pos-1);
        nodes[cur].right = construct(pos+1, end);
        return nodes[cur];
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        i = -1;
        nodes = new TreeNode[nums.length];
        return construct(0, nums.length-1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0};
		new Solution108_CSATBST().sortedArrayToBST(nums);

	}

}
