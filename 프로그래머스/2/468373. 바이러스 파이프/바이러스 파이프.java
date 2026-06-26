import java.util.*;
import java.io.*;
class Solution {
    int maxInfected = 0;
    int[] order;
    List<int[]>[] graph;

    public int solution(int n, int infection, int[][] edges, int k) {
        order = new int[k];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new int[]{edges[i][1], edges[i][2]});
            graph[edges[i][1]].add(new int[]{edges[i][0], edges[i][2]});
        }
        makeOrder(0, k, n, infection);
        
        return maxInfected;
    }

    void makeOrder(int depth, int k, int n, int startNode) {
        if (depth == k) { 
            runSimulation(n, startNode, k);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            order[depth] = i;
            makeOrder(depth + 1, k, n, startNode);
        }
    }
    
    void runSimulation(int n, int startNode, int k) {
        boolean[] infected = new boolean[n + 1];
        infected[startNode] = true; // 최초 감염자 세팅

        for (int step = 0; step < k; step++) {
            int currentPipe = order[step]; // 이번 턴에 열고 닫을 파이프!

            // [핵심 수정 1] 매 턴마다 큐를 새로 만들고, 현재 감염된 모든 애들을 출발점으로 세팅
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (infected[i]) {
                    q.add(i);
                }
            }
            
            while (!q.isEmpty()) {
                int infectedNode = q.poll();
                for (int i = 0; i < graph[infectedNode].size(); i++) {
                    int[] neiNode = graph[infectedNode].get(i);
                    
                    // [핵심 수정 2] 이번에 연 파이프(currentPipe)이고, 아직 감염 안 된 곳(!infected)
                    if (neiNode[1] == currentPipe && !infected[neiNode[0]]) {
                        infected[neiNode[0]] = true;
                        q.add(neiNode[0]); // 새로 감염된 애도 큐에 넣어서 연쇄 전파!
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (infected[i]) count++;
        }
        
        maxInfected = Math.max(maxInfected, count);
    }
}