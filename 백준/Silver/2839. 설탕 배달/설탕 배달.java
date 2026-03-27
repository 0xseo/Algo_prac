import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(st.nextToken());
    boolean flag = false;

    int max5cnt = N / 5;
    for (int i = max5cnt; i >= 0; i--) {
      if ((N - i * 5) % 3 == 0) {
        writer.write((i + (N - i * 5) / 3) + "\n");
        flag = true;
        break;
      }
    }
    if (!flag) {
      writer.write(-1+"\n");
    }

    writer.flush();
  }
}
