#include <iostream>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;
int dist[10000+1];
bool visit[10000+1];
vector<vector<int>> A;


int main() {
	int N, M, K;
	
	cin >> N >> M >> K;
	
	A.resize(N+1);
	for(int i = 0; i < M; ++i) {
		int s, e;
		cin >> s >> e;
		A[s].push_back(e);
	}
	
	queue<int> q;
	q.push(K);
	visit[K] = true;
	
	int bridge = 0;
	while(!q.empty()) {
		int popCnt = q.size();
		for(int p = 0; p < popCnt; ++p) {
			int cur = q.front(); q.pop();
			dist[cur] = bridge + abs(cur - K);
			
			for(int next : A[cur]) {
				if(visit[next]) {continue;}
				visit[next] = true;
				q.push(next);
			}
		}
		bridge++;
	}
	
	int answer = -1;
	int curMax = 0;
	for(int i = 1; i <= N; ++i) {
		if(dist[i] == 0) {continue;}
		if(dist[i] >= curMax) {
			curMax = dist[i];
			answer = i;
		}
	}
	
	cout << answer << endl;
	
	return 0;
}