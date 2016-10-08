import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class Solution127_WL {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int step = 1;
        LinkedList<String> fronts = new LinkedList<>();
        String origin, edited;
        char[] chs;
        fronts.add(beginWord);
        wordList.add(endWord);
        while(!fronts.isEmpty()) {
            if(!wordList.contains(endWord)) return step;
            step++;
            for(int i = 0, size = fronts.size(); i<size; i++) {
                origin = fronts.poll();
                for(int j = 0; j<origin.length(); j++) {
                	chs = origin.toCharArray();
                    for(char c = 'a'; c<='z'; c++) {
                        chs[j] = c;
                        edited = new String(chs);
                        if(wordList.contains(edited)) {
                            fronts.add(edited);
                            wordList.remove(edited);
                        }
                    }
                }
            }
        }
        return 0;
     }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> set = new HashSet<>();
		set.add("hot");
		set.add("dog");
		set.add("dot");
		System.out.println(new Solution127_WL().ladderLength("hot", "dog", set));
	}

}
