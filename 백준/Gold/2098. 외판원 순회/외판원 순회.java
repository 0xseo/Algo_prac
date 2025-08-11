import java.io.*;
import java.util.*;
class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[][] edges;
	static int[][] d;
    public static void main(String[] args) throws Exception {
    	N = Integer.parseInt(reader.readLine());
    	edges = new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(reader.readLine());
    		for (int j = 0; j < N; j++) {
    			int a = Integer.parseInt(st.nextToken());
    			edges[i][j] = a;
    		}
    	}
    	
    	d = new int[N][1<<N];
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < 1<<N; j++) {
    			d[i][j] = -1;
    		}
    	}
    	writer.write(tsp(0, 1<<0) +"\n");
    	
    	writer.flush();
    }
    
    static public int tsp(int curr, int state) {
    	if (state == (1<<N)-1) {
    		if (edges[curr][0] == 0) return Integer.MAX_VALUE;
    		return edges[curr][0];
    	}
    	if (d[curr][state] != -1) return d[curr][state];
    	int ans = Integer.MAX_VALUE;
    	for (int i = 0; i < N; i++) {
    		if (edges[curr][i] != 0 && (state & (1<<i)) == 0) {
    			// 방문하기
    			int nextCost = tsp(i, (state|(1<<i)));
    			if (nextCost != Integer.MAX_VALUE) {    				
    				int cost = edges[curr][i] + nextCost;
					ans = Math.min(cost, ans);
    			}
    		}
    	}
    	return d[curr][state] = ans;
    }
}