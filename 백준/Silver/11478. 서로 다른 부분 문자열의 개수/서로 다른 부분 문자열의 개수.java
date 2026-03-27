import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    String S = st.nextToken();
    HashSet<String> set = new HashSet<String>();

    for (int i = 1; i <= S.length(); i++) {
      for (int j = 0; j <= S.length() - i; j++) {
        set.add(S.substring(j, i+j));
      }
    }

    writer.write(set.size() + "\n");
    writer.flush();
  }
}