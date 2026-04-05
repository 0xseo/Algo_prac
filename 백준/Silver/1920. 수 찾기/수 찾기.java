import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int cnt = Integer.parseInt(reader.readLine());
		
		st = new StringTokenizer(reader.readLine());
		int[] arr = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(reader.readLine());
		
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (Arrays.binarySearch(arr, n) >= 0) {
				writer.write(1  + "\n");
			} else {
				writer.write(0  + "\n");
			}
		}
		
		writer.flush();
	}

}

