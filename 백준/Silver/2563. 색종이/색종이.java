import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(st.nextToken());
    int a = 0;
    int[][] arr = new int[100][100];
    
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(reader.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      for (int dx = x; dx < x+10; dx++) {
        for (int dy = y; dy < y+10; dy++) {
          arr[dy][dx] = 1;
        }
      }
      
    }
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        a = a + arr[i][j];
      }
      
    }
    writer.write(a + "\n");
    writer.flush();
  }
}