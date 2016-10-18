/**
 * Created by Minwei Chen on 10/11/2016.
 */

import java.util.TreeMap;

public class Solution295_FMFDS {


    TreeMap<Integer, Integer> map;
    int[] m1, m2;

    private void goPre(int[] pos) {
        if(pos[1]<=1) {
            pos[0] = map.lowerKey(pos[0]);
            pos[1] = map.get(pos[0]);
        }
        else pos[1]--;
    }

    private void goNext(int[] pos) {
        if(pos[1]>=map.get(pos[0])) {
            pos[0] = map.higherKey(pos[0]);
            pos[1] = 1;
        }
        else pos[1]++;
    }

    public Solution295_FMFDS() {
        map = new TreeMap<>();
        map.put(Integer.MIN_VALUE, 1);
        map.put(Integer.MAX_VALUE, 1);
        m1 = new int[]{Integer.MIN_VALUE, 1};
        m2 = new int[]{Integer.MAX_VALUE, 1};
    }

    // Adds a number into the data structure.
    public void addNum(int num) {

        if(map.containsKey(num)) map.put(num, map.get(num)+1);
        else map.put(num, 1);

        if(m1[0]==m2[0] && m1[1]==m2[1]) {
            if(num<m1[0]) goPre(m1);
            else goNext(m2);
        }
        else {
            if(num<m1[0]) goPre(m2);
            else if(num>=m2[0]) goNext(m1);
            else {
                goPre(m2);
                goNext(m1);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return (m1[0]+m2[0])/2.0;
    }

    public static  void main(String[] args) {
        Solution295_FMFDS ins = new Solution295_FMFDS();
        ins.addNum(1);
        ins.addNum(1);
        ins.addNum(3);
        ins.findMedian();
        ins.addNum(4);
        ins.addNum(3);
    }
}
