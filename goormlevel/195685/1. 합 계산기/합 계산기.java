import java.io.*;
import java.util.StringTokenizer;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int sum = 0;
		for(int i = 0; i < T; ++i) {
			//st = new StringTokenizer();
			String[] tokens = br.readLine().split(" ");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[2]);
			
			if(tokens[1].equals("+")) {
				sum += (a+b);
			}
			else if(tokens[1].equals("-")) {
				sum += (a-b);
			}
			else if (tokens[1].equals("*")) {
				sum += (a*b);
			}
			else {
				sum += (a/b);
			}
		}
		
		System.out.println(sum);
	}
}