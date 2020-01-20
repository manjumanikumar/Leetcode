package com.leetcodepractice;

import java.util.Arrays;

public class MinCostKruskalsSpanningTree {

    int component;
    int[] parent;
    // Amazon | OA 2019 | Min Cost to Connect All Nodes
// https://leetcode.com/discuss/interview-question/356960/Amazon-or-OA-2019-or-Find-Pair-With-Given-Sum


    public int minCosttoConnectAllNodes(int n, int edges[][], int newEdges[][]) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }

        Arrays.sort(newEdges, (a, b) -> (a[2] - b[2]));
        int cost = 0;
        for(int i=0; i<newEdges.length;i++){
            if(!uf.isConnected(newEdges[i][0], newEdges[i][1])){
                uf.union(newEdges[i][0], newEdges[i][1]);
                cost += newEdges[i][2];
                if(component == 1) return cost;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] n_tests = {6};
        int[][][] edges_tests = {{{1, 4}, {4, 5}, {2, 3}}};
        int[][][] newEdges_tests = {{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}}};
        for (int i = 0; i < n_tests.length; ++i) {
            System.out.println(new MinCostKruskalsSpanningTree().minCosttoConnectAllNodes(n_tests[i], edges_tests[i],
                    newEdges_tests[i]));
        }
    }

    public class UnionFind{

        public UnionFind(int size){
            parent = new int[size+1];
            for (int i=0;i<parent.length;i++){
                parent[i] = i;
            }
            component = size;
        }

        public int find(int v){
            if(parent[v] == v) return v;
            parent[v] = find(parent[v]);
            return parent[v];
        }

        public void union(int v1, int v2){
            if (find(v1) == find(v2)) return;
            int root = find(v1);
                while(v2 != parent[v2]){
                    int temp = parent[v2];
                    parent[v2] = root;
                    v2 = temp;
                }
            --component;
            parent[v2] = root;
        }

        public boolean isConnected(int v1, int v2){
            return find(v1) == find(v2);
        }

    }
}
