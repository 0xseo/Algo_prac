import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(reader.readLine());
    int[] arr = new int[6];

    for (int i = 0; i < 6; i++) {
      int temp = Integer.parseInt(st.nextToken());
      arr[i] = temp;
    }

    int x = (arr[2]*arr[4] - arr[5]*arr[1]) / (arr[0]*arr[4] - arr[1]*arr[3]);
    int y = (arr[2]*arr[3] - arr[5]*arr[0]) / (arr[1]*arr[3] - arr[0]*arr[4]);
    writer.write(x + " " + y + " \n");
    writer.flush();
  }
}
