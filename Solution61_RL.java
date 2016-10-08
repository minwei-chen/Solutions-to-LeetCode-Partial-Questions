
public class Solution61_RL {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	private class BiListNode extends ListNode {
        BiListNode pre;
        BiListNode(ListNode n) {
            super(n.val);
        }
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode end = head;
        int size = 1, i;
        BiListNode newHead, newEnd;
        for(newHead = newEnd = new BiListNode(end); end.next!=null; size++) { 
            end = end.next;
            ((BiListNode)(newEnd.next = new BiListNode(end))).pre = newEnd;
            newEnd = (BiListNode) newEnd.next;
        }
        newEnd.next = newHead;
        newHead.pre = newEnd;
        for(i = 0, k %= size; i<k; i++) newHead = (BiListNode) newHead.next;
        newHead.pre.next = null;
        return newHead;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
