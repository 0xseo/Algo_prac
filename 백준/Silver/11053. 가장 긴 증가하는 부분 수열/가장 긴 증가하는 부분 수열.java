import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  static int[] arr;
  static int[] dp;
  public static int binarySearch(int left, int right, int target) {
    int mid;
    while (left < right) {
      mid = (left + right) / 2;
      if (dp[mid] < target) left = mid + 1;
      else right = mid;
    }
    return right;
  }
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(st.nextToken());
    arr = new int[N];
    dp = new int[N];
    st = new StringTokenizer(reader.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int len = 0;
    for (int i = 0; i < N; i++) {
      int idx = binarySearch(0, len, arr[i]);
      dp[idx] = arr[i];
      len = Math.max(len, idx+1);
    }
    
    writer.write(len + "\n");
    writer.flush();
  }

}