#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer;
    
    int m = arr1.size();
    int n = arr2[0].size();
    int l = arr2.size(); 
    
    answer.resize(m);
    for(int i = 0; i < m; ++i) {
        answer[i].resize(n, 0);
    }
    
    for(int i = 0; i < m; ++i) {
        for(int j = 0; j < n; ++j) {
            int sum = 0;
            for(int k = 0; k < l; ++k) { 
                answer[i][j] += arr1[i][k] * arr2[k][j];
            }
        }
    }
    
    return answer;
}