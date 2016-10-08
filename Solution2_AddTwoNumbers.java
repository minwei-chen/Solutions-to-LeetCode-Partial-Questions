public class Solution2_AddTwoNumbers {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result, curRe;
        int a, b = 0;
        curRe = result = new ListNode(0);
       	while(l1 != null && l2 != null) {
       		a = l1.val + l2.val + b;
       		curRe = curRe.next = new ListNode(a%10);
       		b = a/10;
       		l1 = l1.next;
       		l2 = l2.next;
        }
       	// deal with the case of either one list is exhausted.
       	if(l1 == null) l1 = l2;
       	while(l1 != null) {
       		a = l1.val + b;
       		curRe = curRe.next = new ListNode(a%10);
       		b = a/10;
       		l1 = l1.next;
       		
       	}
        if(b != 0) curRe.next = new ListNode(b);
        return result.next;
    }
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2_AddTwoNumbers obj = new Solution2_AddTwoNumbers();
		ListNode L1 = obj.new ListNode(0);
		ListNode L2 = obj.new ListNode(0);
		ListNode l1 = L1, l2 = L2;
		
		l1 = l1.next = obj.new ListNode(2);
		l1 = l1.next = obj.new ListNode(4);
		l1 = l1.next = obj.new ListNode(6);
		l2 = l2.next = obj.new ListNode(5);
		l2 = l2.next = obj.new ListNode(6);
		l2 = l2.next = obj.new ListNode(4);
		
		ListNode result = obj.addTwoNumbers(L1.next, L2.next);
		while(result != null) {
			System.out.println(""+result.val);
			result = result.next;
		}
	}
	*/
}
