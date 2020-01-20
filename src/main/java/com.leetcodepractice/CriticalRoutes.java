package com.leetcodepractice;

import java.util.*;

//Use targens algorithm
// if its a root node then if it has childern > 1
// if visited time <= low time of neighbour
public class CriticalRoutes {

    int time = 0;

    public static void main(String[] args) {
        int numNodes = 7, numEdges = 7;
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
        System.out.println(new CriticalRoutes().getCriticalRoutes(numNodes, numEdges, edges));
    }

    public List<Integer> getCriticalRoutes(int numNodes, int numEdges, int[][] edges) {

        Map<Integer, Set<Integer>> connections = new HashMap<>();
        for(int i=0; i<numNodes; i++){
            connections.put(i, new HashSet<>());
        }
        for(int[] edge : edges){
            connections.get(edge[0]).add(edge[1]);
            connections.get(edge[1]).add(edge[0]);
        }

        int[] parent = new int[numNodes];
        int[] low = new int[numNodes];
        int[] visitedTime = new int[numNodes];
        Arrays.fill(parent, -1);
        Arrays.fill(low, -1);
        Arrays.fill(visitedTime, -1);
        Set<Integer> result = new HashSet<>();
        for (int i=0;i<numNodes;i++){
            if (visitedTime[i] == -1){
                dfs(parent, i, low, visitedTime, connections, result);
            }
        }

        return new ArrayList<>(result);
    }

    public void dfs(int[] parent, int cur, int[] low, int[] visitedTime, Map<Integer, Set<Integer>> connections, Set<Integer> result){

        low[cur] = visitedTime[cur] = ++time;
        int children = 0;

        for (int neigh : connections.get(cur)){
            if (visitedTime[neigh] == -1){
                children++;
                parent[neigh] = cur;
                dfs(parent, neigh, low, visitedTime, connections, result);
                low[cur] = Math.min(low[cur], low[neigh]);
                if ((parent[cur] == -1 && children > 1) || (parent[cur] != -1 && visitedTime[cur] <= low[neigh])){
                    result.add(cur);
                }
            }
            //backedge
            else if(neigh != parent[cur]){
                low[cur] = Math.min(visitedTime[neigh], low[cur]);
            }
        }
    }
}
