import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(reader.readLine());

    int price = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(reader.readLine());
      int p = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      price = price - p*c;
    }
    if (price == 0) {
      writer.write("Yes\n");
    }
    else {
      writer.write("No\n");
    }
    writer.flush();
  }
}