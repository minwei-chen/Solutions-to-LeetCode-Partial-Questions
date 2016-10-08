
public class Solution148_SL {

	 public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}

	 
	    private ListNode next(ListNode head, int len) {
	        for(int i = 0; i<len && head!=null; i++) head = head.next;
	        return head;
	    }
	    
	    private ListNode[] sort(ListNode head, int len) {
	        ListNode cur = head, rs[] = new ListNode[2];
	        // if the entire list length <= len
	        for(int i = 1; i<len && cur.next!=null; i++) cur = cur.next;
	        if(cur.next==null) {
	            rs[0] = head; rs[1] = cur;
	            return rs;
	        }
	        ListNode nextHead = cur.next, anchor = new ListNode(0);
	        int ia = 0, ib = 0;
	        cur = anchor;
	        while(ia<len && ib<len && nextHead!=null) {
	            if(head.val<nextHead.val) {
	                cur = cur.next = head;
	                head = head.next;
	                ia++;
	            }
	            else {
	                cur = cur.next = nextHead;
	                nextHead = nextHead.next;
	                ib++;
	            }
	        }
	        while(ia<len) {
	            cur = cur.next = head;
	            head = head.next;
	            ia++;
	        }
	        while(ib<len && nextHead!=null) {
	            cur = cur.next = nextHead;
	            nextHead = nextHead.next;
	            ib++;
	        }
	        rs[0] = anchor.next;
	        rs[1] = cur;
	        cur.next = null;
	        return rs;
	    }
	    
	    public ListNode sortList(ListNode head) {
	        int len = 0;
	        ListNode anchor = new ListNode(0), rs[], tail;
	        for(ListNode cur = head; cur!=null; cur = cur.next) len++;
	        anchor.next = head;
	        for(int i = 1; i<=(len+1)/2; i *= 2) {
	        	tail = anchor;
	            for(ListNode cur = anchor.next, nextCur; cur!=null; cur = nextCur) {
	            	nextCur = next(cur, i*2);
	                rs = sort(cur, i);
	                tail.next = rs[0];
	                tail = rs[1];
	            }
	        }
	        return anchor.next;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(4), cur = head;
		cur = cur.next = new ListNode(5);
		cur = cur.next = new ListNode(1);
		cur = cur.next = new ListNode(6);
		cur = cur.next = new ListNode(8);
		cur = cur.next = new ListNode(9);
		cur = cur.next = new ListNode(2);
		cur = cur.next = new ListNode(1);
		cur = cur.next = new ListNode(3);
		cur = cur.next = new ListNode(5);
		cur = cur.next = new ListNode(2);
		cur = cur.next = new ListNode(3);
		cur = cur.next = new ListNode(6);
		cur = cur.next = new ListNode(8);
		cur = cur.next = new ListNode(4);
		cur = cur.next = new ListNode(10);
		cur = cur.next = new ListNode(34);
		cur = cur.next = new ListNode(11);
		cur = cur.next = new ListNode(7);
		head = new Solution148_SL().sortList(head);
	}

}
