/**
 * Created by Minwei Chen on 10/6/2016.
 */

import java.util.*;

public class Solution288_UWA {

    private Map<String, List<String>> map;

    public Solution288_UWA(String[] dictionary) {
        map = new HashMap<>();
        for(String w: dictionary) {
            String abbr = getAbbreviation(w);
            if(map.containsKey(abbr)) {
                map.get(abbr).add(w);
            }
            else {
                List<String> l = new LinkedList<>();
                l.add(w);
                map.put(abbr, l);
            }
        }
    }

    private String getAbbreviation(String word) {
        if(word.length()<3) return word;
        return word.substring(0, 1)+(word.length()-2)+word.substring(word.length()-1, word.length());
    }

    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);
        if(!map.containsKey(abbr)) return true;
        List<String> l = map.get(abbr);
        if(l.size()>1) return false;
        if(word.equals(l.get(0))) return true;
        return false;
    }

    public static void main(String[] args) {
        String dic[] = {"hello"};
        new Solution288_UWA(dic).isUnique("hello");
    }
}
