#include <iostream>
#define DIV (100000007)
using namespace std;


int main() {
	int N;
	cin >> N;
	
	int x = 1; //XXX -> OXX XOX XXO OXO XXX
	int l = 1; //OXX -> XOX,XXO XXX
	int m = 1; //XOX -> OXX, XXO, OXO, XXX
	int r = 1; //XXO -> OXX, XOX, XXX
	int lr = 1; //OXO -> XOX, XXX
	
	for(int i = 2; i <= N; ++i) {
		int nx = l + m + r + lr + x;
		int nl = m + r + x;
		int nm = l + r + lr + x;
		int nr = l + m + x;
		int nlr = m + x;
		
		x = nx % DIV;
		l = nl % DIV;
		m = nm % DIV;
		r = nr % DIV;
		lr = nlr % DIV;
	}
	
	cout << (l + m + r + lr + x) % DIV;
	return 0;
}