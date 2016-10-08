import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;


public class Solution56_MI {

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> rs = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Interval element:intervals) {
        	if(map.containsKey(element.start))
        		map.put(element.start, Math.max(map.get(element.start), element.end));
        	else map.put(element.start, element.end);
        }
        int curS = map.firstKey(), curE = map.get(map.firstKey());
        for(Entry<Integer, Integer> e:map.entrySet()) {
        	if(e.getKey()<=curE) curE = Math.max(curE, e.getValue());
        	else {
        		rs.add(new Interval(curS, curE));
        		curS = e.getKey();
        		curE = e.getValue();
        	}
        }
        rs.add(new Interval(curS, curE));
        
        return rs;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
