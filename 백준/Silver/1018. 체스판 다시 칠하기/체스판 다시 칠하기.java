import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] arr = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(reader.readLine());
      String temp = st.nextToken();
      for (int j = 0; j < M; j++) {
        arr[i][j] = temp.charAt(j) == 'B' ? 1 : -1;
      }
    }
    
    int minv = 64;
    for (int i = 0; i < N - 8 + 1; i++) {

      for (int j = 0; j < M - 8 + 1; j++) {
        int cnt = 0;
        int first = arr[i][j];
        for (int y = i; y < i+8; y++) {
          for (int x = j; x < j+8; x++) {
            int tobe = (x + y - i - j) % 2 == 0 ? first : -first;
            if (tobe != arr[y][x]) {
              cnt++;
            }
          }
        }
        cnt = cnt > 32 ? 64 - cnt : cnt;
        if (cnt < minv || 64 - cnt < minv) minv = cnt;
      }
    }
    writer.write(minv + "\n");
    writer.flush();
  }
}
