import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(reader.readLine());

    long temp = 0;
    for (int i = 0; i < 3; i++) {
      temp = temp + Long.parseLong(st.nextToken());
    }
    writer.write(temp + "\n");
    writer.flush();
  }
}