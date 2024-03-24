#include <string>
#include <vector>
#include <limits.h>
/*
1,3 ~ 5,8
*/
using namespace std;

char map[50+1][50+1];

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    int luy = INT_MAX;
    int lux = INT_MAX;
    int rdy = -1;
    int rdx = -1;
    
    const int N = wallpaper.size();
    const int M = wallpaper[0].length();
    
    for(int y = 0; y < N; ++y) {
        for(int x= 0; x < M; ++x) {
            map[y][x] = wallpaper[y][x];
            
            if(map[y][x] == '.') {
                continue;
            }
            
            if(luy > y) {
                luy = y;
            }
            
            if(lux > x) {
                lux = x;
            }
            
            if(rdy < y + 1) {
                rdy = y + 1;
            }
            
            if(rdx < x + 1) {
                rdx = x + 1;
            }
        }
    }
    
    return {luy, lux, rdy, rdx};
}