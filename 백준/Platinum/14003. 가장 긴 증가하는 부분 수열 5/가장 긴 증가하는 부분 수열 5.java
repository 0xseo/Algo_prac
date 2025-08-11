import java.io.*;
import java.util.*;
class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static List<Integer> lisLen;
	static int[] lisPos;
	static int[] arr;
    public static void main(String[] args) throws Exception {
    	int N = Integer.parseInt(reader.readLine());
    	arr = new int[N];
    	lisPos = new int[N];
    	lisLen = new ArrayList<>();
    	
    	st = new StringTokenizer(reader.readLine());
    	for (int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		if (lisLen.size() == 0) {
    			lisLen.add(arr[i]);
    			lisPos[i] = 1;
    		}
    		else {
    			int idx = find_upper_bound(arr[i], lisLen);
    			if (idx >= lisLen.size()) lisLen.add(arr[i]);
    			else lisLen.set(idx, arr[i]);
    			lisPos[i] = idx+1;
    		}
    	}
    	int maxLen = lisLen.size();
    	writer.write(maxLen+ "\n");
    	int st = Integer.MAX_VALUE;
    	int[] ans = new int[maxLen];
    	for (int i = N-1; i >= 0; i--) {
    		if (lisPos[i] == maxLen && st > arr[i]) {
    			maxLen -= 1;
    			st = arr[i];
    			ans[maxLen] = arr[i];
    		}
    	}
    	for (int i = 0; i < ans.length; i++) {
    		writer.write(ans[i]+" ");
    	}
    	writer.flush();
    }
    
    static int find_upper_bound(int val, List<Integer> arr) {
    	int start = 0;
    	int end = arr.size();
    	int mid;
    	while (start < end) {
    		mid = (start + end) / 2;
    		if (arr.get(mid) >= val) {
    			end = mid;
    		} else {
    			start = mid + 1;
    		}
    	}
    	return start;
    }
}