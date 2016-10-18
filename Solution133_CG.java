/**
 * Created by Minwei Chen on 9/18/2016.
 */
import java.util.*;
public class Solution133_CG {
    /**
     * Definition for undirected graph.
     * */
     class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     }


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();
        Map<Integer, List<Integer>> relations = new HashMap<>();
        LinkedList<UndirectedGraphNode> inProcess = new LinkedList<>();
        UndirectedGraphNode curNode;
        List<Integer> neighbors;
        //Set<Integer> added = new HashSet<>();
        inProcess.add(node);

        while(!inProcess.isEmpty()) {
            curNode = inProcess.poll();
            if(nodes.containsKey(curNode.label)) continue;
            nodes.put(curNode.label, new UndirectedGraphNode(curNode.label));
            neighbors = new ArrayList<>(curNode.neighbors.size());
            for(UndirectedGraphNode u: curNode.neighbors) neighbors.add(u.label);
            relations.put(curNode.label, neighbors);
            inProcess.addAll(curNode.neighbors);
        }

        Set<Integer> keys = nodes.keySet();

        for(int label: keys) {
            curNode = nodes.get(label);
            neighbors = relations.get(label);
            List<UndirectedGraphNode> list = curNode.neighbors;
            for(int i: neighbors) list.add(nodes.get(i));
            curNode.neighbors = list;
        }

        return nodes.get(node.label);
    }



}
