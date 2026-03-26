import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] arr = new int[N+1];

    for (int c = 0; c < M; c++) {
      st = new StringTokenizer(reader.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      for (int l = i; l < j+1; l++) {
        arr[l] = k;
      }
    }

    for (int i = 1; i < N+1; i++) {
      writer.write(arr[i] + " ");
    }
    writer.write("\n");
    writer.flush();
  }
}