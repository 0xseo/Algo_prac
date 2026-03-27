import java.io.*;
import java.util.*;

class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] indeg;
	static int[] time;
	static List<Integer>[] edges;
	static List<Integer>[] parents;
    public static void main(String[] args) throws Exception {
    	int N = Integer.parseInt(reader.readLine());
    	indeg = new int[N+1];
    	time = new int[N+1];
    	edges = new ArrayList[N+1];
    	parents = new ArrayList[N+1];
    	for (int i = 1; i <= N; i++) {
    		edges[i] = new ArrayList<>();
    		parents[i] = new ArrayList<>();
    	}
    	for (int i = 1; i <= N; i++) {
    		st = new StringTokenizer(reader.readLine());
    		int t = Integer.parseInt(st.nextToken());
    		time[i] = t;
    		int toNode = Integer.parseInt(st.nextToken());
    		while (toNode != -1) {
    			indeg[i]++;
    			edges[toNode].add(i);
    			parents[i].add(toNode);
    			toNode = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	for (int i = 1; i <= N; i++) {
    		if (indeg[i] == 0) q.add(i);
    	}
    	
    	int predTime = 0;
    	while (!q.isEmpty()) {
    		int curr = q.poll();
//    		writer.write(curr + " " + time[curr] + "\n");
    		for (int toNode:edges[curr]) {
    			indeg[toNode]--;
    			if (indeg[toNode] == 0) {
    				int max = time[curr];
    				for (int p : parents[toNode]) {
    					if (time[p] > max) max = time[p];
    				}
    				time[toNode] += max;
    				q.add(toNode);
    			}
    		}
    	}
    	
    	for (int i = 1; i <= N; i++) {
    		writer.write(time[i] + "\n");
    	}
    	writer.flush();
    	
    }
    
    
}
