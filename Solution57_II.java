import java.util.LinkedList;
import java.util.List;


public class Solution57_II {

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int index, size = intervals.size();
    	List<Interval> rs = new LinkedList<>();
    	Interval i;
    	for(index = 0; index<size && newInterval.end>=(i = intervals.get(0)).start; index++) {
    		intervals.remove(0);
    		if(i.end>=newInterval.start) {
    			newInterval.start = Math.min(newInterval.start, i.start);
    			newInterval.end = Math.max(i.end, newInterval.end);
    		}
    		else rs.add(i);
    	}
    	for(rs.add(newInterval); index<size; index++) rs.add(intervals.remove(0));
    	return rs;     
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
