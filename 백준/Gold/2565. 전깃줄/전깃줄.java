import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  static List<Integer> lis;
  static PriorityQueue<int[]> q;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(st.nextToken());
    lis = new ArrayList<>();
    q = new PriorityQueue<int[]>((e1, e2) -> {
      return e1[0] - e2[0];
    });

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(reader.readLine());
      int[] temp = new int[2];
      temp[0] = Integer.parseInt(st.nextToken());
      temp[1] = Integer.parseInt(st.nextToken());
      q.add(temp);
    }

    for (int i = 0; i < N; i++) {
      int num = q.poll()[1];
      int idx = binarySearch(0, lis.size(), num);
      if (idx >= lis.size()) {
        lis.add(num);
      } else {
        lis.set(idx, num);
      }
    }

    writer.write(N - lis.size() + "\n");

    writer.flush();
  }
  public static int binarySearch(int left, int right, int target) {
    int mid;
    while (left < right) {
      mid = (left + right) / 2;
      if (target > lis.get(mid)) left = mid + 1;
      else right = mid;
    }
    return right;
  }
}