import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //집 개수
		int M = Integer.parseInt(st.nextToken()); //장마 기간
		
		//마을 땅 높이
		int[] K = new int[N]; //땅높이
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			K[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int[] S = new int[M];
		int[] E = new int[M];
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			E[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] lastRainDay = new int[N];
		int[] waterLevel = new int[N];
		Arrays.fill(lastRainDay, -1);
		
		//m일 동안 비가 온다
		for(int m = 1; m <= M; ++m) {
			int sIdx = S[m - 1] - 1;
			int eIdx = E[m - 1] - 1;
			
			//S~E 구간의 집에 물의 높이가 증가한다
			for(int homeIdx = sIdx; homeIdx <= eIdx; ++homeIdx) {
				lastRainDay[homeIdx] = m;
				waterLevel[homeIdx]++;
			}
			
			if(m%3 != 0) {continue;}
			for(int homeIdx = 0; homeIdx < N; ++homeIdx) {
				//2일 내에 비가 내린 위치에 배수 시스템 작동
				if(m - lastRainDay[homeIdx] <= 2 && lastRainDay[homeIdx] != -1) {
					waterLevel[homeIdx]--;
					waterLevel[homeIdx] = Math.max(0, waterLevel[homeIdx]); 
				}
			}	
		}
		
		for(int i = 0; i < N; ++i) {
			System.out.printf("%d", K[i] + waterLevel[i]);
			if(i < N-1) {
				System.out.printf(" ");
			}
		}
	}
}