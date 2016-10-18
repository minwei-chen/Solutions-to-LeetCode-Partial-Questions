/**
 * Created by Minwei Chen on 9/13/2016.
 */
import java.util.*;

public class Solution126_WL2 {

    Map<String, List<String>> map;
    List<List<String>> rs;
    String end;

    private void compose(List<String> workspace, String word) {
        workspace.add(word);
        if(word.equals(end)) {
            rs.add(workspace);
            return;
        }
        List<String> list = map.get(word);
        for(String s: list) {
            List<String> l = new LinkedList<>(workspace);
            compose(l, s);
        }
    }


    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        map = new HashMap<>();
        map.put(beginWord, new LinkedList<>());
        for(String s: wordList) {
            map.put(s, new LinkedList<>());
        }
        wordList.remove(endWord);
        wordList.add(beginWord);
        Set<String> front = new HashSet<>();
        Set<String> nextFront = new HashSet<>();
        front.add(endWord);
        rs = new LinkedList<>();
        while(!front.isEmpty()) {
            nextFront.clear();
            for(String origin: front) {
                for(int i = 0; i<origin.length(); i++) {
                    char[] chs = origin.toCharArray();
                    for(char c = 'a'; c<='z'; c++) {
                        chs[i] = c;
                        String edited = new String(chs);
                        if(wordList.contains(edited)) {
                            map.get(edited).add(origin);
                            nextFront.add(edited);
                        }
                    }
                }
            }
            if(nextFront.contains(beginWord)) break;
            for(String s: nextFront) wordList.remove(s);
            Set<String> interim = front;
            front = nextFront;
            nextFront = interim;
            nextFront.clear();
        }
        end = endWord;
        compose(new LinkedList<>(), beginWord);
        return rs;
    }

    public static void main(String[] args) {

        String a = "a", c = "c";
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("c");
        set.add("b");
        new Solution126_WL2().findLadders(a, c, set);
    }
}
