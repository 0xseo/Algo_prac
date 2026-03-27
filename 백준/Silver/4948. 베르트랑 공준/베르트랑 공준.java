import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(st.nextToken());
    while (n != 0) {
      int lastPrimeNumber = (int) Math.sqrt(n*2);
      boolean[] noPrime = new boolean[n*2+1];
      noPrime[0] = true;
      noPrime[1] = true;
      
      for (int i = 2; i <= lastPrimeNumber; i++) {
        if (!noPrime[i]) {
          for (int j = 1; j <= 2*n/i; j++) {
            noPrime[j*i] = true;
          }
        }
      }
  
      int cnt = 0;
      for (int i = n+1; i <= 2*n; i++) {
        if (!noPrime[i]) cnt++;
      }
  
      writer.write(cnt + "\n");

      st = new StringTokenizer(reader.readLine());
      n = Integer.parseInt(st.nextToken());
    }
    writer.flush();
  }
}