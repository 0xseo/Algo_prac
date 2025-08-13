import java.io.*;
import java.util.*;
class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] memory;
	static int[] cost;
	static List<int[]> dp;
    public static void main(String[] args) throws Exception {
    	st = new StringTokenizer(reader.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	memory = new int[N+1];
    	cost = new int[N+1];
    	dp = new ArrayList<>();
    	
    	st = new StringTokenizer(reader.readLine());
    	for (int i = 1; i <= N; i++) {
    		int a = Integer.parseInt(st.nextToken());
    		memory[i] = a;
    	}
    	
    	st = new StringTokenizer(reader.readLine());
    	for (int i = 1; i <= N; i++) {
    		int a = Integer.parseInt(st.nextToken());
    		cost[i] = a;
    	}
    	
    	int ans = 0;
    	int c = 0;
    	while (true) {
    		dp.add(new int[N+1]);
    		int max = 0;
    		for (int app = 1; app <= N; app++) {
    			if (app == 1) {
    				if (c < cost[app]) continue;
    				dp.get(c)[app] = memory[app];
    				if (dp.get(c)[app] > max) max = dp.get(c)[app];
    			} else {
    				boolean canTurnOff = c >= cost[app];
    				if (!canTurnOff) {
    					dp.get(c)[app] = dp.get(c)[app-1];
    					if (dp.get(c)[app] > max) max = dp.get(c)[app];
    				} else {
    					dp.get(c)[app] = Math.max(dp.get(c)[app-1], dp.get(c-cost[app])[app-1] + memory[app]);
    					if (dp.get(c)[app] > max) max = dp.get(c)[app];
    				}
    			}
    		}
    		if (max >= M) {
    			ans = c;
    			break;
    		}
    		c++;
    	}
    	
    	writer.write(ans + "\n");
    	writer.flush();
    }
}