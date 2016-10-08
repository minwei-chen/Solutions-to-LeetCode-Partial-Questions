import java.util.LinkedList;
import java.util.List;



public class Solution113_PS2 {

	
	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    private List<List<Integer>> rs;
    private LinkedList<Integer> workspace;
    private int sum;
    
    private void travel(TreeNode root, int subSum) {
        if(root==null) return;
        workspace.add(root.val);
        subSum += root.val;
        if(root.left==null && root.right==null && subSum==sum) {
            rs.add(new LinkedList<>(workspace));
            workspace.removeLast();
            return;
        }
        travel(root.left, subSum);
        travel(root.right, subSum);
        workspace.removeLast();
    }
    
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        rs = new LinkedList<>();
        workspace = new LinkedList<>();
        return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
