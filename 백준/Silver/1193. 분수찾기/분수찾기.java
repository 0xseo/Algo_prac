import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(reader.readLine());
    int X = Integer.parseInt(st.nextToken());
    int n = (int) Math.ceil(Math.sqrt(2*X+0.25)-0.5);
    int i = X - (n*(n-1))/2;

    if (n % 2 == 0) {
      writer.write(i + "/" + (n+1-i) + "\n");
    } else {
      writer.write((n+1-i) + "/" + i + "\n");
    }

    writer.flush();
  }
}
