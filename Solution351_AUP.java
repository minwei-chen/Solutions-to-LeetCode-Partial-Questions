/**
 * Created by Minwei Chen on 10/17/2016.
 */

import java.util.*;
public class Solution351_AUP {

    private boolean[] getSelectable(boolean[] selected, int sel) {
        boolean[] selectable = new boolean[10];
        Arrays.fill(selectable, true);
        switch(sel) {
            case 1:
                if(!selected[2]) selectable[3] = false;
                if(!selected[4]) selectable[7] = false;
                if(!selected[5]) selectable[9] = false;
                break;
            case 2:
                if(!selected[5]) selectable[8] = false;
                break;
            case 3:
                if(!selected[2]) selectable[1] = false;
                if(!selected[6]) selectable[9] = false;
                if(!selected[5]) selectable[7] = false;
                break;
            case 4:
                if(!selected[5]) selectable[6] = false;
                break;
            case 5:
                break;
            case 6:
                if(!selected[5]) selectable[4] = false;
                break;
            case 7:
                if(!selected[4]) selectable[1] = false;
                if(!selected[8]) selectable[9] = false;
                if(!selected[5]) selectable[3] = false;
                break;
            case 8:
                if(!selected[5]) selectable[2] = false;
                break;
            case 9:
                if(!selected[6]) selectable[3] = false;
                if(!selected[8]) selectable[7] = false;
                if(!selected[5]) selectable[1] = false;
                break;
        }
        return selectable;
    }

    private int forward(boolean[] ed, int sel, int m, int n, int s) {
        if(s>n) return 0;
        int rs = 0;
        if(s>=m && s<=n) rs++;
        ed[sel] = true;
        boolean[] able = getSelectable(ed, sel);
        for(int i = 1; i<10; i++) {
            if(able[i] && !ed[i]) rs += forward(ed.clone(), i, m, n, s+1);
        }
        return rs;
    }

    public int numberOfPatterns(int m, int n) {
        /* basic idea: if a number is selected, all its adjacent numbers become
        ** selectable. And a selected number becomes unselectable.
        */

        boolean[] able = new boolean[10], ed = new boolean[10];
        int rs = 0;

        rs += forward(ed, 5, m, n, 1);
        System.out.println(rs);

        Arrays.fill(able, false);
        Arrays.fill(ed, false);
        rs += 4*forward(ed, 1, m, n, 1);
        System.out.println(rs);

        Arrays.fill(able, false);
        Arrays.fill(ed, false);
        rs += 4*forward(ed, 2, m, n, 1);

        return rs;

    }

    public static void main(String[] args) {
        new Solution351_AUP().numberOfPatterns(4,4);
    }
}
