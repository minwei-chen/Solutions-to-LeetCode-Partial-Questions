/**
 * Created by Minwei Chen on 10/19/2016.
 */
public class Solution418_SSF {
    private boolean isLegal(int[] cur, int r, int c) {
        if(cur[0]>=0 && cur[0]<r && cur[1]>=0 && cur[1]<c) return true;
        return false;
    }

    private void nextLine(int[] cur) {
        cur[0]++;
        cur[1] = 0;
    }

    private boolean putable(int[] cur, String s, int c) {
        if(c-cur[1]>=s.length()) return true;
        return false;
    }

    private void curTakeStep(int[] cur, int c) {
        if(++cur[1]>=c) nextLine(cur);
    }

    private boolean put(int[] cur, String s, int r, int c) {
        while(isLegal(cur, r, c) && !putable(cur, s, c)) nextLine(cur);

        if(isLegal(cur, r, c)) {
            cur[1] += s.length();
            return true;
        }
        else return false;
    }

    private boolean putCircle(int[] cur, String[] sen, int r, int c) {
        for(String s:sen) {
            if(!put(cur, s, r, c)) return false;
            curTakeStep(cur, c);
        }
        return true;
    }

    private void rightShift(int[] cur, int n) {
        cur[1] += n;
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        /*
        int len = sentence.length, lenS0 = sentence[0].length()+1;
        int[] cur = new int[2];

        int rs = 0;

        for(int i = 0; isLegal(cur, rows, cols); i = (i+1)%len) {
            if(!put(cur, sentence[i], rows, cols)) return rs;
            if(i==len-1) {
                rs++;

                // optimize.
                if(cur[1]+lenS0>cols) {
                    rs *= (rows/(cur[0]+1));
                    cur[0] = (rows/(cur[0]+1))*(cur[0]+1);
                    cur[1] = 0;
                    continue;
                }


            }
            curTakeStep(cur, cols);
        }

        return rs;
        */

        int sLen = 0, rs = 0;
        for(String s:sentence) sLen += s.length()+1;

        int[] cur = new int[2];

        while(isLegal(cur, rows, cols)) {
            int len = cols-cur[1]+1;
            int n = len/sLen;
            if(n>0) {rightShift(cur, n*sLen-1); rs += n; curTakeStep(cur, cols);}

            if(putCircle(cur, sentence, rows, cols)) { rs++;}
        }


        return rs;
    }

    public static void main(String[] args) {
        String[] s = {"f", "p", "a"};
        new Solution418_SSF().wordsTyping(s, 8, 7);
    }
}
