/**
 * Created by Minwei Chen on 10/18/2016.
 */
import java.util.*;

public class Solution332_RI {
    /*
    private LinkedList<LinkedList<String>> legal;
    private String[][] tickets;

    private void bt(int level, int pos, LinkedList<String> done, boolean[] avai) {
        //System.out.println(done.get(0));
        if(!tickets[pos][0].equals(done.getLast())) return;

        done.add(tickets[pos][1]);
        avai[pos] = false;
        for(String s:done) System.out.print(s+", ");
        System.out.println();

        if(level==tickets.length) {
            legal.add(new LinkedList<String>(done));
        }

        for(int i = 0; i<tickets.length; i++) {
            if(avai[i]) bt(level+1, i, done, avai);
        }

        done.removeLast();
        avai[pos] = true;
    }


    public List<String> findItinerary(String[][] tickets) {
        // 1. get all the permutations of the tickets.
        // 2. find all legal Itinerary.
        // 3. get the smallest one.
        // total time comp. O(N^2), space comp. O(N^2)
        // Not an efficient algo.

        // Can we use backtracking to improve the efficiency of permutation.?
        // Yes, we can. And we can combine 1 and 2 together.

        if(tickets.length<1) return new LinkedList<String>();

        legal = new LinkedList<>();
        this.tickets = tickets;

        for(int i = 0; i<tickets.length; i++) {
            if(!tickets[i][0].equals("JFK")) continue;
            LinkedList<String> done = new LinkedList<>();
            done.add(tickets[i][0]); done.add(tickets[i][1]);
            boolean avai[] = new boolean[tickets.length];
            Arrays.fill(avai, true);
            avai[i] = false;
            if(tickets.length<2) legal.add(done);
            for(int j = 0; j<tickets.length; j++) {
                if(avai[j]) bt(2, j, done, avai);
            }
        }

        System.out.println(legal.size());

        LinkedList[] output = new LinkedList[legal.size()];
        output = legal.toArray(output);
        //System.out.println(output[5].size());

        Arrays.sort(output, new Comparator<LinkedList>() {
            public int compare(LinkedList a, LinkedList b) {
                String ah = null, bh = null;
                Iterator ai = a.iterator(); Iterator bi = b.iterator();
                while(ai.hasNext()) {
                    ah = (String)ai.next();
                    bh = (String)bi.next();
                    if(!ah.equals(bh)) return ah.compareTo(bh);
                }
               return 0;
            }});

        return output[0];
    }
    */

    private class Ticket implements Comparable<Ticket> {
        public String des;
        public int num;
        public Ticket(String d, int n) {
            des = d;
            num = n;
        }
        public int compareTo(Ticket t) {
            return this.des.compareTo(t.des);
        }
    }

    private boolean bt(Map<String, Ticket[]> m, boolean[] used, String s, int l, int t, LinkedList<String> done) {
        if(l>=t) {rs = done; return true;}
        Ticket[] ts = m.get(s);
        for(int i = 0; i<ts.length; i++) {
            if(used[ts[i].num]) continue;
            used[ts[i].num] = true;
            done.add(ts[i].des);
            if(bt(m, used, ts[i].des, l+1, t, done)) return true;
            done.removeLast();
            used[ts[i].num] = false;
        }
        return false;
    }

    private List<String> rs;

    public List<String> findItinerary(String[][] ts) {
        Map<String, List<Ticket>> map = new HashMap<>();

        for(int i = 0; i<ts.length; i++) {
            if(map.containsKey(ts[i][0])) map.get(ts[i][0]).add(new Ticket(ts[i][1], i));
            else {
                List<Ticket> l = new ArrayList<>();
                l.add(new Ticket(ts[i][1], i));
                map.put(ts[i][0], l);
            }
        }

        Map<String, Ticket[]> m = new HashMap<>();
        for(Map.Entry<String, List<Ticket>> e:map.entrySet()) {
            Ticket[] t = e.getValue().toArray(new Ticket[e.getValue().size()]);
            Arrays.sort(t);
            m.put(e.getKey(), t);
        }

        boolean[] used = new boolean[ts.length];
        LinkedList<String> ll = new LinkedList<>();
        ll.add("JFK");
        bt(m, used, "JFK", 0, ts.length, ll);
        return rs;
    }

    public static void main(String[] args) {
        String[][] input = {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        new Solution332_RI().findItinerary(input);
    }
}
