import java.io.*;
import java.util.*;
class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
    public static void main(String[] args) throws Exception {
    	String str1 = reader.readLine();
    	String str2 = reader.readLine();
    	char[] arr1 = str1.toCharArray();
    	char[] arr2 = str2.toCharArray();
    	int[][] dp = new int[arr1.length+1][arr2.length+1];
    	
    	String ans = "";
    	for (int i = 1; i <= arr1.length; i++) {
    		for (int j = 1; j <= arr2.length; j++) {
    			if (arr1[i-1] == arr2[j-1]) {
    				dp[i][j] = dp[i-1][j-1] + 1;
    			} else {
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    			}
    		}
    	}
    	writer.write(dp[arr1.length][arr2.length]+"\n");
    	int i = arr1.length;
    	int j = arr2.length;
    	while (i > 0 && j > 0) {
    		if (arr1[i-1] == arr2[j-1] && dp[i][j] == dp[i-1][j-1]+1) {
    			ans = arr1[i-1] + ans;
    			i--;
    			j--;
    		}
    		else if (dp[i][j-1] < dp[i-1][j]) {
    			i--;
    		} else {
    			j--;
    		}
    	}
    	writer.write(ans + "\n");
    	writer.flush();
    }
}