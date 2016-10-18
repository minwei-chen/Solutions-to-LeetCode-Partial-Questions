/**
 * Created by Minwei Chen on 10/5/2016.
 */
public class Solution388_LAFP {
    boolean isFile(String s) {
        return s.contains(".");
    }

    int getLevel(String s) {
        if(s.startsWith("\t")) return getLevel(s.substring(1, s.length()))+1;
        return 1;
    }

    public int lengthLongestPath(String input) {
        int stack[] = new int[512], max = 0;
        String ss[] = input.split("\\n");
        for(int i = 0; i<ss.length; i++) {
            int level = getLevel(ss[i]);
            if(isFile(ss[i])) {
                int length = stack[level-1]+ss[i].length()-level+1;
                max = length>max? length: max;
            }
            else stack[level] = stack[level-1]+1+ss[i].length()-level+1;
        }
        return max;
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        new Solution388_LAFP().lengthLongestPath(input);
    }

}
