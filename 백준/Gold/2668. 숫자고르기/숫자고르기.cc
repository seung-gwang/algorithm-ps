/*
1 2 3 4 5 6 7
3 1 1 5 5 4 6
*/
#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

int N;
int nums[101];

set<int> answers;


void DFS(const int i, const int target, vector<bool>& visit) {
    
    visit[i] = true;

    if(nums[i] == target) {    
        set<int> route;
        for (int i = 1; i <= N; ++i) {
            if (visit[i]) {  
                answers.insert(i);
            }
        }
        return;
    }

    if (visit[nums[i]]) {
        return;
    }

    DFS(nums[i], target, visit);
}

int main() {
    cin >> N;
    for (int i = 1; i <= N; ++i) {
        cin >> nums[i];
    }

    for(int i = 1; i <= N; ++i) {
        vector<bool> visit(N + 1, false);
        DFS(i, i, visit);
    }
   
    cout << answers.size() << endl;
    vector<int> sorted;
    for (const auto& i : answers) {
        sorted.push_back(i);
    }
    sort(sorted.begin(), sorted.end());
    for(const auto& a : sorted) {
        cout << a << endl;
    }
    return 0;
}