
public class Solution25_RNkG {


	//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode anchor = new ListNode(0);
        anchor.next = head;
        ListNode window[] = new ListNode[k+1];
        window[0] = anchor;
        int i;
        while(head!=null) {
        	for(i = 1; i<=k && head!=null; i++) {
        		window[i] = head;
        		head = head.next;
        		window[i].next = window[i-1];
        	}
        	if(i>k) {
        		window[0].next = window[k];
        		window[0] = window[1];
        		window[1].next = head;
        	}
        	else {
        		for(int j = 1; j<i; j++) window[j].next = window[j+1];
        		window[i-1].next = null;
        	}
        	
        }
        return anchor.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution25_RNkG obj = new Solution25_RNkG();
		ListNode anchor = obj.new ListNode(0);
		ListNode head = anchor;
		for(int i = 0; i<10; i++) {
			head = head.next = obj.new ListNode(i);
		}
		head = obj.reverseKGroup(anchor.next, 4);
		for(; head!=null; head = head.next) System.out.println(head.val);
	}

}
