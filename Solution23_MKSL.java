import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


public class Solution23_MKSL {

	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	
	
	private void addTree(TreeMap<Integer, List<Integer>> tree, int val, int index) {
		List<Integer> V = tree.get(val);
		if(V==null) V = new LinkedList<Integer>(); 
		V.add(index);
		tree.put(val, V);
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        int k = lists.length, index;
        ListNode rs = new ListNode(0), rsTail = rs;
        TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
        List<Integer> V = null;
        for(int i = 0; i<k && lists[i]!=null; i++) addTree(tree, lists[i].val, i);
        while(!tree.isEmpty()) {
        	V = tree.remove(tree.firstKey());
        	while(!V.isEmpty()) {
        		index = V.remove(0);
        		rsTail = rsTail.next = lists[index];
        		lists[index] = lists[index].next;
        		if(lists[index]!=null) addTree(tree, lists[index].val, index);
        	}
        }
        return rs.next;
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
