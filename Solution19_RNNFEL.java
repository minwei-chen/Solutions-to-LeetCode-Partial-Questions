import java.util.List;


public class Solution19_RNNFEL {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null || n<1) return head;
		ListNode pre = null, candidate = null, later = null, cur = head;
		int i = 0;
		for(; cur!=null; cur = cur.next) {
			i++;
			if(i>n) {
				pre = candidate;
				candidate = candidate.next;
				later = candidate.next;
			}
			else if(i==n) candidate = head;
		}
		if(i==n) head = head.next;
		if(i>n) pre.next = later;
		return head;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
