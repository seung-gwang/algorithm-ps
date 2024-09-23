#include <cmath>
#include <algorithm>

using namespace std;

long long solution(int w, int h) {
    
    long long totalSqCnt = (long long)w * (long long)h;
    long long unusableSqCnt = w + h - __gcd(w, h);
    return totalSqCnt - unusableSqCnt;
}
