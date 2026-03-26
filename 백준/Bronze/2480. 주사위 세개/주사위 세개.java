import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(reader.readLine());
    int[] arr = new int[7];
    Integer flag = 0;

    for (int i = 0; i < 3; i++) {
      Integer temp = Integer.parseInt(st.nextToken());
      arr[temp]++;
      if (arr[temp] > 1) {
        flag = temp;
      }
    }
    if (flag != 0) {
      if (arr[flag] == 3) {
        writer.write(10000+flag*1000 + "\n");
      }
      else {
        writer.write(1000 + flag*100 + "\n");
      }
    } else {
      for (int i = 6; i > 0; i--) {
        if (arr[i] != 0) {
          flag = i;
          break;
        }
      }
      writer.write(flag * 100 + "\n");
    }

    

    writer.flush();
  }
}