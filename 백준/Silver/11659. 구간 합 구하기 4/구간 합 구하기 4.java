import java.io.*;
import java.util.*;
class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static List<int[]> edges; // x1, y1, x2, y2, c
	static int[] arr;
	static int[] dp;
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(reader.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N+1];
    	dp = new int[N+1];
    	
    	st = new StringTokenizer(reader.readLine());
    	for (int i = 1; i <= N; i++) {
    		int a = Integer.parseInt(st.nextToken());
    		arr[i] = a;
    		dp[i] = a + dp[i-1];
    	}
    	
    	for (int i = 0; i < M; i++) {
    		st = new StringTokenizer(reader.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		writer.write(dp[e] - dp[s-1] + "\n");
    	}
    	
    	
    	writer.flush();
    }
}