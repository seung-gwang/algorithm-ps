#include <iostream>
#include <vector>
#include <queue>
using namespace std;

typedef pair<int, int> weight_dst;

int N, M, X;
vector<vector<weight_dst>> A;

int dijkstra(const int src, const int dst) {
    vector<bool> visit(N + 1, false);
    vector<int> weights(N + 1, 0);

    int maxWeight = -1;
    priority_queue<weight_dst, vector<weight_dst>, greater<>> pq;

    pq.push({ 0, src });
    while (!pq.empty()) {
        auto it = pq.top();
        
        pq.pop();

        if (visit[it.second]) {
            continue;
        }

        weights[it.second] = it.first;
        visit[it.second] = true;

        for (weight_dst next : A[it.second]) {
            if (visit[next.second]) { continue; }
            pq.push({ it.first + next.first, next.second });
        }
    }

    return weights[dst];
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);


    cin >> N >> M >> X;
    
    A.clear();
    A.resize(N + 1);
    for (int i = 0; i < M; ++i) {
        int src, dst, weight;

        cin >> src >> dst >> weight;
        A[src].push_back(make_pair(weight, dst));
    }

    //(n->X) + (X->n)의 최대값 (n : 1, 2, ...., N)
    int answer = -1;
    for (int n = 1; n <= N; ++n) {
        int go = dijkstra(n, X);
        int come = dijkstra(X, n);

        int round = go + come;
        answer = answer > round ? answer : round;
    }

    cout << answer;
    return 0;
}