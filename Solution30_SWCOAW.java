import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class Solution30_SWCOAW {

	public List<Integer> findSubstring(String s, String[] words) {
		final int numOfWords = words.length, lenOfWord = words[0].length();
		final int lenOfSub = lenOfWord*numOfWords, lenOfS = s.length();
		ArrayList<String> wordSet = new ArrayList<String>(numOfWords);
		ArrayList<String> headMatched = new ArrayList<String>(numOfWords), rearMatched = new ArrayList<String>(numOfWords);
		String word;
		List<Integer> rs = new LinkedList<Integer>();
		int baseline, lenToCheck, lenOfMatched, endIndex;
		for(String ss: words) wordSet.add(ss);
		for(int i = 0; i<lenOfWord; i++) {
			baseline = i;
			lenToCheck = lenOfSub;
			lenOfMatched = 0;
			headMatched.clear();
			rearMatched.clear();
			endIndex = baseline+lenToCheck;
			while(endIndex<=lenOfS) {
				while(lenOfMatched<lenToCheck && endIndex<=lenOfS) {
					word = s.substring(endIndex-lenOfMatched-lenOfWord, endIndex-lenOfMatched);
					if(wordSet.remove(word)) {
						lenOfMatched += lenOfWord;
						rearMatched.add(word);
					}	
					else if(!headMatched.contains(word)){
						lenToCheck = lenOfSub-lenOfMatched;
						baseline += lenToCheck;
						endIndex += lenToCheck;
						lenOfMatched = 0;
						wordSet.addAll(headMatched);
						headMatched.clear();
						headMatched.addAll(rearMatched);
						rearMatched.clear();
					}
					else {
						word = s.substring(baseline, baseline+lenOfWord);
						baseline += lenOfWord;
						endIndex += lenOfWord;
						lenOfMatched = 0;
						wordSet.addAll(rearMatched);
						wordSet.add(word);
						rearMatched.clear();
						headMatched.remove(word);
						lenToCheck = lenOfSub-headMatched.size()*lenOfWord;
					}
				}
				if(lenOfMatched==lenToCheck) {
					rs.add(baseline);
					word = s.substring(baseline, baseline+lenOfWord);
					lenToCheck = lenOfWord;
					baseline += lenToCheck;
					endIndex += lenToCheck;
					lenOfMatched = 0;
					headMatched.addAll(rearMatched);
					headMatched.remove(word);
					wordSet.add(word);
					rearMatched.clear();
				}
			}
			wordSet.addAll(headMatched);
		}
		return rs;
		
    }

	
	/* Hash failure.
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> rs = new LinkedList<Integer>();
		final int numOfWords = words.length, lenOfWord = words[0].length();
		final int lenOfSub = lenOfWord*numOfWords, lenOfS = s.length();
		int baseLine, xorOfWords = 0, hash = 0, xorOfSub;
		long hashOfWords = 0, hashOfSub, iHashOfSub;
		for(String ss: words) {
			hash = String.valueOf(ss.hashCode()).hashCode();
			hashOfWords += hash;
			xorOfWords ^= hash;
		}
		for(int i = 0; i<lenOfWord; i++) {
			baseLine = i;
			hashOfSub = xorOfSub = 0;
			for(int j = 0; j<numOfWords && baseLine<=(lenOfS-lenOfSub); j++) {
				hash = String.valueOf(s.substring(baseLine+j*lenOfWord, baseLine+(j+1)*lenOfWord).hashCode()).hashCode();
				hashOfSub += hash;
				xorOfSub ^= hash;
			}
			if(hashOfSub==hashOfWords && xorOfSub==xorOfWords) rs.add(baseLine);
			for(baseLine += lenOfWord; baseLine<=(lenOfS-lenOfSub); baseLine += lenOfWord) {
				hash = String.valueOf(s.substring(baseLine-lenOfWord, baseLine).hashCode()).hashCode();
				hashOfSub -= hash;
				xorOfSub ^= hash;
				hash = String.valueOf(s.substring(baseLine+lenOfSub-lenOfWord, baseLine+lenOfSub).hashCode()).hashCode();
				xorOfSub ^= hash;
				hashOfSub += hash;
				if(hashOfSub==hashOfWords && xorOfSub==xorOfWords) rs.add(baseLine);
			}
		}
		return rs;
	}
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "aa", b = "cb", c = "ba", d = "bb";
		System.out.println((a.hashCode()+b.hashCode())==(c.hashCode()+d.hashCode()));
		
	}
	

}
