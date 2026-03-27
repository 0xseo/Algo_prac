import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(st.nextToken());
    ArrayList<String> pattern = new ArrayList<>(List.of("***", "* *", "***"));
    ArrayList<String> res = star(n, pattern);

    for (int i = 0; i < n; i++) {
      writer.write(res.get(i) + "\n");
    }
    writer.flush();
  }
  public static ArrayList<String> star(int n, ArrayList<String> miniStars) {
    if (n == 3) {
      return miniStars;
    } else {
      ArrayList<String> out = new ArrayList<String>();
      for (String s : miniStars) {
        out.add(s.repeat(3));
      }
      for (String s : miniStars) {
        out.add(s + " ".repeat(miniStars.size()) + s);
      }
      for (String s : miniStars) {
        out.add(s.repeat(3));
      }
      return star(n/3, out);
    }
  }

}