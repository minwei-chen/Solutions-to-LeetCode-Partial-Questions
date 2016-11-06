/**
 * Created by Minwei Chen on 9/26/2016.
 */
import java.util.*;

public class Solution140_WB2 {


    /*String s;
    Map<Integer, List<Integer>> startsFor;
    List<String> rs;

    void recurse(int end, String segmented) {
        if(end<=0) {rs.add(segmented.substring(0, segmented.length()-1)); return;}
        for(int start: startsFor.get(end)) {
            recurse(start, s.substring(start, end)+" "+segmented);
        }
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        Set<Integer> starts = new HashSet<>();
        Map<Integer, List<Integer>> startsFor = new HashMap<>();
        List<Integer> startsAt = new LinkedList<>();
        starts.add(0);
        int max = 0, min = Integer.MAX_VALUE;
        for(String str: wordDict) {
            max = str.length()>max? str.length(): max;
            min = str.length()<min? str.length(): min;
        }
        for(int i = min; !starts.isEmpty() && i<=s.length(); i++) {
            startsAt.clear();
            for(int start: starts) {
                if(wordDict.contains(s.substring(start, i))) {
                    startsAt.add(start);
                    starts.add(i);
                }
            }
            starts.remove(i-max);
            if(!startsAt.isEmpty()) startsFor.put(i, new LinkedList<>(startsAt));
        }
        this.s = s;
        this.startsFor = startsFor;
        rs = new LinkedList<>();
        if(!startsFor.containsKey(s.length())) return rs;
        recurse(s.length(), "");
        return rs;
    }
    */

    Set<String> dict, fails;
    List<String> rs;

    boolean bt(String cur, String pre) {

        if(fails.contains(cur)) return false;

        if(cur.isEmpty()) {
            rs.add(pre.trim()); return true;
        }

        Set<String> matches = new HashSet<>();

        for(String s: dict) {
            if(cur.startsWith(s)) matches.add(s);
        }

        if(matches.isEmpty()) {
            fails.add(cur); return false;
        }

        boolean suc = false;
        for(String s: matches) {
            suc = bt(cur.substring(s.length()), pre+cur.substring(0, s.length())+" ");
        }

        if(suc) return true;
        fails.add(cur);
        return false;
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        rs = new ArrayList<>();
        dict = wordDict;
        if(dict.size()<1 && s.length()>0) return rs;

        fails = new HashSet<>();
        bt(s, "");

        return rs;

    }

    public static void main(String[] argv) {
        String s = "aaaaaaaa";
        HashSet<String> set = new HashSet<>();
        set. add("aaa");
        set.add("aaaa");
        set.add("aa");
        //set.add("sand");
        //set.add("dog");
        new Solution140_WB2().wordBreak(s, set);
    }
}
