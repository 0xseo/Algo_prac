import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    String word1 = st.nextToken();
    st = new StringTokenizer(reader.readLine());
    String word2 = st.nextToken();

    int[][] dp = new int[word1.length()+1][word2.length()+1];

    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    writer.write(dp[word1.length()][word2.length()] + "\n");
    writer.flush();
  }
}
