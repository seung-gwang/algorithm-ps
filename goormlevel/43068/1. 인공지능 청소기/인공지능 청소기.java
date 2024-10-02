import java.io.*;
import java.util.StringTokenizer;
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		StringTokenizer st;
		for(int i = 0; i < T; ++i) {
			st = new StringTokenizer(bf.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			
			X = Math.abs(X);
			Y = Math.abs(Y);
			
			String answer = "NO";
			if(X+Y <= N && (X + Y - N) % 2 == 0) {
				answer = "YES";
			}
			
			System.out.println(answer);
		}
	}
}
