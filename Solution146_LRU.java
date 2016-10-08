import java.util.*;


public class Solution146_LRU {

    private class BiNode {
        int key;
        BiNode pre, next;
        public BiNode(int k) {key = k;}
    }
    
    private BiNode head, tail;
    private int cap, num;
    private Map<Integer, Integer> content;
    private Map<Integer, BiNode> positions;
    
    public Solution146_LRU(int capacity) {
        cap = capacity;
        num = 0;
        head = new BiNode(-1);
        tail = new BiNode(-1);
        head.next = tail; tail.pre = head;
        content = new HashMap<>();
        positions = new HashMap<>();
    }
    
    private void access(int key) {
        BiNode cur = positions.get(key);
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        cur.pre = tail.pre;
        cur.next = tail;
        tail.pre = cur.pre.next= cur;
    }
    
    public int get(int key) {
        if(content.containsKey(key)) {
            access(key);
            return content.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(cap<1) return;
        if(content.containsKey(key)) {access(key);}
        else {
            if(num==cap) {
                access(head.next.key);
                positions.remove(tail.pre.key);
                content.remove(tail.pre.key);
                tail.pre.key = key;
            }
            else {
                num++;
                BiNode cur = new BiNode(key);
                cur.pre = tail.pre; cur.next = tail;
                tail.pre.next = tail.pre = cur;
            }
            positions.put(key, tail.pre);
        }
        content.put(key, value);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution146_LRU obj = new Solution146_LRU(2);
		int a;
		obj.set(2, 1);
		obj.set(2, 2);
		a = obj.get(2);
		obj.set(1, 1);
		obj.set(4, 1);
		a = obj.get(2);
		
		
	}

}
