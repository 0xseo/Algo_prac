import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		Integer temp = Integer.parseInt(st.nextToken());;
		
		while (st.hasMoreTokens()) {
			temp = temp + Integer.parseInt(st.nextToken());
		}
		
//		bw.write("Hello World\n");
		bw.write(temp+"\n");
		
		bw.flush();
	}

}