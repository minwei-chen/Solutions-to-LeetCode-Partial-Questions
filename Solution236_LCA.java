import java.util.*;

public class Solution236_LCA {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private Set<TreeNode>[] set;
	
	private Set<TreeNode> build(TreeNode root, int pos) {
		Set<TreeNode> s = new HashSet<>();
		if(root!=null) {
			s.add(root);
			s.addAll(build(root.left, pos*2));
			s.addAll(build(root.right, pos*2+1));
		}
		return set[pos] = s;
	}
	
	private TreeNode findLCA(TreeNode root, int pos, TreeNode p, TreeNode q) {
		if(!set[pos].contains(p) || !set[pos].contains(q)) return null;
		TreeNode rs = findLCA(root.left, pos*2, p, q);
		if(rs==null) findLCA(root.right, pos*2+1, p, q);
		if(rs==null) return root;
		return rs;
	}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	set = new HashSet[1024];
    	build(root, 1);
    	return findLCA(root, 1, p, q);
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
