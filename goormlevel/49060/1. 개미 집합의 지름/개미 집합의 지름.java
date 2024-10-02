import java.io.*;
import java.util.*;
class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		
		int[] P = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		Arrays.sort(P);
		
		int answer = 9999999;
		for(int i = 0; i < N; ++i) {
			
			
			int left = i;
			int right = N - 1;
			int mid;
			while(left <= right) {
				mid = (left + right) / 2;
				int dist = P[mid] - P[i];
				
				if(dist > D) {
					right = mid - 1;
					continue;
				}
				
				left = mid + 1;
				answer = Math.min(answer, N - (mid - i + 1));
			}
			
			
		}
		
		System.out.printf("%d", answer);
	}
}