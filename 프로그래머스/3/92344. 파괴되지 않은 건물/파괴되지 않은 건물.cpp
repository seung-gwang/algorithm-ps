#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board, vector<vector<int>> skill) {
    int sum[1001][1001] = {0,};
    
    for(const auto& s : skill) {
        //s : type, r1, c1, r2, c2, degree
        int t = s[0] == 1 ? -1 : 1;
        int r1 = s[1];
        int c1 = s[2];
        int r2 = s[3];
        int c2 = s[4];
        int d = s[5];
        
        sum[r1][c1] += t*d;
        sum[r2+1][c2+1] += t*d;
        sum[r1][c2+1] -= t*d;
        sum[r2+1][c1] -= t*d;
    }
    
    const int R = board.size();
    const int C = board[0].size();
    
    for(int r = 0; r < R; ++r) {
        for(int c = 0; c < C; ++c) {
            sum[r+1][c] += sum[r][c];
        }
    }
    
    for(int r = 0; r < R; ++r) {
        for(int c = 0; c < C; ++c) {
            sum[r][c+1] += sum[r][c];
        }
    }
    
    int answer = 0;
    for(int r = 0; r < R; ++r) {
        for(int c = 0; c < C; ++c) {
            int hp = sum[r][c] + board[r][c];
            if(hp > 0) {answer++;}
        }
    }
    
 
    
    
    return answer;
}