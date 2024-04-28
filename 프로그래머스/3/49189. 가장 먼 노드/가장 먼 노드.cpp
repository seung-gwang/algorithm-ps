#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

vector<vector<int>> A;
vector<int> dist;
vector<bool> visit;
int solution(int n, vector<vector<int>> edge) {
    int answer = 0;

    A.clear();
    A.resize(n + 1);
    dist.resize(n + 1, 0);
    visit.resize(n + 1, false);

    for (vector<int>& se : edge) {
        A[se[0]].push_back(se[1]);
        A[se[1]].push_back(se[0]);
    }
    dist[0] = -1;

    queue<int> q;
    int len = 0;
    q.push(1);
    visit[1] = true;
    while (!q.empty()) {
        int qSize = q.size();

        for (int i = 0; i < qSize; ++i) {
            int cur = q.front();
            q.pop();
            dist[cur] = len;

            for (int next : A[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.push(next);
                }
            }
        }
        len++;
    }

    int MAX_LEN = len - 1;

    answer = 0;
    for (int d : dist) {
        if (d == MAX_LEN) {
            answer++;
        }
    }

    return answer;
}