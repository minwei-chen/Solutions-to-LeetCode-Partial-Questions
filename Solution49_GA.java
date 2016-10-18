import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Solution49_GA {

    public List<List<String>> groupAnagrams(String[] strs) {
        char[] arr;
        int hash;
        List<List<String>> rs = new LinkedList<>();
        HashMap<Integer, List<String>> hashMap = new HashMap<>();
        for(String s:strs) {
        	Arrays.sort(arr = s.toCharArray());
        	hash = new String(arr).hashCode();
        	if(!hashMap.containsKey(hash))
        		hashMap.put(hash, new LinkedList<String>());
        	hashMap.get(hash).add(s);
        }
        for(List<String> l:hashMap.values())
        	rs.add(l);
        return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
